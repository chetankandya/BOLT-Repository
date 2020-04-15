<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page errorPage = "errorpage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ page import="java.sql.*,java.io.*"%>
	
	<% 
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Newuser123");
			String data = request.getParameter("q"); 
			 String sql="SELECT accNo FROM AccountDetails  WHERE accNo="+data; 
			 /* String sql="SELECT custid,address FROM register  WHERE address like '"+data+"'"; */ 
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		%>	
		<table>
		
		<%	
				if(rs.next()) {
		%>
					<tr>
						<td> </td>
						<%-- <td> <%=rs.getInt(1)%> </td> 	<td> <%=rs.getString(2)%> </td> --%>
						<%  System.out.println("custid : "+rs.getInt(1)); %>
					</tr>
		<% }
			else {
		%>
				<td> Account Number Doesn't Exists.. </td>
				<td> Please Enter A Valid Account Number.. </td>
				
			<% } %>
			</table>		

</body>
</html>