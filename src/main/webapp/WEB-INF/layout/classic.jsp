<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><tiles:getAsString name="title" /></title>
</head>
<body>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sercurity" %>

<tilesx:useAttribute name="current" />

<div class="container">

<!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<spring:url value="/"/>'>JBA</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="${current == 'index' ? 'active' : '' }" ><a href='<spring:url value="/"/>'>Home</a></li>
					<sercurity:authorize access="hasRole('ROLE_ADMIN')">
			              <li class="${current == 'users' ? 'active' : '' }"><a href='<spring:url value="/users.html"/>'>Users</a></li>
		              </sercurity:authorize>
				<li class="${current == 'register' ? 'active' : '' }"><a
						href='<spring:url value="/register.html"/>'>User register</a></li>
					<sercurity:authorize access="! isAuthenticated()">
						<li class="${current == 'login' ? 'active' : '' }"><a
							href='<spring:url value="/login.html"/>'>Login</a></li>
					</sercurity:authorize>
					<sercurity:authorize access="isAuthenticated()">
			            <li class="${current == 'account' ? 'active' : '' }"><a href='<spring:url value="/account.html"/>'>My Account</a></li>
						<li><a href='<spring:url value="/logout"/>'>Logout</a></li>
					</sercurity:authorize>
				</ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

	<tiles:insertAttribute name="body" />
	
	<br /><br />
	<center>
		<tiles:insertAttribute name="footer" />
	</center>
</div>
<script type="text/javascript">
	$("input").first().focus();
</script>
</body>
</html>