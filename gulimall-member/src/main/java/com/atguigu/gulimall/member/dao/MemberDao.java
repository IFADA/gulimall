package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author feng
 * @email ${email}
 * @date 2020-08-22 16:21:23
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
