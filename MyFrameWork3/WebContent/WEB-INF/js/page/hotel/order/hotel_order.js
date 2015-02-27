$(function(){
	///plugin init
	function formatSelect2(e){
//		var d = $(e.element);
		return e.text;
	};
	
	$("#province").select2({
		placeholder:"请选择城市",
//		allowClear:true,
		ajax: {
		    url: "city/like",
			contentType:'application/json;charset=UTF-8',
			cache:false,
		    type:"POST",
		    dataType: 'json',
		    delay: 250,
		    data: function (params) {
		    	return {
			        name: params,
			      };
		    },
		    results: function (data) {
		    	var items = data.message;
		      // parse the results into the format expected by Select2.
		      // since we are using custom formatting functions we do not need to
		      // alter the remote JSON data
		      return {
		        results: items,
		        more:false
		      };
		    }
		},
		minimumInputLength: 1,
		formatSelection:formatSelect2,
        formatInputTooShort: "请输入城市名称",
        formatNoMatches: "没有匹配的城市名称",
        formatSearching: "查询中..."
	}).change(function(e){
		///搜索对应的区域
		$("#mod_loading").modal({
			backdrop:false,
	        keyboard:false
		});
		$.ajax({
			type:"GET",
			url:"area/find/"+e.val,
			cache:false,
			dataType:"json",
			contentType:'application/json;charset=UTF-8'
		}).done(function(data,textStatus){
			if(data.error == 0){
				$("#mod_loading").hide();
				var html = "<option value=''>请选择区域</option>";
				if(null!=data.message){
					for(var i=0;i<data.message.length;i++){
						var a = data.message[i];
						html += "<option value='"+a.id+"'>"+a.name+"</option>";
					}
				}
				$("#aList").html(html);
			}
		}).fail(function(){
			$("#mod_loading").hide();
			alert("网络异常");
		});
	});
	
	$("#area").select2({
		placeholder:"请选择区域",
//		allowClear:true,
		formatSelection:formatSelect2,
        formatInputTooShort: "请输入区域名称",
        formatNoMatches: "没有匹配的区域名称",
        formatSearching: "查询中..."
	});
	
	$("#hotelName").select2({
		lang: "cn",
		placeholder:"请输入需要查找的酒店名称",
//		allowClear:true,
		ajax: {
		    url: "hotel/search",
			contentType:'application/json;charset=UTF-8',
			cache:false,
		    type:"POST",
		    dataType: 'json',
		    delay: 250,
		    data: function (params) {
		    	return {
			        hotelName: params,
			        areaId: $("#area").val(),
			        cityId: $("#province").val()
			      };
		    },
		    results: function (data) {
		    	var items = data.message.hotels;
		      // parse the results into the format expected by Select2.
		      // since we are using custom formatting functions we do not need to
		      // alter the remote JSON data
		      return {
		        results: items,
		        more:false
		      };
		    }
		},
		minimumInputLength: 1,
		formatSelection:formatSelect2,
        formatInputTooShort: "请输入需要查找的酒店名称",
        formatNoMatches: "没有匹配的酒店名称",
        formatSearching: "查询中..."
	});
	
	$("#stDate").datepicker({
		dafaultDate:"+0d",
		changeMonth:true,
		changeYear:true,
		numberOfMonths:1,
		prevText: '<i class="fa fa-chevron-left"></i>',
		nextText: '<i class="fa fa-chevron-right"></i>',
	    onSelect: function (selectedDate) {
            var mDate = new Date(selectedDate);
            mDate.setDate(mDate.getDate()+1);
	        $('#edDate').datepicker('option', 'minDate', mDate);
	    }
	});
	$("#stDate").datepicker('option', 'minDate', new Date());
	$("#edDate").datepicker({
		dafaultDate:"+0d",
		changeMonth:true,
		changeYear:true,
		numberOfMonths:1,
		prevText: '<i class="fa fa-chevron-left"></i>',
		nextText: '<i class="fa fa-chevron-right"></i>'
	});
	
	///event
	$("#btnOrder").unbind("click").click(function(e){
		e.preventDefault();
		var params = {};
		params.province = $("#province").val();
		params.area = $("#area").val();
		var sdArray = $("#stDate").val().split("-");
		params.startDate = new Date(sdArray[0],sdArray[1],sdArray[2]).getTime();
		var edArray = $("#edDate").val().split("-");
		params.endDate = new Date(edArray[0],edArray[1],edArray[2]).getTime();
		params.hotelName = $("#hotelName").val();
		params.roomNumber = $("#roomNum").val();
		params.roomType = $("#roomType").val();
		console.log(params);
		//check empty str
		if(params.province.trim()===""){
			alert("请选择省/市");
			return false;
		}
		if(params.area.trim()===""){
			alert("请选择区/县");
			return false;
		}
		if($("#stDate").val().trim()===""){
			alert("请选择入住日期");
			return false;
		}	
		if($("#edDate").val().trim()===""){
			alert("请选择离店日期");
			return false;
		}
		if(params.hotelName.trim()===""){
			alert("请输入需要预订的酒店名称");
			return false;
		}	
		$.ajax({
			type:"POST",
			url:"hotel/order/req",
			cache:false,
			data:JSON.stringify(params),
			dataType:"json",
			contentType:'application/json;charset=UTF-8'
		}).done(function(data,textStatus){
			if(data.error == 0){
				alert("申请订单提交成功");
			}
		}).fail(function(){
			alert("网络异常");
		});
	});
});