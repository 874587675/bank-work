package com.cc.service;


import com.cc.vo.UserMoneyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMoneyService {
    // 查询用户余额
    List<UserMoneyVo> getUsersMoney(Integer userId);
    // 修改用户余额
    Integer setUsersMoney(UserMoneyVo userMoneyVo);
    // 新增用户余额
    Integer insertUsersMoney(UserMoneyVo userMoneyVo);
}
