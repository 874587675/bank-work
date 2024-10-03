package com.cc.controller;

import com.cc.object.AjaxResult;
import com.cc.service.UserService;
import com.cc.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @GetMapping("/selectUsers")
    public AjaxResult selectUsers(UserVo userVo) {
        List<UserVo> users = userService.selectUsers(userVo);
        return AjaxResult.success(users);
    }
        
}
