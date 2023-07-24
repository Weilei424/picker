package com.mason.picker;

import com.mason.picker.entity.Item;
import com.mason.picker.entity.User;
import com.mason.picker.repository.ItemRepository;
import com.mason.picker.repository.UserRepository;
import com.mason.picker.service.ItemService;
import com.mason.picker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class PickerApplication implements CommandLineRunner {

	UserRepository userRepository;
	UserService userService;
	ItemRepository itemRepository;
	ItemService itemService;
	public static void main(String[] args) {
		SpringApplication.run(PickerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User[] users = new User[]{
				new User("Adam", "123"),
				new User("Lee", "321"),
				new User("Jojo", "456")
		};

		for (int i = 0; i < users.length; i++) {
			userRepository.save(users[i]);
		}

		Item[] items = new Item[]{
				new Item("Item1"),
				new Item("Item2"),
				new Item("Item3"),
				new Item("Item4"),
				new Item("Item5"),
				new Item("Item6"),
				new Item("Item7"),
				new Item("Item8"),
				new Item("Item9")
		};

		for (int i = 0; i < items.length; i++) {
			itemRepository.save(items[i]);
		}

	}
}
