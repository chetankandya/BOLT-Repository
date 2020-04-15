<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--         <%@ page errorPage = "errorpage.jsp" %> --%>
<!DOCTYPE html>
<html lang="en">
<!-- Head -->
<head>
<title>BOLT | Home </title>
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
			<a href="login.jsp"><img src="images\logo.png" alt="BOLT" width="200px"><!--<i class="fa fa-inr" aria-hidden="true"></i>--> </a>
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
	
	
<!-- Login Section -->
		<div class="banner-main jarallax">
			<div class="container">
				<div class="banner-inner">
					<div class="col-md-5 banner-left">
								
						<form action="login.do" method="post">
						<h3>Login Here</h3>
							<input type="text" name="custId"  maxlength="9" placeholder="User Id" required=""/>
							<input type="password" name="password"  id="myInput" minlength="8" placeholder="Enter Your Password" required=""/>
						
							<!-- An element to toggle between password visibility -->
							<input type="checkbox" onclick="myFunction()"> Show Password
							
							<div class="submit">
								<input type="submit" value="LOGIN">
									<input type="reset" value="RESET">
								</div>
						</form>
						<br>
						<h4><a href = "forgotpassword.jsp">Forgot Password</a> | <a href = "Register.jsp">Register</a></h4>
					</div>
					
					<div class="col-md-7 banner-right">
						<h1>Bank Of Larsen and Toubro</h1>
						<h4>BOLT welcomes you to explore the world of premier Bank in India.</h4>
				
							<div class="banner-right-text">
								<div class="main-icon">
									<i class="fa fa-share" aria-hidden="true"></i>
								</div>
								<p>Wherever you are in life, our simple, flexible banking products and service will help you make the most of every opportunity and experience. </p>
					
							<div class="clearfix"></div>
							</div>
							<div class="banner-right-text">
								<div class="main-icon">
									<i class="fa fa-share" aria-hidden="true"></i>
								</div>
							<p>With a global network, deep expertise and innovative vision, we meet all your banking needs and more.</p>
				
							<div class="clearfix"></div>
							</div>
							<div class="banner-right-text">
								<div class="main-icon">
									<i class="fa fa-share" aria-hidden="true"></i>
								</div>
									<p>We  support sustainable economic and social development. </p>
												
										<div class="clearfix"></div>
							</div>
					</div>
					
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
<!-- //Login Section -->
	
		
<!-- about -->
<section class="about" id="about">
	<div class="container">
	<div class="about-heading">
		<h2>About</h2>
	</div>
		<div class="about-grids">
		<div class="col-md-6 about-left">
			<img src="images/1.jpg" alt="" />
		</div>
		<div class="col-md-6 about-right">
			<h3>A leading  bank focused on helping people and companies prosper across India.</h3><br>
			<h3>We offer banking services that help people and companies to succeed, creating wealth and growth across our markets. .</h3><br>
			<h3>Our heritage and values are expressed in our brand promise - Here for good.</h3><br>
				</div>
		<div class="clearfix"></div>
		</div>
		</div>
</section>
<!-- //about -->

