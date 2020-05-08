package cn.tedu.store.Mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.DistrictMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictMapperTestCase {

	@Autowired
	public DistrictMapper mapper;
	
	@Test
	public void findByParent() {
		List<District> list = mapper.findByParent("86");
		for (District district : list) {
			System.err.println(district);
		}
	}
	
	@Test
	public void findByCode() {
		District d = mapper.findByCode("110101");
		System.err.println(d);
	}
}
