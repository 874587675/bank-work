package com.cc.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRecord implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private Integer senderId;

    /**
     *
     */
    private Integer receiverId;

    /**
     *
     */
    private BigDecimal amount;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     *
     */
    private String status;

    private static final long serialVersionUID = 1L;
}
