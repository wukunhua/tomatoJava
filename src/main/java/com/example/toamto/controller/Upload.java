package com.example.toamto.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RestController
@RequestMapping("/upload")
@Tag(name="文件上传")
public class Upload {

    @PostMapping("/sumPirce")
    @Operation(summary = "文件求和")
    public void receivFile(MultipartFile file){
        System.out.println(file);
    }
}
