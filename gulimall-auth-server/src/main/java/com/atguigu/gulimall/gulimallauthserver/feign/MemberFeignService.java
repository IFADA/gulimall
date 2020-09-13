package com.atguigu.gulimall.gulimallauthserver.feign;


import com.atguigu.common.utils.R;
import com.atguigu.gulimall.gulimallauthserver.vo.SocialUser;
import com.atguigu.gulimall.gulimallauthserver.vo.UserLoginVo;
import com.atguigu.gulimall.gulimallauthserver.vo.UserRegisterVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-member")
public interface MemberFeignService {

    @RequestMapping("/member/member/register")
    R register(@RequestBody UserRegisterVo member);


    @RequestMapping("/member/member/login")
    R login(@RequestBody UserLoginVo vo);


    @PostMapping(value = "/member/member/oauth2/login")
    R oauthLogin(@RequestBody SocialUser socialUser) throws Exception;
}
