package com.example.inflearn_study.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.inflearn_study.domain.Member;

class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@BeforeEach
	void init() {
		repository.clearAll();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("황인섭");
		repository.save(member);
		Member result = repository.findById(member.getId()).get();
		Assertions.assertThat(member).isEqualTo(result);
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("Member1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("Member2");
		repository.save(member2);
		
		Member result1 = repository.findByName("Member1").get();
		Member result2 = repository.findByName("Member2").get();
		
		assertThat(result1).isEqualTo(member1);
		assertThat(result2).isEqualTo(member2);
		

		List<Member> result = repository.findAll();
		
		System.out.println(result.size());
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("Member1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("Member2");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		
		assertThat(result.size()).isEqualTo(2);

		System.out.println(result.size());
	}
}
