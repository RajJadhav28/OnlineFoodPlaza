<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<%
String login=(String)request.getAttribute("login");
%>
</head>
<body>
<!--  Free CSS Template by TemplateMo.com  --> 
<div id="templatemo_container">
	<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
    <div id="templatemo_menu">
        <ul>
        	<li class="current"><a href="MyIndex.jsp"><b>Home</b></a></li>
            <li><a href="FoodServlet?process=allFood"><b>FoodMenus</b></a></li>
            <%if(login!=null && login.equals("admin")){ %>
            <li><a href="AddFood.jsp"><b>AddFood</b></a></li>
            <%} %>
            
            <%if(login!=null && login.equals("customer")){ %>
            <li><a href="CustomerServlet?process=updateProfile"><b>Profile</b></a></li>
            <li><a href="CartServlet?process=showMyCart"><b>My cart</b></a></li>
            <li ><a href="OrderServlet?process=myOrders"><b>My orders</b></a></li>
            <%} %>
            
            <% if(login==null){ %>
            <li ><a href="Login.jsp"><b>Login</b></a></li>
            <li ><a href="AddCustomer.jsp"><b>Register</b></a></li>
            <%} else if(login!=null){ %>
            
            <li ><a href="LoginServlet"><b>Logout</b></a></li>
            
            <%} %>
        </ul>
    </div> <!-- end of menu -->
</body>
</html>