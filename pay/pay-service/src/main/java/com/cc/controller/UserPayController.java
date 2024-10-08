package com.cc.controller;

import com.cc.object.AjaxResult;
import com.cc.service.UserPayService;
import com.cc.vo.TransferRecordVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/pay")
public class UserPayController {
    private final UserPayService userPayService;

    //生成转账记录
    @RequestMapping("/insertTransferRecord")
    public AjaxResult insertTransferRecord(@RequestBody TransferRecordVo transferRecordVo) {
        return AjaxResult.success(userPayService.insertTransferRecord(transferRecordVo));
    }
}
