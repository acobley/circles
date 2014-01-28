<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://yui.yahooapis.com/2.7.0/build/reset-fonts-grids/reset-fonts-grids.css" type="text/css"> 
  
<link rel="stylesheet" href="css/PHPDemos.css" type="text/css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource scope="session"
	driver="org.gjt.mm.mysql.Driver"
	url="jdbc:mysql://arlia.computing.dundee.ac.uk/totpdb"
	user="totpdbuser"
	password="totpdbpassword" 
	/>
	
	<c:set var="SearchTerm" value="${param.SearchTerm}"/>
	
	<sql:query var="Artists" scope="session">
		SELECT track_name, artist_name FROM episode_slots where artist_name like ?
		 <sql:param value="%${SearchTerm}%" />
	</sql:query>

<div id="doc" class="yui-t1"> 
	   <div id="hd" ><h1>Search results from the Top of the Pops database</h1>
	   </div> 
	   <div id="bd" > 
	    <div id="yui-main"> 
	    <div class="yui-b"><div class="yui-g"> 
<!-- Main Content Here -->

<p class="whitetext">Your Seach term is:<br>
<c:out value="${SearchTerm}" />
</p>

<table>
      <c:forEach items="${Artists.rows}" var="row">
			  <tr>
        <c:forEach items="${row}" var="column">
         
            <td class="whitetext">
              ${fn:escapeXml(column.value)}
            </td>
          
        </c:forEach>
				</tr>
      </c:forEach>
    </table>
</div> 
	</div> 
	    </div> 
			
			
	    <div class="yui-b"> <p class="whitetext">
	    The Search results on the right
	    </p>
	    </div> 
	     
	    </div> 
	   <div id="ft" ></div> 
	     <p>
    <a href="http://validator.w3.org/check?uri=referer"><img
        src="http://www.w3.org/Icons/valid-html401-blue"
        alt="Valid HTML 4.01 Transitional" height="31" width="88"></a>
  </p>

	</div> 
</body>
</html>