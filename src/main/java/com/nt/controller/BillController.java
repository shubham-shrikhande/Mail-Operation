package com.nt.controller;

import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.Model.Customer;
import com.nt.service.BillManageServiceImp;

@Controller
public class BillController {

	@Autowired
	BillManageServiceImp service;
	
	@GetMapping("/index")
	public String homePage() {
		return "index";
	}
	
	@PostMapping("/result")
	public String result(@ModelAttribute Customer cust,Map<String, Object> map) throws MessagingException {
		
		String msg=service.billMaker(cust.getName(), cust.getItem(), cust.getPrice(), cust.getTomail());
		map.put("msg", msg);
		return "result";
	}
}
