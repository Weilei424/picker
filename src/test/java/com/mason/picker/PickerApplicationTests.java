package com.mason.picker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mason.picker.entity.User;
import com.mason.picker.repository.ItemRepository;
import com.mason.picker.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class PickerApplicationTests {
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	UserRepository userRepository;
	private User[] users = new User[] {

	};

	@BeforeEach
	void setup() {
		for (int i = 0; i < users.length; i++) {
			userRepository.save(users[i]);
		}
	}

	@AfterEach
	void clear() {
		userRepository.deleteAll();
	}
	@Test
	void contextLoads() {
	}

}
