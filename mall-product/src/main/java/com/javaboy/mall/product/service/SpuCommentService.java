package com.javaboy.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaboy.common.utils.PageUtils;
import com.javaboy.mall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

