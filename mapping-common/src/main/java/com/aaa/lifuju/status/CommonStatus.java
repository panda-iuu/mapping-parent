package com.aaa.lifuju.status;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.status
 * @ClassName: CommonStatus
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/13 13:28
 * @Version: 1.0
 */
public enum  CommonStatus {

        SELECT_SUCCESS("20001","获取数据成功"),
        SELECT_FAILED("10001","获取数据失败"),
        ADD_SUCCESS("20001","新增数据成功"),
        ADD_FAILED("10001","新增数据失败"),
        UPDATE_SUCCESS("20001","更改数据成功"),
        UPDATE_FAILED("10001","更改数据失败"),
        DELETE_SUCCESS("20001","删除数据成功"),
        DElETE_FAILED("10001","删除数据失败");

        CommonStatus(String code, String msg) {
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
