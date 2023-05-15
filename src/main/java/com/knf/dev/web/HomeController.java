package com.knf.dev.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/login")
	public String login() {
		System.out.println("Done!");
		return "login";}


	@GetMapping("/")
	public String home() {
		return "index";
	}
}
