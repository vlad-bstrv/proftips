package ru.vladbstrv.proftips.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    private Long id;
    private String firstname;
    private String lastname;
    private List<Long> postIds;
    private String imageNames;
}
