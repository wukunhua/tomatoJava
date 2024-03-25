package com.example.toamto.service;

import com.example.toamto.mapper.ComponentMapper;
import com.example.toamto.model.Component;
import com.example.toamto.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ComponentService {
    @Resource
    ComponentMapper componentMapper;
    @Resource
    Page<Component> page;

    public Page<Component> getComponentList(Integer num,Integer size){
        List<Component> list = componentMapper.getComponentList(num,size);
        page.setData(list);
        page.setTotal(componentMapper.findComponentCount());

        return page;
    }
}
