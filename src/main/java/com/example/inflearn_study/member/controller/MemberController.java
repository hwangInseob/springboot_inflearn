package com.example.inflearn_study.member.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.inflearn_study.member.dto.CreateMemberRequestDTO;
import com.example.inflearn_study.member.dto.CreateMemberResponseDTO;
import com.example.inflearn_study.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	
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
	
	@GetMapping("/member/{id}/exist")
	public ResponseEntity<Boolean> getIDExists(@PathVariable("id") String loginId) {
		try {
			return ResponseEntity.ok(memberService.isDuplicateId(loginId));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(false);
		}
	}
	
}
