package com.aaa.lifuju.controller;

import com.aaa.lifuju.model.User;
import com.aaa.lifuju.service.LoginService;
import com.aaa.lifuju.redis.RedisService;
import com.aaa.lifuju.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.controller
 * @ClassName: LoginController
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/16 11:46
 * @Version: 1.0
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisService redisService;

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
    public TokenVo doLogin(@RequestBody User user) {
        return loginService.doLogin(user, redisService);
    }
}
