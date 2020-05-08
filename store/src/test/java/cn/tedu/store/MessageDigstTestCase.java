package cn.tedu.store;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDigstTestCase {
		
	@Test
	public void md5() {
		String password = "1";
		String md5password = DigestUtils.md5DigestAsHex(password.getBytes());
		System.err.println(md5password);
	}
}
