package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.OidInstance;
import org.apache.ibatis.annotations.Mapper;

/**
 * (OidInstance)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-14 10:38:28
 */
@Mapper
public interface OidInstanceMapper extends BaseMapper<OidInstance> {
    /**
     * 获取学生总人数
     * @return
     */
    Long selectAllCodeCount();
}

