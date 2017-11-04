package com.sai;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
//public class SpringBootConsoleApplication implements CommandLineRunner {
public class SpringBootConsoleApplication  {
	@Autowired
	DataSource dataSource;

	@Autowired
	private ClientDriver cd;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {

		cd.readConsole();
	}*/
}
