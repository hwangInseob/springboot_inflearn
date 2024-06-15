package com.example.inflearn_study.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.inflearn_study.domain.Member;
import com.example.inflearn_study.repository.MemoryMemberRepository;

class MemberServiceTest {
	MemberService service = new MemberService();
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@BeforeEach
	void init() {
		repository.clearAll();
	}
	
	@Test
	public void join() {
		//given
		Member member1 = new Member();
		member1.setName("member1");
		//when
		service.join(member1);
		Member result = service.findOne(member1.getId()).orElse(new Member());
		//then
		Assertions.assertThat(result).isEqualTo(member1);
		
	}

	@Test
	public void duplicatedJoin() {
		//given
		Member member1 = new Member();
		member1.setName("member1");
		Member member2 = new Member();
		member2.setName("member1");
		service.join(member1);
		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> service.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
	}
	
}
