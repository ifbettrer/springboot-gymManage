package com.ruoyi.web.controller.gym;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.gym.domain.GymEmployee;
import com.ruoyi.gym.serverice.IGymEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym/employee")
public class GymEmployeeController extends BaseController {

    @Autowired
    private IGymEmployeeService gymEmployeeService;

    @PreAuthorize("@ss.hasPermi('gym:employee:list')")
    @GetMapping("/list")
    public TableDataInfo list(GymEmployee gymEmployee)
    {
        startPage();
        List<GymEmployee> list = gymEmployeeService.selectGymEmployeeList(gymEmployee);
//        for (GymEmployee g:list){  //遍历list
//            if (g.getEmployeeAge() == 26L){
//                g.setEmployeeAge(20L);
//            }
//        }
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('gym:employee:add')")
    @Log(title = "新增员工", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GymEmployee gymEmployee)
    {
        gymEmployee.setCreateBy(SecurityUtils.getUsername());  //获取当前用户名称作为创建者
        return toAjax(gymEmployeeService.insertGymEmployee(gymEmployee));
    }

    @PreAuthorize("@ss.hasPermi('gym:employee:remove')")
    @Log(title = "员工离职", businessType = BusinessType.DELETE)
    @DeleteMapping("/{employeeId}")
    public AjaxResult remove(@PathVariable Long employeeId)
    {
        return toAjax(gymEmployeeService.deleteGymEmployeeById(employeeId));
    }

    //获取详细
    @PreAuthorize("@ss.hasPermi('gym:employee:query')")
    @GetMapping(value = "/{employeeId}")
    public AjaxResult getInfo(@PathVariable("employeeId") Long employeeId)
    {
        return success(gymEmployeeService.selectGymEmployeeById(employeeId));
    }

    @PreAuthorize("@ss.hasPermi('gym:employee:edit')")
    @Log(title = "修改员工信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GymEmployee gymEmployee)
    {
        gymEmployee.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(gymEmployeeService.updateGymEmployee(gymEmployee));
    }

}
