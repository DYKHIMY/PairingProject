<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>小学生四则运算</title>
<link rel="stylesheet" type="text/css" href="css/export.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/poiner.css">
<base href="<%=basePath%>">


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<!-- <body>
  <c:if test="${k=='0'}">
   <table>
   
   <c:set var="startIndex" value="${fn:length(studentInf)-1 }"></c:set>
     <c:forEach items="${studentInf}" var="t" varStatus="status">
    <tr>
       <td> 学号是：${studentInf[startIndex - status.index].studentId}</td>
       <td>做题正确率${studentInf[startIndex - status.index].perscore}%</td>
       <td>做题总时间${studentInf[startIndex - status.index].avgtime}</td>
       <td>提交做题记录时间：${studentInf[startIndex - status.index].zttime}</td>
    </tr>
    </c:forEach>  
    </table>
    </c:if>
    <c:if test="${k=='1'}">
 <table>
     <c:forEach items="${studentInf1}" var="t" >
    <tr>
       <td> 学号是：${t.studentId}</td>
       <td>做题正确率${t.perscore}%</td>
       <td>单位做题时间${t.avgtime}</td>
       <td>提交做题记录时间：${t.zttime}</td>
    </tr>
    </c:forEach>  
    </table>
    </c:if>
     -->

<body>
	<div class="bbbb"></div>
	<div class="bacc"></div>

	<div class="head">
		<div class="dayingg" id="back">
			<a href="#">返 回</a>
		</div>
		<div class="logol" id="logol" style="cursor: pointer;">小学生四则运算系统</div>
	</div>
	<div class="centerrr" style="z-index: 50;">
		<ul class="tou">
			<li>学&nbsp;&nbsp;&nbsp;&nbsp;号</li>
			<li>做题正确率</li>
			<li>做题总时间</li>

			<li style="width: 350px;">提交时间</li>
		</ul>
		<c:if test="${k=='0'}">
			<c:set var="startIndex" value="${fn:length(studentInf)-1 }"></c:set>
			<c:forEach items="${studentInf}" var="t" varStatus="status">
				<ul class="ti">
					<li>${studentInf[startIndex - status.index].studentId}</li>
					<li>${studentInf[startIndex - status.index].perscore}%</li>
					<li>${studentInf[startIndex - status.index].avgtime}</li>

					<li style="width: 350px;">${studentInf[startIndex - status.index].zttime}
					</li>
				</ul>
			</c:forEach>
		</c:if>
		<c:if test="${k=='1'}">

			<c:forEach items="${studentInf1}" var="t">
				<ul class="ti">
					<li>${t.studentId}</li>
					<li>${t.perscore}%</li>
					<li>${t.avgtime}</li>

					<li style="width: 350px;">${t.zttime}</li>
				</ul>
			</c:forEach>
		</c:if>
	</div>
</body>
</body>
</html>
