package com.example.inflearn_study.member;

import java.util.List;
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
	
//	private void checkDuplicatedUser(Optional<Member> result) {
//		result.ifPresent(m -> {
//			throw new IllegalStateException("이미 존재하는 회원입니다.");
//			}
//		);
//	}
	
	/**
	 * 회원가입
	 * 
	 * @param member
	 * @return
	 */
//	public Long join(Member member) {
//		//같은 이름의 회원은 가입할 수 없다고 가정.
//		//중복체크
//		Optional<Member> result = memberRepository.findByName(member.getName());
//		
//		checkDuplicatedUser(result);  
//		
//		memberRepository.save(member);
//		return member.getMemberId();
//	}
//	
//	public Optional<Member> findOne(Long id) {
//		return memberRepository.findById(id);
//	}
	
	public List<MemberEntity> findAll() {
		return memberRepository.findAll();
	}
}
