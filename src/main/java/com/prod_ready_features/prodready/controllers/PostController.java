package com.prod_ready_features.prodready.controllers;

import com.prod_ready_features.prodready.dto.PostDTO;
import com.prod_ready_features.prodready.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable Long postId){
        return postService.findById(postId);
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO postDTO){
        return postService.createNewPost(postDTO);
    }

}
