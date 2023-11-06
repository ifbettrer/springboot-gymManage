package com.ruoyi.gym.serverice;

import com.ruoyi.gym.domain.GymEmployee;

import java.util.List;

public interface IGymEmployeeService {

    public List<GymEmployee> selectGymEmployeeList(GymEmployee gymEmployee);

    public int insertGymEmployee(GymEmployee gymEmployee);

    public int deleteGymEmployeeById(Long employeeId);

    public GymEmployee selectGymEmployeeById(Long employeeId);

    public int updateGymEmployee(GymEmployee gymEmployee);

}
