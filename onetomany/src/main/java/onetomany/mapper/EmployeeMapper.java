package onetomany.mapper;

import onetomany.dto.EmployeeDto;
import onetomany.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    void insert(Employee employee);

    List<Employee> findAll();
    Employee findById(@Param("id") long id);
    List<EmployeeDto> findByName(@Param("name")String name);

    void update(Employee employee);

    void updateMobile(@Param("id")long id, @Param("mobile")String mobile);

    void delete(long id);

    // 使用关联查询实现
    List<Employee> findAllEmployeeWithDepartment();

    // 使用子查询实现
    List<Employee> findAllEmployeeWithDepartment2();
}
