package com.ruoyi.gym.serverice;

import com.ruoyi.gym.domain.GymEquip;

import java.util.List;

public interface IGymEquipService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param equipId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public GymEquip selectGymEquipByEquipId(Long equipId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param gymEquip 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GymEquip> selectGymEquipList(GymEquip gymEquip);

    /**
     * 新增【请填写功能名称】
     *
     * @param gymEquip 【请填写功能名称】
     * @return 结果
     */
    public int insertGymEquip(GymEquip gymEquip);

    /**
     * 修改【请填写功能名称】
     *
     * @param gymEquip 【请填写功能名称】
     * @return 结果
     */
    public int updateGymEquip(GymEquip gymEquip);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param equipIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteGymEquipByEquipIds(Long[] equipIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param equipId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteGymEquipByEquipId(Long equipId);
}
