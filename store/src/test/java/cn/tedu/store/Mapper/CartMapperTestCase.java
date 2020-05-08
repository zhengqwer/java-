package cn.tedu.store.Mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.vo.CartVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTestCase {
	
	@Autowired
	public CartMapper mapper;
	
	@Test
	public void Cart() {
		Cart cart = new Cart();
		cart.setUid(1);
		cart.setGid(2L);
		cart.setNum(10);
		Integer rows = mapper.addnew(cart);
		System.err.println(rows);
	}
	
	@Test
	public void updateNum() {
		Integer cid = 1;
		Integer num = 2;
		String modifiedUser = "超级管理员";
		Date modifedTime = new Date();
		Integer rows = mapper.updateNum(cid, num, modifiedUser, modifedTime);
		System.err.println(rows);
	}
	
	@Test
	public void findByUidAndGid() {
		Cart cart = mapper.findByUidAndGid(1, 2L);
		System.err.println(cart);
	}
	
	@Test
	public void findByUid() {
		Integer uid = 1;
		List<CartVO> list = mapper.findByUid(uid);
		for (CartVO cartVO : list) {
			System.err.println(cartVO);
		}
	}
	
	@Test
	public void findByCid() {
		Integer cid = 1;
		Cart cart = mapper.findByCid(cid);
		System.err.println(cart);
	}
	
	@Test
	public void findByCids() {
		Integer[] cids = {1,2,3};
		List<CartVO> list = mapper.findByCids(cids);
		for (CartVO cartVO : list) {
			System.err.println(cartVO);
		}
	}
}
