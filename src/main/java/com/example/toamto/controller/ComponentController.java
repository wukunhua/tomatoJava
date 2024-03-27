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
    public ResultObj getComponentList(@RequestParam(value = "pagenum",defaultValue = "1") Integer pagenum,@RequestParam(value = "size",defaultValue = "10") Integer size){
        System.out.println(pagenum);
        return componentService.getComponentList((pagenum - 1),size);
    }

    @GetMapping(value = "/getComponentListByIpage")
    public ResultObj getComponentListByIpage(SearchComponentDto dto){
        return componentService.getComponentListByIpage(dto);
    }


    @GetMapping(value = "/getComponentListByPage")
    public ResultObj getComponentListByPage(SearchComponentDto dto){
        return componentService.getComponentListByPage(dto);
    }

    @PostMapping("/saveComponent")
    public ResultObj saveComponent(Component component){
        return componentService.saveComponent(component);
    }

    @GetMapping("/test")
    public String  test(){
        return "xds";
    }
}
