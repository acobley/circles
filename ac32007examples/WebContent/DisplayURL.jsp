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


<ul>
<li><a href="/ac32007examples/TestURL/3456">/ac32007examples/TestURL/3456</a></li>
<li><a href="/ac32007examples/TestURL/34444444">/ac32007examples/TestURL/34444444</a></li>
<li><a href="/ac32007examples/TestURL/2222">/ac32007examples/TestURL/2222</a></li>
<li><a href="/ac32007examples/TestURL/1234567890">/ac32007examples/TestURL/1234567890</a></li>
</ul>

<form action="/ac32007examples/TestURL" method="POST">
<input name="url">
<input type="submit"  value="Go!">
</form>

<p>The URI is: 
<jsp:getProperty
	name="urlBean"
	property="url"/>
	</p>

</body>
</html>