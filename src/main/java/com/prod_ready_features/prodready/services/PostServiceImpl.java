package com.prod_ready_features.prodready.services;

import com.prod_ready_features.prodready.dto.PostDTO;
import com.prod_ready_features.prodready.entity.PostEntity;
import com.prod_ready_features.prodready.repositories.PostRepository;
import com.prod_ready_features.prodready.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts(){
        return postRepository.findAll().
                stream().
                map(postEntity -> modelMapper.map(postEntity, PostDTO.class)).
                collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost){
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDTO.class);
    }

    @Override
    public PostDTO findById(Long postId){
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("We did not find the postId "+postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO updatePostById (Long postId, PostDTO inputPost) {
        PostEntity olderEntity = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("We did not find the postId "+postId));
        inputPost.setPostId(postId);
        modelMapper.map(inputPost, olderEntity);
        PostEntity savedPostEntity =postRepository.save(olderEntity);
        return modelMapper.map(olderEntity, PostDTO.class);
    }
}
