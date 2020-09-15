package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.VO.SkuItemSaleAttrVo;
import com.atguigu.gulimall.product.entity.SkuSaleAttrValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * sku销售属性&值
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-08-22 14:53:36
 */
@Mapper
public interface SkuSaleAttrValueDao extends BaseMapper<SkuSaleAttrValueEntity> {

    List<SkuItemSaleAttrVo> getSaleAttrsBySpuId(Long spuId);

    List<String> getSkuSaleValuesAsStringList(Long skuId);
}
