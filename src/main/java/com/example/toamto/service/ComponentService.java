package com.example.toamto.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ComponentService extends ServiceImpl<ComponentMapper,Component> {
    @Resource
    ComponentMapper componentMapper;
    @Resource
    Page<Component> page;

    @Resource
    ResultObj resultObj;

    public ResultObj getList(SearchComponentDto dto){
        QueryWrapper<Component> queryWrapper = new QueryWrapper<>();
        Map<String, Object> dtomap = BeanUtil.beanToMap(dto);
        queryWrapper.allEq((k,v)->(
                k.equals("componentsname") || k.equals("manufacturer")
                ),dtomap,false);
        queryWrapper.orderByDesc("id");
        try {
            IPage<Component> iPage = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>((dto.getPage()),dto.getSize());
            iPage = componentMapper.selectPage(iPage,queryWrapper);
            resultObj.setData(iPage);
            resultObj.setCode("v");
        }catch (NullPointerException e){
            resultObj.setCode("error");
            resultObj.setMsg(e.toString());
        }
//        List<Component> componentListByPage = componentMapper.getComponentListByPage(dto.getComponentsname(), dto.getManufacturer());
//        resultObj.setData(componentListByPage);

        return resultObj;
    }

    public ResultObj updateComponent(Long id,Boolean isAdd,Integer num){
        UpdateWrapper<Component> updateWrapper = new UpdateWrapper<Component>();
        Component component = componentMapper.selectById(id);
        updateWrapper.eq("id",id);
        if(isAdd){
            updateWrapper.set("num",component.getNum() + num);
        }else{
            updateWrapper.set("num",component.getNum() - num);
        }

        //ComponentService componentService = new ComponentService();
        this.update(updateWrapper);
        return resultObj;
    }

    public ResultObj saveComponent(Component component){
        componentMapper.insert(component);
        resultObj.setCode("v");
        return resultObj;
    }
}
