package com.ruoyi.web.controller.gym;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.gym.domain.GymApply;
import com.ruoyi.gym.domain.GymMem;
import com.ruoyi.gym.serverice.IGymApplyService;
import com.ruoyi.gym.serverice.IGymMemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.ruoyi.common.utils.PageUtils.startPage;

@RestController
@RequestMapping("/mem")
public class MemPurchaseController extends BaseController {

    @Autowired
    private IGymMemService gymMemService;

    @Autowired
    private IGymApplyService gymApplyService;

    //显示个人信息
    @PreAuthorize("@ss.hasPermi('mem:purchase:list')")
    @GetMapping(value = "/purchase/list")
    public TableDataInfo buyList()
    {
        startPage();
        GymMem gymMem = gymMemService.selectGymMemByMemName(SecurityUtils.getUsername());
        List<GymMem> list = new ArrayList<>();
        list.add(gymMem);
        return getDataTable(list);
    }

    //购买课时
    @PreAuthorize("@ss.hasPermi('mem:purchase:buy')")
    @Log(title = "购买课时", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/purchase")
    public AjaxResult edit()  //做一个输入传过来即可
    {
        GymMem gymMem = gymMemService.selectGymMemByMemName(SecurityUtils.getUsername());  //根据会员名找到
        gymMem.setBuyLesson(gymMem.getBuyLesson() + 10);
        gymMem.setRestLesson(gymMem.getRestLesson() + 10);
        gymMem.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(gymMemService.updateGymMem(gymMem));
    }

    //获取用户课程列表,这里还需要修改
    @PreAuthorize("@ss.hasPermi('mem:course:list')")
    @GetMapping(value = "/course/list")
    public TableDataInfo courseList(GymApply gymApply)
    {
        startPage();
        gymApply.setMemName(SecurityUtils.getUsername());
        List<GymApply> list = gymApplyService.selectGymApplyList(gymApply);
        return getDataTable(list);
    }

}
