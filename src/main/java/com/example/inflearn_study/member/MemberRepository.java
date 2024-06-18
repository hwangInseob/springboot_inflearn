package com.example.inflearn_study.member;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
	
	
	Optional<MemberEntity> findByLoginId(String loginId);
}
