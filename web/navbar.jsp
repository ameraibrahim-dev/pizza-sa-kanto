<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="index.jsp"><img src="icons/logo.png"
			width="100"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active">
					<div class="cart">
					<a class="nav-link" href="GoToCart"> <img
						src="icons/smart-cart.png" id="cart" alt="cart" height="25"></a>
						 <c:if test="${cart.cartTotal() > 0}">
						    <span class="badge">${cart.cartTotal()}</span>
						  </c:if>
					</div> 
				</li>
			</ul>
		</div>
	</div>
</nav>
