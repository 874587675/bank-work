package com.cc.service.impl;

import com.cc.mapper.UserMoneyMapper;
import com.cc.service.UserMoneyService;
import com.cc.vo.UserMoneyVo;
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
public class UserMoneyServiceImpl implements UserMoneyService{
    private final UserMoneyMapper userMoneyMapper;

    @Override
    public List<UserMoneyVo> getUsersMoney(Integer userId) {
        return userMoneyMapper.getUsersMoney(userId);
    }

    @Override
    public Integer setUsersMoney(UserMoneyVo userMoneyVo) {
        return userMoneyMapper.setUsersMoney(userMoneyVo);
    }

    @Override
    public Integer insertUsersMoney(UserMoneyVo userMoneyVo) {
        return userMoneyMapper.insertUsersMoney(userMoneyVo);
    }
}
