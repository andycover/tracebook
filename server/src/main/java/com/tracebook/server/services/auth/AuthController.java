package com.tracebook.server.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracebook.server.services.auth.model.User;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody User user) {
		// Perform sign up logic
		boolean result = authService.signup(user);
		if (result) {
			return ResponseEntity.ok().body("Sign up successful");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sign up failed");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		// Perform login logic
		boolean result = authService.login(user);
		if (result) {
			return ResponseEntity.ok().body("Login successful");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}
}
