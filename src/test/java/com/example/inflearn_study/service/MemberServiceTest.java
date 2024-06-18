package com.example.inflearn_study.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.inflearn_study.member.MemberEntity;

class MemberServiceTest {
	
	@Test
	public void setterTest() {
		MemberEntity entity = new MemberEntity();
		
		entity.setMemberId(1L);
		
		Assertions.assertThat(entity.getMemberId()).isEqualByComparingTo(1L);
	}
}
