package com.example.inflearn_study.controller;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("hello") //localhost:8080/hello 요청의 진입점 (1)
	public String hello(Model model) {
		model.addAttribute("data", "hello"); //hello.html에서 ${data} = "hello"(3)  
		return "hello"; //templates의 hello.html return (2)
	}
	
	
}
