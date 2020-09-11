package com.atguigu.gulimall.product.web;

import com.atguigu.gulimall.product.VO.SkuItemVo;
import com.atguigu.gulimall.product.dao.SkuImagesDao;
import com.atguigu.gulimall.product.entity.SkuImagesEntity;
import com.atguigu.gulimall.product.service.SkuImagesService;
import com.atguigu.gulimall.product.service.SkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class ItemController {
   @Autowired
    SkuInfoService skuInfoService;
   @Autowired
    SkuImagesService imagesService;
    @GetMapping("/{skuId}.html")
    public String skuItem(@PathVariable("skuId") Long skuId, Model model) throws ExecutionException, InterruptedException {

        SkuItemVo skuItemVo = skuInfoService.item(skuId);
        System.out.println("准备查询" + skuId + "详情");
        model.addAttribute("item",skuItemVo);
        return "item";
    }
}
