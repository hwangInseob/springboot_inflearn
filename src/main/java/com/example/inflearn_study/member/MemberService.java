package com.example.inflearn_study.member;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private final MemberRepository memberRepository;
	
	MemberService(MemberRepository repository) {
		this.memberRepository = repository;
	}
	
	
	public CreateMemberResponseDTO join(CreateMemberRequestDTO reqMemberInfo) {
		CreateMemberResponseDTO respMemberInfo = new CreateMemberResponseDTO();
		
		// 아이디 중복 확인
		if(!isDuplicateId(reqMemberInfo.getLoginId())) {
			MemberEntity entity = MemberEntity.builder()
											  .name(reqMemberInfo.getName())
											  .loginId(reqMemberInfo.getLoginId())
											  .password(reqMemberInfo.getPassword())
											  .createDateTime(LocalDateTime.now())
											  .lastLoginDateTime(LocalDateTime.now())
											  .build();
			
			MemberEntity result = memberRepository.save(entity);
			
			if(result != null) {
				respMemberInfo = CreateMemberResponseDTO.builder()
														.loginId(result.getLoginId())
														.memberId(result.getMemberId())
														.name(result.getName())
														.build();
			}
		} 

		return respMemberInfo;
	}


	private boolean isDuplicateId(String loginId) {
		return memberRepository.findByLoginId(loginId).isPresent();
	}
	
}
