package com.ruoyi.gym.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;

/**
 * 【请填写功能名称】对象 gym_equip
 *
 * @author ruoyi
 * @date 2023-10-21
 */
public class GymEquip extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 器材ID---equipId */
    @Excel(name = "器材ID---equipId")
    //@NotBlank(message = "器材编码不能为空")
    private Long equipId;

    /** 器材名称---equipName */
    @Excel(name = "器材名称---equipName")
    private String equipName;

    /** 器材状态---equipStatus */
    @Excel(name = "器材状态---equipStatus")
    private String equipStatus;

    /** 器材位置---equipLoc */
    @Excel(name = "器材位置---equipLoc")
    private String equipLoc;

    public void setEquipId(Long equipId)
    {
        this.equipId = equipId;
    }

    public Long getEquipId()
    {
        return equipId;
    }
    public void setEquipName(String equipName)
    {
        this.equipName = equipName;
    }

    public String getEquipName()
    {
        return equipName;
    }
    public void setEquipStatus(String equipStatus)
    {
        this.equipStatus = equipStatus;
    }

    public String getEquipStatus()
    {
        return equipStatus;
    }
    public void setEquipLoc(String equipLoc)
    {
        this.equipLoc = equipLoc;
    }

    public String getEquipLoc()
    {
        return equipLoc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("equipId", getEquipId())
                .append("equipName", getEquipName())
                .append("equipStatus", getEquipStatus())
                .append("equipLoc", getEquipLoc())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
