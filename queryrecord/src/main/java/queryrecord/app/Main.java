package queryrecord.app;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import queryrecord.dto.EmployeeDto;
import queryrecord.mapper.EmployeeMapper;

import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession session = factory.openSession();

            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            List<EmployeeDto> employeeDtoList = mapper.findAll();
            for(EmployeeDto ed : employeeDtoList) {
                System.out.println(ed);
            }

            System.out.println(mapper.findById(1));
            System.out.println("===============");

            List<EmployeeDto> es = mapper.findByName("s");
            for(EmployeeDto e : es) {
                System.out.println(e);
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
