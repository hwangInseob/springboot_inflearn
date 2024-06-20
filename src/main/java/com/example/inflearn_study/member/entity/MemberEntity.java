package com.example.inflearn_study.member.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="member")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MemberEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long memberId;
	
	@Column(name = "name")
	private String name;

	@Column(name = "login_id")
	private String loginId;
	
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "create_datetime")
	private LocalDateTime createDateTime;
	
	@Column(name = "last_login_datetime")
	private LocalDateTime lastLoginDateTime;
}
