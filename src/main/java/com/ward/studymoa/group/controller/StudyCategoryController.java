package com.ward.studymoa.group.controller;

import com.ward.studymoa.group.domain.StudyCategory;
import com.ward.studymoa.group.service.StudyCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class StudyCategoryController {

    private final StudyCategoryService studyCategoryService;

    @GetMapping(value = "/")
    @ResponseBody
    public List<StudyCategory> findAllCategory() {
        return studyCategoryService.findAllOrderByTitle();
    }

    @PostMapping(value = "/ttt")
    @ResponseBody
    public ResponseEntity<List<StudyCategory>> ttttt() {
        return new ResponseEntity<List<StudyCategory>>(studyCategoryService.findAllOrderByTitle(), HttpStatus.FOUND);
    }
}
