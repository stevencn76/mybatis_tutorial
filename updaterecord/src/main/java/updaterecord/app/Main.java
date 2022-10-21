package updaterecord.app;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import updaterecord.dto.EmployeeDto;
import updaterecord.mapper.EmployeeMapper;
import updaterecord.model.Employee;

import java.io.InputStream;

public class Main {
    public static void main(String [] args) {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession session = factory.openSession();

            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

//            mapper.updateMobile(1, "1378888888");

//            Employee emp = mapper.findById(1);
//
//            emp.setMobile("1301191119");
//            mapper.update(emp);
//
//            session.commit();

            mapper.delete(2);
            session.commit();

            for(EmployeeDto em : mapper.findAll()) {
                System.out.println(em);
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
