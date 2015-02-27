package com.bjj.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="reqorder")
//@CompoundIndexes({
//	@CompoundIndex(name="",def="{}")
//})
public class ReqOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5297968621161872704L;
	@Id
	private String id;
	private String province;
	private String area;
	private Long startDate;
	private Long endDate;
	private String hotelName;
	private Integer roomNumber;
	private Integer roomType;
	/**
	 * 无参构造，当请求为User对象时，SPRING需要
	 * */
	public ReqOrder(){
		super();
	}
	
	@PersistenceConstructor
	public ReqOrder(String province,String area,Long startDate,Long endDate,String hotelName,Integer roomNumber,Integer roomType){
		this.province = province;
		this.area = area;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hotelName = hotelName;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Long getStartDate() {
		return startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getRoomType() {
		return roomType;
	}

	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "[ReqOrder:id="+this.id+"province="+this.province+
				"area="+this.area+"startDate="+this.startDate+"endDate="+this.endDate+
				"hotelName="+this.hotelName+"roomNumber="+this.roomNumber+"roomType="+this.roomType+"]";
	}
	
	public static String RoomTypeFormat(int type){
		String ft = null;
		switch(type){
		case 0:
			ft = "皆可";
			break;
		case 1:
			ft = "大床";
			break;
		case 2:
			ft = "双床";
			break;
		}
		return ft;
	}
}
