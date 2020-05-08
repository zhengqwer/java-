package cn.tedu.store.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;

@RunWith(SpringRunner.class)
@SpringBootTest
public class addressServiceTestCase {
	
	@Autowired
	public IAddressService service;
	
	@Test
	public void add() {
		try {
			Address address = new Address();
			address.setUid(3);
			address.setName("TIANTAN用户");
			String username = "超级用户";
			service.addnew(address, username);
			System.err.println("添加成功");
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
		
	}
	
	@Test
	public void findByUid() {
		List<Address> list = service.getByUid(1);
		System.err.println("BEGIN");
		for (Address address : list) {
			System.err.println(address);
		}
		System.err.println("END");
	}
	
	@Test
	public void setDefault() {
		try {
			service.setDefault(1, 1, "ROOT");
			System.err.println("执行成功！");
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void deleteByAid() {
		try {
			service.deleteByAid(5, 1, "超级管理员");
			System.err.println("删除成功");
		} catch (Exception e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changeInfo() {
		try {
			Address address = new Address();
			address.setAid(1);
			address.setName("龙哥");
			address.setZip("999999");
			address.setAddress("数据小区101室");
			address.setTel("000000");
			address.setPhone("000000");
			address.setTag("公司");
			address.setModifiedUser("后台人员");
			address.setModifiedTime(new Date());
			service.changeInfo(address);
			System.out.println("修改成功");
		} catch (Exception e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByAid() {
		Address address = service.getByAid(1);
		System.err.println(address);
	}
}
