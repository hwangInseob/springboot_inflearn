package com.example.inflearn_study.member;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public class MemberRepository {

	private final EntityManager em;
	
	@Autowired
	public MemberRepository(EntityManager em) {
		this.em = em;
	}
	
	public MemberEntity save(MemberEntity member) {
		em.persist(member);
		return member;
	}
	
	public Optional<MemberEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	
	public Optional<MemberEntity> findByName(String name) {
		return Optional.empty();
	}

	
	public List<MemberEntity> findAll() {
		return em.createQuery("select m from Member m", MemberEntity.class)
		           .getResultList();
	}
}
