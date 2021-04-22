package com.javaboy.mall.product.dao;

import com.javaboy.mall.product.entity.BrandEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {
	
}
