package onetomany.mapper;

import onetomany.model.Department;

import java.util.List;

public interface DepartmentMapper {
    List<Department> findAll();
    List<Department> findAll2();
}
