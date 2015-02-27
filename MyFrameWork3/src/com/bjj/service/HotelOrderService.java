package com.bjj.service;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjj.model.ReqOrder;
import com.bjj.service.db.AreaRepository;
import com.bjj.service.db.CityRepository;
import com.bjj.service.db.HotelOrderRepository;
import com.bjj.service.db.HotelRepository;
import com.bjj.tools.DateUtils;
import com.bjj.tools.MailUtils;

@Component
public class HotelOrderService {
	@Autowired
	HotelOrderRepository repo;
	
	@Autowired
	CityRepository cityRepo;
	
	@Autowired
	AreaRepository areaRepo;
	
	@Autowired
	HotelRepository hotelRepo;
	
	@Autowired
	MailUtils mailUtils;

	@Autowired
	DateUtils dateUtils;
	
	public ReqOrder saveReqOrder(ReqOrder rOrder){
		try {
			return repo.save(rOrder);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean sendReqOrderNotifyByMail(ReqOrder reqOrder){
		return mailUtils.sendmail("cloudbian@bingdian.com", "申请预订单", getReqOrderMailContent(reqOrder));
	}
	
	private String getReqOrderMailContent(ReqOrder reqOrder){
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
			sb.append("<head>");
				sb.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />");
				sb.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'/>");
			sb.append("</head>");
		sb.append("<body>");
			sb.append("<table border=1px width='600'>");
				sb.append("<tr>");
					sb.append("<td>省/市:"+cityRepo.findOne(new ObjectId(reqOrder.getProvince())).getText()+"</td>");
					sb.append("<td>区/县:"+areaRepo.findOne(new ObjectId(reqOrder.getArea())).getName()+"</td>");
				sb.append("</tr>");
				sb.append("<tr>");
					sb.append("<td>开始日期:"+dateUtils.DateFormat(new Date(reqOrder.getStartDate()))+"</td>");
					sb.append("<td>结束日期:"+dateUtils.DateFormat(new Date(reqOrder.getEndDate()))+"</td>");
				sb.append("</tr>");
				sb.append("<tr>");
					sb.append("<td colspan='2'>酒店名称:"+hotelRepo.findOne(new ObjectId(reqOrder.getHotelName())).getText()+"</td>");
				sb.append("</tr>");
				sb.append("<tr>");
					sb.append("<td>房间数:"+reqOrder.getRoomNumber()+"</td>");
					sb.append("<td>房型:"+ReqOrder.RoomTypeFormat(reqOrder.getRoomType())+"</td>");
				sb.append("</tr>");
			sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
}
