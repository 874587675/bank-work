package com.cc.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:
 * @ClassName:
 * @description:
 * @author: zgc
 * @date:
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult {
    private Integer code;
    private String message;
    private Object data;
    
    //成功的结果
    public static AjaxResult success(Object data){
        return new AjaxResult(200, "操作成功", data);
    }
    
    //失败的结果
    public static AjaxResult error(String message) {
        return new AjaxResult(500, message, null);
    }
    
    //自定义的结果
    public static AjaxResult custom(Integer code, String message, Object data) {
        return new AjaxResult(code, message, data);
    }
}
