package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生管理对象 student
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
public class Student extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Integer id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String name;

    /** 密码 */
    @Excel(name = "密码")
    private String pwd;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPwd(String pwd) 
    {
        this.pwd = pwd;
    }

    public String getPwd() 
    {
        return pwd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("pwd", getPwd())
            .toString();
    }
}
