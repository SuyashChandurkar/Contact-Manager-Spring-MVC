package com.jspiders.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.ContactDto;
import com.jspiders.springmvc.dto.UserDto;
import com.jspiders.springmvc.services.ContactServices;

@Controller
public class ContactController {
	@Autowired
	private ContactServices contactServices;
	
	
	
		@RequestMapping(path="/home" ,method = RequestMethod.GET)
		public String home(HttpSession httpSession) {
			UserDto user = (UserDto)httpSession.getAttribute("user");
			if (user!=null) {
				return "home";
			}else {
				return "signin_page";
			}
			
		}
		@RequestMapping(path="/add", method=RequestMethod.GET)
		public String add(HttpSession httpSession) {
			UserDto user =(UserDto) httpSession.getAttribute("user");
			if (user!=null) {
				return "add";
			}else {
				return "signin_page";
			}
		}
		
		@RequestMapping(path="/contact", method = RequestMethod.POST)
		  public String addContact(@RequestParam("firstname")String firstname,@RequestParam("lastname") String lastname, @RequestParam("email")String email,@RequestParam("mobile") String mobile,ModelMap map) {
			boolean status = contactServices.addContact( firstname,  lastname,  email,  mobile);
	        List<ContactDto> contacts = contactServices.viewallcontact();
	        if (status) {
				map.addAttribute("message","Contact Added ");
			}else {
				map.addAttribute("message","Contact Not Added");
			}
	        if (contacts!=null) {
				map.addAttribute("contacts",contacts);
			}else {
				map.addAttribute("message","Contact Not Founds");
			}
	        return "viewallcontact";
	    }
		
		@RequestMapping(path="/contacts", method=RequestMethod.GET)
		public String viewAllContact(ModelMap map,HttpSession httpSession) {
			
			UserDto user =(UserDto) httpSession.getAttribute("user");
			if (user!=null) {
				List<ContactDto> contacts = contactServices.viewallcontact();
				if (contacts.size()>0) {
					map.addAttribute("contacts",contacts);
				}else {
					map.addAttribute("message","contact not found");
				}
				return "viewallcontact";
			}else {
				return "signin_page";
			}
			
			
		}
		
		
		@RequestMapping(path="/delete", method = RequestMethod.GET)
		public String delete(ModelMap map) {
			System.out.println("deletemethod");
			List<ContactDto> contacts = contactServices.viewallcontact();
			if (contacts.size()>0) {
				System.out.println("end delete method");
				map.addAttribute("contacts",contacts);
			}else {
				map.addAttribute("message","contact not found");
			}
			return "delete";
			
		}
		
		
		@RequestMapping(path="/deletecontact", method = RequestMethod.POST)
		public String deleteContact(@RequestParam("id")int id,ModelMap map) {
			ContactDto contact = contactServices.deleteContact(id);
			
			if (contact!=null) {
				map.addAttribute("message","Contact Get Succesfully Deleted");
				
			}else {
				map.addAttribute("message","Contact Not Found");
			}
			List<ContactDto> viewallcontact = contactServices.viewallcontact();
			if (viewallcontact!=null) {
				map.addAttribute("contacts", viewallcontact);
			}else {
				map.addAttribute("message", "Contact Not Found");
			}
			
			return "delete";
			
		}
		
		@RequestMapping("/edit")
		public String editPage(Model map,HttpSession httpSession) {
			
			UserDto user = (UserDto)httpSession.getAttribute("user");
			if (user!=null) {
				List<ContactDto> contacts = contactServices.viewallcontact();
				if (contacts!=null) {
					
					map.addAttribute("contacts", contacts);
				}else {
					map.addAttribute("message","Contact Not Found");
				}
				
				return "edit";
			}else {
				return "signin_page";
			}
			
			
			
		}
		
		
		@RequestMapping(path="/update",method = RequestMethod.POST)
		public String updatePage(@RequestParam("id") int id ,ModelMap map) {
			ContactDto contact = ContactServices.getContact(id);
			List<ContactDto> contacts = contactServices.viewallcontact();
			if (contact!=null) {
				map.addAttribute("contact", contact);
			}else {
				map.addAttribute("message","Contact DoesNot Exits");
			}
			return "update";
		}
		
		
		@RequestMapping(path="/updatecontact",method = RequestMethod.POST)
		public String updateContact(@RequestParam(name="id")int id,@RequestParam("firstname")String firstname,@RequestParam("lastname") String lastname, @RequestParam("email")String email,@RequestParam("mobile") String mobile,ModelMap map) {
			List<ContactDto> contacts = contactServices.viewallcontact();
			boolean status = contactServices.updateContact(id,firstname, lastname, email, mobile);
			if (status) {
				map.addAttribute("message","Contact Updated Succesfully");
				map.addAttribute("contacts",contacts);
				return "viewallcontact";
			}else {
				map.addAttribute("message","Contact Not Updated.......");
				return "edit";
			}
			
			
			
		}
		
		
		@RequestMapping(path="searchby",method = RequestMethod.GET)
		public String getSearchByOption(HttpSession httpSession) {
			UserDto user = (UserDto)httpSession.getAttribute("user");
			if (user!=null) {
				return "searchby";
			}else {
				return "signin_page";
			}
		}
		
		@RequestMapping(path="searchbyoperation" ,method =RequestMethod.POST)
		public String searchByOperation(@RequestParam(name="option") String option,@RequestParam(name="name")String name,ModelMap map) {
			
			
			ContactDto contact = contactServices.searchByOperation(option,name);
			
			if (contact!=null) {
				
				map.addAttribute("contact",contact);
				return"showsearchuser";
			}else {
				map.addAttribute("message","contact Does Not Exists");
				return"searchby";
			}
			
		}
}
