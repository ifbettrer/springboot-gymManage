package com.ruoyi.gym.serverice;

import com.ruoyi.gym.domain.GymMem;

import java.util.List;

public interface IGymMemService
{
    public GymMem selectGymMemByMemId(Long memId);

    public GymMem selectGymMemByMemName(String memName);

    public List<GymMem> selectGymMemList(GymMem gymMem);

    public int insertGymMem(GymMem gymMem);

    public int updateGymMem(GymMem gymMem);

//    public int deleteGymMemByMemIds(Long[] memIds);

    public int deleteGymMemByMemId(Long memId);
}
