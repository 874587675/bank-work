package com.cc.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMoney implements Serializable {
    /**
     *
     */
    private Integer userId;

    /**
     *
     */
    private BigDecimal userMoney;
    /**
     *
     */
    private Byte deleted;

    private static final long serialVersionUID = 1L;
}
