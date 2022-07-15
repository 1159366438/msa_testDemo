package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * (OidInstance)表实体类
 *
 * @author makejava
 * @since 2022-07-14 10:38:29
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class OidInstance extends Model<OidInstance> implements Serializable{

    private static final long serialVersionUID = -3897823829254385277L;
    private String id;

    @TableField
    private String userid;
    
    private Long datacenterId;

    private Long workerId;
    
    private String appCode;

    private Long updateTime;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }

