package com.example.toamto.controller;

import com.example.toamto.mapper.ComponentMapper;
import com.example.toamto.model.Component;
import com.example.toamto.model.Page;
import com.example.toamto.service.ComponentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ComponentController {

    @Resource
    ComponentService componentService;


    @GetMapping(value = "/getComponentList")
    public Page<Component> getComponentList(@RequestParam(value = "pagenum") Integer pagenum,@RequestParam(value = "size") Integer size){
        System.out.println(pagenum);
        return componentService.getComponentList((pagenum - 1),size);
    }

    @GetMapping("/test")
    public String  test(){
        return "xds";
    }
}
