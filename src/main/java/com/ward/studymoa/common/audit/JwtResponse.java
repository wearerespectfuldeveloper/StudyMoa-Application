package com.ward.studymoa.common.audit;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private String type = "StudyMoa";

    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }
}
