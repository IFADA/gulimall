package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author feng
 * @email ${email}
 * @date 2020-08-22 16:07:03
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
