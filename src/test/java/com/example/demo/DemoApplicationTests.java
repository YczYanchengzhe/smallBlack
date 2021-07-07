package com.example.demo;

import com.example.demo.dao.modol.UserInfo;
import com.example.demo.dao.service.UserServiceDao;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserServiceDao userServiceDao;

	@Test
	void contextLoads() {
		List<UserInfo> re = userServiceDao.list();


		System.out.println(re);

	}

}
