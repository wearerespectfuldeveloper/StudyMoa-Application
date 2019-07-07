package com.ward.studymoa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping(value = "/")
    @ResponseBody
    public String sampleRequest() {
        return "Hello StudyMoa ㄱㅏ나다라마바사아자";
    }

    @GetMapping(value = "/ha")
    @ResponseBody
    public String hello() {
        return "yeah!!!!! Jenkins Check";
    }
}
