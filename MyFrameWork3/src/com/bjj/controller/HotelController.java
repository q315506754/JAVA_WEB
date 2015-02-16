package com.bjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelController {
	
	@RequestMapping({"/hotel/order"})
	public String goHotelOrder(){
		return "hotel_order";
	}
}
