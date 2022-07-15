package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.OidInstance;

/**
 * (OidInstance)表服务接口
 *
 * @author makejava
 * @since 2022-07-14 10:38:29
 */
public interface OidInstanceService extends IService<OidInstance> {

    OidInstance queryById(Integer id);

    boolean updateById(OidInstance oidInstance);

    long queryAllCodeCount();
}

