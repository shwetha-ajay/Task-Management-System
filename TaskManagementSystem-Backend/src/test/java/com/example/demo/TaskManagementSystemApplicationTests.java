package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;
@Suite
@SelectPackages("com.bytes.service")
@SpringBootTest
class TaskManagementSystemApplicationTests {

	@Test
	void contextLoads() {
	}

}
