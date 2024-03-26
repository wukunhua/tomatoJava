package com.example.toamto.service;

import com.example.toamto.mapper.ComponentMapper;
import com.example.toamto.model.Component;
import com.example.toamto.model.Page;
import com.example.toamto.model.ResultObj;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ComponentService {
    @Resource
    ComponentMapper componentMapper;
    @Resource
    Page<Component> page;

    @Resource
    ResultObj resultObj;

    public ResultObj getComponentList(Integer num,Integer size){
        List<Component> list = componentMapper.getComponentList(num,size);

        page.setList(list);
        page.setTotal(componentMapper.findComponentCount());
        resultObj.setData(page);
        resultObj.setCode("v");

        return resultObj;
    }

    public ResultObj saveComponent(Component component){
        componentMapper.insert(component);
        resultObj.setCode("v");
        return resultObj;
    }
}
