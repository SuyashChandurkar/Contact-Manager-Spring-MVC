package com.jspiders.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.UserDto;
import com.jspiders.springmvc.services.ContactServices;
import com.jspiders.springmvc.services.UserServices;
@Controller
public class UserController {
	@Autowired
private UserServices userServices;
	
	
	@RequestMapping(path="/delete_user",method=RequestMethod.GET)
	public String deleteUser(HttpSession httpSession,ModelMap map) {
		
		
		UserDto deleteuser = (UserDto)httpSession.getAttribute("user");
		if (deleteuser!=null) {
			System.out.println(deleteuser);
			UserServices.deleteUser(deleteuser);
			map.addAttribute("message", "User Deleted Succesfully");
		}
	return "signin_page";
		
		
	}
	
	@RequestMapping(path="getsignup_page", method = RequestMethod.GET)
	public String getSignupPage() {
		return "signup_page";
	}
	
	@RequestMapping(path="getsignin_page", method = RequestMethod.GET)
	public String getSigninPage() {
		return "signin_page";
	}
	
	@RequestMapping(path="signout",method = RequestMethod.GET)
	public String signOut() {
		return "signin_page";
	}
	
	@RequestMapping(path="/add_user",method = RequestMethod.POST)
	public String  addUser(@RequestParam(name="email")String email,@RequestParam(name="password")String password,ModelMap map) {
		boolean status = userServices.addUser(email, password);
		System.out.println(status);
		if (status) {
			map.addAttribute("message","SIGNED UP SUCCESFULLY");
			return "signin_page";
		}else {
			map.addAttribute("message","ERROR WHILE SING UP");
			return "signup_page";
		}
	
		
	}
	
	
	@RequestMapping(path ="/chech_user",method = RequestMethod.POST)
	public String findUserByEmailAndPassword(@RequestParam(name="email")String email,@RequestParam(name="password")String password,ModelMap map,HttpSession httpSession) {
		UserDto res = userServices.findUserByEmailAndPassword(email, password);
		System.out.println(res);
		if (res!=null) {
			httpSession.setAttribute("user", res);
			return "home";
		}else {
			map.addAttribute("message","invalid email or password");
			return "signin_page";
			
		}
	}
}
