package com.prod_ready_features.prodready.services;

import com.prod_ready_features.prodready.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List <PostDTO> getAllPosts();
    PostDTO createNewPost(PostDTO inputPost);
    PostDTO findById(Long postId);
    PostDTO updatePostById(Long postId, PostDTO postDTO);

}
