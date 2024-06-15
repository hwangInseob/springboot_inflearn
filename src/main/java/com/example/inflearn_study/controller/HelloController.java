package com.example.inflearn_study.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.juli.logging.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@GetMapping("hello") //localhost:8080/hello 요청의 진입점 (1)
	public String hello(Model model) {
		model.addAttribute("data", "hello"); //hello.html에서 ${data} = "hello"(3)  
		return "hello"; //templates의 hello.html return (2)
	}
	
	/*
	 * localhost:8080/request?reqParam=myname 처럼 쿼리스트링으로 넘어오는 데이터를 받아들임
	 * @RequestParam("reqParam") String reqParam으로 받으면 {baseURL}/request 같이 reqParam이 없이 요청오면 400 에러 발생
	 * 아래와 같이 required = false 설정해주면 없어도 가능
	 * @RequestParam(required = false, name = "reqParam") String reqParam
	 * 
	 * 
	 * */
	@GetMapping("hello-param")
	public String helloPost(@RequestParam(required = false, name = "reqParam") String reqParam, Model model) {
		model.addAttribute("data", reqParam); //hello.html에서 ${data} = "hello"(3)  
		return "hello_param"; //templates의 hello.html return (2)
	}
	
	
}
