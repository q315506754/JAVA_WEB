package com.bjj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjj.model.Response;
import com.bjj.service.CityService;

@Controller
public class CityController {
	@Autowired
	private CityService ser;
	
	@RequestMapping(value="/city/all",method=RequestMethod.GET)
	@ResponseBody
	public Response saveReqOrder(){
		Response rm = new Response();
		try {
			rm.setError(0);
			rm.setMessage(ser.getAllCitys());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rm;
	}
}
