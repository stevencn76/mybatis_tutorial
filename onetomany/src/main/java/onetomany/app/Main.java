package onetomany.app;

import onetomany.mapper.EmployeeMapper;
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

            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            for(Employee em : mapper.findAllEmployeeWithDepartment2()) {
                System.out.println(em);
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
