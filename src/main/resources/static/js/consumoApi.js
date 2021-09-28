$(function(){
	var url = "http://api.worldbank.org/v2/country?format=json";
	$.get(url,function(data){
		$.each(data[1],function(i,e){
			$(".paises").append($("<li>").text(data[1][i].name).attr("name",data[1][i].name));
		});
		carga();
	});
});

$(function(){
	var url = "https://www.boredapi.com/api/activity";
	for(var i = 0; i < 6; i++){
		if(i < 3){
			$.get(url,function(data){
			$(".taskes").append($("<small>").text(data.activity));
			$(".taskes").append($("<br>"));
		});
		} else {
			$.get(url,function(data){
			$(".taskes1").append($("<small>").text(data.activity));
			$(".taskes1").append($("<br>"));
		});
		}
	}	
});

var carga = (function(){
	$(".paises li").bind("click",function(){
		$(".grados").text("Cargando ...");
		var pais = $(this).attr("name");
		$(".pais").text(pais);
		var url = "http://api.weatherapi.com/v1/current.json?key=6add9a596cc5404b86513809212709&q="+pais+"&aqi=no";
		$.get(url,function(data){
			$(".grados").text(data.current.temp_c+"°");
			$(".imgclima").attr("src",data.current.condition.icon);
			$(".imgclima").attr("alt",data.current.condition.text);
			$(".tz").text(data.location.tz_id);
			$(".hora").text(data.location.localtime.split(" ")[1]);
		});
	});
});