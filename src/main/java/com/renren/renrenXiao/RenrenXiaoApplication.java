package com.renren.renrenXiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.renren.renrenXiao.dao.rdb")
public class RenrenXiaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenrenXiaoApplication.class, args);
	}
}
