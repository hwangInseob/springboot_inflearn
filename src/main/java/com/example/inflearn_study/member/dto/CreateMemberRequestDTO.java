package com.example.inflearn_study.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateMemberRequestDTO {
	private String name;
	private String password;
	private String loginId;
	
}
