package com.example.toamto.controller;

import com.example.toamto.mapper.ComponentMapper;
import com.example.toamto.model.Component;
import com.example.toamto.model.Page;
import com.example.toamto.model.ResultObj;
import com.example.toamto.model.SearchComponentDto;
import com.example.toamto.service.ComponentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ComponentController {

    @Resource
    ComponentService componentService;


    @GetMapping(value = "/getComponentList")
    public ResultObj getComponentList(SearchComponentDto dto){
        return componentService.getComponentList(dto);
    }

    @PostMapping("/saveComponent")
    public ResultObj saveComponent(Component component){
        return componentService.saveComponent(component);
    }

    @PostMapping("/changeComponentNum")
    public ResultObj changeComponentNum(Long id,Boolean isAdd,Integer num){
        return componentService.updateComponent(id,isAdd,num);
    }

    @GetMapping("/test")
    public String  test(){
        return "xds";
    }
}
