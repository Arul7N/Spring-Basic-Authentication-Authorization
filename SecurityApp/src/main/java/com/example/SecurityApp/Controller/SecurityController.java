package com.example.SecurityApp.Controller;

import com.example.SecurityApp.Model.Info;
import com.example.SecurityApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@Autowired
	private UserService service;

	@GetMapping("/")
	public String home() {
		return "Welcome All";
	}


	@PreAuthorize("hasAuthority('USER')")
	@GetMapping("/user")
	public String user() {
		return "Welcome User";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return "Welcome Admin";
	}


	@PostMapping("/add")
	public String addUser(@RequestBody Info info){
		return service.newUser(info);
	}
}
