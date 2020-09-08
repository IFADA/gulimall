package com.atguigu.gulimall.product.web;

import com.atguigu.gulimall.product.VO.Catelog2Vo;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    CategoryService categoryService;

    @GetMapping({"/","index.html"})
    public String indexPage(Model model){
       List<CategoryEntity> categoryEntities = categoryService.getLevel1Categorys();
       model.addAttribute("categorys",categoryEntities);
       return "index";
    }
    //index/json/catalog.json
    @GetMapping(value = "/index/catalog.json")
    @ResponseBody
    public Map<String, List<Catelog2Vo>> getCatalogJson() {

        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJson();

        return catalogJson;

    }

}
