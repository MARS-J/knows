package org.dromara.web.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.dromara.web.domain.bo.SpgModelConfigBo;
import org.dromara.web.domain.vo.SpgModelConfigVo;
import org.dromara.web.domain.SpgModelConfig;
import org.dromara.web.mapper.SpgModelConfigMapper;
import org.dromara.web.service.ISpgModelConfigService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 大模型配置，存储各类大模型的连接和参数信息Service业务层处理
 *
 * @author xingyu
 * @date 2025-09-21
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class SpgModelConfigServiceImpl implements ISpgModelConfigService {

    private final SpgModelConfigMapper baseMapper;

    /**
     * 查询大模型配置，存储各类大模型的连接和参数信息
     *
     * @param id 主键
     * @return 大模型配置，存储各类大模型的连接和参数信息
     */
    @Override
    public SpgModelConfigVo queryById(String id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询大模型配置，存储各类大模型的连接和参数信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 大模型配置，存储各类大模型的连接和参数信息分页列表
     */
    @Override
    public TableDataInfo<SpgModelConfigVo> queryPageList(SpgModelConfigBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SpgModelConfig> lqw = buildQueryWrapper(bo);
        Page<SpgModelConfigVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的大模型配置，存储各类大模型的连接和参数信息列表
     *
     * @param bo 查询条件
     * @return 大模型配置，存储各类大模型的连接和参数信息列表
     */
    @Override
    public List<SpgModelConfigVo> queryList(SpgModelConfigBo bo) {
        LambdaQueryWrapper<SpgModelConfig> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SpgModelConfig> buildQueryWrapper(SpgModelConfigBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SpgModelConfig> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(SpgModelConfig::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getProvider()), SpgModelConfig::getProvider, bo.getProvider());
        lqw.eq(StringUtils.isNotBlank(bo.getApiKey()), SpgModelConfig::getApiKey, bo.getApiKey());
        lqw.eq(StringUtils.isNotBlank(bo.getModelType()), SpgModelConfig::getModelType, bo.getModelType());
        lqw.like(StringUtils.isNotBlank(bo.getModelName()), SpgModelConfig::getModelName, bo.getModelName());
        lqw.eq(bo.getCreatedTime() != null, SpgModelConfig::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, SpgModelConfig::getUpdatedTime, bo.getUpdatedTime());
        lqw.eq(StringUtils.isNotBlank(bo.getCreatedBy()), SpgModelConfig::getCreatedBy, bo.getCreatedBy());
        lqw.eq(StringUtils.isNotBlank(bo.getIsEnabled()), SpgModelConfig::getIsEnabled, bo.getIsEnabled());
        lqw.eq(StringUtils.isNotBlank(bo.getRemarks()), SpgModelConfig::getRemarks, bo.getRemarks());
        return lqw;
    }

    /**
     * 新增大模型配置，存储各类大模型的连接和参数信息
     *
     * @param bo 大模型配置，存储各类大模型的连接和参数信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SpgModelConfigBo bo) {
        SpgModelConfig add = MapstructUtils.convert(bo, SpgModelConfig.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改大模型配置，存储各类大模型的连接和参数信息
     *
     * @param bo 大模型配置，存储各类大模型的连接和参数信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SpgModelConfigBo bo) {
        SpgModelConfig update = MapstructUtils.convert(bo, SpgModelConfig.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SpgModelConfig entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除大模型配置，存储各类大模型的连接和参数信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
