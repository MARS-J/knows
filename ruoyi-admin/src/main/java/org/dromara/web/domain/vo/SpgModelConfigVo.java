package org.dromara.web.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.web.domain.SpgModelConfig;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 大模型配置，存储各类大模型的连接和参数信息视图对象 spg_model_config
 *
 * @author xingyu
 * @date 2025-09-21
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SpgModelConfig.class)
public class SpgModelConfigVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，自增
     */
    @ExcelProperty(value = "主键ID，自增")
    private String id;

    /**
     * 模型提供商，如OpenAI、Anthropic、百度等
     */
    @ExcelProperty(value = "模型提供商，如OpenAI、Anthropic、百度等")
    private String provider;

    /**
     * 访问模型的API密钥
     */
    @ExcelProperty(value = "访问模型的API密钥")
    private String apiKey;

    /**
     * 模型类型，如文本生成、图像生成、语音识别等
     */
    @ExcelProperty(value = "模型类型，如文本生成、图像生成、语音识别等")
    private String modelType;

    /**
     * 模型具体名称，如gpt-4、claude-3-opus、ERNIE-Bot等
     */
    @ExcelProperty(value = "模型具体名称，如gpt-4、claude-3-opus、ERNIE-Bot等")
    private String modelName;

    /**
     * 记录创建时间
     */
    @ExcelProperty(value = "记录创建时间")
    private Date createdTime;

    /**
     * 记录最后更新时间
     */
    @ExcelProperty(value = "记录最后更新时间")
    private Date updatedTime;

    /**
     * 创建人
     */
    @ExcelProperty(value = "创建人")
    private String createdBy;

    /**
     * 是否启用该配置
     */
    @ExcelProperty(value = "是否启用该配置")
    private String isEnabled;

    /**
     * 备注信息
     */
    @ExcelProperty(value = "备注信息")
    private String remarks;


}
