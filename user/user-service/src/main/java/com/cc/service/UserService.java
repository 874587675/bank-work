package com.cc.service;

import com.cc.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    // 查询用户基本信息
    List<UserVo> selectUsers(UserVo userVo);
    // 新增用户
    Integer insertUser(UserVo userVo);
    // 修改用户状态
    Integer updateUser(UserVo userVo);
    // 逻辑删除用户
    Integer deleteUser(UserVo userVo);
}
