package com.ruoyi.web.controller.gym;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.gym.domain.GymApply;
import com.ruoyi.gym.domain.GymCour;
import com.ruoyi.gym.domain.GymMem;
import com.ruoyi.gym.serverice.IGymApplyService;
import com.ruoyi.gym.serverice.IGymCourService;
import com.ruoyi.gym.serverice.IGymMemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/gym/cour")
public class GymCourController extends BaseController
{
    @Autowired
    private IGymCourService gymCourService;

    @Autowired
    private IGymApplyService gymApplyService;

    @Autowired
    private IGymMemService gymMemService;

    @PreAuthorize("@ss.hasPermi('gym:cour:list')")
    @GetMapping("/list")
    public TableDataInfo list(GymCour gymCour)
    {
        startPage();
        List<GymCour> list = gymCourService.selectGymCourList(gymCour);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('gym:cour:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Long courseId)
    {
        return success(gymCourService.selectGymCourById(courseId));
    }

    @PreAuthorize("@ss.hasPermi('gym:cour:add')")
    @Log(title = "增加课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GymCour gymCour)
    {
        gymCour.setCreateBy(SecurityUtils.getUsername());
        return toAjax(gymCourService.insertGymCour(gymCour));
    }

    @PreAuthorize("@ss.hasPermi('gym:cour:edit')")
    @Log(title = "编辑课程信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GymCour gymCour)
    {
        gymCour.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(gymCourService.updateGymCour(gymCour));
    }

    @PreAuthorize("@ss.hasPermi('gym:cour:remove')")
    @Log(title = "删除课程", businessType = BusinessType.DELETE)
    @DeleteMapping("{courseId}")
    public AjaxResult remove(@PathVariable Long courseId)
    {
        return toAjax(gymCourService.deleteGymCourById(courseId));
    }

    //报名课程的同时，需要匹配剩余课时与报名课时的数量，报名还需要判断是否已经报名
    @PreAuthorize("@ss.hasPermi('gym:cour:enroll')")
    @Log(title = "报名课程")
    @PostMapping("/{Cid}")
    public AjaxResult enroll(@PathVariable Long Cid)
    {
        GymCour gymCour = gymCourService.selectGymCourById(Cid);
//        GymApply gymApply = new GymApply();
//        gymApply.setCourseId(Cid);
//        gymApply.setCourseName(gymCour.getCourseName());
//        gymApply.setTeacherName(gymCour.getTeacherName());
//        gymApply.setMemName(SecurityUtils.getUsername());
//        gymApply.setStartTime(gymCour.getStartTime());
//        return toAjax(gymApplyService.insertGymApply(gymApply));
        if (judge(gymCour)){
            GymApply gymApply = new GymApply();
            gymApply.setCourseId(Cid);
            gymApply.setCourseName(gymCour.getCourseName());
            gymApply.setTeacherName(gymCour.getTeacherName());
            gymApply.setMemName(SecurityUtils.getUsername());
            gymApply.setStartTime(gymCour.getStartTime());
            return toAjax(gymApplyService.insertGymApply(gymApply));
        }else {
            return toAjax(false);
        }
    }

    public boolean judge(GymCour gymCour){
        String member = SecurityUtils.getUsername();
        GymMem gymMem = gymMemService.selectGymMemByMemName(member);
        long rest = gymMem.getRestLesson() - gymCour.getCourseDuration();
        if (rest < 0){
            JOptionPane.showMessageDialog(null,"您的剩余课时不足报名此课程，请购买课时");
            return false;
        }else {
            gymMem.setRestLesson(rest);   //报名课程，减去相应的课时
            gymMemService.updateGymMem(gymMem);
            return true;
        }
    }
}
