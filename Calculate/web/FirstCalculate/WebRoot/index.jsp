<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="UTF-8">
	<title>小学生四则运算</title>
	<link rel="stylesheet" type="text/css" href="css/oformm.css">
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/poiner.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.mengban{
			position: fixed;
			width: 100%;
			height: 100%;
			z-index: 100;
			background-color: rgba(39,40,34,0.7);
			display: none;
		}
		.aw{
			width: 300px;
			left: 50%;
			margin-left: -150px;
			margin-top: 30px;
			height: 100px;
            color: #4B92DB;
            line-height: 100px;
            text-align: center;
            font-size:20px;
		}
		
	</style>
  </head>
  
  <body>
     <div class="bbbb"></div>
    <div class="bacc"></div>
    <div class="mengban" id="mengban">
    	<div class="duzi aw">
    		文件上传中，请稍后...
    	</div>
    </div>
    <div class="head">
        <div class="searchh" id="cha">成绩汇总</div>
	    <div class="searchh" id="mia">智能出题</div>
        <div class="searchh" id="chu" >题目导入</div>
        <div class="chamian" id="chamian"> 
            <div class="kk" ><a href="AllServlet?flag=record&k=0">各用户全部成绩</a></div>
            <div class="kk" ><a href="AllServlet?flag=record&k=1">各用户最佳成绩</a></div>
         </div>
        <div class="logol"  id="logol">小学生四则运算系统</div>

	</div>



	<div class="duzi cp" id="miao" style="display: none;">
	   
	   <div class="otou" style="display:inline-block;width:200px；">题目导入</div>
	   <div style="display:inline-block;margin-left:20px;">本系统只支持ANSI格式txt文件</div>
	   <form action="AllServlet?flag=MakeAnswer"  enctype="multipart/form-data" method="post" id="wenjiantijiao">
	     <div>
          <div class="eoo" id="xuehao">学号：</div>
          <input type="text" class="hhh" name="xh" id="hhh">
         </div>
         <div>
	      <div  class="eoo vp" onclick="myfile.click();">选择文件</div>
	      <input type="text" id="input1" class="mmm">
	     </div>
	      <input type="file" id="myfile" name="file1" onchange="input1.value=this.value" style="display:none" >	      
	      <input type="submit" id="otou" value="确定提交" class="eo">
	   </form>
	</div>



	<div class="duzi" id="xinxi" style="display: block;margin-top: 40px;height: 300px;">
	   <div class="otou" >智能出题</div>
	     <div class="mmainduzi">
		      <form id="oBiaodan" action="AllServlet?flag=MakeQuestion"   method="post">
		      				
				<span>有无乘除</span>
				<select name="c">
					<option value="有">有</option>
					<option value="无" selected="">无</option>
				</select>
				<span >有无括号</span>
				<select name="b">
					<option value="有">有</option>
					<option value="无" selected="">无</option>	
				</select>
				<span>出题个数</span>
				<input type="text" name="n" class="oinput" id="numm">
				<span>符号上限</span>
				<input type="text" name="o" class="oinput" placeholder="MAX" id="nummMax" value="1">
				<span>数值范围</span>
				<input type="text" name="mmin" class="oinput" placeholder="MIN" id="minn">
				<span>----------</span>
				<input type="text" name="mmax" class="oinput"  placeholder="MAX" id="maxx">
				<input type="submit" value="确定" class="anan" id="yiding">
				<input type="reset" class="anan" >
			   </form>
		    </div>
	   
	</div>	 


<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/oformm.js"></script>

  </body>
</html>
