package org.dromara.web.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.web.domain.vo.SpgModelConfigVo;
import org.dromara.web.domain.bo.SpgModelConfigBo;
import org.dromara.web.service.ISpgModelConfigService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 大模型配置，存储各类大模型的连接和参数信息
 *
 * @author xingyu
 * @date 2025-09-21
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/spg/modelConfig")
public class SpgModelConfigController extends BaseController {

    private final ISpgModelConfigService spgModelConfigService;

    /**
     * 查询大模型配置，存储各类大模型的连接和参数信息列表
     */
    @SaCheckPermission("web:modelConfig:list")
    @GetMapping("/list")
    public TableDataInfo<SpgModelConfigVo> list(SpgModelConfigBo bo, PageQuery pageQuery) {
        return spgModelConfigService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出大模型配置，存储各类大模型的连接和参数信息列表
     */
    @SaCheckPermission("web:modelConfig:export")
    @Log(title = "大模型配置，存储各类大模型的连接和参数信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SpgModelConfigBo bo, HttpServletResponse response) {
        List<SpgModelConfigVo> list = spgModelConfigService.queryList(bo);
        ExcelUtil.exportExcel(list, "大模型配置，存储各类大模型的连接和参数信息", SpgModelConfigVo.class, response);
    }

    /**
     * 获取大模型配置，存储各类大模型的连接和参数信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("web:modelConfig:query")
    @GetMapping("/{id}")
    public R<SpgModelConfigVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable String id) {
        return R.ok(spgModelConfigService.queryById(id));
    }

    /**
     * 新增大模型配置，存储各类大模型的连接和参数信息
     */
    @SaCheckPermission("web:modelConfig:add")
    @Log(title = "大模型配置，存储各类大模型的连接和参数信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SpgModelConfigBo bo) {
        return toAjax(spgModelConfigService.insertByBo(bo));
    }

    /**
     * 修改大模型配置，存储各类大模型的连接和参数信息
     */
    @SaCheckPermission("web:modelConfig:edit")
    @Log(title = "大模型配置，存储各类大模型的连接和参数信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SpgModelConfigBo bo) {
        return toAjax(spgModelConfigService.updateByBo(bo));
    }

    /**
     * 删除大模型配置，存储各类大模型的连接和参数信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("web:modelConfig:remove")
    @Log(title = "大模型配置，存储各类大模型的连接和参数信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] ids) {
        return toAjax(spgModelConfigService.deleteWithValidByIds(List.of(ids), true));
    }
}
