package com.ruoyi.gym.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 gym_mem
 *
 * @author ruoyi
 * @date 2023-10-26
 */
public class GymMem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long memId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String memName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String memSex;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long memAge;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long memHeight;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long memWeight;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String memPhone;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long buyLesson;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long restLesson;

    public void setMemId(Long memId)
    {
        this.memId = memId;
    }

    public Long getMemId()
    {
        return memId;
    }
    public void setMemName(String memName)
    {
        this.memName = memName;
    }

    public String getMemName()
    {
        return memName;
    }
    public void setMemSex(String memSex)
    {
        this.memSex = memSex;
    }

    public String getMemSex()
    {
        return memSex;
    }
    public void setMemAge(Long memAge)
    {
        this.memAge = memAge;
    }

    public Long getMemAge()
    {
        return memAge;
    }
    public void setMemHeight(Long memHeight)
    {
        this.memHeight = memHeight;
    }

    public Long getMemHeight()
    {
        return memHeight;
    }
    public void setMemWeight(Long memWeight)
    {
        this.memWeight = memWeight;
    }

    public Long getMemWeight()
    {
        return memWeight;
    }
    public void setMemPhone(String memPhone)
    {
        this.memPhone = memPhone;
    }

    public String getMemPhone()
    {
        return memPhone;
    }
    public void setBuyLesson(Long buyLesson)
    {
        this.buyLesson = buyLesson;
    }

    public Long getBuyLesson()
    {
        return buyLesson;
    }
    public void setRestLesson(Long restLesson)
    {
        this.restLesson = restLesson;
    }

    public Long getRestLesson()
    {
        return restLesson;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("memId", getMemId())
                .append("memName", getMemName())
                .append("memSex", getMemSex())
                .append("memAge", getMemAge())
                .append("memHeight", getMemHeight())
                .append("memWeight", getMemWeight())
                .append("memPhone", getMemPhone())
                .append("buyLesson", getBuyLesson())
                .append("restLesson", getRestLesson())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}

