package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.OidInstance;
import com.example.mapper.OidInstanceMapper;
import com.example.service.OidInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * (OidInstance)表服务实现类
 *
 * @author makejava
 * @since 2022-07-14 10:38:30
 */
@Transactional
@Service("oidInstanceService")
public class OidInstanceServiceImpl extends ServiceImpl<OidInstanceMapper, OidInstance> implements OidInstanceService {

    @Autowired
    private OidInstanceMapper oidInstanceMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public OidInstance queryById(Integer id) {
        return oidInstanceMapper.selectById(id);
    }

    @Override
    public boolean updateById(OidInstance oidInstance) {
//        int i = oidInstanceMapper.updateById(oidInstance);
        LambdaUpdateWrapper<OidInstance> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(OidInstance::getWorkerId,oidInstance.getWorkerId());
        updateWrapper.set(OidInstance::getDatacenterId,oidInstance.getDatacenterId());
        updateWrapper.set(OidInstance::getAppCode,oidInstance.getAppCode());
        updateWrapper.set(OidInstance::getUpdateTime,oidInstance.getUpdateTime());
        int i = oidInstanceMapper.update(oidInstance,updateWrapper);

        return i==1;
    }

    @Override
    public long queryAllCodeCount() {
        //设置 redisTemplate 对象 key 的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //从 redis 缓存中获取总人数
        Long allCodeCount = (Long) redisTemplate.opsForValue().get("allCodeCount");
        //判断是否为空
        if (allCodeCount==null) {
            //去数据库查询，并存放到 redis 缓存中

            allCodeCount = oidInstanceMapper.selectAllCodeCount();

            redisTemplate.opsForValue().set("allCodeCount",allCodeCount,15, TimeUnit.SECONDS);
        }
        return allCodeCount;
    }
}

