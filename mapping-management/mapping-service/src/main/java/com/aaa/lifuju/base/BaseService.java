package com.aaa.lifuju.base;

import com.aaa.lifuju.utils.Map2BeanUtils;
import com.aaa.lifuju.utils.SpringContextUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.base
 * @ClassName: BaseService
 * @Author: lifuju
 * @Description:
 * 通用service
 * @Date: 2020/5/11 23:37
 * @Version: 1.0
 */
public abstract class BaseService<T> {

    private Class<T> cache=null;

    @Autowired
    private Mapper<T> mapper;

    /**
     *@Description: TODO
     * 为了保护Mapper的安全性必须是private但要向子类提供接口 使用protected
     *@MethodName: getMapper
     *@Author: lifuju
     *@Date: 2020/5/12 22:20
     */

    protected Mapper getMapper(){
        return mapper;
    }

    /**
     *@Description: TODO
     * 新增功能
     *@MethodName: add
     *@Author: lifuju
     *@Date: 2020/5/12 22:26
     */

    public Integer add(T t) throws Exception{
        return mapper.insertSelective(t);
    }

    /**
     *@Description: TODO
     * 通过主键删除
     *@MethodName: delete
     *@Author: lifuju
     *@Date: 2020/5/12 22:28
     */

    public Integer delete(T t) throws Exception{
        return mapper.deleteByPrimaryKey(t);
    }
    /**
     *@Description: TODO
     * 通过主键批量删除
     *@MethodName: delete
     *@Author: lifuju
     *@Date: 2020/5/12 22:31
     */

    public Integer delete(List<Object> ids) throws  Exception{
        Example example=Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id",ids)).build();
        return mapper.deleteByExample(ids);
    }

    /**
     *@Description: TODO
     * 更新功能
     *@MethodName: update
     *@Author: lifuju
     *@Date: 2020/5/12 22:40
     */

    public Integer update(T t) throws Exception{
        return mapper.updateByPrimaryKeySelective(t);
    }

    /**
     *@Description: TODO
     * 批量更新
     *@MethodName: batchUpdate
     *@Author: lifuju
     *@Date: 2020/5/12 22:45
     */

    public Integer batchUpdate(T t,Object[] ids) throws Exception{
        Example example=Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t,example);
    }

    /**
     *@Description: TODO
     * 查询一条数据
     *@MethodName: queryOne
     *@Author: lifuju
     *@Date: 2020/5/12 22:47
     */

    public T queryOne(T t) throws  Exception{
        return mapper.selectOne(t);
    }

    /**
     *@Description: TODO
     * 通过指定字段查询一条数据
     *@MethodName: queryByField
     *@Author: lifuju
     *@Date: 2020/5/12 22:59
     */

    public T queryByField(Sqls where,String orderByField,String... fields) throws Exception{
        return queryByFieldsBase(null, null, where, orderByField, fields).get(0);
    }

    /**
     *@Description: TODO
     * 条件查询集合
     *@MethodName: queryListByFields
     *@Author: lifuju
     *@Date: 2020/5/12 23:07
     */

    public List<T> queryListByFields(Sqls where, String orderByField, String... fields) throws Exception {
        return queryByFieldsBase(null, null, where, orderByField, fields);
    }

    /**
     *@Description: TODO
     * 条件查询分页
     *@MethodName: queryListByPageAndFields
     *@Author: lifuju
     *@Date: 2020/5/12 23:08
     */

    public PageInfo<T> queryListByPageAndFields(Integer pageNo, Integer pageSize, Sqls where, String orderByFileds, String... fields) throws Exception {
        return new PageInfo<T>(queryByFieldsBase(pageNo, pageSize, where, orderByFileds, fields));
    }
    /**
     *@Description: TODO
     * 条件查询
     *@MethodName: queryList
     *@Author: lifuju
     *@Date: 2020/5/12 23:08
     */

    public List<T> queryList(T t) throws Exception {
        return mapper.select(t);
    }

    /**
     *@Description: TODO
     * 分页查询
     *@MethodName: queryListByPage
     *@Author: lifuju
     *@Date: 2020/5/12 23:09
     */

    public PageInfo<T> queryListByPage(T t, Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }

    /**
     *@Description: TODO
     * 根据反射获取实例对象
     *@MethodName: newIstance
     *@Author: lifuju
     *@Date: 2020/5/13 9:24
     */
    public T newInstance(Map map){
        return (T)Map2BeanUtils.map2Bean(map,getTypeArguement());

    }


    /**
     *@Description: TODO
     * 封装条件查询 分页查询 排序查询的通用方法
     *@MethodName: queryByFieldBase
     *@Author: lifuju
     *@Date: 2020/5/12 22:53
     */

    private List<T> queryByFieldsBase(Integer pageNo, Integer pageSize, Sqls where, String orderByField, String... field){
        Example.Builder builder = null;
        if(null == field || field.length == 0) {
            // 没有条件查询，说明查询的是所有数据
            builder = Example.builder(getTypeArguement());
        } else {
            // 指定某些/某个字段进行查询
            builder = Example.builder(getTypeArguement())
                    .select(field);
        }
        if(null != where) {
            builder = builder.where(where);
        }

        if(null != orderByField) {
            builder = builder.orderByDesc(orderByField);
        }

        Example example = builder.build();

        if(null != pageNo && null != pageSize) { // pageHelper通用分页插件
            PageHelper.startPage(pageNo, pageSize);
        }

        List list = getMapper().selectByExample(example);
        return list;
    }

    /**
     *@Description: TODO
     * 获取子类泛型类型
     *@MethodName: getTypeArguement
     *@Author: lifuju
     *@Date: 2020/5/12 22:36
     */

    private Class<T> getTypeArguement(){
        if ( null == cache) {
            cache = (Class<T>) ((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        }
        return cache;
    }
    /**
     *@Description: TODO
     * 获取spring容器
     *@MethodName: getApplicationContext
     *@Author: lifuju
     *@Date: 2020/5/13 10:11
     */

    public ApplicationContext getApplicationContext() {
        return SpringContextUtils.getApplicationContext();
    }
}
