package com.ruoyi.gym.serverice.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.gym.domain.GymEquip;
import com.ruoyi.gym.mapper.GymEquipMapper;
import com.ruoyi.gym.serverice.IGymEquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymEquipServiceImpl implements IGymEquipService
{
    @Autowired
    private GymEquipMapper gymEquipMapper;

    @Override
    public GymEquip selectGymEquipByEquipId(Long equipId)
    {
        return gymEquipMapper.selectGymEquipByEquipId(equipId);
    }

    @Override
    public List<GymEquip> selectGymEquipList(GymEquip gymEquip)
    {
        return gymEquipMapper.selectGymEquipList(gymEquip);
    }

    @Override
    public int insertGymEquip(GymEquip gymEquip)
    {
        gymEquip.setCreateTime(DateUtils.getNowDate());
        return gymEquipMapper.insertGymEquip(gymEquip);
    }

    @Override
    public int updateGymEquip(GymEquip gymEquip)
    {
        gymEquip.setUpdateTime(DateUtils.getNowDate());
        return gymEquipMapper.updateGymEquip(gymEquip);
    }

    @Override
    public int deleteGymEquipByEquipIds(Long[] equipIds)
    {
        return gymEquipMapper.deleteGymEquipByEquipIds(equipIds);
    }

    @Override
    public int deleteGymEquipByEquipId(Long equipId)
    {
        return gymEquipMapper.deleteGymEquipByEquipId(equipId);
    }
}
