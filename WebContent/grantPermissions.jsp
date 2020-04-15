<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
							<li><a href="AdminHome.jsp">My Profile</a></li>
							<li><a href="viewCustomer.jsp">View Customer Details</a></li>
							<li><a href="viewAllCustomer.jsp">View all Customer Details</a></li>
							<li><a href="addAdmin.jsp">Add new admin</a></li>
							<li><a href="grantPermissions.jsp">Grant Permissions</a></li>
							<li align="right"><a href="adminlogout.jsp" ><button onclick="alert('Logout Successfully.\nThank You For Your Trust...')">Logout</button></a></li>
						 
								
							
						</ul>
					</div>
				</div>
			</nav>
		</div>
		



<!-- User Home Section -->

		<div class="banner-main jarallax">
			<div class="container">
				<div class="banner-inner">
					<div class="col-md-5 banner-left">
						
						<div width="50%">		
							</div>
							<h3>In progress...</h3>
							
								
					</div>
			
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

<!-- //User Home Section -->


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
			
			
			jQuery(document).ready(function($){
    $cf = $('#phonenumber');
    $cf.blur(function(e){
        phone = $(this).val();
        phone = phone.replace(/[^0-9]/g,'');
        if (phone.length != 10)
        {
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