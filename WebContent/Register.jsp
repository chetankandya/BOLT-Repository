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

<script>
function showCustomer(str) {
  var xhttp;    
  if (str == "") {
    document.getElementById("txtHint").innerHTML = "";
    return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("txtHint").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "getcustomer.jsp?q="+str, true);
  xhttp.send();
}
</script>

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
							<li><a href="login.jsp">home</a></li>
							<li><a href="login.jsp#about">about</a></li>
							<li><a href="login.jsp#services">services</a></li>
							<li><a href="login.jsp#payment">payment</a></li>
							<li><a href="login.jsp#contact">contact</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		



<!-- Registration Section -->

		<div class="banner-main jarallax">
			<div class="container">
				<div class="banner-inner">
					<div class="col-md-5 banner-left">
								
						<form name="myForm" action="register.do" onsubmit="return validateForm();" method="post">
						<h3>Open ASAP Account</h3>
							<div id="txtHint">Register info will be listed here...</div>
						    <input type="text" name="custId" placeholder="User Id" maxlength="9" autofocus required="" oninput="showCustomer(this.value)"/>
							<input type="text" name="custName" placeholder="Customer Name"  required=""/>
							<input type="text" name="mobileNo" id="phonenumber" placeholder="Mobile Number" maxlength="10" required=""/>
							Gender<input type="radio" name="gender" value="male" checked> Male <input type="radio" name="gender" value="female"> Female
 							<input type="radio" name="gender" value="other"> Other  
							<input type="text"  name="emailId" placeholder="Email" required=""/>
							<input type="password"  name="password" id="myInput" minlength="8" placeholder="Password"  required=""/>
							<!-- An element to toggle between password visibility -->
							<input type="checkbox" onclick="myFunction()"> Show Password
							<input type="date"  name="dateOfBirth" placeholder="DOB" min="1947-08-15"  max="2018-07-20" required=""/>
							<input type="text" name="address" placeholder="Address" required=""/>
							<input type="text" name="city" placeholder="City" required=""/>
							<input type="text" name="country" placeholder="Country" required=""/>
							<input type="text" name="pincode"  minlength="6" maxlength="6" placeholder="PinCode" required=""/>
							<input type="text"  name="aadharNo" id="aadharnumber" maxlength="12" placeholder="Aadhar Card" required=""/>
							<input type="text" name="panNo"  minlength="10" maxlength="10" placeholder="Pan Card"  required=""/>
 							<label>
      				  			<input type="checkbox"  name="remember" style="margin-bottom:15px" required> By creating an account you agree to our <a href="Terms and Conditions.pdf" target="_blank" style="color:white">Terms & Privacy</a>.
      						</label>
 							


							<div class="submit">
									<input type="submit" value="REGISTER" >
									<input type="reset" value="RESET">
								</div>
						</form>
					
						<br>
						 <h4><a href = "login.jsp">Login</a></h4>
					</div>
			
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

<!-- //Registration Section -->
	
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
			
			
			jQuery(document).ready(function($){
    $cf = $('#phonenumber');
    $cf.blur(function(e){
        phone = $(this).val();
        phone = phone.replace(/[^0-9]/g,'');
        if (phone.length != 10)
        {
            alert('Phone number must be 10 digits and in Number Format.');
            $('#phonenumber').val('');
         
        }
    });
});
	</script>
	
		<script type="text/javascript">
		$(document).ready(function() {

			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
			
			
			jQuery(document).ready(function($){
    $cf = $('#aadharnumber');
    $cf.blur(function(e){
        phone = $(this).val();
        phone = phone.replace(/[^0-9]/g,'');
        if (phone.length != 12)
        {
            alert('Aadhar number must be 12 digits and in Number Format.');
            $('#aadharnumber').val('');
         
        }
    });
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
<script>
function validateForm() {
    var x = document.forms["myForm"]["emailId"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    }
}



</script>
</body>
</html>
