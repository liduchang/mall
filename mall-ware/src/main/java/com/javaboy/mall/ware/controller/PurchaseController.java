package com.javaboy.mall.ware.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.javaboy.mall.ware.vo.MergeVo;
import com.javaboy.mall.ware.vo.PurchaseDoneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javaboy.mall.ware.entity.PurchaseEntity;
import com.javaboy.mall.ware.service.PurchaseService;
import com.javaboy.common.utils.PageUtils;
import com.javaboy.common.utils.Resp;



/**
 * 采购信息
 *
 * @author liduchang
 * @email liduchang@qq.com
 * @date 2020-11-17 13:50:10
 */
@RestController
@RequestMapping("ware/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    ///ware/purchase/done
    @PostMapping("/done")
    public Resp finish(@RequestBody PurchaseDoneVo doneVo){

        purchaseService.done(doneVo);

        return Resp.ok();
    }

    /**
     * 领取采购单
     * @return
     */
    @PostMapping("/received")
    public Resp received(@RequestBody List<Long> ids){

        purchaseService.received(ids);

        return Resp.ok();
    }

    ///ware/purchase/unreceive/list
    ///ware/purchase/merge
    @PostMapping("/merge")
    public Resp merge(@RequestBody MergeVo mergeVo){

        purchaseService.mergePurchase(mergeVo);
        return Resp.ok();
    }

    @RequestMapping("/unreceive/list")
    //@RequiresPermissions("ware:purchase:list")
    public Resp unreceivelist(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPageUnreceivePurchase(params);

        return Resp.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:purchase:list")
    public Resp list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPage(params);

        return Resp.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:purchase:info")
    public Resp info(@PathVariable("id") Long id){
		PurchaseEntity purchase = purchaseService.getById(id);

        return Resp.ok().put("purchase", purchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:purchase:save")
    public Resp save(@RequestBody PurchaseEntity purchase){
        purchase.setUpdateTime(new Date());
        purchase.setCreateTime(new Date());
		purchaseService.save(purchase);

        return Resp.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:purchase:update")
    public Resp update(@RequestBody PurchaseEntity purchase){
		purchaseService.updateById(purchase);

        return Resp.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:purchase:delete")
    public Resp delete(@RequestBody Long[] ids){
		purchaseService.removeByIds(Arrays.asList(ids));

        return Resp.ok();
    }

}
