<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import var="main" url="/main.jsp" />
<c:import var="navbar" url="/navbar.jsp" />
${main} ${navbar}
<div class="container marginTop">
	<img class="header mb-3" src="icons/id.png" height="75">
	<hr />
	<div class="row">
		<div class="col-lg-7">
			<div class="m-3" style="padding: 15px;">
				<div>
					<form action="ConfirmOrder" method="post">
						<h5 class="mt ml-2">
							<b>Customer Details</b>
						</h5>
						<div class="row">
							<div class="col-md-6">
								<small>First Name</small> <input type="text"
									class="form-control" name="firstName" placeholder="First Name"
									required="required" value="${userInput.get('firstName')}">
								<small class="text-danger float-right"
									style="text-align: right;">${errors.get("firstName")}</small>
							</div>
							<div class="col-md-6">
								<small>Last Name</small> <input type="text" class="form-control"
									name="lastName" placeholder="Last Name" required="required"
									value="${userInput.get('lastName')}"> <small
									class="text-danger float-right" style="text-align: right;">${errors.get("lastName")}</small>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<small>Phone Number</small> <input type="text"
									class="form-control" name="phoneNumber"
									placeholder="09000000000" required="required" maxlength="11"
									value="${userInput.get('phoneNumber')}"> <small
									class="text-danger float-right" style="text-align: right;">${errors.get("phoneNumber")}</small>

							</div>
							<div class="col-md-6">
								<small>Email Address</small> <input type="text "
									class="form-control" name="emailAddress"
									placeholder="user@email.com" required="required"
									value="${userInput.get('emailAddress')}"> <small
									class="text-danger float-right" style="text-align: right;">${errors.get("emailAddress")}</small>
							</div>
						</div>
						<h5 class="mt-4 ml-2">
							<b>Shipping Address</b>
						</h5>
						<div class="row">
							<div class="col-md-6">
								<small>House Number</small> <input type="text"
									class="form-control" name="houseNumber"
									placeholder="House Number" required="required"
									value="${userInput.get('houseNumber')}">
							</div>
							<div class="col-md-6">
								<small>Street</small> <input type="text" class="form-control"
									name="street" placeholder="Street" required="required"
									value="${userInput.get('street')}"> <small
									class="text-danger float-right" style="text-align: right;">${errors.get("street")}</small>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<small>Barangay/ Subdivision</small> <input type="text"
									class="form-control" name="barangaySubdivision"
									placeholder="Barangay/ Subdivision" required="required"
									value="${userInput.get('barangaySubdivision')}"> <small
									class="text-danger float-right" style="text-align: right;">${errors.get("barangaySubdivision")}</small>
							</div>
							<div class="col-md-6">
								<small>City</small> <input type="text" class="form-control"
									name="city" placeholder="City" required="required"
									value="${userInput.get('city')}"> <small
									class="text-danger float-right" style="text-align: right;">${errors.get("city")}</small>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<small>Province</small> <input type="text" class="form-control"
									name="province" placeholder="Province" required="required"
									value="${userInput.get('province')}"> <small
									class="text-danger float-right" style="text-align: right;">${errors.get("province")}</small>
							</div>
							<div class="col-md-6">
								<small>Zip Code</small> <input type="text" class="form-control"
									name="zipCode" placeholder="Zip Code" required="required"
									maxlength="4" value="${userInput.get('zipCode')}"> <small
									class="text-danger float-right" style="text-align: right;">${errors.get("zipCode")}</small>
							</div>
						</div>

						<h5 class="mt-4 ml-2">
							<b>Payment Details</b>
						</h5>
						<div class="form-group">
						<input class="selectedPaymentType" type="hidden" value="${userInput.get('paymentType')}"/>
							<small>Payment Type</small> <select
								class="custom-select form-control paymentType" name="paymentType"
								id="paymentType" required="required">
									<option class="cash" value="cash">Cash On
										Delivery</option>
									<option class="card" value="card">Card</option>
							</select>
						</div>
						<div class="cardNumber" style="display:none;">
							<small>Card Number</small> <input type="text"
								class=" form-control" name="cardNumber"
								placeholder="00000000000000" value="${userInput.get('cardNumber')}">
							<small class="text-danger float-right" style="text-align: right;">${errors.get("cardNumber")}</small>
						</div>
						<button class="mt-2 btn btn-warning btn-block" type="submit">
							Checkout</button>
					</form>
				</div>
			</div>
		</div>
		<div class="col-lg-5">
			<div class="m-3"
				style="background-color: rgb(248, 249, 249, 0.5); padding: 15px; border-radius: 5px">
				<h5 class="mt ml-2">
					<b>Cart</b>
				</h5>
				<c:forEach items="${cart.getCartProducts()}" var="product">
					<div class="row m-2" style="position: relative;">
						<div class="col-md-4">
							<img class="card-img-top m-1" src="${product.imageSource}"
								alt="${product.productID}">
						</div>
						<div class="col-md-8">
							<b>${product.name}</b> <br> <small>
								Size:&nbsp;&nbsp;&nbsp;&nbsp;${product.size} <br>
								Quantity:&nbsp;&nbsp;&nbsp;&nbsp;${product.quantity} <br> <b
								class="float-right">Php&nbsp;&nbsp;${product.totalPrice}</b>
							</small>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="m-3"
				style="background-color: rgb(248, 249, 249, 0.5); padding: 15px; border-radius: 5px">
				<h5 class="mt ml-2">
					<b>Order Summary</b>
				</h5>
				<div class="row ml-1">
					<div class="col-8">Net Pay</div>
					<div class="col-4">Php ${cart.netPay}</div>
				</div>
				<div class="row ml-1">
					<div class="col-8">VAT</div>
					<div class="col-4">Php ${cart.VAT}</div>
				</div>
				<div class="row ml-1">
					<div class="col-8">Gross Pay (${cart.cartTotal()} item/ s)</div>
					<div class="col-4">Php ${cart.grossPay}</div>
				</div>
				<br>
				<div class="row ml-1">
					<div class="col-8">Shipping Fee</div>
					<c:set var="shipping" value="${50.0}" />
					<div class="col-4">Php ${shipping}</div>
				</div>

				<div class="mt-3 row ml-2">
					<div class="col-8">
						<b>Total</b>
					</div>
					<hr />
					<div class="col-4" style="color: red;">
						<b>Php ${cart.grossPay + shipping}</b>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<script>

</script>


