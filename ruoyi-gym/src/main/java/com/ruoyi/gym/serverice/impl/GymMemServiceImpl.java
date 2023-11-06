package com.ruoyi.gym.serverice.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.gym.domain.GymMem;
import com.ruoyi.gym.mapper.GymMemMapper;
import com.ruoyi.gym.serverice.IGymMemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymMemServiceImpl implements IGymMemService
{
    @Autowired
    private GymMemMapper gymMemMapper;

    @Override
    public GymMem selectGymMemByMemId(Long memId)
    {
        return gymMemMapper.selectGymMemByMemId(memId);
    }

    @Override
    public GymMem selectGymMemByMemName(String memName) {
        return gymMemMapper.selectGymMemByMemName(memName);
    }

    @Override
    public List<GymMem> selectGymMemList(GymMem gymMem)
    {
        return gymMemMapper.selectGymMemList(gymMem);
    }

    @Override
    public int insertGymMem(GymMem gymMem)
    {
        gymMem.setCreateTime(DateUtils.getNowDate());
        return gymMemMapper.insertGymMem(gymMem);
    }

    @Override
    public int updateGymMem(GymMem gymMem)
    {
        gymMem.setUpdateTime(DateUtils.getNowDate());
        return gymMemMapper.updateGymMem(gymMem);
    }

//    @Override
//    public int deleteGymMemByMemIds(Long[] memIds)
//    {
//        return gymMemMapper.deleteGymMemByMemIds(memIds);
//    }

    @Override
    public int deleteGymMemByMemId(Long memId)
    {
        return gymMemMapper.deleteGymMemByMemId(memId);
    }
}
