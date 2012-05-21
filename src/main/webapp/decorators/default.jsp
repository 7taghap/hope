<%@ include file="/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title><decorator:title default="Welcome"/></title>
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/default/style.css" title="default" />

 <script type="text/javascript" src="${ctx}/javascripts/top_up-min.js?libs=core&images_path=/${ctx}/images/top_up/&fast_mode=1"></script>
<!--  <script type="text/javascript" src="/javascripts/datatable-1.9.js"></script> -->
  <script type="text/javascript" src="${ctx}/javascripts/utiljs.js"></script>
<decorator:head/>
</head>
<body>
	<div id="top">
		<p id="skiplinks">
			Skip to: <a href="#content">content</a> | <a href="#sidebar">sidebar</a>
		</p>
		<div id="sitetitle">
			<h1 style="cursor: pointer" onclick="location.href='${ctx}/'">Business
				Logo v.1.0</h1>
			<p>There is always room for more...</p>
		</div>
		<hr class="clear" />
	</div>

	<div id="wrap">


		<div id="content">

			<h1>
				<decorator:title />
			</h1>
			<%@ include file="/messages.jsp"%>
			<decorator:body />

			<div id="underground">
				<decorator:getProperty property="page.underground" />
			</div>

		</div>

		<div id="sidebar">

			<h2 class="accessibility">Navigation</h2>
			<ul class="clearfix">
				<li><a href="/home.html" title="Home"><span>Home</span></a></li>
				<li><a href="/searchFlights.html" title="Flights"><span>Flights</span></a></li>
				<li><a href="/reservations.html" title=""><span>Reservations</span></a></li>
			</ul>

		</div>
		<hr class="clear" />
	</div>

	<div id="footer">
		<div class="left">
			<p>
				&copy; 2010 <a href="#">Your Name</a> | Template design by <a
					href="http://andreasviklund.com/">Andreas Viklund</a>
			</p>
		</div>
		<div class="right textright">
			<p>
				Sample footer menu: <a href="#">Link 1</a> | <a href="#">Link 2</a>
				| <a href="#">Link 3</a>
			</p>
			<p class="hide">
				<a href="#top">Return to top</a>
			</p>
		</div>
	</div>
	
</body>
</html>

