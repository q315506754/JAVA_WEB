$(function(){
	function formatSelect2(e){
//		var d = $(e.element);
		return e.text;
	};
	
	$("#city").select2({
		placeholder:"请选择城市",
//		allowClear:true,
		formatSelection:formatSelect2
	});
	
	$("#area").select2({
		placeholder:"请选择区域",
//		allowClear:true,
		formatSelection:formatSelect2
	});
	
	$("#stDate").datepicker({
		dafaultDate:"+0d",
		changeMonth:true,
		changeYear:true,
		numberOfMonths:1,
		prevText: '<i class="fa fa-chevron-left"></i>',
		nextText: '<i class="fa fa-chevron-right"></i>',
	    onSelect: function (selectedDate) {
	        $('#edDate').datepicker('option', 'minDate', selectedDate);
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
});