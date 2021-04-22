package com.javaboy.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaboy.common.utils.PageUtils;
import com.javaboy.mall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

