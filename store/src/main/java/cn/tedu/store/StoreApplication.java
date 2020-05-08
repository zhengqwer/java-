package cn.tedu.store;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
@MapperScan("cn.tedu.store.mapper")
@Configuration
public class StoreApplication {	

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
	
	/**
	 * 设置文件上传大小
	 * @return 上传文件最大限制
	 */
	@Bean
	public MultipartConfigElement getMultipartConfig() {
		
		MultipartConfigFactory factory = new MultipartConfigFactory();
		DataSize maxFileSize = DataSize.ofMegabytes(100L);
		factory.setMaxFileSize(maxFileSize );
		factory.setMaxRequestSize(maxFileSize);
		
		return factory.createMultipartConfig();
	}

}
