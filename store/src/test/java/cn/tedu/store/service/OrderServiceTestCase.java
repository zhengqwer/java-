package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTestCase {

	@Autowired
	public IOrderService service;
	
	@Test
	public void create() {
		Integer aid = 1;
		Integer[] cids = {1,2,3};
		Integer uid = 1;
		String username = "管理员";
		Order order = service.create(aid, cids, uid, username);
		System.err.println(order);
	}
}
