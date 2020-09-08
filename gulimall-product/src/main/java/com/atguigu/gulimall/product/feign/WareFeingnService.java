package com.atguigu.gulimall.product.feign;

import com.atguigu.common.to.SkuHasStockVo;
import com.atguigu.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("gulimall-ware")
public interface WareFeingnService {

    @RequestMapping("/ware/waresku/hasStock")
    R getSkusHasStock(@RequestBody List<Long> skuIds);

}
