package com.orilinc.service;

import org.springframework.data.domain.Page;

import com.orilinc.entity.Domain;

public interface DomainService {
		
	public Domain inset(Domain domain);
	
	public Page<Domain> getAll(Integer pageNumber);
	
	public Domain getById(int id);
	
	public void update(Domain domain);
	
	public void delete(int id);
		
	public Domain checkDomain(Domain domain);
}
