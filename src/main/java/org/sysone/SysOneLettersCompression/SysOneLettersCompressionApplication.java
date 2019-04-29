package org.sysone.SysOneLettersCompression;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.sysone")
public class SysOneLettersCompressionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysOneLettersCompressionApplication.class, args);
	}

}
