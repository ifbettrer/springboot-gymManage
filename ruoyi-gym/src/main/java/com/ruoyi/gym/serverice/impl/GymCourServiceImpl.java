package com.ruoyi.gym.serverice.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.gym.domain.GymCour;
import com.ruoyi.gym.mapper.GymCourMapper;
import com.ruoyi.gym.serverice.IGymCourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymCourServiceImpl implements IGymCourService {
    @Autowired
    private GymCourMapper gymCourMapper;
    @Override
    public List<GymCour> selectGymCourList(GymCour gymCour) {
        return gymCourMapper.selectGymCourList(gymCour);
    }

    @Override
    public int deleteGymCourById(Long courseId) {
        return gymCourMapper.deleteGymCourById(courseId);
    }

    @Override
    public int insertGymCour(GymCour gymCour) {
        gymCour.setCreateTime(DateUtils.getNowDate());
        return gymCourMapper.insertGymCour(gymCour);
    }

    @Override
    public GymCour selectGymCourById(Long courseId) {
        return gymCourMapper.selectGymCourById(courseId);
    }

    @Override
    public int updateGymCour(GymCour gymCour) {
        gymCour.setUpdateTime(DateUtils.getNowDate());
        return gymCourMapper.updateGymCour(gymCour);
    }
}
