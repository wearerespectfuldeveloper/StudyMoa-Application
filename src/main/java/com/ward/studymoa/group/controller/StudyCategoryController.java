package com.ward.studymoa.group.controller;

import com.ward.studymoa.group.domain.StudyCategory;
import com.ward.studymoa.group.service.StudyCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudyCategoryController {

    private final StudyCategoryService studyCategoryService;

    @GetMapping(value = "/categories")
    @ResponseBody
    public List<StudyCategory> findAllCategory() {
        return studyCategoryService.findAllOrderByTitle();
    }
}