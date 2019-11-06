package com.swalikh.kernel.utils;

import lombok.Data;
import java.io.Serializable;
/**
 * 时    间: 2019/9/2 14:10
 * 方法描述：结果相应类
 * 返回类型：
 * 修改内容：（若修改了请注明修改人，修改时间，修改内容）
 */
@Data
public class Result implements Serializable {

    public static final int OK = 200;
    public static final int ERR = 400;
    // 响应状态
    private Integer status;
    // 响应消息
    private String msg;
    // 响应数据
    private Object data;
    public Result() {

    }
    /**
     * @Author: Mr.huanglei
     * @Date: 2018/11/5  14:52
     * @Description: 单纯成功时或失败时的响应消息，在msg中添加具体的消息内容，成功为200，客户端数据有错误为400，服务端发生错误为500
     */
    public static Result ok(String successMsg) {
        return new Result(200, successMsg, null);
    }
    public static Result ok(Object data) {
        return new Result(200, null, data);
    }
    public static Result ok(String msg,Object data) {
        return new Result(200, msg, data);
    }

    public static Result err(String errMsg) {
        return new Result(400, errMsg, null);
    }

    //构建特殊情况的响应，不包含data属性
    public static Result build(Integer status, String msg) {
        return new Result(status, msg, null);
    }

    public static Result build(Integer status, String msg, Object data) {
        return new Result(status, msg, data);
    }

    //构建成功时候的响应
    public static Result buildOk(String msg, Object data) {
        return new Result(200, msg, data);
    }

    public Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

}
