package com.aaa.lifuju.base;

import static com.aaa.lifuju.status.CommonStatus.*;
import static com.aaa.lifuju.status.LoginStatus.LOGIN_FAILED;
import static com.aaa.lifuju.status.LoginStatus.LOGIN_SUCCESS;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.base
 * @ClassName: BaseController
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/12 23:48
 * @Version: 1.0
 */
public class BaseController {

    /**
     *@Description: TODO
     * 登录成功 系统消息
     *@MethodName: loginSuccess
     *@Author: lifuju
     *@Date: 2020/5/12 23:55
     */

    protected ResultData loginSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     *@Description: TODO
     * 登录成功 自定义消息
     *@MethodName: loginSuccess
     *@Author: lifuju
     *@Date: 2020/5/12 23:55
     */

    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
        /**
         *@Description: TODO
         * 登录成功，系统消息，自定义返回值
         *@MethodName: loginSuccess
         *@Author: lifuju
         *@Date: 2020/5/12 23:56
         */

        protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     *@Description: TODO
     * 登录成功，自定义消息，自定义返回值
     *@MethodName: loginSuccess
     *@Author: lifuju
     *@Date: 2020/5/12 23:56
     */

    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }


    /**
     *@Description: TODO
     *  登录失败，使用系统消息
     *@MethodName: loginFailed
     *@Author: lifuju
     *@Date: 2020/5/12 23:56
     */

    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }


    /**
     *@Description: TODO
     * 查询数据成功，使用系统消息，返回数据
     *@MethodName: getSuccess
     *@Author: lifuju
     *@Date: 2020/5/12 23:43
     */


    protected ResultData getSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
   /**
    *@Description: TODO
    * 查询数据失败，使用系统消息
    *@MethodName: getFailed
    *@Author: lifuju
    *@Date: 2020/5/12 23:43
    */

   protected ResultData getFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(SELECT_FAILED.getMsg());
        return resultData;
    }
   /**
    *@Description: TODO
    * 新增数据成功，使用系统消息
    *@MethodName: addSuccess
    *@Author: lifuju
    *@Date: 2020/5/12 23:43
    */

   protected ResultData addSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_SUCCESS.getCode());
        resultData.setMsg(ADD_SUCCESS.getMsg());
        return resultData;
    }
    /**
     *@Description: TODO
     * 新增数据失败，使用系统消息
     *@MethodName: addFailed
     *@Author: lifuju
     *@Date: 2020/5/12 23:30
     */

    protected ResultData addFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_FAILED.getCode());
        resultData.setMsg(ADD_FAILED.getMsg());
        return resultData;
    }
   /**
    *@Description: TODO
    * 更改数据成功，使用系统消息
    *@MethodName: updateSuccess
    *@Author: lifuju
    *@Date: 2020/5/12 23:44
    */

   protected ResultData updateSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }

  /**
   *@Description: TODO
   * 新数据失败，使用系统消息
   *@MethodName: updateFailed
   *@Author: lifuju
   *@Date: 2020/5/12 22:45
   */

  protected ResultData updateFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }


    /**
     *@Description: TODO
     * 删除成功 系统消息
     *@MethodName: deleteSuccess
     *@Author: lifuju
     *@Date: 2020/5/13 13:32
     */

    protected ResultData deleteSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        return resultData;
    }
    /**
     *@Description: TODO
     * 删除成功 自定义消息
     *@MethodName: deleteSuccess
     *@Author: lifuju
     *@Date: 2020/5/13 13:38
     */

    protected ResultData deleteSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     *@Description: TODO
     * 删除失败 系统消息
     *@MethodName: deleteFailed
     *@Author: lifuju
     *@Date: 2020/5/13 13:40
     */

    protected ResultData deleteFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(DElETE_FAILED.getCode());
        resultData.setMsg(DElETE_FAILED.getMsg());
        return resultData;
    }
    /**
     *@Description: TODO
     * 删除失败 自定义消息
     *@MethodName: deleteFailed
     *@Author: lifuju
     *@Date: 2020/5/13 13:41
     */

    protected ResultData deleteFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DElETE_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

}
