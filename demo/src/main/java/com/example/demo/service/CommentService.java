package com.example.demo.service;

import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // 특정 게시글의 댓글 목록을 조회하는 메서드
    public List<Comment> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    // 특정 ID에 해당하는 댓글을 조회하는 메서드
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    // 댓글을 저장하는 메서드
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    // 특정 ID에 해당하는 댓글을 삭제하는 메서드
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    // 댓글의 비밀번호를 확인하는 메서드
    public boolean checkPassword(Long id, String password) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.isPresent() && comment.get().getPassword().equals(password);
    }
}
