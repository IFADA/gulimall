package com.atguigu.gulimall.gulimallauthserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.atguigu.common.utils.HttpUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.gulimallauthserver.feign.MemberFeignService;
import com.atguigu.common.vo.MemberResponseVo;
import com.atguigu.gulimall.gulimallauthserver.vo.SocialUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class OAuth2Controller {

    @Autowired
    private MemberFeignService memberFeignService;

    @GetMapping(value = "/oauth2.0/weibo/success")
    public String weibo(@RequestParam("code") String code, HttpSession session, HttpServletResponse servletResponse) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("client_id", "1276978904");
        map.put("client_secret", "217628e76cbf8792bb320ea3d01a3eb6");
        map.put("grant_type", "authorization_code");
        map.put("redirect_uri", "http://auth.gulimall.com/oauth2.0/weibo/success");
        map.put("code", code);
        //1、根据code换取accessToken
        HttpResponse response = HttpUtils.doPost("https://api.weibo.com", "/oauth2/access_token", "post", new HashMap<>(), map, new HashMap<>());
        //2.处理
        if (response.getStatusLine().getStatusCode() == 200) {
            String json = EntityUtils.toString(response.getEntity());
            SocialUser socialUser = JSON.parseObject(json, SocialUser.class);
            //知道了哪个社交用户
            //1）、当前用户如果是第一次进网站，自动注册进来（为当前社交用户生成一个会员信息，以后这个社交账号就对应指定的会员）
            //登录或者注册这个社交用户
            System.out.println(socialUser.getAccess_token());
            //调用远程服务
            R oauthLogin = memberFeignService.oauthLogin(socialUser);
            if (oauthLogin.getCode() == 0) {
                MemberResponseVo data = oauthLogin.getData("data", new TypeReference<MemberResponseVo>() {
                });
                log.info("登录成功,用户{}", data.toString());
                //TODO:1 默认发的令牌作用域为当前域，解决子域共享问题
                //TODO:2.使用JSON的序列化存放seesion到redis中
                session.setAttribute("loginUser", data);
                //1.第一次使用session:命令浏览器保存卡号 ,以后浏览器访问浏览器就会带上这个网站cookie
                //子域名 gulimall.com auth.gulimall.com order.gulimall.com
                //2、登录成功跳回首页
                return "redirect:http://gulimall.com";

            }

        } else {
            return "redirect:http://auth.gulimall.com/login.html";
        }
        //2、登录成功跳回首页
        return "redirect:http://gulimall.com";
    }

}
