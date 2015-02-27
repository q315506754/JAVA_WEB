package com.bjj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjj.model.ReqOrder;
import com.bjj.model.Response;
import com.bjj.service.HotelOrderService;
import com.bjj.thread.ReqOrderMailThread;

@Controller
public class HotelOrderController {
	@Autowired
	HotelOrderService ser;
	@Autowired
	ReqOrderMailThread mailThread;
	
	@RequestMapping(value="/hotel/order/req",method=RequestMethod.POST)
	@ResponseBody
	public Response saveReqOrder(@RequestBody ReqOrder reqOrder){
		Response rm = new Response();
		ReqOrder rOrder = ser.saveReqOrder(reqOrder);
		if(null!=rOrder){
			rm.setError(0);
			//异步发送邮件
			mailThread.setROrder(reqOrder);
			mailThread.start();
		}else{
			rm.setError(1);
			rm.setMessage("提交申请订单失败，请重新试试");
		}
		return rm;
	}
}
