package ru.vladbstrv.proftips.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.vladbstrv.proftips.dto.Mapper;
import ru.vladbstrv.proftips.dto.requestDto.UserRequestDto;
import ru.vladbstrv.proftips.dto.responseDto.UserResponseDto;
import ru.vladbstrv.proftips.model.User;
import ru.vladbstrv.proftips.repository.UserRepository;
import ru.vladbstrv.proftips.service.StorageService;
import ru.vladbstrv.proftips.service.UserService;
import ru.vladbstrv.proftips.utils.Const;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final StorageService storageService;
    private final UserRepository userRepository;

    public UserServiceImpl(StorageService storageService, UserRepository userRepository) {
        this.storageService = storageService;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setFirstname(userRequestDto.getFirstname());
        user.setLastname(userRequestDto.getLastname());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        userRepository.save(user);
        return Mapper.userToUserResponseDto(user);
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("could not find category with id: " + userId));
    }

    @Override
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(Mapper::userToUserResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        User user = getUser(userId);
        return Mapper.userToUserResponseDto(user);
    }

    @Override
    public User updateAvatarUser(MultipartFile image, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() ->
                new IllegalArgumentException("ldksajbflksadbflkjbasdkjfbaslkdjbflkasdbf")
        );
        if (user.getAvatar() != null) {
            storageService.deleteFile(user.getAvatar().replaceAll(Const.BUCKET_URL, ""));
        }
        String imageUrl = storageService.uploadFile(image);
        user.setAvatar(imageUrl);
        userRepository.save(user);
        return user;
    }
}
