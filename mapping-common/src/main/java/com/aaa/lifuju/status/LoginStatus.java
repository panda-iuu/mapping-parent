package com.aaa.lifuju.status;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.status
 * @ClassName: LoginStatus
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/13 11:48
 * @Version: 1.0
 */
public enum LoginStatus {
    LOGIN_SUCCESS("20001", "登录成功"),
    LOGIN_FAILED("10001", "登录失败"),
    USER_EXIST("20002", "用户存在"),
    USER_NOT_EXIST("10002", "用户不存在"),
    PASSWORD_WRONG("10003", "密码错误"),
    USER_LOCKED("10004", "账号被锁定"),
    LOGOUT_WRONG("10005", "用户退出异常");

    LoginStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
