package com.example.Controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.OidInstance;
import com.example.service.OidInstanceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (OidInstance)表控制层
 *
 * @author makejava
 * @since 2022-07-14 10:38:26
 */
@RestController
@RequestMapping("oidInstance")
public class OidInstanceController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OidInstanceService oidInstanceService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param oidInstance 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<OidInstance> page, OidInstance oidInstance) {
        return success(this.oidInstanceService.page(page, new QueryWrapper<>(oidInstance)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.oidInstanceService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param oidInstance 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody OidInstance oidInstance) {
        return success(this.oidInstanceService.save(oidInstance));
    }

    /**
     * 修改数据
     *
     * @param oidInstance 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody OidInstance oidInstance) {
        return success(this.oidInstanceService.updateById(oidInstance));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.oidInstanceService.removeByIds(idList));
    }

    @RequestMapping("/querybyid")
    public OidInstance querybyid() {
        return oidInstanceService.queryById(1);
    }

//    @RequestMapping("/updateById")
    @PostMapping("/updateById")
    public R<Boolean> updateById(@RequestBody OidInstance oidInstance) {
        boolean i = oidInstanceService.updateById(oidInstance);
        return success(i);
    }
}

