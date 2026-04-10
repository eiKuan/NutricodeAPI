package com.tg.nutricode;

import org.springframework.boot.SpringApplication;

public class TestNutricodeApplication {

	public static void main(String[] args) {
		SpringApplication.from(NutricodeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
