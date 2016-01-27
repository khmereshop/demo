package com.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.base.Account;
import com.demo.model.PersonModel;
import com.demo.service.SessionService;


@RestController
public class AccountController {

	@Resource(name="accountService") // the resource refer to component
	private Account accountService;
	
	@Resource(name="sessionService")
	private SessionService sessionService;
	
	@RequestMapping(value="/account",method=RequestMethod.GET)
	public List<PersonModel> getAccount() {
		return accountService.getAccount();
	}
	
	@RequestMapping(value="/account",method=RequestMethod.POST)
	public PersonModel createAccount(@RequestBody PersonModel person) {
		
		String token = sessionService.getSession();
		person.setToken(token);
		accountService.setAccount(person);
		
		return person;
	}
	
	@RequestMapping(value="/session",method=RequestMethod.POST)
	public String createSession(@RequestBody PersonModel person) {
		String token = person.getToken();
		sessionService.setSession(token);
		return token;
	}
	
	@RequestMapping(value="/session",method=RequestMethod.GET)
	public String getSession() {
		return sessionService.getSession();
	}
	
}
