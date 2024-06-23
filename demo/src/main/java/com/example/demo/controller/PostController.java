package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    // PostService와 CommentService를 주입받아 사용합니다.
    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    // 모든 게시글을 가져와서 모델에 추가하고 posts.html 뷰로 반환합니다.
    @GetMapping
    public String getAllPosts(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "posts";
    }

    // 새 게시글 작성 폼을 표시합니다.
    @GetMapping("/new")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "create_post";
    }

    // 새 게시글을 저장하고 게시글 목록 페이지로 리디렉션합니다.
    @PostMapping("/create")
    public String savePost(@ModelAttribute("post") Post post) {
        postService.save(post);
        return "redirect:/posts";
    }

    // 게시글 수정 폼을 표시합니다. 비밀번호가 틀린 경우 에러 메시지를 모델에 추가합니다.
    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model, @RequestParam(value = "error", required = false) String error) {
        Post post = postService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        if (error != null) {
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
        }
        return "edit_post";
    }

    // 게시글을 업데이트합니다. 비밀번호가 맞지 않으면 에러 메시지를 표시합니다.
    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable Long id, @RequestParam String password, @ModelAttribute("post") Post post, Model model) {
        Post existingPost = postService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        if (postService.checkPassword(id, password)) {
            existingPost.setTitle(post.getTitle());
            existingPost.setUsername(post.getUsername());
            existingPost.setEmail(post.getEmail());
            existingPost.setContent(post.getContent());
            postService.save(existingPost);
            return "redirect:/posts";
        } else {
            return "redirect:/posts/edit/" + id + "?error";
        }
    }

    // 게시글을 삭제하고 게시글 목록 페이지로 리디렉션합니다.
    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deleteById(id);
        return "redirect:/posts";
    }

    // 특정 게시글을 조회하여 모델에 추가하고 post_detail.html 뷰로 반환합니다.
    @GetMapping("/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Post post = postService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        List<Comment> comments = commentService.findByPostId(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment()); // 댓글 작성 폼을 위한 빈 객체 추가
        return "post_detail";
    }

    // 댓글을 저장하고 게시글 상세 페이지로 리디렉션합니다.
    @PostMapping("/{postId}/comments")
    public String saveComment(@PathVariable Long postId, @ModelAttribute("comment") Comment comment) {
        comment.setPostId(postId);
        commentService.save(comment);
        return "redirect:/posts/" + postId;
    }

    // 댓글을 삭제하고 게시글 상세 페이지로 리디렉션합니다.
    @PostMapping("/{postId}/comments/delete/{id}")
    public String deleteComment(@PathVariable Long postId, @PathVariable Long id, @RequestParam String password) {
        Comment comment = commentService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment Id:" + id));
        if (commentService.checkPassword(id, password)) {
            commentService.deleteById(id);
        }
        return "redirect:/posts/" + postId;
    }

    // 댓글을 수정하고 게시글 상세 페이지로 리디렉션합니다. 비밀번호가 맞지 않으면 에러 메시지를 표시합니다.
    @PostMapping("/{postId}/comments/edit/{id}")
    public String editComment(@PathVariable Long postId, @PathVariable Long id,
                              @RequestParam String password, @ModelAttribute("comment") Comment updatedComment) {
        Comment comment = commentService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment Id:" + id));
        if (commentService.checkPassword(id, password)) {
            updatedComment.setId(id);
            updatedComment.setPostId(postId);
            commentService.save(updatedComment);
        } else {
            return "redirect:/posts/" + postId + "/comments?error=비밀번호가 틀렸습니다";
        }
        return "redirect:/posts/" + postId;
    }
}
