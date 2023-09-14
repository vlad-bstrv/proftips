package ru.vladbstrv.proftips.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.vladbstrv.proftips.auth.config.JwtService;
import ru.vladbstrv.proftips.dto.requestDto.PostRequestDto;
import ru.vladbstrv.proftips.dto.responseDto.PostResponseDto;
import ru.vladbstrv.proftips.model.User;
import ru.vladbstrv.proftips.service.PostService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public ResponseEntity<PostResponseDto> addPost(
            @RequestBody final PostRequestDto postRequestDto
    ) {
        User principal1 = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println( principal1.getId());
        PostResponseDto postResponseDto = postService.addPost(postRequestDto, principal1.getId());
        return ResponseEntity.ok(postResponseDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable final Long id, Principal principal) {
        String name = principal.getName();
        System.out.println(name + " --------------- ");
        PostResponseDto postResponseDto = postService.getPostById(id);
        User principal1 = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("принципал " + principal1.getEmail());
        System.out.println(principal1.getId());
        return ResponseEntity.ok(postResponseDto);
    }
}
