package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.base.Account;
import com.demo.model.PersonModel;


@Component(value="accountService") // this name refer to the variable in the controller
public class AccountService implements Account  {

	private List<PersonModel> person = new ArrayList<PersonModel>();
	
	public List<PersonModel> getAccount() {
		
		return this.person;
	}
	
	public void setAccount(PersonModel data) {
		this.person.add(data);
		System.out.println(data.toString());
	}
	
}
