package com.javaboy.mall.coupon.dao;

import com.javaboy.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author liduchang
 * @email liduchang@qq.com
 * @date 2020-10-08 09:36:40
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
