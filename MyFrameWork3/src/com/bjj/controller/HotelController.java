package com.bjj.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjj.model.ReqOrder;
import com.bjj.model.Response;
import com.bjj.service.HotelService;

@Controller
public class HotelController {
	@Autowired
	HotelService ser;
	
	@RequestMapping({"/hotel/order"})
	public String goHotelOrder(){
		return "hotel_order";
	}
	
	@RequestMapping(value="/hotel/search",method=RequestMethod.POST)
	@ResponseBody
	public Response searchHotel(@RequestParam(value="cityId",required=false)String cityId,@RequestParam(value="areaId",required=false)String areaId,@RequestParam(value="hotelName",required=true)String hotelName){
		Response rm = new Response();
		try {
			rm.setError(0);
			JSONObject result = new JSONObject();
			result.put("hotels", ser.searchHotelsByAreaIdAndName(cityId,areaId,hotelName));
			result.put("total_count", result.getJSONArray("hotels").size());
			rm.setMessage(result);
		} catch (Exception e) {
			e.printStackTrace();
			rm.setError(1);
		}
		return rm;
	}
}
