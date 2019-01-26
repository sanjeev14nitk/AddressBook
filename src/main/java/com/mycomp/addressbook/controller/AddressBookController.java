package com.mycomp.addressbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycomp.addressbook.dao.AbOperations;
import com.mycomp.addressbook.dto.Login;

@Controller
public class AddressBookController {
	
	@Autowired 
	private AbOperations abOperations;
	
	@RequestMapping("login.htm")
	public String welcome() {
		return "login";
	}
	
	@RequestMapping("userlogin.htm")
	public ModelAndView userLogin(Login login) {
		boolean status = abOperations.userLogin(login);
		
		ModelAndView mv = new ModelAndView();
		
		if(status)
		{
			mv.setViewName("register");
		}
		
		return mv;

	}
	
}
