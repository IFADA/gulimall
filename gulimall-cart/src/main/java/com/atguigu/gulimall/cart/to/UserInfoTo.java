package com.atguigu.gulimall.cart.to;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserInfoTo {
    //用户已经登录
    private Long userId;
    //用户临时登录
    private String userKey;
    private boolean tempUser=false;
}
