package com.ward.studymoa.user.controller;

import com.ward.studymoa.user.domain.StudyUser;
import com.ward.studymoa.user.dto.request.SignUpDto;
import com.ward.studymoa.user.service.impl.StudyUserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final StudyUserAuthService studyUserAuthService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignUpDto signUpDTO) {
        StudyUser studyUser = signUpDTO.ofStudyUser();

        studyUserAuthService.signUp(studyUser);
        return ResponseEntity.ok().body("User registered successfully!");
    }

    @PostMapping("signin")
    public String signIn(@RequestParam String userId, @RequestParam String password) {
        return studyUserAuthService.signIn(userId, password);
    }

    @PostMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("testtest");
    }
}
