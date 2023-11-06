package com.ruoyi.gym.mapper;

import com.ruoyi.gym.domain.GymEmployee;

import java.util.List;

public interface GymEmployeeMapper {

    //显示
    List<GymEmployee> selectEmployeeList(GymEmployee gymEmployee);

    //新增
    public int insertGymEmployee(GymEmployee gymEmployee);

    //删除
    public int deleteGymEmployeeById(Long employeeId);

    //查询单个
    public GymEmployee selectGymEmployeeById(Long employeeId);

    //修改
    public int updateGymEmployee(GymEmployee gymEmployee);



}
