package createrecord.app;

import createrecord.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String [] args) {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession session = factory.openSession();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = format.parse("2010-09-01");
//            Employee emp = new Employee("Zhangsan", birthday, 1, "13811111111");
            Employee emp = new Employee("Lisi", birthday, 1, "1382222222");

            session.insert("Employee.insert", emp);
            session.commit();

            System.out.println(emp);

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
