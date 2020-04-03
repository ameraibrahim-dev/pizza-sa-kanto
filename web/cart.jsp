<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import var="main" url="/main.jsp" />
<c:import var="navbar" url="/navbar.jsp" />
<c:import var="footer" url="/footer.jsp" />
${main} ${navbar}
<div class="container marginTop">
	<img class="header mb-3" src="icons/pizza-icon.png" height="75">
	<hr />
	<div class="row">
		<div class="col-lg-7">
			<div class="m-3" style="padding: 15px;">
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
							<div class="mt-3 mb-3 ml-2 mlr-2">
								<div class="row">
									<div class="col-8">
										<h4>
											<b>${product.name}</b>
										</h4>
										Size:&nbsp;&nbsp;&nbsp;&nbsp;${product.size} <br>
										Quantity:&nbsp;&nbsp;&nbsp;&nbsp;${product.quantity}
									</div>
									<div class="col-4">
										<b class="ml-1">Php&nbsp;&nbsp;${product.totalPrice}</b>
									</div>
								</div>
							</div>

							<button class="btn btn-danger btn-sm float-right" type="button"
								data-toggle="modal" data-target="#${product.productID}"
								style="position: absolute; bottom: 15px; right: 15px">Delete</button>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="col-lg-5">
			<div class="m-3"
				style="background-color: rgb(248, 249, 249, 0.5); padding: 15px; border-radius: 5px">
				<h5 class="mt ml-2">
					<b>Order Summary</b>
				</h5>
				<div class="row ml-1">
					<div class="col-7">Net Pay</div>
					<div class="col-5">Php&nbsp;&nbsp;${cart.netPay}</div>
				</div>
				<div class="row ml-1">
					<div class="col-7">VAT</div>
					<div class="col-5">Php&nbsp;&nbsp;${cart.VAT}</div>
				</div>
				<div class="row ml-1">
					<div class="col-7">Gross Pay (${cart.cartTotal()} item/ s)</div>
					<div class="col-5">Php&nbsp;&nbsp;${cart.grossPay}</div>
				</div>
				<br>
				<div class="row ml-1">
					<div class="col-7">Shipping Fee</div>
					<c:set var="shipping" value="${50.0}" />
					<div class="col-5">Php&nbsp;&nbsp;${shipping}</div>
				</div>

				<div class="mt-3 row ml-1">
					<div class="col-7">
						<b>Total</b>
					</div>
					<hr />
					<div class="col-5" style="color: red;">
						<b>Php&nbsp;&nbsp;${cart.grossPay + shipping}</b>
					</div>
				</div>
				<div class="mt-3" style="align-items: right;">
					<a href="./Checkout" class="btn btn-warning btn-block">Proceed
						to Checkout</a> <a href="./pizza" class="btn btn-dark btn-block">Add
						Items</a>
				</div>
			</div>
		</div>
	</div>
</div>

<!--Cart Delete Confirmation Modal-->

<c:forEach items="${cart.getCartProducts()}" var="product">
	<div class="modal fade" tabindex="-1" role="dialog"
		id="${product.productID}">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="background-color: #f5f0e3;">
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<div class="container-fluid" style="text-align: center;">
						<img src="icons/warning.png" class="mb-3" height="30"> <br>
						<b>Are you sure you want to delete this from your cart?</b>
					</div>

					<hr />
					<div class="row m-2" style="position: relative;">
						<div class="col-md-4">
							<img class="card-img-top m-1" src="${product.imageSource}">
						</div>
						<div class="col-md-8">
							<b>${product.name}</b> <br> <small>
								Size:&nbsp;&nbsp;&nbsp;&nbsp;${product.size} <br>
								Quantity:&nbsp;&nbsp;&nbsp;&nbsp;${product.quantity} <br> <b
								class="float-right">Php&nbsp;&nbsp;${product.totalPrice}</b>
							</small>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<form action="DeleteItem" method="post">
						<input type="hidden" name="deleteItem"
							value="${product.productID}" />
						<button type="submit"
							class="btn btn-danger">Delete</button>
						<button type="button" class="btn btn-dark" data-dismiss="modal">Cancel</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</c:forEach>

