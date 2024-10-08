package com.cc.service;


import com.cc.vo.TransferRecordVo;

public interface UserPayService {
    // 新增用户转账记录
    Integer insertTransferRecord(TransferRecordVo transferRecordVo);
}
