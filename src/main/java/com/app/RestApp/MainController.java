package com.app.RestApp;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	HashMap<String, String> map = new HashMap<>();
	String names,pwsd;
	@GetMapping("/Home")
	//@ResponseBody
	public String sayWelcome()
	{
		return "login.jsp";
	}
	
	@PostMapping("/loginvalidate")
	@ResponseBody
	public String valid(@RequestParam("uname") String name,@RequestParam("psw") String pwd) {
		
		if(name.equals(names) && pwd.equals(pwsd))
		{
			System.out.println(map.get(name));
		return "Success";
		}
		else
			return 
					"Failure";
		
	}
	
	@GetMapping("/Register")
	
	public String Register()
	{
		
		return "Register.jsp";
	}
	
	@PostMapping("/registering")

	public String reg(@RequestParam("uname") String name,@RequestParam("psw") String pwd) {
		
		map.put(name,pwd);
		names=name;
		pwsd=pwd;

		return "login.jsp";
	}
	
}
