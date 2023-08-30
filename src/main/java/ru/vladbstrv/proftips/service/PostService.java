package ru.vladbstrv.proftips.service;

import org.springframework.stereotype.Service;
import ru.vladbstrv.proftips.dto.Mapper;
import ru.vladbstrv.proftips.dto.requestDto.PostRequestDto;
import ru.vladbstrv.proftips.dto.responseDto.PostResponseDto;
import ru.vladbstrv.proftips.model.Post;
import ru.vladbstrv.proftips.model.User;
import ru.vladbstrv.proftips.repository.PostRepository;

import java.time.LocalDateTime;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public PostResponseDto addPost(PostRequestDto postRequestDto) {
        Post post = new Post();
        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());
        User user = userService.getUser(postRequestDto.getUserId());
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());

        Post post1 = postRepository.save(post);
        return Mapper.postToPostResponseDto(post1);
    }

    public Post getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() ->
                new IllegalArgumentException("cannot find post with id: " + postId));
        return post;
    }

    public PostResponseDto getPostById(Long postId) {
        Post post = getPost(postId);
        return Mapper.postToPostResponseDto(post);
    }
}
