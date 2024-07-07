package blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/auth/loginForm")
	public String login() {
		
		return "loginForm";
	}
	
	@GetMapping("/auth/joinForm")
	public String join() {
		return "joinForm";
	}


}
