package queryrecord.mapper;

import org.apache.ibatis.annotations.Param;
import queryrecord.dto.EmployeeDto;
import queryrecord.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    void insert(Employee employee);

    List<EmployeeDto> findAll();
    EmployeeDto findById(@Param("id") long id);
    List<EmployeeDto> findByName(@Param("name")String name);
}
