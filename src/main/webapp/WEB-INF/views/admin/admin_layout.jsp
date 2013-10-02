<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><tiles:insertAttribute name="title" defaultValue="Construction Group"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
</head>
<body>
<%-- <div id="wrapper">
  <div class="container">
  	<tiles:insertAttribute name="body" />
  </div>
<div class="footer"><tiles:insertAttribute name="footer" /></div>
</div> --%>
<tiles:insertAttribute name="body" />
</body>
</html>
