package com.example.inflearn_study.member.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inflearn_study.member.dto.CreateMemberRequestDTO;
import com.example.inflearn_study.member.dto.CreateMemberResponseDTO;
import com.example.inflearn_study.member.entity.MemberEntity;
import com.example.inflearn_study.member.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
	private final MemberRepository memberRepository;
	
	
	public CreateMemberResponseDTO join(CreateMemberRequestDTO reqMemberInfo) {
		CreateMemberResponseDTO respMemberInfo = new CreateMemberResponseDTO();
		
		// 아이디 중복 확인
		if(!isDuplicateId(reqMemberInfo.getLoginId())) {
			
			
			MemberEntity entity = MemberEntity.toMemberEntity(reqMemberInfo);
			
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


	public boolean isDuplicateId(String loginId) {
		return memberRepository.findByLoginId(loginId).isPresent();
	}
	
}
