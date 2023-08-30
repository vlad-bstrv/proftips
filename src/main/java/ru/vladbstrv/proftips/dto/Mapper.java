package ru.vladbstrv.proftips.dto;

import ru.vladbstrv.proftips.dto.responseDto.PostResponseDto;
import ru.vladbstrv.proftips.dto.responseDto.UserResponseDto;
import ru.vladbstrv.proftips.model.Post;
import ru.vladbstrv.proftips.model.User;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static PostResponseDto postToPostResponseDto(Post post) {
        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(post.getId());
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setContent(post.getContent());
        postResponseDto.setUsername(post.getUser().getFirstname());
        postResponseDto.setCreatedAt(post.getCreatedAt());
        return postResponseDto;
    }

    public static UserResponseDto userToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setFirstname(user.getFirstname());
        userResponseDto.setLastname(user.getLastname());
        List<Long> namePosts = new ArrayList<>();
        List<Post> posts = user.getPosts();
        for (Post post : posts) {
            namePosts.add(post.getId());
        }
        userResponseDto.setPostIds(namePosts);
        return userResponseDto;
    }
}
