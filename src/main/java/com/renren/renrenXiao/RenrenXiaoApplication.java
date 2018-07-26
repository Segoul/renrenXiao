package com.renren.renrenXiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.renren.renrenXiao.dao.rdb")
@EnableTransactionManagement
public class RenrenXiaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenrenXiaoApplication.class, args);
	}
}
