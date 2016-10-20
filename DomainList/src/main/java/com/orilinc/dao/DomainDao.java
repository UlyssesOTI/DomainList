package com.orilinc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orilinc.entity.Domain;

@Repository
public interface DomainDao extends JpaRepository<Domain, Integer>{
	
	public List<Domain> findByName(String name);
	
}
