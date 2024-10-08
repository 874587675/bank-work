package com.cc.controller;

import com.cc.object.AjaxResult;
import com.cc.service.UserMoneyService;
import com.cc.service.UserService;
import com.cc.vo.UserMoneyVo;
import com.cc.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program:
 * @ClassName:
 * @description:
 * @author: zgc
 * @date:
 * @Version 1.0
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    // 引入 UserService
    private final UserService userService;

    // 引入 UserMoneyService 并注入
    private final UserMoneyService userMoneyService;

    //查询用户基本信息
    @PostMapping("/selectUser")
    public List<UserVo> selectUser(@RequestBody UserVo userVo) {
        List<UserVo> users = userService.selectUsers(userVo);
        if (users!=null){
            return users;
        }
        return null;
    }

    @PostMapping("/selectUsers")
    public AjaxResult selectUsers(@RequestBody UserVo userVo) {
        List<UserVo> users = userService.selectUsers(userVo);
        if (users!=null){
            return AjaxResult.success(users);
        }
        return AjaxResult.error("查询用户基本信息失败");
    }

    // 新增用户

    @PostMapping("/insertUser")
    public AjaxResult insertUser(@RequestBody UserVo userVo) {
        int i = userService.insertUser(userVo);
        if (i > 0) {
            return AjaxResult.success(i);
        }
        return AjaxResult.error("新增用户失败");
    }

    // 修改用户

    @PostMapping("/updateUser")
    public AjaxResult updateUser(@RequestBody UserVo userVo) {
        int i = userService.updateUser(userVo);
        if (i > 0) {
            return AjaxResult.success(i);
        }
        return AjaxResult.error("修改用户状态失败");
    }
    // 删除用户

    @PostMapping("/deleteUser")
    public AjaxResult deleteUser(@RequestBody UserVo userVo) {
        int i = userService.deleteUser(userVo);
        if (i > 0) {
            return AjaxResult.success(i);
        }
        return AjaxResult.error("删除用户失败");
    }

    // 查询用户余额

    @GetMapping("/getUsersMoney")
    public List<UserMoneyVo> getUsersMoney(@RequestParam("userId") Integer userId){
        return userMoneyService.getUsersMoney(userId);
    }

    // 修改用户余额

    @PostMapping("/setUsersMoney")
    public AjaxResult setUsersMoney(@RequestBody UserMoneyVo userMoneyVo){
        return AjaxResult.success(userMoneyService.setUsersMoney(userMoneyVo));
    }

    // 新增用户余额

    @PostMapping("/insertUsersMoney")
    public AjaxResult insertUsersMoney(@RequestBody UserMoneyVo userMoneyVo){
        return AjaxResult.success(userMoneyService.insertUsersMoney(userMoneyVo));
    }

}
