package com.ward.studymoa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping(name = "/")
    @ResponseBody
    public String sampleRequest() {
        return "Hello StudyMoa! I'm Done!!";
    }

    @GetMapping(name = "/haha")
    @ResponseBody
    public String haha() {
        return "hahahahahaha";
    }
}
