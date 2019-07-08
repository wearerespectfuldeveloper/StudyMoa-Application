package com.ward.studymoa;

import com.ward.studymoa.api.service.StudyCategoryService;
import com.ward.studymoa.core.StudyCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudymoaApplicationTests {

	@Autowired
	StudyCategoryService studyCategoryService;

	@Test
	public void contextLoads() {
	}

}
