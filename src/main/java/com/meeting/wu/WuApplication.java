package com.meeting.wu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class WuApplication {
	public static void main(String[] args) {
		SpringApplication.run(WuApplication.class, args);
	}

}
