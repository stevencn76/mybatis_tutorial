package manytomany.mapper;

import manytomany.model.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    void insert(Order order);
    void insertOrderProduct(@Param("orderId") int orderId, @Param("productId") int productId);

    Order findById(@Param("id") int id);
}
