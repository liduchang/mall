package com.javaboy.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaboy.common.utils.PageUtils;
import com.javaboy.mall.order.entity.OrderSettingEntity;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author liduchang
 * @email liduchang@qq.com
 * @date 2020-10-08 09:56:16
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

