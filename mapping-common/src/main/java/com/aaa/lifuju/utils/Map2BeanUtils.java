package com.aaa.lifuju.utils;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.objenesis.Objenesis;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.utils
 * @ClassName: Map2BeanUtils
 * @Author: lifuju
 * @Description:
 * map和bean的装换
 * @Date: 2020/5/13 9:25
 * @Version: 1.0
 */
public class Map2BeanUtils {

    private Map2BeanUtils(){}

    private final static Objenesis OBJENESIS =null;

    private final static StringBuffer STRING_BUFFER=new StringBuffer();

    private final static ConcurrentHashMap<Class, MethodAccess> CONCURRENT_HASH_MAP=new ConcurrentHashMap<Class, MethodAccess>();


    /**
     *@Description: TODO
     * map和bean之间的转换
     *@MethodName: map2Bean
     *@Author: lifuju
     *@Date: 2020/5/13 9:36
     */
    public static <T> T map2Bean(Map<String, Object> map, Class<T> clazz) {
        // 通过clazz类型获取泛型对象(获取咱们所需要的对象)(但是这个对象是一个空对象)
        T instance = OBJENESIS.newInstance(clazz);
        MethodAccess methodAccess = CONCURRENT_HASH_MAP.get(clazz);
        if(null == methodAccess) {
            methodAccess = MethodAccess.get(clazz);
            // 就是为了获取下一步的get和set方法
            CONCURRENT_HASH_MAP.putIfAbsent(clazz, methodAccess);
            // 循环数据
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                // 于是就可以获取到Map中的各种数据，我就需要通过setter方法进行赋值了
                String setMethodName = setMethodName(entry.getKey());
                int index = methodAccess.getIndex(setMethodName, entry.getValue().getClass());
                methodAccess.invoke(instance, index, entry.getValue());
            }
        }
        return instance;
    }

    /**
     *@Description: TODO
     * 通过字段获取set的方法名
     *@MethodName: setMethodName
     *@Author: lifuju
     *@Date: 2020/5/13 9:43
     */

    private static String setMethodName(String fieldName) {
        // fieldName--->bookName--->getBookName()
        // 所以第一步并不是直接获取，而是先把这个字段的首字母大写
        String filedJava = firstToUpperCase(fieldName);
        STRING_BUFFER.setLength(0);// 确保了StringBuffer中没有任何数据
        // 拼接set方法
        return STRING_BUFFER.append("set").append(filedJava).toString();
    }

    /**
     *@Description: TODO
     * 把String类型字符串的首字母大写
     *@MethodName: firstToUpperCase
     *@Author: lifuju
     *@Date: 2020/5/13 9:43
     */

    private static String firstToUpperCase(String field) {
        return field.substring(0,1).toUpperCase() + field.substring(1);
    }
}
