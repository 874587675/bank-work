package com.cc.service.impl;

import com.cc.mapper.UserMapper;
import com.cc.mapper.UserMoneyMapper;
import com.cc.service.UserService;
import com.cc.vo.UserMoneyVo;
import com.cc.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    private final UserMoneyMapper userMoneyMapper;


    // 查询用户基本信息
    @Override
    public List<UserVo> selectUsers(UserVo userVo){
        List<UserVo> userVos = userMapper.selectUsers(userVo);
        return userVos;
    }

    // 新增用户
    @Override
    @Transactional
    public Integer insertUser(UserVo userVo) {
        // 插入用户
        Integer result = userMapper.insertUser(userVo);

        // 确认 ID 是否被正确设置
        Integer userId = userVo.getId();

        if (userId != null) {
            // 插入用户余额
            UserMoneyVo userMoneyVo = new UserMoneyVo();
            userMoneyVo.setUserId(userId);
            userMoneyVo.setUserMoney(BigDecimal.valueOf(0));
            userMoneyMapper.insertUsersMoney(userMoneyVo);
        } else {
            // 处理 ID 为空的情况
            System.err.println("Failed to retrieve user ID after insertion.");
        }

        return result;
    }

    //  修改用户
    @Override
    @Transactional
    public Integer updateUser(UserVo userVo) {
        return userMapper.updateUser(userVo);
    }

    //  删除用户
    @Override
    @Transactional
    public Integer deleteUser(UserVo userVo) {
        Integer result = userMapper.deleteUser(userVo);
        // 删除用户余额
        UserMoneyVo userMoneyVo = new UserMoneyVo();
        userMoneyVo.setUserId(userVo.getId());
        userMoneyVo.setDeleted(userVo.getDeleted());
        userMoneyMapper.deleteUsersMoney(userMoneyVo);
        return result;
    }
}
