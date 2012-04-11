<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<% //response.sendRedirect("admin?actionType=users"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hope IMS</title>
        <link rel="stylesheet" type="text/css" href="styles/default/style.css" />
		<link rel="stylesheet" type="text/css" href="css/form.css" />
    </head>
    <body>
        <h1>Hope IMS</h1>

  <div class="container" id="page">
  
  <div id="content">
         <div class="form">
         <a href="product/new">create product</a>
         </div>
       </div>
 </div>
    </body>
</html>


<%-- <%@ include file="/WEB-INF/pages/taglib.jsp" %> --%>

<%-- Redirected because we can't set the welcome page to a virtual URL. --%>
<!-- <c:redirect url="/hello.htm"/> -->