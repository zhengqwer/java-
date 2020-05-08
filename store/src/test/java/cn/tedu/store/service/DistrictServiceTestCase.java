package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictServiceTestCase {

	@Autowired
	public IDistrictService service;
	
	@Test
	public void findByParent() {
		List<District> list = service.getByParent("86");
		System.err.println("BEGIN");
		for(District d : list) {
			System.err.println(d);
		}
		System.err.println("END");
	}
	
	@Test
	public void findByCode() {
		District d = service.getByCode("110101");
		System.err.println(d);
	}
	
}
