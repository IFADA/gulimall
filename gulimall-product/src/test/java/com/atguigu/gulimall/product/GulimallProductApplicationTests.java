package com.atguigu.gulimall.product;



import com.atguigu.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

@SpringBootTest
@Slf4j
class GulimallProductApplicationTests {
   @Autowired
    CategoryService categoryService;

   @Test
   public void  testFindPath(){
//       Long[] catelogPath = categoryService.findCatelogPath((long) 225);
//       log.info("完成路径:{}", Arrays.asList(catelogPath));
   }
}
