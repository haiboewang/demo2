<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" defaultValue="My app"/></title>
<style type="text/css">
	div.container {margin-left:auto;margin-right:auto;margin-top:30px;width:900px;background-color:#b0e0e6; border:1px solid red;}
	div.left_menu{float:left;width:160px;height:250px;margin:0;padding:1em;}
	div.content{margin-left:190px;border-left:1px solid gray;padding:1em;}
	div.header,div.footer{weight:800;height:30padding:0.5em;color:white;background-color:gray;clear:left;}
</style>
</head>
<body>
<div class="container">
	<div class="header"><tiles:insertAttribute name="header" /></div>
	<div class="left_menu"><tiles:insertAttribute name="menu" /></div>
	<div class="content"><tiles:insertAttribute name="body" /></div>
	<div class="footer"><tiles:insertAttribute name="footer" /></div>
</div>
</body>
</html>