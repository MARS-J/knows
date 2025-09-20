package org.dromara.web.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 大模型配置，存储各类大模型的连接和参数信息对象 spg_model_config
 *
 * @author xingyu
 * @date 2025-09-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("spg_model_config")
public class SpgModelConfig extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，自增
     */
    @TableId(value = "id")
    private String id;

    /**
     * 模型提供商，如OpenAI、Anthropic、百度等
     */
    private String provider;

    /**
     * 访问模型的API密钥
     */
    private String apiKey;

    /**
     * 模型类型，如文本生成、图像生成、语音识别等
     */
    private String modelType;

    /**
     * 模型具体名称，如gpt-4、claude-3-opus、ERNIE-Bot等
     */
    private String modelName;

    /**
     * 记录创建时间
     */
    private Date createdTime;

    /**
     * 记录最后更新时间
     */
    private Date updatedTime;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 是否启用该配置
     */
    private String isEnabled;

    /**
     * 备注信息
     */
    private String remarks;


}
