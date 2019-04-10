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
    
    <title>My JSP 'answer.jsp' starting page</title>
    <meta charset="UTF-8">
	<title>小学生四则运算</title>
	<link rel="stylesheet" type="text/css" href="css/oform.css">
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

  </head>
     
  <body>
        <div class="bbbb"></div>
    <div class="bacc"></div>
    <div class="head">	 
		<div class="logol"  id="logol">小学生四则运算系统</div>
		<div class="theTime" id="theTime">计时区</div>
	</div>
	<!-- <div class="allin"></div> -->
	 <div class="huizong" id="mainbody">
    	
    	<!-- 能拖动的标题 -->
    	<div class="miao" id="drag" > 
    	   答题情况  
        </div>
        <div class="mianban">
          <div class="lii">
        	<div class="tiao w">总题目数</div>
        	<div class="tiao a">:</div>
        	<div class="tiao emm"></div>
          </div>
          <div class="lii">
        	<div class="tiao w">答对题数</div>
        	<div class="tiao a">:</div>
        	<div class="tiao emm"></div>
          </div>
          <div class="lii">
        	<div class="tiao w">答错题数</div>
        	<div class="tiao a">:</div>
        	<div class="tiao emm"></div>
          </div>
          <div class="lii">
        	<div class="tiao w">总时间</div>
        	<div class="tiao a">:</div>
        	<div class="tiao emm"></div>
          </div>
          	 <form  onsubmit="return PostData()" id="form1" action="AllServlet?flag=score"   method="post">
                  <input name="questionNum" type="text" id="allnum" value="" style="display: none;">
                  <input name="correctNum" type="text" id="allyes" value="" style="display: none;">
                  <input name="time" type="text" id="alltime" value="" style="display: none;">

    	   	      
    	   	       <input type="submit" class="quedinng" value="确定">
    	   	   </form>	
        </div>
        
    </div>
    <div>      
    	<div class="duzi">
    	   <div class="timu">题 目</div>
    	   <div class="allTi">
    	   	 <c:forEach items="${questionList}" var="t" varStatus="loop">
    	   	  <div class="Ti">
    	   	  	 <div class="mu">${t}</div>
    	   	  	 <div class="mu a">=</div>
    	   	  	 <div class="mu b">
    	   	  	 	<input type="text" class="huida">
    	   	  	 </div>
    	   	  	  <div class="mu a yesno"></div>
    	   	  	 <div class="anwser c">
    	   	  	 	<div class="mu d">答案：</div>
    	   	  	 	<div class="mu b e">${answerList[loop.count-1]}</div>
    	   	  	 </div>
    	   	  </div>
    	   	  </c:forEach>


    	   </div>
    	    <div class="timu">
    	      
    	   	      <input type="button"  class="tiJiao" value="提交" id="tiJiao" >
    	   	  
    	   	    <iframe name="ajaxFrame" style="display: none;"></iframe>
    	   </div>
    		
    	</div>
    	
    </div>	


<script type="text/javascript" src="js/oform.js"></script>	
<script type="text/javascript" src="js/jquery.js"></script>	
  </body>
</html>
