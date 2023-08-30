package ru.vladbstrv.proftips.dto.requestDto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
