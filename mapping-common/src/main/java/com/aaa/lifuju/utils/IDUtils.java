package com.aaa.lifuju.utils;

import java.util.UUID;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.utils
 * @ClassName: IDUtils
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/16 11:33
 * @Version: 1.0
 */
public class IDUtils {
    private IDUtils() {

    }

    /**
     * @author Seven Lee
     * @description
     *      获取uuid
     * @param [id]
     * @date 2020/5/15
     * @return java.lang.String
     * @throws
     **/
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
