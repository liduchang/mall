package com.javaboy.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaboy.common.utils.PageUtils;
import com.javaboy.mall.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * δΈι’εε
 *
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

