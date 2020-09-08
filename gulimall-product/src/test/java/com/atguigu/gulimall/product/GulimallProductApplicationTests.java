package com.atguigu.gulimall.product;



import com.atguigu.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

@SpringBootTest
@Slf4j
class GulimallProductApplicationTests {
   @Autowired
    CategoryService categoryService;
   @Autowired
    StringRedisTemplate redisTemplate;
   @Autowired
    RedissonClient redissonClient;

   @Test
   public void  testFindPath(){
//       Long[] catelogPath = categoryService.findCatelogPath((long) 225);
//       log.info("完成路径:{}", Arrays.asList(catelogPath));
   }
   @Test
    public  void  testRedist(){
       ValueOperations<String, String> ops = redisTemplate.opsForValue();
          ops.set("hello","wold");
       String hello = ops.get("hello");
       System.out.println(hello);
   }
    @Test
    public void  testReddsion() {
        System.out.println(redissonClient);
   }
}
