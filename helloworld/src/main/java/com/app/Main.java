package com.app;

import com.mapper.ProductMapper;
import com.model.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession session = factory.openSession();

            ProductMapper productMapper = session.getMapper(ProductMapper.class);

            List<Product> productList = productMapper.findAll();
            for(Product p : productList) {
                System.out.println(p);
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
