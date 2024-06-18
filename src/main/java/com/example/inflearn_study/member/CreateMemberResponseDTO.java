package com.example.inflearn_study.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateMemberResponseDTO {
	private Long memberId;
	private String name;
	private String loginId;
}
