package com.cc.mapper;

import com.cc.vo.UserVo;

import java.util.List;
public interface UserMapper {
    // 查询用户基本信息
    List<UserVo> selectUsers(UserVo userVo);
}
