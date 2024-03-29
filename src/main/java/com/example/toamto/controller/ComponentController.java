package com.example.toamto.controller;

import com.example.toamto.mapper.ComponentMapper;
import com.example.toamto.model.Component;
import com.example.toamto.model.Page;
import com.example.toamto.model.ResultObj;
import com.example.toamto.model.SearchComponentDto;
import com.example.toamto.service.ComponentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("/component")
@RestController
public class ComponentController {

    @Resource
    ComponentService componentService;


    @GetMapping(value = "/getList")
    public ResultObj getComponentList(@RequestHeader Map<String,String > headers, SearchComponentDto dto){
        System.out.println(headers);
        return componentService.getList(dto);
    }

    @PostMapping("/save")
    public ResultObj saveComponent(Component component){
        return componentService.saveComponent(component);
    }

    @PostMapping("/changeNum")
    public ResultObj changeComponentNum(Long id,Boolean isAdd,Integer num){
        return componentService.updateComponent(id,isAdd,num);
    }

    @GetMapping("/test")
    public String  test(){
        return "xds";
    }
}
