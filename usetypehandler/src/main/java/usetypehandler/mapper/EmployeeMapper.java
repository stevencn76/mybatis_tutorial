package usetypehandler.mapper;

import org.apache.ibatis.annotations.Param;
import usetypehandler.dto.EmployeeDto;
import usetypehandler.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    void insert(Employee employee);

    List<Employee> findAll();
    Employee findById(@Param("id") long id);
    List<EmployeeDto> findByName(@Param("name")String name);

    void update(Employee employee);

    void updateMobile(@Param("id")long id, @Param("mobile")String mobile);

    void delete(long id);
}
