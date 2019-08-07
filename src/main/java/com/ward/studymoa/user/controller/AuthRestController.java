package com.ward.studymoa.user.controller;

import com.ward.studymoa.user.domain.StudyUser;
import com.ward.studymoa.user.dto.SignUpDTO;
import com.ward.studymoa.user.service.StudyUserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final StudyUserAuthService studyUserAuthService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignUpDTO signUpDTO) {
        StudyUser studyUser = signUpDTO.ofStudyUser();

        studyUserAuthService.signUp(studyUser);
        return ResponseEntity.ok().body("User registerd successfully!");
    }

    @PostMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("testtest");
    }
}
