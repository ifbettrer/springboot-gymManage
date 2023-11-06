package com.ruoyi.gym.serverice.impl;


import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.gym.domain.GymApply;
import com.ruoyi.gym.mapper.GymApplyMapper;
import com.ruoyi.gym.serverice.IGymApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymApplyServiceImpl implements IGymApplyService {

    @Autowired
    private GymApplyMapper applyMapper;

    @Override
    public List<GymApply> selectGymApplyList(GymApply gymApply) {
        return applyMapper.selectGymApplyList(gymApply);
    }

    @Override
    public int deleteGymApplyById(Long applyId) {
        return applyMapper.deleteGymApplyById(applyId);
    }

    @Override
    public int insertGymApply(GymApply gymApply) {
        gymApply.setCreateTime(DateUtils.getNowDate());
        return applyMapper.insertGymApply(gymApply);
    }

    @Override
    public GymApply selectGymApplyById(Long applyId) {
        return applyMapper.selectGymApplyById(applyId);
    }

    @Override
    public int updateGymApply(GymApply gymApply) {
        gymApply.setUpdateTime(DateUtils.getNowDate());
        return applyMapper.updateGymApply(gymApply);
    }

    @Override
    public List<GymApply> selectMemApplyList(String memName) {
        return applyMapper.selectMemApplyList(memName);
    }
}
