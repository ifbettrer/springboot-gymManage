package com.ruoyi.gym.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 gym_employee
 *
 * @author ruoyi
 * @date 2023-10-24
 */
public class GymEmployee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工编号---employeeId */
    private Long employeeId;

    /** 员工姓名---employeeName */
    @Excel(name = "员工姓名---employeeName")
    private String employeeName;

    /** 性别---employeeSex */
    @Excel(name = "性别---employeeSex")
    private String employeeSex;

    /** 年龄---employeeAge */
    @Excel(name = "年龄---employeeAge")
    private Long employeeAge;

    /** 职务---vocation */
    @Excel(name = "职务---vocation")
    private String vocation;

    /** 电话---employeePhone */
    @Excel(name = "电话---employeePhone")
    private String employeePhone;

    public void setEmployeeId(Long employeeId)
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId()
    {
        return employeeId;
    }
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }
    public void setEmployeeSex(String employeeSex)
    {
        this.employeeSex = employeeSex;
    }

    public String getEmployeeSex()
    {
        return employeeSex;
    }
    public void setEmployeeAge(Long employeeAge)
    {
//        if (employeeAge == 26L){
//            employeeAge = 20L;
//        }
        this.employeeAge = employeeAge;
    }

    public Long getEmployeeAge()
    {
        return employeeAge;
    }
    public void setVocation(String vocation)
    {
        this.vocation = vocation;
    }

    public String getVocation()
    {
        return vocation;
    }

    public void setEmployeePhone(String employeePhone)
    {
        this.employeePhone = employeePhone;
    }

    public String getEmployeePhone()
    {
        return employeePhone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("employeeId", getEmployeeId())
                .append("employeeName", getEmployeeName())
                .append("employeeSex", getEmployeeSex())
                .append("employeeAge", getEmployeeAge())
                .append("vocation", getVocation())
                .append("employeePhone", getEmployeePhone())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}

