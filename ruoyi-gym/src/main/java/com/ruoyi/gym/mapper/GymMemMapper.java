package com.ruoyi.gym.mapper;

import java.util.List;

import com.ruoyi.gym.domain.GymMem;

public interface GymMemMapper
{
    public GymMem selectGymMemByMemId(Long memId);

    public GymMem selectGymMemByMemName(String memName);

    public List<GymMem> selectGymMemList(GymMem gymMem);

    public int insertGymMem(GymMem gymMem);

    public int updateGymMem(GymMem gymMem);

    public int deleteGymMemByMemId(Long memId);

//    public int deleteGymMemByMemIds(Long[] memIds);
}

