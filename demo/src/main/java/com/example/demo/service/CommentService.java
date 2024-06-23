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

    public List<Comment> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    public boolean checkPassword(Long id, String password) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.isPresent() && comment.get().getPassword().equals(password);
    }
}
