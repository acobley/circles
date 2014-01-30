<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>

<%
double PoundtoDollar =1.58;
double PoundtoEuro= 1.172;
double PoundtoRuble=47.377795;

%>

<table>
<% for (int Pound=10; Pound <=100; Pound=Pound+10){ %>
<tr>
<td><%=Pound %></td>
<td><%=Pound*PoundtoDollar %></td>
<td><%=Pound*PoundtoEuro %></td>
<td><%=Pound*PoundtoRuble %></td>
</tr>
<% } %>
</table>
</body>
</html>