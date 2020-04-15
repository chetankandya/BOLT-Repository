<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<!-- <script>
$("#search").click(function() {
var benAccNo= $('#benAccNo').val();
benName.value = benName;
benPhone.value = benPhone;
benBank.value = benBank;
benIfsc.value = benIfsc;
benDesc.value = benDesc;
$.ajax({
url: "getBen.jsp",
type: 'POST',
data: {benAccNo: benAccNo},
success: function(data) {
$('#benName').val(data);
$('#benPhone').val(data);
$('#benBank').val(data);
$('#benIfsc').val(data);
$('#benDesc').val(data);
alert(data);
var city_name = data;
}
});
});
</script> -->

<script>
function showBeneficiary(str) {
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
  xhttp.open("GET", "getbeneficiary.jsp?q="+str, true);
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


</head>
<!-- //Head -->
<!-- Body -->

<body>
                             <%   
									entity.CustomerDetails cust = (entity.CustomerDetails) session.getAttribute("cust");
									
							%>

<div align="right"><h3><%=cust.getCustName()%></h3> 
<a href="logout.jsp" ><button onclick="alert('Logout Successfully.\nThank You For Your Trust...')">Logout</button></a></div>

	<!-- Top Bar Logo-->
		<div class="logo">
		<a href="#"><img src="images\logo.png" alt="BOLT" width="200px"><!--<i class="fa fa-inr" aria-hidden="true"></i>--> </a>
			<br>
			<center><span>Let's solve</span></center>
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
								<ul class="nav navbar-nav navbar-right">
							<li><a href="userhome.jsp">My Account</a></li>
							<li><a href="accountstatement.jsp">Account Statement</a></li>
							<!-- <li><a href="">services</a></li> -->
							<li><a href="addbeneficiary.jsp">Add Beneficiary</a></li>
							<li><a href="debit.jsp">Fund Transfer</a></li>
							<li><a href="debitben.jsp">Inter Fund Transfer </a></li>
							<li><a href="showaccount.jsp">View details</a></li>
							<li><a href="updateProfile.jsp">update details</a></li>
												    
						</ul>
					</div>
				</div>
			</nav>
		</div>
		


		<div class="banner-main jarallax">
			<div class="container">
				<div class="banner-inner">
					<div class="col-md-5 banner-left">


						<form action="debit1.do" method="post">
						<h3>Fund Transfer</h3>
					
						  <label>Enter Beneficiary Account Number</label>	
						  <input type="text" name="benAccNo" placeholder="Account Number" oninput="showBeneficiary(this.value)"/>
						  
						  <br>
			             <div id="txtHint">Beneficiary info will be listed here...</div>

							 <br>
							<label>Amount</label>
							<input type="text" name="amount" placeholder="Amount"/>
							<br>
							
								
								
							
							<div class="submit">
									<input type="submit" value="TRANSFER">
									<input type="reset" value="RESET">
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
