package com.prod_ready_features.prodready.controllers;

import com.prod_ready_features.prodready.dto.PostDTO;
import com.prod_ready_features.prodready.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path ="/posts" )
public class PostController {

    private final PostService postService;
    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }
}
