package com.atgulimall.gulimall.seckill.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Slf4j
@EnableAsync
public class HelloSchedule {
    /**
     * spring中6位组成
     */
    @Async
    @Scheduled(cron = "* * * * * ?")
    public void hello() {
        log.info("hellp");
    }

}
