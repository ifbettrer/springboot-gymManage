package com.ruoyi.gym.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class GymApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long aplId;

    /** $column.columnComment */
    @Excel(name = "课程编号", readConverterExp = "$column.readConverterExp()")
    private Long courseId;

    /** $column.columnComment */
    @Excel(name = "课程名称", readConverterExp = "$column.readConverterExp()")
    private String courseName;

    /** $column.columnComment */
    @Excel(name = "教练姓名", readConverterExp = "$column.readConverterExp()")
    private String teacherName;

    /** $column.columnComment */
    @Excel(name = "会员名称", readConverterExp = "$column.readConverterExp()")
    private String memName;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开课时间", readConverterExp = "$column.readConverterExp()",dateFormat = "yyyy-MM-dd")
    private Date startTime;

    public void setAplId(Long aplId)
    {
        this.aplId = aplId;
    }

    public Long getAplId()
    {
        return aplId;
    }
    public void setCourseId(Long courseId)
    {
        this.courseId = courseId;
    }

    public Long getCourseId()
    {
        return courseId;
    }
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getCourseName()
    {
        return courseName;
    }
    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName()
    {
        return teacherName;
    }
    public void setMemName(String memName)
    {
        this.memName = memName;
    }

    public String getMemName()
    {
        return memName;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("aplId", getAplId())
                .append("courseId", getCourseId())
                .append("courseName", getCourseName())
                .append("teacherName", getTeacherName())
                .append("memName", getMemName())
                .append("startTime", getStartTime())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}

