package com.example.inflearn_study.member;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="member")
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
