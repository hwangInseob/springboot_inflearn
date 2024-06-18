package com.example.inflearn_study.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@PostMapping("/member")
	public ResponseEntity<CreateMemberResponseDTO> createMember(@RequestBody CreateMemberRequestDTO reqMemberInfo) {
		try {
			CreateMemberResponseDTO response;
			
			response = memberService.join(reqMemberInfo);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new CreateMemberResponseDTO());
		}
	}
}
