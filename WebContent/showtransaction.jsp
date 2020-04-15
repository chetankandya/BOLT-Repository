<!DOCTYPE html>
<%@ page import="entity.TransactionDetails" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page errorPage = "errorpage.jsp" %>
<html lang="en">
<!-- Head -->
<head>
<title>BOLT | TRANSACTION</title>
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

#trans tr:nth-child(even){background-color: #f2f2f2;}

#trans tr:hover {background-color: #ddd;}

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
         window.frames["print_frame"].document.body.innerHTML = document.getElementById("printableTable").innerHTML;
         window.frames["print_frame"].window.focus();
         window.frames["print_frame"].window.print();
       }
	</script>
	
	
</head>
<!-- //Head -->
<!-- Body -->
 <body>
     <%
		entity.CustomerDetails cust = (entity.CustomerDetails) session.getAttribute("cust");
	  %>

	<div align="right">
		<h3 color="blue"><%=cust.getCustName()%></h3>
		<a href="logout.jsp"><button
				onclick="alert('Logout Successfully.\nThank You For Your Trust...')">Logout</button></a>
	</div>
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
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myNavbar">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse" id="myNavbar">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="userhome.html" >My account</a></li>
							<li><a href="#" class="scroll">account statement</a></li>
							<li><a href="#" class="scroll">services</a></li>
							<li><a href="#" class="scroll">fund transfer</a></li>
							<li><a href="debitben.jsp">Inter Fund Transfer </a></li>
							<li><a href="#" class="scroll">Add Beneficiary</a></li>
							<li><a href="#" class="scroll">update details</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		



<!--  Section -->

<div class="banner-main jarallax">
			<div class="container">
				<div class="banner-inner">
					<div class="col-md-5 banner-left">
					
				
					  <div id="printableTable">
							<table border = "1"  width = "600"><tr><td>Transaction Id</td> <td> Transfer Date</td><td>Beneficiary Name</td><td>Beneficiary Account</td></tr>	
				<tr><td>${view1.getTransId()}</td><td>${view1.getTransferDate()}</td><td>${view1.getBenName()}</td><td>${view1.getBenAccNo()}</td></tr>
				<tr><td>${view2.getTransId()}</td><td>${view2.getTransferDate()}</td><td>${view2.getBenName()}</td><td>${view2.getBenAccNo()}</td></tr>
				<tr><td>${view3.getTransId()}</td><td>${view3.getTransferDate()}</td><td>${view3.getBenName()}</td><td>${view3.getBenAccNo()}</td></tr>
				<tr><td>${view4.getTransId()}</td><td>${view4.getTransferDate()}</td><td>${view4.getBenName()}</td><td>${view4.getBenAccNo()}</td></tr>
				<tr><td>${view5.getTransId()}</td><td>${view5.getTransferDate()}</td><td>${view5.getBenName()}</td><td>${view5.getBenAccNo()}</td></tr>
				<tr><td>${view6.getTransId()}</td><td>${view6.getTransferDate()}</td><td>${view6.getBenName()}</td><td>${view6.getBenAccNo()}</td></tr>
				<tr><td>${view7.getTransId()}</td><td>${view7.getTransferDate()}</td><td>${view7.getBenName()}</td><td>${view7.getBenAccNo()}</td></tr>
					<tr><td>${view8.getTransId()}</td><td>${view8.getTransferDate()}</td><td>${view8.getBenName()}</td><td>${view8.getBenAccNo()}</td></tr>
					<tr><td>${view9.getTransId()}</td><td>${view9.getTransferDate()}</td><td>${view9.getBenName()}</td><td>${view9.getBenAccNo()}</td></tr>
						<tr><td>${view10.getTransId()}</td><td>${view10.getTransferDate()}</td><td>${view10.getBenName()}</td><td>${view10.getBenAccNo()}</td></tr>
				
				</table>
							
							  </div>
							  <br>
							  
			                    <h3><a href="userhome.jsp">Go Back</a></h3>
							  	<button class="Button Button--outline" onclick="printDiv()">Print</button>
					</div>
							 <iframe name="print_frame" width="0" height="0" frameborder="0" src="about:blank"></iframe>

					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
<!-- //Registration Section -->
	
<!-- footer 
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
-->
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
			

$(document).ready(function() {
    $('#trans').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'print'
        ]
    } );
} );

history.pushState(null, null, location.href);
window.onpopstate = function () {
    history.go(1);
};

	</script>
	<!-- //here ends scrolling icon -->
	<script src="js/bars.js"></script>
</body>
</html>