<!-- services -->
<section class="services" id="services">
	<div class="container">
		<div class="services-heading">
			<h3>services</h3>
		</div>
		<div class="service-grids">
			<div class="service-grid-top">
				<div class="col-md-4 service-grid-1">
					<div class="service-grid-text">
						<div class="icon">
							<i class="fa fa-rupee" aria-hidden="true"></i>
						</div>
						<h4>eStatement</h4>
						<p>Help save the planet by registering to receive an eStatement each month.</p>
					</div>
				</div>
				<div class="col-md-4 service-grid-1">
					<div class="service-grid-text">
						<div class="icon">
							<i class="fa fa-university" aria-hidden="true"></i>
						</div>
						<h4>Online Banking</h4>
						<p>Get complete control of your accounts and manage your finances anytime, anywhere. </p>
					</div>
				</div>
				<div class="col-md-4 service-grid-1">
					<div class="service-grid-text">
						<div class="icon">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</div>
						<h4>Bank with confidence</h4>
						<p>Safe and secure, the BOLT platform allows you to bank online without hesitating. </p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="service-grid-bottom">
				<div class="col-md-4 service-grid-1">
					<div class="service-grid-text">
						<div class="icon">
							<i class="fa fa-handshake-o" aria-hidden="true"></i></div>
						<h4>Payment Gateway</h4>
						<p>Our Payment Gateway enables you to pay for goods and services online at over 5,000 merchants.</p>
					</div>
				</div>
				<div class="col-md-4 service-grid-1">
					<div class="service-grid-text">
						<div class="icon">
							<i class="fa fa-briefcase" aria-hidden="true"></i>
						</div>
						<h4>Loans</h4>
						<p>We provide personal loans, home equity loans, home equity lines of credit, home loans and business loans.</p>
					</div>
				</div>
				<div class="col-md-4 service-grid-1">
					<div class="service-grid-text">
						<div class="icon">
							<i class="fa fa-credit-card" aria-hidden="true"></i>
						</div>
						<h4>Fund Transfer</h4>
						<p>Transfer your funds in a hassle free manner from one account to another account in a secure and reliable manner.</p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</section>
<!-- //services -->




<!-- payment -->
<section class="payment jarallax" id="payment">
	<div class="container">
		<div class="payments-heading">
			<h3>Our Payments</h3>
		</div>
		<div class="payment-grids">
		<div class="col-md-3 payment-grid">
			<i class="fa fa-cc-visa" aria-hidden="true"></i>
			<h5>visa card</h5>
		</div>
		<div class="col-md-3 payment-grid">
			<i class="fa credit fa-credit-card-alt" aria-hidden="true"></i>
			<h5>credit card</h5>
		</div>
		<div class="col-md-3 payment-grid">
			<i class="fa fa-cc-mastercard" aria-hidden="true"></i>
			<h5>master card</h5>
		</div>
		<div class="col-md-3 payment-grid">
			<i class="fa fa-credit-card-alt" aria-hidden="true"></i>
			<h5>debit card</h5>
		</div>
		<div class="clearfix"></div>
		</div>
	</div>
</section>
<!-- //payment -->



<!-- modal -->
	<div class="modal about-modal fade" id="myModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header"> 
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span class="span1"aria-hidden="true">&times;</span></button>						
						<h4 class="modal-title"> Corporate<span> Bank</span></h4>
					</div> 
					<div class="modal-body">
					<div class="agileits-w3layouts-info">
						<img src="images/business.jpg" alt="" />
						<p>Duis venenatis, turpis eu bibendum porttitor, sapien quam ultricies tellus, ac rhoncus risus odio eget nunc. Pellentesque ac fermentum diam. Integer eu facilisis nunc, a iaculis felis. Pellentesque pellentesque tempor enim, in dapibus turpis porttitor quis. Suspendisse ultrices hendrerit massa. Nam id metus id tellus ultrices ullamcorper.  Cras tempor massa luctus, varius lacus sit amet, blandit lorem. Duis auctor in tortor sed tristique. Proin sed finibus sem.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- //modal -->
	
<!-- contact -->
<section class="contact" id="contact">
	<div class="container">
		<div class="contact-heading">
			<h3>Contact us</h3>
		</div>
		<div class="contact-grids">
			<div class=" col-md-6 contact-form">
				<form action="#" method="post">
						<input type="text" placeholder="Subject" required=""/>
						<input type="text" placeholder="Your name" required=""/>
						<input type="email" placeholder="Your mail" required=""/>
						<textarea placeholder="Message" required=""></textarea>
						<div class="submit1">
							<input type="submit" value="submit">
						</div>
				</form>
			</div>
			<div class=" col-md-6 map">
				<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d60319.33528607023!2d73.06424131924618!3d19.109478400000008!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sin!4v1531480805564"></iframe>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</section>
<!-- //contact -->

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
			<p> © 2018 BOLT Bank. All rights reserved </p>
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
	</script>
	<!-- //here ends scrolling icon -->
	<script src="js/bars.js"></script>
	
	<script>
function myFunction() {
    var x = document.getElementById("myInput");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
</script>

	
	
</body>
</html>