package com.edwardawebb.circleci.demo.controllers;

import com.edwardawebb.circleci.demo.BuildInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final BuildInfo buildInfo;

    @Autowired
    public RestController(BuildInfo buildInfo) {
        this.buildInfo = buildInfo;
    }

    @GetMapping("/build-info")
    @ResponseBody
    public BuildInfo greeting() {
        return buildInfo;
    }
}
