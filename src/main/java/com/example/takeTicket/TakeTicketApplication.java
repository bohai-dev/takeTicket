package com.example.takeTicket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.takeTicket.dao")
public class TakeTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakeTicketApplication.class, args);
	}
}
