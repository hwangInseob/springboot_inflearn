package com.example.inflearn_study.member;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

@SpringBootTest
public class MemberTest {

	@Autowired
	MemberRepository memberRepo;
	

	@Test
	public void getMemberOne() {
		memberRepo.findById(0L).ifPresent(member -> { 
			System.out.println(member.toString());
			}
		);
	}
	
	@Test
	public void createMember() {
		MemberEntity newMember = MemberEntity.builder().name("황인섭").loginId("admin").password("1234").createDateTime(LocalDateTime.now()).lastLoginDateTime(LocalDateTime.now()).build();
				
		memberRepo.save(newMember);
	}
}
