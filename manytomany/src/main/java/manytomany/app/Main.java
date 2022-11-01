package manytomany.app;

import manytomany.mapper.OrderMapper;
import manytomany.mapper.ProductMapper;
import manytomany.model.Department;
import manytomany.model.Employee;
import manytomany.model.Order;
import manytomany.model.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;

public class Main {
    public static void main(String [] args) {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession session = factory.openSession();

            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            ProductMapper productMapper = session.getMapper(ProductMapper.class);

            Product product = new Product();
            product.setName("test");
            product.setCount(2);
            product.setPrice(4.5);
            productMapper.insert(product);

            Order order = new Order();
            order.setReceiver("Zhangsan");
            order.setAddress("Shanghai");
            order.setCreateTime(new Timestamp(new Date().getTime()));
            orderMapper.insert(order);

            orderMapper.insertOrderProduct(order.getId(), product.getId());
            session.commit();


            Order order1 = orderMapper.findById(order.getId());
            if (order1 != null) {
                System.out.println(order1);
                for (Product tp : order1.getProducts()) {
                    System.out.println(tp);
                }
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
