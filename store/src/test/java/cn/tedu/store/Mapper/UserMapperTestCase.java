package cn.tedu.store.Mapper;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestCase {
	

	@Autowired
	UserMapper mapper;
	
	@Test
	public void insert() throws SQLException {
		User user = new User();
		user.setUsername("root");
		user.setPassword("123465");
		Integer rows = mapper.insert(user);
		System.err.println("rows="+rows);
		
	}
	
	@Test
	public void updatePassword() {
		Date date = new Date();
		Integer rows = mapper.updatePassword(2, "123", "ajax",date);
		System.err.println(rows);
	}
	
	@Test
	public void updateInfo() {
		User user = new User();
		user.setUid(2);
		user.setPhone("123123123");
		user.setEmail("123@tedu.com");
		user.setGender(1);
		user.setModifiedUser("超级管理员");
		user.setModifiedTime(new Date());
		Integer rows = mapper.updateInfo(user);
		System.err.println(rows);
	}
	
	@Test
	public void updateAvatar() {
		Integer rows = mapper.updateAvatar(2, "/home/soft01/zheng", "超级管理员", new Date());
		System.err.println(rows);
	}
	
	@Test
	public void findByUid() {
		User user = mapper.findByUid(2);
		System.err.println(user);
	}
	
	@Test
	public void findByUsername() {
		User user = mapper.findByUsername("zhangsan");
		System.err.println(user);
	}
	
	
}
