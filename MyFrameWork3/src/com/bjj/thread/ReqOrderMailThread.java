package com.bjj.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjj.model.ReqOrder;
import com.bjj.service.HotelOrderService;

@Component
public class ReqOrderMailThread extends Thread {
	ReqOrder rOrder;
	@Autowired
	HotelOrderService ser;
	
	public void setROrder(ReqOrder rOrder){
		this.rOrder = rOrder;
	}
	
	@Override
	public void run() {
		super.run();
		if(!ser.sendReqOrderNotifyByMail(rOrder)){
			System.out.println(rOrder.getId()+"邮件发送失败");
		}
	}
}
