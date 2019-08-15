package com.ward.studymoa.user.dto.request;

import com.ward.studymoa.user.domain.StudyUser;
import lombok.Data;

@Data
public class SignUpDto {

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
