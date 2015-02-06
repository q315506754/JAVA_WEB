$(function(){
	$("#btnLogin").unbind("click").click(function(e){
		var params = {};
		params.userName = $("#name").val().trim();
		params.passWord = $("#password").val().trim();
		$.ajax({
			type:"POST",
			url:"user/login",
			cache:false,
			data:JSON.stringify(params),
			dataType:"json",
			contentType:'application/json;charset=UTF-8'
		}).done(function(data,textStatus){
			
		}).fail(function(){
			alert("网络异常");
		});
		
	});
});