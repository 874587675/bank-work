package com.cc.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 用户类型（0普通用户、1银行人员）
     */
    private Byte userType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 是否已删除
     */
    private byte[] deleted;

    /**
     * 密码盐值
     */
    private String salt;

    private static final long serialVersionUID = 1L;
}
