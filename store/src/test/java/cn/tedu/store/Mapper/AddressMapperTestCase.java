package cn.tedu.store.Mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTestCase {
	
	@Autowired
	AddressMapper mapper;
	
	@Test
	public void insert() {
		Address address = new Address();
		address.setUid(1);
		address.setName("zhangsan");
		address.setProvince("jilin");
		Integer rows = mapper.insert(address);
		System.err.println(rows);
	}
	
	@Test
	public void countByUid() {
		Integer rows = mapper.countByUid(1);
		System.err.println(rows);
	}
	
	@Test
	public void findByUid() {
		List<Address> list = mapper.findByUid(1);
		System.err.println("BEGIN");
		for(Address a : list) {
			System.err.println(a);
		}
		System.err.println("END");
	}
	
	@Test
	public void updatedefault() {
		Integer rows = mapper.updateDefault(1, "超级管理员", new Date());
		System.err.println(rows);
	}
	
	@Test
	public void updateNotDefault() {
		Integer rows = mapper.updateNotDefault(1);
		System.err.println(rows);
	}
	
	@Test
	public void findByAid() {
		Address a = mapper.findByAid(1);
		System.err.println(a);
	}
	
	@Test
	public void deleteByAid() {
		Integer rows = mapper.deleteByAid(10);
		System.err.println(rows);
	}
	
	@Test
	public void findLastModified() {
		Address address = mapper.findLastModified(1);
		System.err.println(address);
	}
	
	@Test
	public void updateInfo() {
		Address address = new Address();
		address.setAid(1);
		address.setName("刚哥");
		address.setZip("666666");
		address.setAddress("幸福小区101室");
		address.setTel("110120");
		address.setPhone("789798");
		address.setTag("家");
		address.setModifiedUser("超级管理员");
		address.setModifiedTime(new Date());
		Integer rows = mapper.updateInfo(address);
		System.err.println(rows);
	}

}
