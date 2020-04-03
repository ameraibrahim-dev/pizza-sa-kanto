<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Pizza Sa Kanto</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!--Font CSS-->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat&display=swap"
	rel="stylesheet">

<!--Font Awesome CSS-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
	integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ"
	crossorigin="anonymous">

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">

<!--Favicon-->
<link rel="icon" href="icons/favicon.png">

</head>
<style>
.cart {
	position: relative;
	display: inline-block;
}

.badge {
	position: absolute;
	top: -0px;
	right: -0px;
	padding: 2px 6px;
	border-radius: 50%;
	background: red;
	color: white;
}

.marginTop {
	margin-top: 40px;
}

.order-details {
	text-align: center;
}

.header {
	display: block;
	margin-left: auto;
	margin-right: auto;
}

.w-80 {
	margin-bottom: 20px;
}

.loading {
		-webkit-animation: rotation 4s infinite linear;
}

@-webkit-keyframes rotation {
		from {
				-webkit-transform: rotate(0deg);
		}
		to {
				-webkit-transform: rotate(359deg);
		}
}
</style>
<body>
	<c:if test="${message != null}">
		<div class="alert alert-dark" role="alert" aria-live="assertive"
			aria-atomic="true"
			style="width: 20rem; position: fixed; bottom: 1rem; right: 1rem; border: 1px solid #343A40; z-index: 100;">
			<div class="row">
				<div class="col-1">
					<img class="loading" src="icons/favicon.png" height="25">
				</div>
				<div class="col">
					<button type="button" class="mr-2 close"
						style="position: absolute; top: 0; right: 0;" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<div class="toast-body" style="color: #343A40;"><b>${message}</b></div>
				</div>
			</div>
		</div>
	</c:if>
