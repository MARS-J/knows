package org.dromara.web.service;

import org.dromara.web.domain.vo.SpgModelConfigVo;
import org.dromara.web.domain.bo.SpgModelConfigBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 大模型配置，存储各类大模型的连接和参数信息Service接口
 *
 * @author xingyu
 * @date 2025-09-21
 */
public interface ISpgModelConfigService {

    /**
     * 查询大模型配置，存储各类大模型的连接和参数信息
     *
     * @param id 主键
     * @return 大模型配置，存储各类大模型的连接和参数信息
     */
    SpgModelConfigVo queryById(String id);

    /**
     * 分页查询大模型配置，存储各类大模型的连接和参数信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 大模型配置，存储各类大模型的连接和参数信息分页列表
     */
    TableDataInfo<SpgModelConfigVo> queryPageList(SpgModelConfigBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的大模型配置，存储各类大模型的连接和参数信息列表
     *
     * @param bo 查询条件
     * @return 大模型配置，存储各类大模型的连接和参数信息列表
     */
    List<SpgModelConfigVo> queryList(SpgModelConfigBo bo);

    /**
     * 新增大模型配置，存储各类大模型的连接和参数信息
     *
     * @param bo 大模型配置，存储各类大模型的连接和参数信息
     * @return 是否新增成功
     */
    Boolean insertByBo(SpgModelConfigBo bo);

    /**
     * 修改大模型配置，存储各类大模型的连接和参数信息
     *
     * @param bo 大模型配置，存储各类大模型的连接和参数信息
     * @return 是否修改成功
     */
    Boolean updateByBo(SpgModelConfigBo bo);

    /**
     * 校验并批量删除大模型配置，存储各类大模型的连接和参数信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
