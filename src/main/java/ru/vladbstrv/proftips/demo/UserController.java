package ru.vladbstrv.proftips.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vladbstrv.proftips.dto.requestDto.UserRequestDto;
import ru.vladbstrv.proftips.dto.responseDto.UserResponseDto;
import ru.vladbstrv.proftips.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> addUser(
            @RequestBody final UserRequestDto userRequestDto) {
        System.out.println("userRequestDto " + userRequestDto);
        UserResponseDto userResponseDto = userService.addUser(userRequestDto);
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable final Long id) {
        UserResponseDto userResponseDto = userService.getUserById(id);
        System.out.println("userResponseDto " + userResponseDto);
        return ResponseEntity.ok(userResponseDto);
    }

}
