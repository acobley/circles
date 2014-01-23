<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean
	id="urlBean"
	scope="request"
	class="uk.ac.dundee.computing.aec.stores.URLStorage" />

<p>The Count is: 
<jsp:getProperty
	name="urlBean"
	property="url"/>
	</p>

</body>
</html>