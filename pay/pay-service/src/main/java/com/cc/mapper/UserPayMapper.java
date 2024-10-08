package com.cc.mapper;

import com.cc.vo.TransferRecordVo;

public interface UserPayMapper {
    // 新增用户转账记录
    Integer insertTransferRecord(TransferRecordVo transferRecordVo);
}
