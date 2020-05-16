package com.aaa.lifuju.base;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.base
 * @ClassName: CommonController
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/13 08:27
 * @Version: 1.0
 */
public abstract class CommonController<T> extends BaseController{
    /**
     *@Description: TODO
     * 钩子函数  在新增之前锁执行的内容
     *@MethodName: beforeAdd
     *@Author: lifuju
     *@Date: 2020/5/13 11:28
     */

    protected void beforeAdd(Map map){

    }

    /**
     *@Description: TODO
     * 钩子函数  新增之后所执行的内容
     *@MethodName: afterAdd
     *@Author: lifuju
     *@Date: 2020/5/13 11:29
     */

    protected void afterAdd(Map map){

    }
    /**
     *@Description: TODO
     * 查询一条数据
     *@MethodName: getOne
     *@Author: lifuju
     *@Date: 2020/5/13 11:32
     */
    public ResultData getOne(Map map){
        T instance = getBaseService().newInstance(map);
        try {
            T queryOne = getBaseService().queryOne(instance);
            if(null!=null && "".equals(queryOne)){
                return getSuccess(queryOne);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getFailed();
    }
        /**
         *@Description: TODO
         * 条件查询
         *@MethodName: getList
         *@Author: lifuju
         *@Date: 2020/5/13 11:40
         */
        public ResultData getList(Map map){
        T instance = getBaseService().newInstance(map);
        try {
            List<T> ts = getBaseService().queryList(instance);
            if(ts.size()>0){
                return getSuccess(ts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getFailed();
    }
        /**
         *@Description: TODO
         * 分页查询
         *@MethodName: getListByPage
         *@Author: lifuju
         *@Date: 2020/5/13 11:46
         */
        public ResultData getListByPage(Map map, Integer pageNo, Integer pageSize){
        T instance = getBaseService().newInstance(map);
        try {
            PageInfo<T> tPageInfo = getBaseService().queryListByPage(instance, pageNo, pageSize);
            if (null!=tPageInfo && "".equals(tPageInfo)){
                return getSuccess(tPageInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getFailed();
    }

    public  abstract BaseService<T> getBaseService();

    /**
     *@Description: TODO
     * 新增数据
     *@MethodName: add
     *@Author: lifuju
     *@Date: 2020/5/13 13:12
     */

    public ResultData add(@RequestBody Map map){
      beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            Integer insertResult = getBaseService().add(instance);
            if (insertResult >0) {
                //说明保存成功
                afterAdd(map);
                return loginSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginFailed();
    }
    // TODO delete, batchDelete, update, getOne, getList, getListByPage(不带条件的分页查询)

    /**
     *@Description: TODO
     * 通过主键 删除数据
     *@MethodName: delete
     *@Author: lifuju
     *@Date: 2020/5/13 13:46
     */

    public ResultData delete(@RequestBody Map map){
        T intance = getBaseService().newInstance(map);
        try {
            Integer delete = getBaseService().delete(intance);
            if (delete >0){
                return deleteSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteFailed();
    }
        /**
         *@Description: TODO
         * 更新一条数据
         *@MethodName: update
         *@Author: lifuju
         *@Date: 2020/5/13 13:10
         */
        public ResultData update(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        try {
            Integer update = getBaseService().update(instance);
            if(update>0){
                return updateSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateFailed();
    }

    /**
     *@Description: TODO
     * 防止数据不安全，所以不能直接在controller某个方法中直接接收HttpServletRequest对象
     * 必须要从本地当前线程中获取对象
     *@MethodName: getServletRequest
     *@Author: lifuju
     *@Date: 2020/5/13 09:01
     */

    public HttpServletRequest getServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        if(requestAttributes instanceof ServletRequestAttributes) {
            servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }
        /**
         *@Description: TODO
         *   获取当前客户端的session对象(如果不存在，则会重新创建一个)
         *@MethodName: getSession
         *@Author: lifuju
         *@Date: 2020/5/13 09:11
         */

        public HttpSession getSession() {
        return getServletRequest().getSession();
    }
        /**
         *@Description: TODO
         *  获取当前客户端的session对象(如果不存在，则直接返回为null)
         *@MethodName: getExistSession
         *@Author: lifuju
         *@Date: 2020/5/13 09：06
         */

        public HttpSession getExistSession() {
        return getServletRequest().getSession(false);

    }
}
