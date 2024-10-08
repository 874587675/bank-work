package com.cc.service.impl;

import com.cc.feign.UserMoneyFeign;
import com.cc.mapper.UserPayMapper;
import com.cc.object.AjaxResult;

import com.cc.service.UserPayService;
import com.cc.vo.TransferRecordVo;
import com.cc.vo.UserMoneyVo;
import com.cc.vo.UserVo;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
public class UserPayServiceImpl implements UserPayService {
    // 引入 UserPayMapper 并注入
    private final UserPayMapper userPayMapper;

    private final UserMoneyFeign userMoneyFeign;

    @Override
    @GlobalTransactional
    public Integer insertTransferRecord(TransferRecordVo transferRecordVo) {
        List<UserMoneyVo> usersMoney = userMoneyFeign.getUsersMoney(transferRecordVo.getSenderId());
        List<UserMoneyVo> rusersMoney = userMoneyFeign.getUsersMoney(transferRecordVo.getReceiverId());
        UserVo r = new UserVo();
        r.setId(transferRecordVo.getSenderId());
        List<UserVo> rusersVo = userMoneyFeign.selectUser(r);
        Byte rstatus = rusersVo.get(0).getStatus();
        if (usersMoney != null && rstatus!=1) {
            int userId = usersMoney.get(0).getUserId();
            BigDecimal userMoney = usersMoney.get(0).getUserMoney();
            UserVo s = new UserVo();
            s.setId(userId);
            List<UserVo> susersVo = userMoneyFeign.selectUser(s);
            Byte sstatus = susersVo.get(0).getStatus();
            if (userMoney.compareTo(transferRecordVo.getAmount())>=0 && sstatus!=1){
                //扣款
                UserMoneyVo sender = new UserMoneyVo();
                sender.setUserId(transferRecordVo.getSenderId());
                sender.setUserMoney(userMoney.subtract(transferRecordVo.getAmount()));
                userMoneyFeign.setUsersMoney(sender);
                //转入
                UserMoneyVo receiver = new UserMoneyVo();
                receiver.setUserId(transferRecordVo.getReceiverId());
                receiver.setUserMoney(rusersMoney.get(0).getUserMoney().add(transferRecordVo.getAmount()));
                userMoneyFeign.setUsersMoney(receiver);
                //插入存款记录
                userPayMapper.insertTransferRecord(transferRecordVo);
                return 1;
            }
        } else {
            // 处理错误或空数据的情况
            System.out.println("Failed to retrieve user money.");
        }
        return 0;
    }
}
