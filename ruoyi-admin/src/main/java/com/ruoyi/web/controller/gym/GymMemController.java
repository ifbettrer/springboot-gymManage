package com.ruoyi.web.controller.gym;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.gym.domain.GymMem;
import com.ruoyi.gym.serverice.IGymMemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/gym/mem")
public class GymMemController extends BaseController
{
    @Autowired
    private IGymMemService gymMemService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('gym:mem:list')")
    @GetMapping("/list")
    public TableDataInfo list(GymMem gymMem)
    {
        startPage();
        List<GymMem> list = gymMemService.selectGymMemList(gymMem);
        return getDataTable(list);
    }


    @PreAuthorize("@ss.hasPermi('gym:mem:query')")
    @GetMapping(value = "/{memId}")
    public AjaxResult getInfo(@PathVariable("memId") Long memId)
    {
        return success(gymMemService.selectGymMemByMemId(memId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('gym:mem:add')")
    @Log(title = "办卡", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GymMem gymMem)
    {
        gymMem.setCreateBy(SecurityUtils.getUsername());
        return toAjax(gymMemService.insertGymMem(gymMem));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('gym:mem:edit')")
    @Log(title = "修改会员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GymMem gymMem)
    {
        gymMem.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(gymMemService.updateGymMem(gymMem));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('gym:mem:remove')")
    @Log(title = "会员退卡", businessType = BusinessType.DELETE)
    @DeleteMapping("/{memId}")
    public AjaxResult remove(@PathVariable Long memId)
    {
        return toAjax(gymMemService.deleteGymMemByMemId(memId));
    }

    //@PreAuthorize("@ss.hasPermi('gym:mem:remove')")
//    @Log(title = "会员退卡", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{memIds}")
//    public AjaxResult remove(@PathVariable Long[] memIds)
//    {
//        return toAjax(gymMemService.deleteGymMemByMemIds(memIds));
//    }
}
