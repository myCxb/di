package com.dq.daoyuan.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONResult {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    ////// 成功与否
    private Boolean success;

    ////// 响应状态
    private Integer code;

    ////// 提示信息
    private String message;

    ////// 回应数据
    private Object data;

    /**
     * build : 构建
     * 无参数的情况下调用，默认为：使用人员为了省略时间下，若是调用，初始化为‘成功‘
     */
    public static JSONResult build(){
        return new JSONResult(true , ResultCode.success , "成功响应" , null);
    }


    /**
     * build : 满参
     * 满参情况下，使用人员自定义返回内容
     * @return
     */
    public static JSONResult build(boolean success , Integer code , String massage ,Object data){
        return new JSONResult(success , code , massage , data);
    }

    /**
     * success : 成功
     * 成功的情况下，Boolean的success默认为true，Integer的code默认为200；
     * 仅需要传递massage（提示信息） 与 data（数据）
     * @return
     */
    public static JSONResult success(String massage , Object data){
        return new JSONResult(true , ResultCode.success , massage , data);
    }

    /**
     * success : 失败
     * 失败的情况下，Boolean的success默认为false，Integer的code默认为500；
     * 仅需要传递massage（提示信息） 与 data（数据）
     * @return
     */
    public static JSONResult error(String massage , Object data){
        return new JSONResult(false, ResultCode.error , massage , data);
    }

    /**
     * succes ： 失败 （不算内部系统出错，仅仅是数据回流异常）
     * 查询条件为空的清空下，Boolean的success默认为false，Integer的code默认为100（系统自定义），data默认为null
     * 仅需要传递massage（提示信息）
     * @param massage
     * @return
     */
    public static JSONResult empty(String massage){
        return new JSONResult(false , ResultCode.empty , massage , null);
    }

    public JSONResult(){

    }

    public JSONResult(Boolean success, Integer code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
