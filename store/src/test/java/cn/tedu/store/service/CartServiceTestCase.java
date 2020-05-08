package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTestCase {

	@Autowired
	public ICartService service;
	
	@Test
	public void addToCart() {
		try {
			Cart cart = new Cart();
			cart.setUid(4);
			cart.setGid(5L);
			cart.setNum(1);
			String username = "系统管理员";
			service.addToCart(cart, username);
			System.err.println("添加成功！！！");
		} catch (Exception e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByUid() {
		List<CartVO> list = service.getByUid(1);
		for (CartVO cartVO : list) {
			System.err.println(cartVO);
		}
	}
	
	@Test
	public void addNum() {
		try {
			Integer cid = 1;
			Integer uid = 1;
			String username = "超级用户";
			Integer rows = service.addNum(cid, uid, username);
			System.err.println(rows);
		} catch (Exception e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByCids() {
		Integer[] cids = {1,2,3};
		List<CartVO> list = service.getByCids(cids);
		for (CartVO cartVO : list) {
			System.err.println(cartVO);
		}
	}
}
