package manytomany.mapper;

import manytomany.model.Department;

import java.util.List;

public interface DepartmentMapper {
    List<Department> findAll();
    List<Department> findAll2();
}
