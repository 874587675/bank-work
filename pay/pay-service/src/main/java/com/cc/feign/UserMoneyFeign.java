package com.cc.feign;

import com.cc.object.AjaxResult;
import com.cc.vo.UserMoneyVo;
import com.cc.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("bank-user-service")
public interface UserMoneyFeign {
    // 查询用户余额
    @GetMapping("/user/getUsersMoney")
    List<UserMoneyVo> getUsersMoney(@RequestParam("userId") Integer userId);

    // 修改用户余额
    @PostMapping("/user/setUsersMoney")
    AjaxResult setUsersMoney(@RequestBody UserMoneyVo userMoneyVo);

    // 新增用户余额
    @PostMapping("/user/insertUsersMoney")
    AjaxResult insertUsersMoney(@RequestBody UserMoneyVo userMoneyVo);

    @PostMapping("/user/selectUser")
    List<UserVo> selectUser(@RequestBody UserVo userVo);
}
