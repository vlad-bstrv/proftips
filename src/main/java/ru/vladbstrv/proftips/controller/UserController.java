package ru.vladbstrv.proftips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.vladbstrv.proftips.dto.requestDto.UserRequestDto;
import ru.vladbstrv.proftips.dto.responseDto.UserResponseDto;
import ru.vladbstrv.proftips.model.User;
import ru.vladbstrv.proftips.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> addUser(
            @RequestBody final UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.addUser(userRequestDto);
        System.out.println(userResponseDto.getFirstname());
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable final Long id) {
        UserResponseDto userResponseDto = userService.getUserById(id);
        System.out.println("userResponseDto " + userResponseDto);
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/get")
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping()
    public ResponseEntity<String> addAvatarUser(@RequestParam(value = "image") MultipartFile image, Authentication authentication) {
        System.out.println(authentication.getName());
        User user = userService.updateAvatarUser(image, authentication.getName());
        return ResponseEntity.ok(user.getAvatar());
    }



}
