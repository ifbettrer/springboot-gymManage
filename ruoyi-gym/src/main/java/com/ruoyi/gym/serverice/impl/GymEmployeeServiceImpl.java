package com.ruoyi.gym.serverice.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.gym.domain.GymEmployee;
import com.ruoyi.gym.domain.GymEquip;
import com.ruoyi.gym.mapper.GymEmployeeMapper;
import com.ruoyi.gym.mapper.GymEquipMapper;
import com.ruoyi.gym.serverice.IGymEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymEmployeeServiceImpl implements IGymEmployeeService {

    @Autowired
    private GymEmployeeMapper gymEmployeeMapper;
    @Override
    public List<GymEmployee> selectGymEmployeeList(GymEmployee gymEmployee) {return gymEmployeeMapper.selectEmployeeList(gymEmployee);}

    @Override
    public int insertGymEmployee(GymEmployee gymEmployee)
    {
        gymEmployee.setCreateTime(DateUtils.getNowDate());
        return gymEmployeeMapper.insertGymEmployee(gymEmployee);
    }

    @Override
    public int deleteGymEmployeeById(Long employeeId) {
        return gymEmployeeMapper.deleteGymEmployeeById(employeeId);
    }

    @Override
    public GymEmployee selectGymEmployeeById(Long employeeId) {
        return gymEmployeeMapper.selectGymEmployeeById(employeeId);
    }

    @Override
    public int updateGymEmployee(GymEmployee gymEmployee) {
        gymEmployee.setUpdateTime(DateUtils.getNowDate());
        return gymEmployeeMapper.updateGymEmployee(gymEmployee);
    }
}
