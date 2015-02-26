package com.bjj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjj.model.Response;
import com.bjj.service.AreaService;

@Controller
public class AreaController {
	@Autowired
	private AreaService ser;
	
	@RequestMapping(value="/area/find/{cityId}",method=RequestMethod.GET)
	@ResponseBody
	public Response saveReqOrder(@PathVariable String cityId){
		Response rm = new Response();
		try {
			rm.setError(0);
			rm.setMessage(ser.getAllAreas(cityId));
		} catch (Exception e) {
			e.printStackTrace();
			rm.setError(1);
			rm.setMessage("获取区域列表异常:"+e.getMessage());
		}
		return rm;
	}
}
