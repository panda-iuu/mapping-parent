package com.aaa.lifuju.controller;

import com.aaa.lifuju.base.BaseController;
import com.aaa.lifuju.base.ResultData;
import com.aaa.lifuju.model.User;
import com.aaa.lifuju.service.IQYService;
import com.aaa.lifuju.vo.TokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.controller
 * @ClassName: LoginController
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/16 11:25
 * @Version: 1.0
 */
@RestController
@Api(value = "登录信息", tags = "用户登录接口")
public class LoginController extends BaseController {
    @Autowired
    private IQYService qyService;

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
    @ApiOperation(value = "登录功能", notes = "用户执行登录功能")
    public ResultData doLogin(User user) {
        TokenVo tokenVo = qyService.doLogin(user);
        if(tokenVo.getIfSuccess()) {
            return super.loginSuccess(tokenVo.getToken());
        }
        return super.loginFailed();
    }

}
