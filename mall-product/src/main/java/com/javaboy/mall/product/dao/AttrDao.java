package com.javaboy.mall.product.dao;

import com.javaboy.mall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	
}
