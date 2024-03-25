package com.example.toamto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.toamto.model.Component;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.print.attribute.IntegerSyntax;
import java.util.List;

@Mapper
public interface ComponentMapper extends BaseMapper<Component> {

    @Select("select * from component limit #{page},#{size}")
    List<Component> getComponentList(@Param("page") Integer page, @Param("size")Integer size);

    @Select("select count(1) from component")
    Long findComponentCount();
}
