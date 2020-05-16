package com.aaa.lifuju.redis;

import com.aaa.lifuju.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import static com.aaa.lifuju.staticstatus.RedisProperties.*;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.service
 * @ClassName: RedisService
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/14 11:41
 * @Version: 1.0
 */
@Service
public class RedisService<T> {

    @Autowired
    private JedisCluster jedisCluster;

    public String set(String key, T value, String nxxx, String expx, Integer seconds) {
        if(null != seconds && 0 < seconds && (NX.equals(nxxx) || XX.equals(nxxx)) && (EX.equals(expx) || PX.equals(expx))) {
            // 说明需要设置失效时间
            return jedisCluster.set(key, JSONUtil.toJsonString(value), nxxx, expx, seconds);
        } else {
            // 说明不需要设置失效时间
            // 就算不需要失效时间，但是我也得知道最终你所传递的是nx还是xx，所以需要再次判断
            if(NX.equals(nxxx)) {
                return String.valueOf(jedisCluster.setnx(key, JSONUtil.toJsonString(value)));
            } else if(XX.equals(nxxx)) {
                return jedisCluster.set(key, JSONUtil.toJsonString(value));
            }
        }
        return NO;
    }
}