</body>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script>
$(document).ready(function () {
    //ALERT FUNCTION
    window.setTimeout(function () {
        $(".alert").fadeTo(500, 0).slideUp(500, function () {
            $(this).remove();
        });
    }, 4000);
    //CHECK PAYMENT TYPE
    if ($(".selectedPaymentType").val() == "card") {
    	$(".cardNumber").show();
    	$(".card").prop("selected", true);
    }
    $('#paymentType').change(
        function () {
            var selectedClass = $('option:selected',
                this).attr('class');
            if (selectedClass == "card") {
                $(".cardNumber").show();
            }else{
                $(".cardNumber").hide();
            }
        });

    //QUANTITY FUNTIONALITIES
    $('.plus').click(function () {
        var product = "." + $(this).data("plus");
        $(product).val(parseInt($(product).val()) + 1);
    });
    $('.minus').click(function () {
        var product = "." + $(this).data("minus");
        $(product).val(parseInt($(product).val()) - 1);
        if ($(product).val() == 0) {
            $(product).val(1);
        }
    });

    //PIZZA CONFIRMATION MODALS
    //HAWAIIAN
    $('#addHawaiian').click(function () {
        $('.hawaiianSize').text(
            $('#hawaiianSize').val());
        $('.hawaiianQuantity').text(
            $('.hawaiian').val());
        if ($('#hawaiianSize').val() == "9") {
            $('.hawaiianPrice').text(
                parseFloat($(
                    '.hawaiian')
                    .val()) * 315);
        } else if ($('#hawaiianSize').val() == "12") {
            $('.hawaiianPrice').text(
                parseFloat($(
                    '.hawaiian')
                    .val()) * 525);
        } else if ($('#hawaiianSize').val() == "15") {
            $('.hawaiianPrice').text(
                parseFloat($(
                    '.hawaiian')
                    .val()) * 735);
        } else {
            $('.hawaiianPrice').text(
                parseFloat($(
                    '.hawaiian')
                    .val()) * 945);
        }
    });
    $('#modalHawaiian').click(function () {
        $('#submitHawaiian').submit();
    });
    //FOUR SEASONS ALL MEAT
    $('#addFourSeasons').click(function () {
        $('.fourSeasonsSize')
            .text(
                $(
                    '#fourSeasonsSize')
                    .val());
        $('.fourSeasonsQuantity').text(
            $('.fourSeasons').val());
        if ($('#fourSeasonsSize').val() == "9") {
            $('.fourSeasonsPrice').text(
                parseFloat($(
                    '.fourSeasons')
                    .val()) * 525);
        } else if ($('#fourSeasonsSize')
            .val() == "12") {
            $('.fourSeasonsPrice').text(
                parseFloat($(
                    '.fourSeasons')
                    .val()) * 735);
        } else if ($('#fourSeasonsSize')
            .val() == "15") {
            $('.fourSeasonsPrice').text(
                parseFloat($(
                    '.fourSeasons')
                    .val()) * 945);
        } else {
            $('.fourSeasonsPrice').text(
                parseFloat($(
                    '.fourSeasons')
                    .val()) * 1155);
        }
    });
    $('#modalFourSeasons').click(function () {
        $('#submitFourSeasons').submit();
    });
    //ROASTED GARLIC AND SHRIMP
    $('#addRoastedGarlicShrimp').click(function () {
        $('.roastedGarlicShrimpSize')
            .text(
                $(
                    '#roastedGarlicShrimpSize')
                    .val());
        $('.roastedGarlicShrimpQuantity')
            .text(
                $(
                    '.roastedGarlicShrimp')
                    .val());
        if ($('#roastedGarlicShrimpSize')
            .val() == "9") {
            $('.roastedGarlicShrimpPrice')
                .text(
                    parseFloat($(
                        '.roastedGarlicShrimp')
                        .val()) * 420);
        } else if ($(
            '#roastedGarlicShrimpSize')
            .val() == "12") {
            $('.roastedGarlicShrimpPrice')
                .text(
                    parseFloat($(
                        '.roastedGarlicShrimp')
                        .val()) * 630);
        } else if ($(
            '#roastedGarlicShrimpSize')
            .val() == "15") {
            $('.roastedGarlicShrimpPrice')
                .text(
                    parseFloat($(
                        '.roastedGarlicShrimp')
                        .val()) * 840);
        } else {
            $('.roastedGarlicShrimpPrice')
                .text(
                    parseFloat($(
                        '.roastedGarlicShrimp')
                        .val()) * 1050);
        }
    });
    $('#modalRoastedGarlicShrimp').click(function () {
        $('#submitRoastedGarlicShrimp').submit();
    });

    //PASTA CONFIRMATION MODALS
    //CHICKEN ALFREDO
    $('#addChickenAlfredo').click(function () {
        $('.chickenAlfredoSize').text(
            $('#chickenAlfredoSize')
                .val());
        $('.chickenAlfredoQuantity').text(
            $('.chickenAlfredo').val());
        if ($('#chickenAlfredoSize').val() == "Regular") {
            $('.chickenAlfredoPrice')
                .text(
                    parseFloat($(
                        '.chickenAlfredo')
                        .val()) * 245);
        } else {
            $('.chickenAlfredoPrice')
                .text(
                    parseFloat($(
                        '.chickenAlfredo')
                        .val()) * 420);
        }
    });
    $('#modalChickenAlfredo').click(function () {
        $('#submitChickenAlfredo').submit();
    });
    //SHRIMP ALFREDO
    $('#addShrimpAlfredo').click(function () {
        $('.shrimpAlfredoSize').text(
            $('#shrimpAlfredoSize')
                .val());
        $('.shrimpAlfredoQuantity').text(
            $('.shrimpAlfredo').val());
        if ($('#shrimpAlfredoSize').val() == "Regular") {
            $('.shrimpAlfredoPrice')
                .text(
                    parseFloat($(
                        '.shrimpAlfredo')
                        .val()) * 245);
        } else {
            $('.shrimpAlfredoPrice')
                .text(
                    parseFloat($(
                        '.shrimpAlfredo')
                        .val()) * 420);
        }
    });
    $('#modalShrimpAlfredo').click(function () {
        $('#submitShrimpAlfredo').submit();
    });
    //SPAGHETTI AND MEATBALLS
    $('#addSpaghettiMeatballs').click(function () {
        $('.spaghettiMeatballsSize')
            .text(
                $(
                    '#spaghettiMeatballsSize')
                    .val());
        $('.spaghettiMeatballsQuantity')
            .text(
                $(
                    '.spaghettiMeatballs')
                    .val());
        if ($('#spaghettiMeatballsSize')
            .val() == "Regular") {
            $('.spaghettiMeatballsPrice')
                .text(
                    parseFloat($(
                        '.spaghettiMeatballs')
                        .val()) * 210);
        } else {
            $('.spaghettiMeatballsPrice')
                .text(
                    parseFloat($(
                        '.spaghettiMeatballs')
                        .val()) * 380);
        }
    });
    $('#modalSpaghettiMeatballs').click(function () {
        $('#submitSpaghettiMeatballs').submit();
    });
});
</script>
</html>