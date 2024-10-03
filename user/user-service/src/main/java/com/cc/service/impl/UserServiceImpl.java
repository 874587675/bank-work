package com.cc.service.impl;

import com.cc.mapper.UserMapper;
import com.cc.service.UserService;
import com.cc.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:
 * @ClassName:
 * @description:
 * @author: zgc
 * @date:
 * @Version 1.0
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    // 引入 UserMapper 并注入
    private final UserMapper userMapper;
    
    
    // 查询用户基本信息
    @Override
    public List<UserVo> selectUsers(UserVo userVo){
        List<UserVo> userVos = userMapper.selectUsers(userVo);
        return  userVos;
    }
}
