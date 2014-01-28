<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="java.util.*,java.sql.*"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Simple Database Access</title>
</head>
<body>
<%
try{
     Class.forName("org.gjt.mm.mysql.Driver");
}catch(Exception E){
     System.out.println("First: " + E);
		 %><p>Can not get Class <%=E%><%
}
try {
Connection MyConnection= DriverManager.getConnection("jdbc:mysql://localhost/Faultdb","root","Cl1m8t3;");

Statement st    = null;
ResultSet rs;
 st = MyConnection.createStatement();
 rs = st.executeQuery("Select * from Faults");
%><table><%
 while (rs.next() ){
	 %><tr><td><%=rs.getString("summary")%></td> 
	 <td><%=rs.getString("detail")%></td> 
	 <td><%=rs.getInt("sectionid")%></td> 

     </tr> 	
 		<% 
 }
 rs.close();
 MyConnection.close();
 %>
 </table><% 
 }catch(Exception E){
     System.out.println("Second: " + E);
		 %><p>Can not execute query <%=E%><%
}
%> 

</body>
</html>