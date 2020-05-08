package cn.tedu.store.service;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTestCase {
	

	@Autowired
	IUserService service;
	
	@Test
	public void regTest() {
		try {
			User user = new User();
			user.setUsername("root");
			user.setPassword("123");
			service.reg(user);
			System.out.println("注册成功！");
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void loginTest() {
		try {
			String username = "qwer";
			String password = "123";
			User result = service.login(username, password);
			System.err.println(result);
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changePassword() {
		try {
			service.changePassword(2, "qwer", "123", "456");
			System.err.println("修改成功！");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changeInfo() {
		try {
			User user = new User();
			user.setUid(2);
			user.setPhone("13897125306");
			user.setEmail("138@tedu.com");
			user.setGender(0);
			user.setModifiedUser("ROOT");
			user.setCreatedTime(new Date());
			service.changeInfo(user);
			System.err.println("修改成功！");
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changeAvatar() {
		try {
			Integer uid = 2;
			String avatar = "这里是头像的路径";
			String username = "ROOT";
			service.changeAvatar(uid, avatar, username);
			System.err.println("修改成功");
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByUid() {
		try {
			User user = service.getByUid(2);
			System.err.println(user);
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
}
