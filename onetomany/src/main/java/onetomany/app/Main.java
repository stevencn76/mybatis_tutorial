package onetomany.app;

import onetomany.mapper.DepartmentMapper;
import onetomany.mapper.EmployeeMapper;
import onetomany.model.Department;
import onetomany.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Main {
    public static void main(String [] args) {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession session = factory.openSession();

            DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);

            for(Department dep : mapper.findAll2()) {
                System.out.println(dep);
                System.out.println("--------------------");
                for(Employee emp : dep.getEmployees()) {
//                    if (emp.getId() != null) {
                        System.out.println(emp);
//                    }
                }
                System.out.println("=====================");
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
