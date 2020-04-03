<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import var="main" url="/main.jsp" />
<c:import var="navbar" url="/navbar.jsp" />
<c:import var="menu" url="/menu.jsp" />
<c:import var="carousel" url="/carousel.jsp" />
<c:import var="footer" url="/footer.jsp" />
${main} ${navbar}
<!-- Page Content -->
<div class="container">

	<div class="row">

		<div class="col-lg-3 position-sticky">${menu}</div>
		<!-- /.col-lg-3 -->

		<!-- Header Slider -->
		<div class="col-lg-9">
			${carousel}
			<div class="row">

				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
						<img class="card-img-top" src="${chickenAlfredo.imageSource}"
							alt="chicken-alfredo">
						<div class="card-body">
							<h4 class="card-title">${chickenAlfredo.name }</h4>
							<p class="card-text">${chickenAlfredo.description }</p>
						</div>
						<div class="card-footer">
							<form action="AddToCart" method="post" id="submitChickenAlfredo">
								<input type="hidden" name="name" value="${chickenAlfredo.name}">
								<input type="hidden" name="category"
									value="${chickenAlfredo.category}"> <input
									type="hidden" name="description"
									value="${chickenAlfredo.description}"> <input
									type="hidden" name="imageSource"
									value="${chickenAlfredo.imageSource}">
								<div class="form-group">
									<small>Size</small> <select id="chickenAlfredoSize" class="form-control" name="size" required="required">
										<option value="Regular">Regular - 210</option>
										<option value="Large">Large - 380</option>
									</select>
								</div>
								<small>Quantity:</small>
								<div class="input-group" style="text-align: center;">
									<div class="input-group-prepend">
										<button type="button" class="btn btn-warning btn-sm minus"
											data-minus="chickenAlfredo" style="border-radius: 0;">
											<i class="fas fa-minus-square"></i>
										</button>
									</div>
									<input type="text"
										class="form-control form-control-sm input chickenAlfredo"
										style="text-align: center;" value="1" min="1" disabled>
									<input name="quantity" type="hidden"
										class="form-control form-control-sm input chickenAlfredo"
										style="text-align: center;" value="1" min="1">
									<div class="input-group-prepend">
										<button type="button" class="btn btn-dark btn-sm plus"
											data-plus="chickenAlfredo" style="border-radius: 0;">
											<i class="fas fa-plus-square"></i>
										</button>
									</div>
								</div>
								<br>
								<button id="addChickenAlfredo" class="btn btn-dark btn-block" type="button"
									data-toggle="modal" data-target="#chickenAlfredo">
									Add to Cart</button>
							</form>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
						<img class="card-img-top" src="${shrimpAlfredo.imageSource}"
							alt="shrimp-alfredo">
						<div class="card-body">
							<h4 class="card-title">${shrimpAlfredo.name }</h4>
							<p class="card-text">${shrimpAlfredo.description}</p>
						</div>
						<div class="card-footer">
							<form action="AddToCart" method="post" id="submitShrimpAlfredo">
								<input type="hidden" name="name" value="${shrimpAlfredo.name}">
								<input type="hidden" name="category"
									value="${shrimpAlfredo.category}"> <input type="hidden"
									name="description" value="${shrimpAlfredo.description}">
								<input type="hidden" name="imageSource"
									value="${shrimpAlfredo.imageSource}">
								<div class="form-group">
									<small>Size</small> <select id="shrimpAlfredoSize" class="form-control" name="size" required="required">
										<option value="Regular">Regular - 245</option>
										<option value="Large">Large - 420</option>
									</select>
								</div>
								<small>Quantity:</small>
								<div class="input-group" style="text-align: center;">
									<div class="input-group-prepend">
										<button type="button" class="btn btn-warning btn-sm minus"
											data-minus="shrimpAlfredo" style="border-radius: 0;">
											<i class="fas fa-minus-square"></i>
										</button>
									</div>
									<input type="text"
										class="form-control form-control-sm input shrimpAlfredo"
										style="text-align: center;" value="1" min="1" disabled>
									<input name="quantity" type="hidden"
										class="form-control form-control-sm input shrimpAlfredo"
										style="text-align: center;" value="1" min="1">
									<div class="input-group-prepend">
										<button type="button" class="btn btn-dark btn-sm plus"
											data-plus="shrimpAlfredo" style="border-radius: 0;">
											<i class="fas fa-plus-square"></i>
										</button>
									</div>
								</div>
								<br>
								<button id="addShrimpAlfredo" class="btn btn-dark btn-block"  type="button"
									data-toggle="modal" data-target="#shrimpAlfredo">
									Add to Cart</button>
							</form>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
						<img class="card-img-top" src="${spaghettiMeatballs.imageSource}"
							alt="spaghetti-meatballs">
						<div class="card-body">
							<h4 class="card-title">${spaghettiMeatballs.name}</h4>
							<p class="card-text">${spaghettiMeatballs.description}</p>
						</div>
						<div class="card-footer">
							<form action="AddToCart" method="post"
								id="submitSpaghettiMeatballs">
								<input type="hidden" name="name"
									value="${spaghettiMeatballs.name}"> <input
									type="hidden" name="category"
									value="${spaghettiMeatballs.category}"> <input
									type="hidden" name="description"
									value="${spaghettiMeatballs.description}"> <input
									type="hidden" name="imageSource"
									value="${spaghettiMeatballs.imageSource}">
								<div class="form-group">
									<small>Size</small> <select id="spaghettiMeatballsSize" class="form-control" name="size" required="required">
										<option value="Regular">Regular - 210</option>
										<option value="Large">Large - 380</option>
									</select>
								</div>
								<small>Quantity:</small>
								<div class="input-group" style="text-align: center;">
									<div class="input-group-prepend">
										<button type="button" class="btn btn-warning btn-sm minus"
											data-minus="spaghettiMeatballs" style="border-radius: 0;">
											<i class="fas fa-minus-square"></i>
										</button>
									</div>
									<input type="text"
										class="form-control form-control-sm input spaghettiMeatballs"
										style="text-align: center;" value="1" min="1" disabled>
									<input name="quantity" type="hidden"
										class="form-control form-control-sm input spaghettiMeatballs"
										style="text-align: center;" value="1" min="1">
									<div class="input-group-prepend">
										<button type="button" class="btn btn-dark btn-sm plus"
											data-plus="spaghettiMeatballs" style="border-radius: 0;">
											<i class="fas fa-plus-square"></i>
										</button>
									</div>
								</div>
								<br>

								<button id="addSpaghettiMeatballs"
									class="btn btn-dark btn-block" type="button"
									data-toggle="modal" data-target="#spaghettiMeatballs">
									Add to Cart</button>
							</form>
						</div>
					</div>
				</div>

			</div>
			<!-- /.row -->
		</div>
		<!-- /.col-lg-9 -->
	</div>
	<!-- /.row -->
