package com.example.inflearn_study.service;

import java.util.List;
import java.util.Optional;

import com.example.inflearn_study.domain.Member;
import com.example.inflearn_study.repository.MemberRepository;
import com.example.inflearn_study.repository.MemoryMemberRepository;

public class MemberService {
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	private void checkDuplicatedUser(Optional<Member> result) {
		result.ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
			}
		);
	}
	
	/**
	 * 회원가입
	 * 
	 * @param member
	 * @return
	 */
	public Long join(Member member) {
		//같은 이름의 회원은 가입할 수 없다고 가정.
		//중복체크
		Optional<Member> result = memberRepository.findByName(member.getName());
		
		checkDuplicatedUser(result);  
		
		memberRepository.save(member);
		return member.getId();
	}
	
	public Optional<Member> findOne(Long id) {
		return memberRepository.findById(id);
	}
	
	public List<Member> findAll() {
		return memberRepository.findAll();
	}
}
