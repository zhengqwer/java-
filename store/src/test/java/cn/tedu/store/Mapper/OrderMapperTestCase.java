package cn.tedu.store.Mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.mapper.OrderMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTestCase {

	@Autowired
	OrderMapper mapper;
	
	@Test
	public void insert() {
		Order order = new Order();
		order.setRecv_name("管理员");
		order.setUid(1);
		order.setRecv_phone("000000");
		order.setRecv_address("北京");
		Integer rows = mapper.insert(order);
		System.err.println(rows);
	}
	
	@Test
	public void insertOrderItem() {
		OrderItem orderItem = new OrderItem();
		orderItem.setOid(1);
		orderItem.setGid(1L);
		orderItem.setGoods_title("很厉害的商品");
		orderItem.setGoods_image("图片地址");
		Integer rows = mapper.insertOrderItem(orderItem);
		System.err.println(rows);
	}
}
