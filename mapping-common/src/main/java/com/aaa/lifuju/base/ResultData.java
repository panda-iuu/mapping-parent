package com.aaa.lifuju.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.base
 * @ClassName: ResultData
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/13 11:38
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
public class ResultData<T> implements Serializable {
    private String code;
    private String msg;
    private String detail;
    private T data;
}
