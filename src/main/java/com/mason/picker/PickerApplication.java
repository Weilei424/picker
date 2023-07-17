package com.mason.picker;

import com.mason.picker.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PickerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PickerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User[] users = new User[]{
				new User("Adam")
		};


	}
}
