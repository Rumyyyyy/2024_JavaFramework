package com.example.demo.service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // 모든 게시글을 조회하는 메서드
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    // 특정 ID에 해당하는 게시글을 조회하는 메서드
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    // 게시글을 저장하는 메서드
    public void save(Post post) {
        postRepository.save(post);
    }

    // 특정 ID에 해당하는 게시글을 삭제하는 메서드
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    // 게시글의 비밀번호를 확인하는 메서드
    public boolean checkPassword(Long id, String password) {
        Optional<Post> post = postRepository.findById(id);
        return post.isPresent() && post.get().getPassword().equals(password);
    }
}
