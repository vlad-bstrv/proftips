package ru.vladbstrv.proftips.service;

import org.springframework.web.multipart.MultipartFile;
import ru.vladbstrv.proftips.dto.requestDto.UserRequestDto;
import ru.vladbstrv.proftips.dto.responseDto.UserResponseDto;
import ru.vladbstrv.proftips.model.User;

import java.util.List;

public interface UserService {

    public UserResponseDto addUser(UserRequestDto userRequestDto);
    public UserResponseDto getUserById(Long userId);
    public User getUser(Long userId);
    public List<UserResponseDto> getUsers();
    public User updateAvatarUser(MultipartFile image, String userEmail);
}
