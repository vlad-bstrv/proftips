package ru.vladbstrv.proftips.dto.requestDto;

import lombok.Data;

@Data
public class PostRequestDto {
    private String title;
    private String content;
    private Long userId;
}
