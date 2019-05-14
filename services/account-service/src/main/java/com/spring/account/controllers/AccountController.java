package com.spring.account.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AccountController {
	
	@RequestMapping(path = "/")
	public String returnAccount() {
		return "Initial account Wtild";
	}
}
