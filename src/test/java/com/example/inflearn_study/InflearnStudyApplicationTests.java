package com.example.inflearn_study;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.inflearn_study.domain.Member;

@SpringBootTest
class InflearnStudyApplicationTests {

	@Test
	void contextLoads() {
		List<Member> result = new ArrayList<Member>();
		System.out.println(result);
	}

}
