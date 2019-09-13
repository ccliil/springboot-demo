package com.cdtu.mapper;

import com.cdtu.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

    public void deleteEmpById(Integer id);

    public void updateEmp(Employee employee);
}
