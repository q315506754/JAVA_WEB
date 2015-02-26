$(function(){
	///loading
	$("#mod_loading").modal({
		backdrop:false,
        keyboard:false
	});
	$.ajax({
		type:"GET",
		url:"city/all",
		cache:false,
		dataType:"json",
		contentType:'application/json;charset=UTF-8'
	}).done(function(data,textStatus){
		if(data.error == 0){
			$("#mod_loading").hide();
			var html = "<option value=''>请选择省市</option>";
			for(var i=0;i<data.message.length;i++){
				var c = data.message[i];
				html += "<option value='"+c.id+"'>"+c.name+"</option>";
			}
			$("#cList").html(html);
		}
	}).fail(function(){
		$("#mod_loading").hide();
		alert("网络异常");
	});
	
	///plugin init
	function formatSelect2(e){
//		var d = $(e.element);
		return e.text;
	};
	
	$("#province").select2({
		placeholder:"请选择城市",
//		allowClear:true,
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
		params.startDate = $("#stDate").val();
		params.endDate = $("#edDate").val();
		params.hotelName = $("#hotelName").val();
		params.roomNumber = $("#roomNum").val();
		params.roomType = $("roomType").val();
		//check empty str
		if(params.province.trim()===""){
			alert("请选择省/市");
			return false;
		}
		if(params.area.trim()===""){
			alert("请选择区/县");
			return false;
		}
		if(params.startDate.trim()===""){
			alert("请选择入住日期");
			return false;
		}	
		if(params.endDate.trim()===""){
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
			console.log(data,textStatus);
			if(data.error == 0){
//				window.location.href = "index";
			}
		}).fail(function(){
			alert("网络异常");
		});
	});
});