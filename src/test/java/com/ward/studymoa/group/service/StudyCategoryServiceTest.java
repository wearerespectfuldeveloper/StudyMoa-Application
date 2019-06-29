package com.ward.studymoa.group.service;

import com.ward.studymoa.group.domain.StudyCategory;
import com.ward.studymoa.group.repository.StudyCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudyCategoryServiceTest {

    @Autowired
    StudyCategoryRepository studyCategoryRepository;

    @Test
    public void simpleTest() {
        StudyCategory studyCategory = StudyCategory.builder().title("프로그래밍").build();
        studyCategoryRepository.save(studyCategory);
    }
}