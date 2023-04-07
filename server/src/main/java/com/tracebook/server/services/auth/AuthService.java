package com.tracebook.server.services.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tracebook.server.services.auth.model.User;

@Service
public class AuthService {
	private Map<String, String> users = new HashMap<>();

	public boolean signup(User user) {
		// perform sign up logic
		if (!users.containsKey(user.getName())) {
			users.put(user.getPassword(), user.getPassword());
			return true;
		} else {
			return false;
		}
	}

	public boolean login(User user) {
		// Perform login logic
		if (users.containsKey(user.getName()) && users.get(user.getName()).equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
