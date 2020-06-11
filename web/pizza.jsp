<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import var="main" url="/main.jsp" />
<c:import var="navbar" url="/navbar.jsp" />
<c:import var="menu" url="/menu.jsp" />
<c:import var="carousel" url="/carousel.jsp" />
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
						<img class="card-img-top" src="${hawaiian.imageSource}"
							alt="hawaiian-pizza">
						<div class="card-body">
							<h4 class="card-title">${hawaiian.name }</h4>
							<p class="card-text">${hawaiian.description }</p>
						</div>
						<div class="card-footer">
							<form action="AddToCart" method="post" id="submitHawaiian">
								<input type="hidden" name="name" value="${hawaiian.name}">
								<input type="hidden" name="category"
									value="${hawaiian.category}"> <input type="hidden"
									name="description" value="${hawaiian.description}"> <input
									type="hidden" name="imageSource"
									value="${hawaiian.imageSource}">
								<div class="form-group">
									<small>Size</small> 
									<select
										class="custom-select form-control" name="size"
										id="hawaiianSize" required="required">
										<option value="9">9" - 315</option>
										<option value="12">12" - 525</option>
										<option value="15">15" - 735</option>
										<option value="18">18" - 945</option>
									</select>
								</div>
					            	<small>Quantity:</small>
								<div class="input-group" style="text-align: center;">
					              	<div class="input-group-prepend">
					                	<button type="button" class="btn btn-warning btn-sm minus" data-minus="hawaiian" style="border-radius: 0;"><i class="fas fa-minus-square"></i></button>
					             	 </div>
					              	<input type="text" class="form-control form-control-sm input hawaiian" style="text-align: center;" value="1" min="1" disabled>
					              	<input name="quantity" type="hidden" class="form-control form-control-sm input hawaiian" style="text-align: center;" value="1" min="1">
					              	<div class="input-group-prepend">
					                	<button type="button" class="btn btn-dark btn-sm plus" data-plus="hawaiian" style="border-radius: 0;"><i class="fas fa-plus-square"></i></button>
					              	</div>
					            </div>
								<br>
									<button id="addHawaiian" class="btn btn-dark btn-block" type="button"
									data-toggle="modal" data-target="#hawaiian">
										Add to Cart</button>
							</form>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
						<img class="card-img-top" src="${fourSeasons.imageSource}"
							alt="four-seasons">
						<div class="card-body">
							<h4 class="card-title">${fourSeasons.name }</h4>
							<p class="card-text">${fourSeasons.description }</p>
						</div>
						<div class="card-footer">
							<form action="AddToCart" method="post" id="submitFourSeasons">
								<input type="hidden" name="name" value="${fourSeasons.name}">
								<input type="hidden" name="category"
									value="${fourSeasons.category}"> <input type="hidden"
									name="description" value="${fourSeasons.description}">
								<input type="hidden" name="imageSource"
									value="${fourSeasons.imageSource}">
								<div class="form-group">
									<small>Size</small> 
									<select
										class="custom-select form-control" name="size"
										id="fourSeasonsSize" required="required">
										<option value="9">9" - 525</option>
										<option value="12">12" - 735</option>
										<option value="15">15" - 945</option>
										<option value="18">18" - 1155</option>
									</select>
								</div>
					            	<small>Quantity:</small>
								<div class="input-group" style="text-align: center;">
					              	<div class="input-group-prepend">
					                	<button type="button" class="btn btn-warning btn-sm minus" data-minus="fourSeasons" style="border-radius: 0;"><i class="fas fa-minus-square"></i></button>
					             	 </div>
					              	<input type="text" class="form-control form-control-sm fourSeasons" style="text-align: center;" value="1" min="1" disabled>
					              	<input name="quantity" type="hidden" class="form-control form-control-sm fourSeasons" style="text-align: center;" value="1" min="1">
					              	<div class="input-group-prepend">
					                	<button type="button" class="btn btn-dark btn-sm plus" data-plus="fourSeasons" style="border-radius: 0;"><i class="fas fa-plus-square"></i></button>
					              	</div>
					            </div>
								<br>
									<button id="addFourSeasons" class="btn btn-dark btn-block" type="button"
									data-toggle="modal" data-target="#fourSeasons">
										Add to Cart</button>
							</form>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
						<img class="card-img-top" src="${roastedGarlicShrimp.imageSource}"
							alt="garlic-shrimp">
						<div class="card-body">
							<h4 class="card-title">${roastedGarlicShrimp.name}</h4>
							<p class="card-text">${roastedGarlicShrimp.description}</p>
						</div>
						<div class="card-footer">
							<form action="AddToCart" method="post" id="submitRoastedGarlicShrimp">
								<input type="hidden" name="name"
									value="${roastedGarlicShrimp.name}"> <input
									type="hidden" name="category"
									value="${roastedGarlicShrimp.category}"> <input
									type="hidden" name="description"
									value="${roastedGarlicShrimp.description}"> <input
									type="hidden" name="imageSource"
									value="${roastedGarlicShrimp.imageSource}">
								<div class="form-group">
									<small>Size</small> 
									<select
										class="custom-select form-control" name="size"
										id="roastedGarlicShrimpSize" required="required">
										<option value="9">9" - 420</option>
										<option value="12">12" - 630</option>
										<option value="15">15" - 840</option>
										<option value="18">18" - 1050</option>
									</select>
								</div>
					            	<small>Quantity:</small>
								<div class="input-group" style="text-align: center;">
					              	<div class="input-group-prepend">
					                	<button type="button" class="btn btn-warning btn-sm minus" data-minus="roastedGarlicShrimp" style="border-radius: 0;"><i class="fas fa-minus-square"></i></button>
					             	 </div>
					              	<input type="text" class="form-control form-control-sm roastedGarlicShrimp" style="text-align: center;" value="1" min="1" disabled>
					              	<input name="quantity" type="hidden" class="form-control form-control-sm roastedGarlicShrimp" style="text-align: center;" value="1" min="1">
					              	<div class="input-group-prepend">
					                	<button type="button" class="btn btn-dark btn-sm plus" data-plus="roastedGarlicShrimp" style="border-radius: 0;"><i class="fas fa-plus-square"></i></button>
					              	</div>
					            </div>
								<br>
									<button id="addRoastedGarlicShrimp" class="btn btn-dark btn-block" type="button"
									data-toggle="modal" data-target="#roastedGarlicShrimp">
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

