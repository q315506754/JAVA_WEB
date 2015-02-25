package com.bjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bjj.model.ReqOrder;
import com.bjj.model.Response;

@Controller
public class HotelController {
	
	@RequestMapping({"/hotel/order"})
	public String goHotelOrder(){
		return "hotel_order";
	}
	
	@RequestMapping(value="/hotel/order/req",method=RequestMethod.POST)
	public Response saveReqOrder(@RequestBody ReqOrder reqOrder){
		System.out.println(reqOrder.getEndDate());
		Response rm = new Response();
		return rm;
	}
}
