<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
String errmsg=(String)request.getAttribute("errmsg");
%>
<%
if(msg!=null){%>
<h3><%=msg %></h3>

<%}else if(errmsg!=null){%>

<h3><%=errmsg %></h3>
<%} %>
</body>
</html>