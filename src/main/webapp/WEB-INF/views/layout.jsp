<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><tiles:insertAttribute name="title" defaultValue="Construction Group"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="resources/stylesheet/style.css" />
<script type="text/javascript" src="resources/js/jquery-1.4.2.min.js"></script>
<!-- <script type="text/javascript" src="resources/js/main.js"></script> -->
<script type="text/javascript">
$(document).ready(function(){
   $("#menuHome").mouseenter(function(){
	 $("#menuHome2").show();
	 $("#menuContactUs2").hide();
	 });
   
   $("#menuContactUs").mouseenter(function(){
	 $("#menuContactUs2").show();
	 $("#menuHome2").hide();
	 });
   
});
</script>
</head>
<body>
<div id="wrapper">
  <div class="header">
    <div style="position:absolute; left: 32px;"> <img src="resources/images/logo.gif" alt="" border="0" /></div>
    <div class="header-left"> <a href="index.html"><img src="resources/images/logo.jpg" alt="Logo" border="0" /></a> </div>
    <div class="header-right">Phone : +91-2454-9995<br />
      +91-2454-6373</div>
    <div class="clear"></div>
  </div>
  <div class="clear"></div>
  <div class="menuzone">
    <div class="menuleft">
      <div class="menuright">
        <div class="mainmenu">
          <ul>
            <li class="active" id="menuHome"><a href="/web/">Home!</a></li>
            <li><a href="aboutus.html">About Us</a></li>
            <li><a href="projects.html" id="menuProjects">Projects</a></li>
            <li><a href="services.html">Services</a></li>
            <li><a href="support.html">Support</a></li>
            <li><a href="privacy.html">Privacy</a></li>
            <li id="menuContactUs"><a href="contactUs">Contact Us</a></li>
          </ul>
        </div>
		<div class="menulevel2" id="menuHome2">
			<ul>
            <li class="active"><a href="/web/">Home</a></li>
            <li style="background:none;"><a href="contactUs">Contact Us</a></li>
          </ul>
		</div>
		<div class="menulevel2" id="menuContactUs2">
			<ul>
            <li class="active"><a href="/web/">Home2</a></li>
            <li style="background:none;"><a href="contactUs">Contact Us 2</a></li>
          </ul>
		</div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
  <div class="container">
  	<tiles:insertAttribute name="body" />
  <div class="clear"></div>  
  </div>
</div>
<div class="clear"></div>
<div class="footer"><tiles:insertAttribute name="footer" /></div>

</body>
</html>
