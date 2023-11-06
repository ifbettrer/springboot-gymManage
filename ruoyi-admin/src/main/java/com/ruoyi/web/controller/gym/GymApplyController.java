package com.ruoyi.web.controller.gym;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.gym.domain.GymApply;
import com.ruoyi.gym.domain.GymCour;
import com.ruoyi.gym.domain.GymMem;
import com.ruoyi.gym.serverice.IGymApplyService;
import com.ruoyi.gym.serverice.IGymCourService;
import com.ruoyi.gym.serverice.IGymMemService;
import com.ruoyi.gym.serverice.impl.GymApplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/gym/apply")
public class GymApplyController extends BaseController {

    @Autowired
    private IGymApplyService applyService;

    @Autowired
    private IGymCourService gymCourService;

    @Autowired
    private IGymMemService gymMemService;

    @PreAuthorize("@ss.hasPermi('gym:apply:list')")
    @GetMapping("/list")
    public TableDataInfo list(GymApply gymApply)
    {
        startPage();
        List<GymApply> list = applyService.selectGymApplyList(gymApply);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('gym:apply:query')")
    @GetMapping(value = "/{aplId}")
    public AjaxResult getInfo(@PathVariable("aplId") Long aplId)
    {
        return success(applyService.selectGymApplyById(aplId));
    }

    @PreAuthorize("@ss.hasPermi('gym:apply:add')")
    @Log(title = "录入报名信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GymApply gymApply)
    {
        Long Cid = gymApply.getCourseId();  //获取对应的课程编号
        //String Mname = gymApply.getMemName();
        GymCour gymCour = gymCourService.selectGymCourById(Cid);  //获取课程信息
        //设置插入信息
        gymApply.setCourseName(gymCour.getCourseName());
        gymApply.setTeacherName(gymCour.getTeacherName());
        gymApply.setStartTime(gymCour.getStartTime());
        gymApply.setCreateBy(SecurityUtils.getUsername());
        return toAjax(applyService.insertGymApply(gymApply));
    }

    @PreAuthorize("@ss.hasPermi('gym:apply:edit')")
    @Log(title = "编辑报名信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GymApply gymApply)
    {
        gymApply.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(applyService.updateGymApply(gymApply));
    }


    //获取间隔时间
//    public static long getDaysBetweenDates(String startDateStr, String endDateStr) throws ParseException {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = dateFormat.parse(startDateStr);
//        Date endDate = dateFormat.parse(endDateStr);
//        long diffInMillies = endDate.getTime() - startDate.getTime();
//        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//    }

    @PreAuthorize("@ss.hasPermi('gym:apply:remove')")
    @Log(title = "删除报名记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{applyId}")
    public AjaxResult remove(@PathVariable Long applyId) throws ParseException {
        GymApply gymApply = applyService.selectGymApplyById(applyId);  //获取课程id和用户名字
        GymCour gymCour = gymCourService.selectGymCourById(gymApply.getCourseId());  //获取对应课程课时
        GymMem gymMem = gymMemService.selectGymMemByMemName(gymApply.getMemName());
        gymMem.setRestLesson(gymMem.getRestLesson() + gymCour.getCourseDuration());
        gymMemService.updateGymMem(gymMem);
        return toAjax(applyService.deleteGymApplyById(applyId));
    }
}
