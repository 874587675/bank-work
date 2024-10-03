package com.cc.service;

import com.cc.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    
    // 查询用户基本信息
    List<UserVo> selectUsers(UserVo userVo);
}
