package cn.tedu.store.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Goods;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceTestCase {
	

	@Autowired
	IGoodsService service;
	
	@Test
	public void getHotList() {
		List<Goods> list = service.getHotList();
		for (Goods goods : list) {
			System.err.println(goods);
		}
	}
	
	@Test
	public void getById() {
		Goods goods = service.getById(10000001L);
		System.err.println(goods);
	}
}
