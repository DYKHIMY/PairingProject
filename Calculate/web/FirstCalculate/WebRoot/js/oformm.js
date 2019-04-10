
$("#mia").click(function(){
	$("#xinxi").css("display","block");	
	$("#miao").css("display","none");
});
$("#chu").click(function(){
	$("#xinxi").css("display","none");
	
	$("#miao").css("display","block");
});
var wenjiantijiao=document.getElementById('wenjiantijiao');
var hhh=document.getElementById('hhh');

$("#otou").click(function(){
		
		if(hhh.value==""){
			alert("请输入正确学号");
			wenjiantijiao.onsubmit=function(){return false;} 
		}else{
			wenjiantijiao.onsubmit=function(){return true;} 
			$("#mengban").css("display","block");
		}
	});
$("#cha").click(function(e){
	$("#chamian").css("display","block");
	 e.stopPropagation();
})
$("#chamian").click(function(e){
	$("#chamian").css("display","block");
	 e.stopPropagation();
})
$(document).click(function(e){
    $("#chamian").css("display","none");  
});

var oBiaodan=document.getElementById('oBiaodan');
$("#yiding").click(function(){
	var nummMax=document.getElementById('nummMax');
	var numm=document.getElementById('numm');
	var minn=document.getElementById('minn');
	var maxx=document.getElementById('maxx');
	if(numm.value==""){
		alert("请输入正确的题目个数，范围是1-10000");
		oBiaodan.onsubmit=function(){return false;} 
	}if(nummMax==""||nummMax<1||nummMax>10){
		alert("请输入正确符号范围，0-10");
		oBiaodan.onsubmit=function(){return false;} 
	}

	
	if(numm.value<1||numm.value>10000){
		alert("题目数量超出范围，范围为1-10000");
		oBiaodan.onsubmit=function(){return false;} 
	}
	if(minn.value==""||minn.value<1||minn.value>50){
		alert("请填写正确范围！！！下线范围1-100，上限范围50到1000 ");
		oBiaodan.onsubmit=function(){return false;} 
	}
	if(maxx.value==""||maxx.value<50||maxx.value>1000){
		alert("请填写正确范围！！！下线范围1-100，上限范围50到1000 ");
		oBiaodan.onsubmit=function(){return false;} 
	}else{
		oBiaodan.onsubmit=function(){return true;} 
	}

});