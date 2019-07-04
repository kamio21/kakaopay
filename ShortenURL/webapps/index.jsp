<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>   
<%  
	String oriurl = (String)request.getAttribute("oriurl");
	String shorten_url = (String)request.getAttribute("resurl");

	if(oriurl == null) oriurl = "";
	if(shorten_url == null) shorten_url = "";
	//String strImagePath = getServletContext().getRealPath("").replace("\\", "/") ;//+ "/WEB-INF/images/kakao.jpg";
	String strImagePath =  request.getSession().getServletContext().getRealPath("/").replace("\\", "/")+"img/kakao.jpg";


%>

<style type = "text/css">
@import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);
body { 
    
    min-height: 100%;
    background-position: center;
    background-display:block ;
    background-size: cover;
    background-repeat: no-repeat;
    background-color : yellow;
}
</style> 
    
<!DOCTYPE html>
<html>
<head>
<script language ="javascript">
function shorten_click() {

	var origin_url = document.writeform.origin_url.value ;
	
	if(origin_url==""){
		
		alert("주소를 입력하세요.");
		return;
	}

	var form = document.writeform;
	form.action = "/getUrlServlet";
	//f.method = "get";
	form.submit();
	
}
function goWebsite() {
	
	var url= document.writeform.shorten_url.value;
	url = "http://" +  url;
	window.open(url,"popup","width=1000, height=700, location=yes");
	
}
</script>
</head>
<body>

<h1 align = "center" style="font-family:Nanum Gothic">단축URL 생성서비스</h1>
<form method="post" action="urlShorten/UrlShortenMakeServlet" name="writeform">
	<h1 align = "center" style="font-family:Nanum Gothic"> 원본URL 
	<input type ="text" name= "origin_url" value="<%= oriurl %>">
	<input type ="button" style="width:100; font-family:Nanum Gothic ; " value="shorten" onclick="shorten_click()" /></h1>
	
	<h1 align = "center" style="font-family:Nanum Gothic"> 단축URL <input type ="text" name= "shorten_url" value="<%= shorten_url %>">
	<input type ="button" style="width:100; font-family:Nanum Gothic" value="goWebsite" onclick="goWebsite()"/></h1>
	
</form>
</body>
</html>