package usetypehandler.app;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import usetypehandler.dto.EmployeeDto;
import usetypehandler.mapper.EmployeeMapper;
import usetypehandler.model.Employee;
import usetypehandler.model.Gender;

import java.io.InputStream;

public class Main {
    public static void main(String [] args) {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession session = factory.openSession();

            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee tmp = mapper.findById(1);

            Employee newEmp = new Employee("Niu", tmp.getBirthday(), Gender.FEMALE, "120");
            mapper.insert(newEmp);

            session.commit();

//            Employee emp = mapper.findById(1);

//            mapper.updateMobile(1, "1378888888");

//            Employee emp = mapper.findById(1);
//
//            emp.setMobile("1301191119");
//            mapper.update(emp);
//
//            session.commit();

            for(Employee em : mapper.findAll()) {
                System.out.println(em);
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
