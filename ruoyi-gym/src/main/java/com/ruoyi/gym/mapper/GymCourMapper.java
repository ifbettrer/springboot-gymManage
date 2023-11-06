package com.ruoyi.gym.mapper;

import com.ruoyi.gym.domain.GymCour;

import java.util.List;

public interface GymCourMapper {

    List<GymCour> selectGymCourList(GymCour gymCour);

    //删除
    public int deleteGymCourById(Long courseId);

    //新增
    public int insertGymCour(GymCour gymCour);

    //查询详细
    public GymCour selectGymCourById(Long courseId);

    //修改
    public int updateGymCour(GymCour gymCour);
}