</div>
<!-- /.container -->

<!-- Chicken Alfredo Modal -->
<div class="modal fade" tabindex="-1" role="dialog"
	id="chickenAlfredo">
	<div class="modal-dialog" role="document">
		<div class="modal-content" style="background-color: #f5f0e3;">
			<div class="modal-body">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="container-fluid" style="text-align: center;">
					<img src="icons/pasta-1.png" class="mb-3" height="30"> <br>
					<b>Are you sure you want to add this to your cart?</b>
				</div>

				<hr />
				<div class="row m-2" style="position: relative;">
					<div class="col-md-4">
						<img class="card-img-top m-1"
							src="${chickenAlfredo.imageSource}">
					</div>
					<div class="col-md-8">
						<b>${chickenAlfredo.name}</b> <br> <small>
							Size:&nbsp;&nbsp;&nbsp;&nbsp;<span class="chickenAlfredoSize"></span>
							<br> Quantity:&nbsp;&nbsp;&nbsp;&nbsp;<span
							class="chickenAlfredoQuantity"></span> <br> <b
							class="float-right">Php&nbsp;&nbsp;<span
								class="chickenAlfredoPrice"></span></b>
						</small>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="modalChickenAlfredo" type="button"
					class="btn btn-warning">Add to Cart</button>
				<button type="button" class="btn btn-dark" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!-- Shrimp Alfredo Modal -->
<div class="modal fade" tabindex="-1" role="dialog"
	id="shrimpAlfredo">
	<div class="modal-dialog" role="document">
		<div class="modal-content" style="background-color: #f5f0e3;">
			<div class="modal-body">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="container-fluid" style="text-align: center;">
					<img src="icons/pasta-1.png" class="mb-3" height="30"> <br>
					<b>Are you sure you want to add this to your cart?</b>
				</div>

				<hr />
				<div class="row m-2" style="position: relative;">
					<div class="col-md-4">
						<img class="card-img-top m-1"
							src="${shrimpAlfredo.imageSource}">
					</div>
					<div class="col-md-8">
						<b>${shrimpAlfredo.name}</b> <br> <small>
							Size:&nbsp;&nbsp;&nbsp;&nbsp;<span class="shrimpAlfredoSize"></span>
							<br> Quantity:&nbsp;&nbsp;&nbsp;&nbsp;<span
							class="shrimpAlfredoQuantity"></span> <br> <b
							class="float-right">Php&nbsp;&nbsp;<span
								class="shrimpAlfredoPrice"></span></b>
						</small>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="modalShrimpAlfredo" type="button"
					class="btn btn-warning">Add to Cart</button>
				<button type="button" class="btn btn-dark" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!-- Spaghetti and Meatballs Modal -->
<div class="modal fade" tabindex="-1" role="dialog"
	id="spaghettiMeatballs">
	<div class="modal-dialog" role="document">
		<div class="modal-content" style="background-color: #f5f0e3;">
			<div class="modal-body">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="container-fluid" style="text-align: center;">
					<img src="icons/pasta-1.png" class="mb-3" height="30"> <br>
					<b>Are you sure you want to add this to your cart?</b>
				</div>

				<hr />
				<div class="row m-2" style="position: relative;">
					<div class="col-md-4">
						<img class="card-img-top m-1"
							src="${spaghettiMeatballs.imageSource}">
					</div>
					<div class="col-md-8">
						<b>${spaghettiMeatballs.name}</b> <br> <small>
							Size:&nbsp;&nbsp;&nbsp;&nbsp;<span class="spaghettiMeatballsSize"></span>
							<br> Quantity:&nbsp;&nbsp;&nbsp;&nbsp;<span
							class="spaghettiMeatballsQuantity"></span> <br> <b
							class="float-right">Php&nbsp;&nbsp;<span
								class="spaghettiMeatballsPrice"></span></b>
						</small>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="modalSpaghettiMeatballs" type="button"
					class="btn btn-warning">Add to Cart</button>
				<button type="button" class="btn btn-dark" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>
