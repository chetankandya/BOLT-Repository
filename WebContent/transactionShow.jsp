<%-- 		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage = "errorpage.jsp" %>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
		<head>
		<style type="text/css">
		table, th, td {
     		 border: 1px solid black;
						}
		
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<title>Insert title here</title>
		</head>
		<body>
		<h1>This is RegisterSuccess.jsp</h1>
		<div class="container">
		<div class="table-responsive">          
		  <table class="table">
		    <thead>
		    <table style="width:50%;">
		      
		   <tr style="height:100px">
		       <th>Customer Id</th>
		       <th>Name</th>
		       <th>Mobile Number</th>
		       <th>Gender</th>
		       <th>Aadhar Number</th>
		       <th>Email Id</th>
		        <th>Pan Number</th>
		         <th>Date Of Birth</th>
		          <th>Address</th>
		           <th>city</th>
		            <th>Pincode</th></tr>
		            </thead>
		                <tbody valign="bottom">
		   <tr style="height:100px">
		       <td>${ customer.custId }</td>
		       <td>${ customer.custName }</td>
		       <td>${ customer.mobileNo }</td>
		       <td>${ customer.gender }</td>
		       <td>${ customer.aadharNo }</td>
		       <td>${ customer.emailId }</td>
		        <td>${ customer.panNo }</td>
		         <td>${ customer.dateOfBirth }</td>
		          <td>${ customer.address }</td>
		           <td>${ customer.emailId }</td>
		            <td>${ customer.city }</td>
		             <td>${ customer.pincode }</td>
		      </tr>
		    </tbody>
		  </table>
		     </div>></div>
		
		</body>
		</html> --%>
		
		
		
		
		
		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<!-- Head -->
<head>
<title>BOLT | Home </title>
	<style type="text/css">
		table, th, td {
     		 border: 1px solid black;
						}
		
		</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<!--<meta name="keywords" content="Corporate Bank a Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />-->
<!-- .css files -->
	<link href="css/bars.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/font-awesome.css" />
<!-- //.css files -->

<!-- Default-JavaScript-File -->
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- //Default-JavaScript-File -->

<!-- fonts -->
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Ropa+Sans:400,400i&amp;subset=latin-ext" rel="stylesheet">
<!-- //fonts -->

<!-- scrolling script -->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- //scrolling script -->

</head>
<!-- //Head -->
<!-- Body -->
 <body>
	
	<!-- Top Bar Logo-->
		<div class="logo">
			<a href="#"><!--<i class="fa fa-inr" aria-hidden="true"></i>-->BOLT </a>
			<br>
			<center><span>Bank of Trust</span></center>
		</div>
	
		<!-- Top-Bar -->
		<div class="top-bar">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myNavbar">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse" id="myNavbar">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#index.html" class="scroll">home</a></li>
							<li><a href="#about" class="scroll">about</a></li>
							<li><a href="#services" class="scroll">services</a></li>
							<li><a href="#payment" class="scroll">payment</a></li>
							<li><a href="#contact" class="scroll">contact</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	
	
<!-- mid section -->
<section class="welcome">

<div class="container">
		<div class="table-responsive">          
		  <table class="table">
		    <thead>
		    <table style="width:50%;">
		      
		   <tr style="height:100px">
		       <th>Transaction Id</th>
		       <th>Customer Id</th>
		       <th>Beneficiary Name</th>
		       <th>Beneficiary Account Number</th>
		       <th>Transfer Amount</th>
		       <th>Transfer Date</th>
		        
		            </thead>
		                <tbody valign="bottom">
		   <tr style="height:100px">
		       <td>${ l.transId }</td>
		       <td>${ l.custId }</td>
		       <td>${ l.benName }</td>
		       <td>${ l.benAccNo }</td>
		       <td>${ l.amount }</td>
		       <td>${ l.transferDate }</td>
		      
		      </tr>
		    </tbody>
		  </table>
		     </div>></div>
</section>

<!-- footer -->
<section class="footer">
	<div class="container">
		<div class="footer-grids">
			<div class="col-md-4 footer-grid1">
				<div class="logo1">
					<a href="index.html">BOLT <span>Bank</span></a>
				</div>
				<p>Bank Of Larsen and Toubro welcomes you to explore the world of premier bank in India.</p>
				
			</div>
			
			<div class="col-md-3 footer-grid2">
				<h4>Address</h4>
				<p class="p1">BOLT Bank</p>
				<p> Plot No. EL-200,</p>
				<p>TTC Electronic Zone,</p>
				<p>Shil Phata - Mahape Road,</p>
				<p>Kopar Khairane,</p>
				<p>MIDC Industrial Area, Mahape,</p>
				<p>Navi Mumbai, </p>
				<p>Maharashtra 400710</p>
			</div>
			
			<div class="col-md-2 footer-grid3">
				<h4>menu</h4>
					<p><a href="#index.html" class="scroll">home</a></p>
					<p><a href="#about" class="scroll">about</a></p>
					<p><a href="#services" class="scroll">services</a></p>
					<p><a href="#payment" class="scroll">payment</a></p>
					<p><a href="#contact" class="scroll">contact</a></p>
			</div>
			
			<div class="col-md-3 footer-grid4">
				<h4>our Services</h4>
				<p><a>Funds transfer</a></p>
				<p><a>Mobile banking</a></p>
				<p><a>Deposits</a></p>
			 	<p><a>Internet online banking</a></p>
				<p><a>Balance enquiry</a></p>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</section>
<!-- //footer -->

<!-- copyright -->
<section class="copyright">
	<div class="agileits_copyright text-center">
			<p>© 2018 BOLT Bank. All rights reserved </p>
	</div>
</section>
<!-- //copyright -->

	<script src="js/jarallax.js"></script>
	<script src="js/SmoothScroll.min.js"></script>
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed: 0.5,
			imgWidth: 1366,
			imgHeight: 768
		})
	</script>

	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {

			$().UItoTop({ easingType: 'easeOutQuart' });
								
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