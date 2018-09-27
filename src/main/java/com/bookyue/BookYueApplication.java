package com.bookyue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bookyue.mapper")
public class BookYueApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookYueApplication.class, args);
	}
}
