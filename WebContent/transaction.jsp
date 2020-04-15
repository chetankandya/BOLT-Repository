<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page errorPage = "errorpage.jsp" %>s
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="transaction.do" method="post">
                             <input type="text" name="custId" placeholder="User Id"/>
							<input type="text" name="transferDate" placeholder="TransferDate"/>
							<input type="number" name="amount"  placeholder="Amount" /> 
							<input type="text"  name="benAccNo" placeholder="Benefeciary Account No" />
							<input type="text"  name="benName" placeholder="Beneficiary Name" />
							<div class="submit"></div>
						<input type="submit" value="submit">
								
</form>
</body>
</html>