package com.ward.studymoa.user.dto;

import com.ward.studymoa.user.domain.StudyUser;
import lombok.Data;

@Data
public class SignUpDTO {

    private String userId;
    private String email;
    private String password;
    private String name;
    private String phoneNumber;

    public StudyUser ofStudyUser() {
        return StudyUser.builder()
                .userId(userId)
                .email(email)
                .password(password)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }
}
