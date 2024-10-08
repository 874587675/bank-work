package com.cc.mapper;

import com.cc.vo.UserMoneyVo;
import com.cc.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMoneyMapper {
    // 查询用户余额
    List<UserMoneyVo> getUsersMoney(@Param("userId") Integer userId);
    // 修改用户余额
    Integer setUsersMoney(UserMoneyVo userMoneyVo);
    // 新增用户余额
    Integer insertUsersMoney(UserMoneyVo userMoneyVo);
    // 删除用户余额
    Integer deleteUsersMoney(UserMoneyVo userMoneyVo);
}
