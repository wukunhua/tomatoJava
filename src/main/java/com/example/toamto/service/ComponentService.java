package com.example.toamto.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.toamto.mapper.ComponentMapper;
import com.example.toamto.model.Component;
import com.example.toamto.model.Page;
import com.example.toamto.model.ResultObj;
import com.example.toamto.model.SearchComponentDto;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public ResultObj getComponentListByIpage(SearchComponentDto dto){
        QueryWrapper<Component> queryWrapper = new QueryWrapper<>();
        Map<String, Object> dtomap = BeanUtil.beanToMap(dto);
        queryWrapper.allEq((k,v)->(
                k.equals("componentsname") || k.equals("manufacturer")
                ),dtomap,false);
        IPage<Component> iPage1 = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>((dto.getPage()),dto.getSize());
        iPage1 = componentMapper.selectPage(iPage1,queryWrapper);
        resultObj.setData(iPage1);
        resultObj.setCode("v");

        return resultObj;
    }


    public ResultObj getComponentListByPage(SearchComponentDto dto){

        //IPage<Component> iPage1 = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>((dto.getPage() - 1),dto.getSize());
        List<Component> componentListByPage = componentMapper.getComponentListByPage(dto.getComponentsname(), dto.getManufacturer());
        resultObj.setData(componentListByPage);
        resultObj.setCode("v");

        return resultObj;
    }



    public ResultObj saveComponent(Component component){
        componentMapper.insert(component);
        resultObj.setCode("v");
        return resultObj;
    }
}
