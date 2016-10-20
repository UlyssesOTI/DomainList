package com.orilinc.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.orilinc.dao.DomainDao;
import com.orilinc.entity.Domain;

@Component
public class DomainValidator implements Validator{
	
	@Autowired
	private DomainDao domainDao;

	public boolean supports(Class<?> clazz) {		
		return Domain.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Domain domain = (Domain) target;
		List<Domain> domainList = domainDao.findByName(domain.getName());
		if(domainList!=null && domainList.size()>0){
			errors.rejectValue("name", "name.alreadyExist");
		}
	}

}
