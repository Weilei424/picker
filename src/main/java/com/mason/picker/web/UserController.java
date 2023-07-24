package com.mason.picker.web;

import com.mason.picker.entity.Item;
import com.mason.picker.entity.User;
import com.mason.picker.service.UserService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @ApiResponse(responseCode = "200", description = "Successful retrieval of user")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @ApiResponse(responseCode = "201", description = "Successful creation of user")
    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @ApiResponse(responseCode = "204", description = "Successful deletion of user")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiResponse(responseCode = "200", description = "Successful creation of users",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = User.class))))
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}/pick")
    public ResponseEntity<Item> pickItem(@PathVariable Long id) {
        return new ResponseEntity<>(userService.pickItem(id), HttpStatus.OK);
    }
}
