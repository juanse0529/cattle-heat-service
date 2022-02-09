package com.cattle.heat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cattle.heat", "com.cattle.commons"})
@EntityScan(basePackages = {"com.cattle.heat.model","com.cattle.commons.model"})
public class HeatsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeatsServiceApplication.class, args);
	}

}
