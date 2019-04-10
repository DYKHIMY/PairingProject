// setInterval计时器
       var theTime=document.getElementById('theTime');
       var n=0;
       var m=0;
       var f=0;
       var ff=0;
       var timert=null;
       function timeCount(){
        clearInterval(timert);
        timert=setInterval(
          function(){
             n=n+1;
             f=n/60;
             ff=parseInt(f) 
             m=n%60;
             theTime.innerHTML=ff+"  分  "+m+"  秒";
          },1000);
       }
       timeCount();
       // function stopCount(){
       //  clearInterval(timert);
       // }


var tiJiao=document.getElementById('tiJiao');
var oBody=document.getElementById('mainbody');
var huida=document.getElementsByClassName('huida');
var daan=document.getElementsByClassName('e');
var anwser=document.getElementsByClassName('anwser');
var yesno=document.getElementsByClassName('yesno');
var emm=document.getElementsByClassName('emm');
var allnum=document.getElementById('allnum');
var alltime=document.getElementById('alltime');
var allyes=document.getElementById('allyes');
// var yes=0;
// var no=0;

tiJiao.onclick=function(){
    var yes=0;
    var no=0;
//判断回答是否正确
   for(var i=0;i<huida.length;i++){
         anwser[i].style.display="inline-block";
      if(huida[i].value==daan[i].innerHTML){
         yesno[i].innerHTML="√";
         yesno[i].style.color="#1DF126";
         yes++;
      }else{
         yesno[i].innerHTML="×";
          yesno[i].style.color="red";
          no++;
      }
   }
   clearInterval(timert);
  
   oBody.style.display="block";
   tiJiao.style.display="none";
   allnum.value=daan.length;
   allyes.value=yes;
   
   emm[0].innerHTML=daan.length;
   emm[1].innerHTML=yes;
   emm[2].innerHTML=no;
   if(theTime.innerHTML=="计时区"){
   emm[3].innerHTML="您没有计时";
   alltime.value=0; 
   }else{
       emm[3].innerHTML=theTime.innerHTML; 
       alltime.value=theTime.innerHTML; 
   }

}



//面板拖动
var drag=document.getElementById('drag');
    drag.onmousedown=function(){
         startMove();
    }
    var oCha=document.getElementById('QQcha');
    oCha.onclick=function(){
        var oBody=document.getElementById('mainbody');
        var oCha=document.getElementById('QQcha');
        oBody.style.display="none";
    }

function startMove(event){
        event=event || window.event;
        var oBody=document.getElementById('mainbody');
        var disX=event.clientX-oBody.offsetLeft;
        var disY=event.clientY-oBody.offsetTop;
        document.onmousemove=function(event){
            event=event ||window.event;
            okMove(event,disX,disY);
          event.preventDefault();
        }
        document.onmouseup=function(){
    document.onmousemove=null;
    document.onmouseup=null;
  }
}
function okMove(e,posX,posY){
    var oBody=document.getElementById('mainbody');
    var l=e.clientX-posX;
    var t=e.clientY-posY;
    var winW=document.documentElement.clientWidth || document.body.clientWidth;
    var winH=document.documentElement.clientHeight || document.body.clientHeight;
    var maxW=winW-oBody.offsetWidth-10;
    var maxH=winH-oBody.offsetHeight;
     
  if(l<0){
    l=0;
  }else if(l>maxW){
    l=maxW;
  }
  if(t<0){
    t=10;
  }else if(t>maxH){
    t=maxH;
  }
    oBody.style.left=l+'px';
    oBody.style.top=t+'px';
}

//向后台传输数据
// function login(){
//         $.ajax({
//             type: "POST",
//             url: "",//传输的地址
//             data : $('#form1').serialize(),
//             success: function (result) {
//                     console.log(result);//打印服务端返回的数据(调试用)
//                     if (result.resultCode == 200) {
//                         alert("SUCCESS");
//                     }
//                     ;
//                 },
//                 error : function() {
//                     alert("异常！");
//                 }
//         });
        
//     }

