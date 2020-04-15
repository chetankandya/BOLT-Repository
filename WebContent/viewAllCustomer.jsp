<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page errorPage = "errorpage.jsp" %>
<!DOCTYPE html>
<html lang="en">
<!-- Head -->
<head>
<title>BOLT | ADMIN HOME</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<!--<meta name="keywords" content="Corporate Bank a Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />-->
<!-- .css files -->
<link href="css/bars.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"
	media="all" />
<link rel="stylesheet" href="css/stylereg.css" type="text/css"
	media="all" />
<link rel="stylesheet" href="css/font-awesome.css" />
<!-- //.css files -->

<!-- Default-JavaScript-File -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- //Default-JavaScript-File -->

<!-- fonts -->
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Ropa+Sans:400,400i&amp;subset=latin-ext"
	rel="stylesheet">
<!-- //fonts -->

<!-- scrolling script -->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- //scrolling script -->

<style>


#trans {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#trans td, #trans th {
	border: 1px solid #ddd;
	padding: 8px;
}

#trans tr:nth-child(even) {
	background-color: #f2f2f2;
}

#trans tr:hover {
	background-color: #ddd;
}

#trans th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: grey;
	color: white;
}
</style>

<style type="text/css">
@media print {
	* {
		display: none;
	}
	#printableTable {
		display: block;
	}
}
</style>

<script>
	function printDiv() {
		window.frames["print_frame"].document.body.innerHTML = document
				.getElementById("printableTable").innerHTML;
		window.frames["print_frame"].window.focus();
		window.frames["print_frame"].window.print();
	}
</script>




</head>
<!-- //Head -->
<!-- Body -->
<body>

	<!-- Top Bar Logo-->
	<div class="logo">
		<a href="#"><img src="images\logo.png" alt="BOLT" width="200px">
			<!--<i class="fa fa-inr" aria-hidden="true"></i>--> </a> <br>
		<center>
			<span>Bank of Trust</span>
		</center>
	</div>

	<!-- Top-Bar -->
	<div class="top-bar">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#myNavbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="AdminHome.jsp">My Profile</a></li>
						<li><a href="viewCustomer.jsp">View Customer Details</a></li>
						<li><a href="viewAllCustomer.jsp">View all Customer
								Details</a></li>
						<li><a href="addAdmin.jsp">Add new admin</a></li>
					    <li><a href="grantPermissions.jsp">Grant Permissions</a></li>
			<li align="right"><a href="adminlogout.jsp" ><button onclick="alert('Logout Successfully.\nThank You For Your Trust...')">Logout</button></a></li>
											
					</ul>
				</div>
			</div>
		</nav>
	</div>



	<div class="banner-main jarallax">
		<div class="container">
		
				<div class="col-md-5 banner-left" width="100%">

					<form action="viewAll.do" method="post">

						<div id="printableTable" style="overflow-x:auto;">
							<h3>All Customers</h3>

							<div class="submit">
								<input type="submit" value="Show All Customers"> <br>
							</div>
							<br>

							<table id="trans">
								<tr>
									<th>Customer Id</th>
									<th>Name</th>
									<th>Address</th>
									<th>City</th>
									<th>Country</th>
									<th>Pincode</th>
									<th>Date Of Birth</th>
									<th>Gender</th>
									<th>Mobile Number</th>
									<th>Email Id</th>
									<th>Aadhar Number</th>
									<th>Pan Number</th>
									<th>Account No.</th>
									<th>Account Type</th>
									<th>Balance</th>
									<th>Branch</th>
									<th>Date of Opening</th>

								</tr>




								<c:if test="${not empty view}">
									<c:forEach var="listValue" items="${view}">

										<tr>
											<td>${listValue.getCustId()}</td>
											<td>${listValue.getCustName()}</td>
											<td>${listValue.getAddress()}</td>
											<td>${listValue.getCity()}</td>
											<td>${listValue.getCountry()}</td>
											<td>${listValue.getPincode()}</td>
											<td>${listValue.getDateOfBirth()}</td>
											<td>${listValue.getGender()}</td>
											<td>${listValue.getMobileNo()}</td>
											<td>${listValue.getEmailId()}</td>
											<td>${listValue.getAadharNo()}</td>
											<td>${listValue.getPanNo()}</td>
											<td>${listValue.getAccountDetails().getAccNo()}</td>
											<td>${listValue.getAccountDetails().getAcctype()}</td>
											<td>${listValue.getAccountDetails().getBalance()}</td>
											<td>${listValue.getAccountDetails().getBranch()}</td>
											<td>${listValue.getAccountDetails().getDateOfOpening()}</td>

										</tr>

									</c:forEach>
								</c:if>


							</table>
						</div>
						<br>
					
				</div>
				
				<div class="clearfix"></div>
		
			<div class="clearfix"></div>
		</div>
	</div>



	<%-- 

	<div id="printableTable">

		<form action="viewAll.do" method="post">
			<br> <br>
			<h3>View All Customer Details</h3>
			<br>

			<div class="submit">
				<input type="submit" value="Show All Customers"> <br> <br>
			</div>
			<div class="container">
				<div class="table-responsive">
				<table id="trans">

						<tr>
							<td>Customer Id</td>
							<td>Name</td>
							<td>Address</td>
							<td>city</td>
							<td>country</td>
							<td>Pincode</td>
							<td>Date Of Birth</td>
							<td>Gender</td>
							<td>Mobile Number</td>
							<td>Email Id</td>
							<td>Aadhar Number</td>
							<td>Pan Number</td>
						</tr>



						<c:if test="${not empty view}">

							<ul>
								<c:forEach var="listValue" items="${view}">

									<li>${listValue.getCustId()}</li>
									<li>${listValue.getCustName()}</li>
									<li>${listValue.getAddress()}</li>
									<li>${listValue.getCity()}</li>
									<li>${listValue.getCountry()}</li>
									<li>${listValue.getPincode()}</li>
									<li>${listValue.getDateOfBirth()}</li>
									<li>${listValue.getGender()}</li>
									<li>${listValue.getMobileNo()}</li>
									<li>${listValue.getAadharNo()}</li>
									<li>${listValue.getPanNo()}</li>
									<li>${listValue.getAccountDetails().getAccNo()}</li>
									<li>${listValue.getAccountDetails().getAcctype()}</li>
									<li>${listValue.getAccountDetails().getBalance()}</li>
									<li>${listValue.getAccountDetails().getBranch()}</li>
									<li>${listValue.getAccountDetails().getDateOfOpening()}</li>


								</c:forEach>
							</ul>
						</c:if>

					</table>
				</div>
			</div>

		</form>

 --%>
	<section class="copyright">
		<div class="agileits_copyright text-center">
			<p>© 2018 BOLT Bank. All rights reserved</p>
		</div>
	</section>
	<!-- //copyright -->

	<script src="js/jarallax.js"></script>
	<script src="js/SmoothScroll.min.js"></script>
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed : 0.5,
			imgWidth : 1366,
			imgHeight : 768
		})
	</script>

	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>

	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});

		jQuery(document).ready(function($) {
			$cf = $('#phonenumber');
			$cf.blur(function(e) {
				phone = $(this).val();
				phone = phone.replace(/[^0-9]/g, '');
				if (phone.length != 10) {
					alert('Phone number must be 10 digits.');
					$('#phonenumber').val('');

				}
			});
		});
		
		history.pushState(null, null, location.href);
	    window.onpopstate = function () {
	        history.go(1);
	    };
	    
	</script>
	<!-- //here ends scrolling icon -->
	<script src="js/bars.js"></script>
</body>
</html>