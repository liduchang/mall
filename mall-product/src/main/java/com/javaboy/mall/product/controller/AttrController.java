package com.javaboy.mall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.javaboy.common.utils.Resp;
import com.javaboy.mall.product.entity.ProductAttrValueEntity;
import com.javaboy.mall.product.service.ProductAttrValueService;
import com.javaboy.mall.product.vo.AttrRespVo;
import com.javaboy.mall.product.vo.AttrVo;
import com.javaboy.mall.product.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javaboy.common.utils.PageUtils;


/**
 * 商品属性
 *
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @Autowired
    ProductAttrValueService productAttrValueService;

    ///product/attr/info/{attrId}

    // /product/attr/base/listforspu/{spuId}
    @GetMapping("/base/listforspu/{spuId}")
    public Resp baseAttrlistforspu(@PathVariable("spuId") Long spuId){

        List<ProductAttrValueEntity> entities = productAttrValueService.baseAttrlistforspu(spuId);

        return Resp.ok().put("data",entities);
    }

    //product/attr/sale/list/0?
    ///product/attr/base/list/{catelogId}
    @GetMapping("/{attrType}/list/{catelogId}")
    public Resp baseAttrList(@RequestParam Map<String, Object> params,
                             @PathVariable("catelogId") Long catelogId,
                             @PathVariable("attrType")String type){

        PageUtils page = attrService.queryBaseAttrPage(params,catelogId,type);
        return Resp.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public Resp list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return Resp.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public Resp info(@PathVariable("attrId") Long attrId){
		//AttrEntity attr = attrService.getById(attrId);
        AttrRespVo respVo = attrService.getAttrInfo(attrId);

        return Resp.ok().put("attr", respVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public Resp save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return Resp.ok();
    }

    ///product/attrgroup/attr/relation/delete


    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public Resp update(@RequestBody AttrVo attr){
		attrService.updateAttr(attr);

        return Resp.ok();
    }

    ///product/attr/update/{spuId}
    @PostMapping("/update/{spuId}")
    public Resp updateSpuAttr(@PathVariable("spuId") Long spuId,
                              @RequestBody List<ProductAttrValueEntity> entities){

        productAttrValueService.updateSpuAttr(spuId,entities);

        return Resp.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public Resp delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return Resp.ok();
    }

}
