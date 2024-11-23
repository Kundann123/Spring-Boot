package com.dbmodule.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbmodule.exception.UserDetailsNotFoundException;
import com.dbmodule.model.User;
import com.dbmodule.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sample_api")
public class UserController {

	@Autowired
	private UserService userService;

	//Swagger Documentation Annotations - Operation, Tag.
	@Operation(summary = "retrieve all the users", description = "retrieve all the users.The response is list of all users.")
	@GetMapping("/get_all_users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@Operation(summary = "Adding the user", description = "Add new user in DB. The response is SUCCESS.")
	@PostMapping("/add_users")
	public ResponseEntity<String> saveUser(@Valid @RequestBody User user) {
		userService.saveUser(user);
		// It allows you to control the HTTP response status code
		return ResponseEntity.status(HttpStatus.CREATED).body("Success");
	}

	@Operation(summary = "Get the users", description = "retrieve user by request parameter ID.")
	@GetMapping("/get_user_by_id")
	public ResponseEntity<User> fetchUserById(@RequestParam int id) {
		Optional<User> dataUser = userService.userById(id);
		if (dataUser.isEmpty()) {
			throw new UserDetailsNotFoundException("User not found for ID: " + id);
		}
		return ResponseEntity.ok(dataUser.get());
	}

	@Operation(summary = "Get the users", description = "retrieve user by path variable ID.")
	@GetMapping("/{id}")
	public Optional<User> fetchUserByPathVariable(@PathVariable int id) {
		Optional<User> dataUser = userService.userById(id);
		if (dataUser.isEmpty()) {
			throw new RuntimeException("Data not available for ID: "+id);
		}
		return dataUser;
	}

	@Operation(summary = "Delete the users", description = "Remove the user by path variable ID.")
//	@Tag(name = "delete", description = "GET method for delete user by ID.") 
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable int id) {
		userService.deleteUser(id);
//		return ResponseEntity.status(HttpStatus.OK).body("Success");
	}
	
	@Operation(summary = "Update the user", description = "Update the data of existing user.")
	@PutMapping("/update_data")
	public ResponseEntity<User> updateUserData(@RequestBody User user){
		userService.updateUserDetails(user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
