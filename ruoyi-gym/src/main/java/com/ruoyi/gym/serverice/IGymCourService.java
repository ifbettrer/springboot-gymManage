package com.ruoyi.gym.serverice;

import com.ruoyi.gym.domain.GymCour;

import java.util.List;

public interface IGymCourService {

    List<GymCour> selectGymCourList(GymCour gymCour);

    public int deleteGymCourById(Long courseId);

    public int insertGymCour(GymCour gymCour);

    public GymCour selectGymCourById(Long courseId);

    public int updateGymCour(GymCour gymCour);

}
