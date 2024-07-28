package com.riwi.test.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping(path = "tests")
@RestController
public class test {
    @GetMapping
    public String tests(){
        return "Si Sirvessssssssssssssss";
    }
}
