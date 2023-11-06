package com.ruoyi.gym.mapper;

import com.ruoyi.gym.domain.GymEquip;

import java.util.List;

public interface GymEquipMapper
{
    public GymEquip selectGymEquipByEquipId(Long equipId);

    public List<GymEquip> selectGymEquipList(GymEquip gymEquip);

    public int insertGymEquip(GymEquip gymEquip);

    public int updateGymEquip(GymEquip gymEquip);

    public int deleteGymEquipByEquipId(Long equipId);

    public int deleteGymEquipByEquipIds(Long[] equipIds);
}
