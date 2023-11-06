package com.ruoyi.web.controller.gym;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.gym.domain.GymEquip;
import com.ruoyi.gym.serverice.IGymEquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym/equip")
public class GymEquipController extends BaseController
{
    @Autowired
    private IGymEquipService gymEquipService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('gym:equip:list')")
    @GetMapping("/list")
    public TableDataInfo list(GymEquip gymEquip)
    {
        startPage();
        List<GymEquip> list = gymEquipService.selectGymEquipList(gymEquip);
        return getDataTable(list);
    }


    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('gym:equip:query')")
    @GetMapping(value = "/{equipId}")
    public AjaxResult getInfo(@PathVariable("equipId") Long equipId)
    {
        return success(gymEquipService.selectGymEquipByEquipId(equipId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('gym:equip:add')")
    @Log(title = "添加器材信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GymEquip gymEquip)
    {
        gymEquip.setCreateBy(SecurityUtils.getUsername());
        return toAjax(gymEquipService.insertGymEquip(gymEquip));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('gym:equip:edit')")
    @Log(title = "修改器材信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GymEquip gymEquip)
    {
        gymEquip.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(gymEquipService.updateGymEquip(gymEquip));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('gym:equip:remove')")
    @Log(title = "删除器材信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{equipIds}")
    public AjaxResult remove(@PathVariable Long[] equipIds)
    {
        return toAjax(gymEquipService.deleteGymEquipByEquipIds(equipIds));
    }

    @PreAuthorize("@ss.hasPermi('gym:equip:repair')")
    @Log(title = "维修器材", businessType = BusinessType.UPDATE)
    @PutMapping("/{equipId}")
    public AjaxResult repair(@PathVariable("equipId") Long equipId)
    {
        GymEquip gymEquip = gymEquipService.selectGymEquipByEquipId(equipId);
        String temp = gymEquip.getEquipStatus();
        if (temp.equals("1")){
            gymEquip.setEquipStatus("0");
            gymEquip.setRemark("于" + DateUtils.dateTime() + "维修完成");
        } else {
            gymEquip.setEquipStatus("1");
            gymEquip.setRemark("于" + DateUtils.dateTime() + "报修，器材损坏");
        }
        return toAjax(gymEquipService.updateGymEquip(gymEquip));
    }
}
