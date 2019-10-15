package com.medicalservice.MedicalService.controller;

import com.medicalservice.MedicalService.model.Comment;
import com.medicalservice.MedicalService.repository.CommentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CommentController {
    private CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/medical-service-comments")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Comment> commentCollection() {
        return commentRepository.findAll().stream().collect(Collectors.toList());
    }
}
