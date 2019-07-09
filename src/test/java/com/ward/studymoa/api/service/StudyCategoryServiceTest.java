package com.ward.studymoa.api.service;

import com.ward.studymoa.core.StudyCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudyCategoryServiceTest {

    @Autowired
    StudyCategoryService studyCategoryService;

    @Test
    public void studyCategoryFindAllTest() {
        List<StudyCategory> studyCateogryList = studyCategoryService.findAllOrderByTitle();

        for (StudyCategory studyCategory : studyCateogryList) {
            log.info("Category Title : " + studyCategory.getTitle());
        }
    }
}