package com.example.inflearn_study.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMemberRequestDTO {

	public String name;
	public String password;
	public String loginId;
	
}
