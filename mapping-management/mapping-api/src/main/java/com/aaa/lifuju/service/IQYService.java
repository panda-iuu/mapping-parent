package com.aaa.lifuju.service;

import com.aaa.lifuju.model.User;
import com.aaa.lifuju.vo.TokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.service
 * @ClassName: IQYService
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/16 11:43
 * @Version: 1.0
 */
@FeignClient(value = "system-interface")
public interface IQYService {
    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param [user]
     * @date 2020/5/15
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user);
}
