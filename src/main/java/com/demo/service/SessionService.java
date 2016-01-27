package com.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component(value="sessionService")
public class SessionService  {

	@Autowired
	private HttpSession request;
	
	public void setSession(String token){
		request.setAttribute("token", token);
	}
	
	public String getSession() {
		return (String) request.getAttribute("token");
	}
	
}
