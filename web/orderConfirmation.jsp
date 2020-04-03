<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import var="main" url="/main.jsp" />
<c:import var="navbar" url="/navbar.jsp" />
${main} ${navbar}

<div class="container marginTop col-lg-4" style="background-color: rgb(248, 249, 249, 0.5); padding:25px; border-radius: 5px; border: 1px solid #343A40;">
	<div class="container" style="text-align: center;">
		<img class="mb-3" src="icons/logo-2.png" style="text-align: center;"
			width="45%">
		<h4>
			<small>Makati City, Philippines</small>
		</h4>
		<h6>
			<small>DTI NUMBER: 123456</small>
		</h6>
	</div>

	<div class="container mt-3 ml-2" style="text-align: left;">
	<hr/>
		<h3>
			<small>Shipping and Billing</small>
		</h3>
		<div class="ml-5 row">
			<div class="col-sm-1">
				<i class="fas fa-user"></i>
			</div>
			<div class="col-sm-11">
				<b>${transaction.details.firstName}
					${transaction.details.lastName}</b>
			</div>
		</div>
		<div class="ml-5 mt-1 row">
			<div class="col-sm-1">
				<i class="fas fa-map-marked-alt"></i>
			</div>
			<div class="col-sm-11">
				${transaction.details.address.houseNumber}
				${transaction.details.address.street} <br>
				${transaction.details.address.barangaySubdivision}
				${transaction.details.address.city} <br>
				${transaction.details.address.province},
				${transaction.details.address.zipCode}
			</div>
		</div>
		<div class="ml-5 mt-1 row">
			<div class="col-sm-1">
				<i class="fas fa-phone"></i>
			</div>
			<div class="col-sm-11">${transaction.details.phoneNumber}</div>
		</div>
		<div class="ml-5 mt-1 row">
			<div class="col-sm-1">
				<i class="fas fa-envelope"></i>
			</div>
			<div class="col-sm-11">${transaction.details.emailAddress}</div>
		</div>
	</div>

	<div class="container mt-3 ml-2" style="text-align: left;">
		<h3>
			<small>Order Summary</small>
		</h3>
		<c:forEach items="${transaction.cart.getCartProducts()}" var="product">
			<div class="ml-5 row">
				<div class="col-sm-7">${product.name}</div>
				<div class="col-sm-5">Php&nbsp;&nbsp;${product.totalPrice}</div>
			</div>
		</c:forEach>
		<hr />
		<div class="mt-3 ml-5 row">
			<div class="col-sm-7">Shipping Fee</div>
			<div class="col-sm-5">
				<c:set var="shipping" value="${50}" />
				Php&nbsp;&nbsp;${shipping}
			</div>
		</div>
		<hr />
		<div class="mt-3 ml-5 row">
			<div class="col-sm-7">Net Pay</div>
			<div class="col-sm-5">
				Php&nbsp;&nbsp;${transaction.cart.netPay}</div>
		</div>
		<div class="ml-5 row">
			<div class="col-sm-7">VAT</div>
			<div class="col-sm-5">Php&nbsp;&nbsp;${transaction.cart.VAT}</div>
		</div>
		<hr />
		<div class="ml-5 row" style="color: red;">
			<div class="col-sm-7">
				<b>Total Gross Pay</b>
			</div>
			<div class="col-sm-5">
				<b>Php&nbsp;&nbsp;${transaction.cart.grossPay}</b>
			</div>
		</div>
	</div>
</div>
<div class="container marginTop col-lg-4" style="text-align: center;">
	<h4>Thank you for Shopping with us, Enjoy your Meal.</h4>
</div>
<!-- /.container container-cart -->