<!-- Hawaiian Modal -->
<div class="modal fade" tabindex="-1" role="dialog"
	id="hawaiian">
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
							src="${hawaiian.imageSource}">
					</div>
					<div class="col-md-8">
						<b>${hawaiian.name}</b> <br> <small>
							Size:&nbsp;&nbsp;&nbsp;&nbsp;<span class="hawaiianSize"></span>
							<br> Quantity:&nbsp;&nbsp;&nbsp;&nbsp;<span
							class="hawaiianQuantity"></span> <br> <b
							class="float-right">Php&nbsp;&nbsp;<span
								class="hawaiianPrice"></span></b>
						</small>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="modalHawaiian" type="button"
					class="btn btn-warning">Add to Cart</button>
				<button type="button" class="btn btn-dark" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!-- Four Seasons All Meat Modal -->
<div class="modal fade" tabindex="-1" role="dialog"
	id="fourSeasons">
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
							src="${fourSeasons.imageSource}">
					</div>
					<div class="col-md-8">
						<b>${fourSeasons.name}</b> <br> <small>
							Size:&nbsp;&nbsp;&nbsp;&nbsp;<span class="fourSeasonsSize"></span>
							<br> Quantity:&nbsp;&nbsp;&nbsp;&nbsp;<span
							class="fourSeasonsQuantity"></span> <br> <b
							class="float-right">Php&nbsp;&nbsp;<span
								class="fourSeasonsPrice"></span></b>
						</small>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="modalFourSeasons" type="button"
					class="btn btn-warning">Add to Cart</button>
				<button type="button" class="btn btn-dark" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!-- Roasted Garlic and Shrimp Modal -->
<div class="modal fade" tabindex="-1" role="dialog"
	id="roastedGarlicShrimp">
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
							src="${roastedGarlicShrimp.imageSource}">
					</div>
					<div class="col-md-8">
						<b>${roastedGarlicShrimp.name}</b> <br> <small>
							Size:&nbsp;&nbsp;&nbsp;&nbsp;<span class="roastedGarlicShrimpSize"></span>
							<br> Quantity:&nbsp;&nbsp;&nbsp;&nbsp;<span
							class="roastedGarlicShrimpQuantity"></span> <br> <b
							class="float-right">Php&nbsp;&nbsp;<span
								class="roastedGarlicShrimpPrice"></span></b>
						</small>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="modalRoastedGarlicShrimp" type="button"
					class="btn btn-warning">Add to Cart</button>
				<button type="button" class="btn btn-dark" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

