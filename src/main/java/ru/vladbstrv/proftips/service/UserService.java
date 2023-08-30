package ru.vladbstrv.proftips.service;

import org.springframework.stereotype.Service;
import ru.vladbstrv.proftips.dto.Mapper;
import ru.vladbstrv.proftips.dto.requestDto.UserRequestDto;
import ru.vladbstrv.proftips.dto.responseDto.UserResponseDto;
import ru.vladbstrv.proftips.model.User;
import ru.vladbstrv.proftips.repository.UserRepository;

import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setFirstname(userRequestDto.getFirstname());
        user.setLastname(userRequestDto.getLastname());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        System.out.println("User " + user);
        User save = userRepository.save(user);
        System.out.println("Save " + save);
        return Mapper.userToUserResponseDto(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("could not find category with id: " + userId));
    }

    public UserResponseDto getUserById(Long userId) {
        User user = getUser(userId);
        return Mapper.userToUserResponseDto(user);
    }
}
