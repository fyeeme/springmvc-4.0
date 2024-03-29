package com.fedora.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fedora.org.service.impl.OrderServiceImpl;


@Controller
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderService;

	@RequestMapping("/order/P1234/2")
	public String process() {
		orderService.processOrder("P1234", 2);
		return "redirect:/products";
	}
}
