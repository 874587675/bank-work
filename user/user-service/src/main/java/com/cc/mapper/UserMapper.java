package com.cc.mapper;

import com.cc.vo.UserVo;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface UserMapper {
    // 查询用户基本信息
    List<UserVo> selectUsers(UserVo userVo);

    //新增用户
    Integer insertUser(UserVo userVo);

    //修改用户
    Integer updateUser(UserVo userVo);

    //逻辑删除用户
    Integer deleteUser(UserVo userVo);
}
