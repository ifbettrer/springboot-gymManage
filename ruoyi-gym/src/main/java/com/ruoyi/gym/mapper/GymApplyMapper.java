package com.ruoyi.gym.mapper;

import com.ruoyi.gym.domain.GymApply;

import java.util.List;

public interface GymApplyMapper {

    List<GymApply> selectGymApplyList(GymApply gymApply);

    //删除
    public int deleteGymApplyById(Long applyId);

    //新增
    public int insertGymApply(GymApply gymApply);

    //查询详细
    public GymApply selectGymApplyById(Long applyId);

    //修改
    public int updateGymApply(GymApply gymApply);

    List<GymApply> selectMemApplyList(String memName);
}
