package com.javaboy.mall.ware.feign;

import com.javaboy.common.utils.Resp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("mall-product")
public interface ProductFeignService {

    /**
     *      /product/skuinfo/info/{skuId}
     *
     *
     *   1)、让所有请求过网关；
     *          1、@FeignClient("mall-gateway")：给mall-gateway所在的机器发请求
     *          2、/api/product/skuinfo/info/{skuId}
     *   2）、直接让后台指定服务处理
     *          1、@FeignClient("mall-gateway")
     *          2、/product/skuinfo/info/{skuId}
     *
     * @return
     */
    @RequestMapping("/product/skuinfo/info/{skuId}")
    public Resp info(@PathVariable("skuId") Long skuId);
}
