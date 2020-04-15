<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page errorPage = "errorpage.jsp" %>
<!DOCTYPE html>
<html lang="en">
<!-- Head -->
<head>
<title>BOLT | REGISTER</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<!--<meta name="keywords" content="Corporate Bank a Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />-->
<!-- .css files -->
	<link href="css/bars.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/stylereg.css" type="text/css" media="all" />
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
		<a href="#"><img src="images\logo.png" alt="BOLT" width="200px"><!--<i class="fa fa-inr" aria-hidden="true"></i>--> </a>
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
		


		<div class="banner-main jarallax">
			<div class="container">
				<div class="banner-inner">
					<div class="col-md-5 banner-left">


<form action="reset.do" method="post">
						<h3>Verify your Account</h3>
						  <label>Enter your  UserId</label>					
							<input type="text" name="custId" placeholder="User ID" required=""/>
							<label>Enter new password</label>
							<input type="password"  name="password" minlength="8" placeholder="new password" required=""/>
							<label>confirm new password</label>
							
							<input type="password"  name="password1" placeholder="confirm password" required=""/>
						
							<div class="submit">
									<input type="submit" value="Confirm">
										<input type="reset" value="Reset">
								</div>
						</form>
						
						</div>
			
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

<!-- <form action="controller/login/reset" method="post">

Enter New password: <input type="password" name="password">
Confirm password:<input type="password" name="password1">
 <input type="hidden" id="custId" name="custId" value="chetan12">
<input type="submit"></form> -->
</body>
</html>
