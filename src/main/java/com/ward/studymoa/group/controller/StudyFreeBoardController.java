package com.ward.studymoa.group.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ward.studymoa.utill.DataMap;
import com.ward.studymoa.utill.ResponseStatus;

@RestController
@RequestMapping("/v/1.0/freeboard")
public class StudyFreeBoardController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudyFreeBoardController.class);
	
	@GetMapping("/test2")
	public ResponseEntity<Object> test() {
		
		LOGGER.info("test2");
		
		return new ResponseEntity<>(ResponseStatus.SUCCESS.toRemap(), HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public ResponseEntity<Object> test2(@RequestBody DataMap dataMap) {
		
		LOGGER.info("test");
		
		List<String> list = new ArrayList<String>(); 
		list.add("test");
		list.add("test");
		
		ModelMap modelMap = new ModelMap();
		modelMap.put("list", list);
		
		return new ResponseEntity<>(ResponseStatus.SUCCESS.toInmap("test", modelMap), HttpStatus.OK);
	}
	
}
