package com.orilinc.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orilinc.dao.DomainDao;
import com.orilinc.entity.Domain;
import com.orilinc.service.DomainService;

@Service
public class DomainServiceImpl implements DomainService{
	
	private static final int PAGE_SIZE = 5;

	@Autowired
	private DomainDao domainDao;
	
	public Domain inset(Domain domain) {			
		return domainDao.save(domain);		
	}

	public Page<Domain> getAll(Integer pageNumber) {
		
		PageRequest request =
	            new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "name");
	    return domainDao.findAll(request);
		
	}

	@Transactional
	public Domain getById(int id) {
		return domainDao.findOne(id);
	}

	public void update(Domain domain) {
		domainDao.save(domain);
	}

	public void delete(int id) {
		domainDao.delete(id);
	}
	
	public Domain checkDomain(Domain domain) {
		
		String apiKey ="AIzaSyCODHdxG2_dLXSphohA2qeJojRd10iYNyE";  
		String domainURLEncoded=null;
		try {
			domainURLEncoded = URLEncoder.encode(domain.getName(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String url = "https://sb-ssl.google.com/safebrowsing/api/lookup?"
				+ "client=DomainList"
				+ "&key="+apiKey
				+ "&appver=1.0.0"
				+ "&pver=3.0"
				+ "&url="+domainURLEncoded;
		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "");
			int responseCode = con.getResponseCode();
			if(responseCode==200){
				domain.setStatus(true);
			}else{
				domain.setStatus(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return domain;
	}

}
