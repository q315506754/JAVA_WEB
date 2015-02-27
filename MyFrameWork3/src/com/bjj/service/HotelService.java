package com.bjj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.bjj.model.Hotel;
import com.bjj.service.db.HotelRepository;

@Component
public class HotelService {
	@Autowired
	HotelRepository repo;
	
	public List<Hotel> searchHotelsByAreaIdAndName(String cityId,String areaId,String name){
		Pageable page = new PageRequest(0, 10); //限制每次返回最多10条记录
		if(!"".equals(areaId.trim())){
			return repo.findHotelsByAreaId_Name(areaId, name, page);
		}else if(!"".equals(cityId.trim())){
			return repo.findHotelsByCityId_Name(cityId, name, page);
		}else{
			return repo.findHotelsByName(name, page);
		}
		
	}
}
