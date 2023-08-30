package ru.vladbstrv.proftips.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vladbstrv.proftips.dto.requestDto.PostRequestDto;
import ru.vladbstrv.proftips.dto.responseDto.PostResponseDto;
import ru.vladbstrv.proftips.service.PostService;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public ResponseEntity<PostResponseDto> addPost(@RequestBody final PostRequestDto postRequestDto) {
        PostResponseDto postResponseDto = postService.addPost(postRequestDto);
        return ResponseEntity.ok(postResponseDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable final Long id) {
        PostResponseDto postResponseDto = postService.getPostById(id);
        return ResponseEntity.ok(postResponseDto);
    }
}
