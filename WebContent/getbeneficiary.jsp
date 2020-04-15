<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			 System.out.println("q ==> "+data);
			 String sql="SELECT benName,benIfsc FROM beneficiarydetails WHERE benAccNo="+data;
			 System.out.println("query "+sql);
			   
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			  System.out.println("rs : "+rs);
			
		%>	
		
		
		<%	
				if(rs.next()) {
		
							
						  System.out.println("custid : "+rs.getString(1)); 
						  System.out.println("custid : "+rs.getString(2)); 
						
						String str1 = rs.getString(1);
						String str2 = rs.getString(2);
						
		%>										
						<label>Enter beneficiary Name</label>
							<input type="text" name="benName" value="<%=str1%>"	/>
							 <label>IFSC Code</label>
						<input type="text" name="ifscCode"  value="<%=str2%>" />
						
				
				
					
		<% } 	else
		{
			  System.out.println("ben not found");
			  %>
			  
				<label>Beneficiary not found </label>
				<label>Please Add Beneficiary First </label>
				<br>
				<a href="addbeneficiary.jsp"  style="color:white;">Add Beneficiary</a>
		<% } %>
		
				
				
			
					

</body>
</html>
