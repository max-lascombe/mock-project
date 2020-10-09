"use strict";

var acceptedOrder = false;
var currentOrderId = null;

var pendingOrderId = null;
var pendingOrderDeliveryAddress = null;
var pendingOrderRestaurantAddress = null;

function get_orders(){
		$.get( "/checkForOrders", function( data ) {
  		$( ".result" ).html( data );
		var json = JSON.parse(data.orderList);
		var ordInd = -1;
		for(var i = 0; i < json.length; i++){
			if(json[i].Status === "available"){
				ordInd = i;
				break;
			}
		}
		
		//alert(json[0].DeliveryInfo.Address); "orderIdText"
		if(data.available && !($('#alertModal').hasClass('show'))){
			pendingOrderId = json[ordInd].OrderId;
			pendingOrderDeliveryAddress = json[ordInd].DeliveryInfo.Address;
			pendingOrderRestaurantAddress = json[ordInd].RestaurantInfo.Address;
			$('#alertText').html("A food order is ready to be picked up at " + pendingOrderRestaurantAddress)
			$("#alertModal").modal()
  			//alert( data.available );
		}
	});
}

function get_orders_error(){
	$('#send').prop('disabled', true);
	$.get( "/checkForOrders", function( data ) {
	  $( ".result" ).html( data );
	var json = JSON.parse(data.orderList);
	var ordInd = -1;
	for(var i = 0; i < json.length; i++){
		if(json[i].Status === "available"){
			ordInd = i;
			break;
		}
	}
	
	//alert(json[0].DeliveryInfo.Address); "orderIdText"
	if(data.available){
		$('#alertText').html("Oops, another driver has already started delivering this order. Another food order is ready to be picked up at " + json[ordInd].DeliveryInfo.Address)
		pendingOrderId = json[ordInd].OrderId;
		pendingOrderDeliveryAddress = json[ordInd].DeliveryInfo.Address;
		pendingOrderRestaurantAddress = json[ordInd].RestaurantInfo.Address;
		$("#alertModal").modal()
		  //alert( data.available );
	}
});
}

function getTextForId(id) {
	if(id == 1)
		return "Picked Up";
	else if(id == 2)
		return "Almost There";
	else if(id == 3)
		return "I'm Here";
		
	return "";	
}

$(document).ready(function() {

	$('#send').prop('disabled', true);
	$('#exampleRadios1').prop('disabled', true);
	$('#exampleRadios2').prop('disabled', true);
	$('#exampleRadios3').prop('disabled', true);

	setInterval(function(){
		if(!acceptedOrder && !($('#alertModal').hasClass('show'))){
			get_orders();
		}
		}, 3000);

	$('#finish').click( () => {
		$('#orderIdText').html("Order ID: ")
		$('#deliverAddressText').html("Delivery Address: ");
		$('#pickupAddressText').html("Restaurant Pickup Address: ")
		pendingOrderId = null;
		pendingOrderDeliveryAddress = null;
		pendingOrderRestaurantAddress = null;
		currentOrderId = null;
		acceptedOrder = false;
		$('#send').prop('disabled', true);
		$('#exampleRadios1').prop('checked', false); // Unchecks it
		$('#exampleRadios2').prop('checked', false); // Unchecks it
		$('#exampleRadios3').prop('checked', false); // Unchecks it
		$('#exampleRadios1').prop('disabled', true);
		$('#exampleRadios2').attr("disabled", true);
		$('#exampleRadios3').attr("disabled", true);
	});

	$('#acceptOrderBtn').click( () => {
		fetch("https://cors-anywhere.herokuapp.com/http://delivery-service-api.us-e2.cloudhub.io/getOrder/" + pendingOrderId) // Call the fetch function passing the url of the API as a parameter
		.then(res=>res.json()).then(function(res) {
			if(res.Status === 'available'){
				
				$('#orderIdText').html("Order ID: " + pendingOrderId)
				$('#deliverAddressText').html("Delivery Address: " + pendingOrderDeliveryAddress);
				$('#pickupAddressText').html("Restaurant Pickup Address: " + pendingOrderRestaurantAddress)
				currentOrderId = pendingOrderId;
				acceptedOrder = true;
				$('#send').prop('disabled', false);
				$('#exampleRadios1').prop('disabled', false);

				
			}else{
				get_orders_error();
			}
			console.log(res);
		})
		.catch(function() {
			// This is where you run code if the server returns any errors
		});

		/* $('#orderIdText').html("Order ID: " + json[ordInd].OrderId)
		$('#addressText').html("Customer Address: " + json[ordInd].DeliveryInfo.Address)
		currentOrderId = json[ordInd].OrderId;
		acceptedOrder = true; */
	});

	$('#send').click(function() {
		var sel = $('input[type=radio]:checked').val();
		var updateTxt = getTextForId(sel);
		if(sel == 1){
			$("#etaModal").modal();
		}else{	
			fetch("https://cors-anywhere.herokuapp.com/http://delivery-service-api.us-e2.cloudhub.io/update/" + currentOrderId, {
			  method: 'post',
			  headers: {
			    'Content-Type': 'application/json'
			  },
			  body: JSON.stringify({"Update": updateTxt})
			}).then(res=>res.json())
			  .then(res => {
				  console.log(res);
			  });

			//send a popup
			$('#msgText').html("Order Update \"" + updateTxt + "\" sent")
			$("#msgModal").modal()
		}
	})

	$('#sendETA').click(function(){
		var updateTxt = getTextForId(1);

		fetch("https://cors-anywhere.herokuapp.com/http://delivery-service-api.us-e2.cloudhub.io/getOrder/" + pendingOrderId) // Call the fetch function passing the url of the API as a parameter
		.then(res=>res.json()).then(function(res) {
			if(!(res.Status === 'available')){
				
				$('#orderIdText').html("Order ID: ")
				$('#deliverAddressText').html("Delivery Address: ");
				$('#pickupAddressText').html("Restaurant Pickup Address: ")
				pendingOrderId = null;
				pendingOrderDeliveryAddress = null;
				pendingOrderRestaurantAddress = null;
				currentOrderId = null;
				acceptedOrder = false;
				$('#msgText').html("Error, order already in progress")
				$("#msgModal").modal()
				get_orders_error();
				
			}
			console.log(res);
		})
		.catch(function() {
			// This is where you run code if the server returns any errors
		});

		fetch("https://cors-anywhere.herokuapp.com/http://delivery-service-api.us-e2.cloudhub.io/update/" + currentOrderId, {
			  method: 'post',
			  headers: {
			    'Content-Type': 'application/json'
			  },
			  body: JSON.stringify({"Update": updateTxt})
			}).then(res=>res.json())
			  .then(res => {
				  console.log(res);
			  });

		var eta = $('#etaField').val();
		if(eta.length < 1){
			eta = "30"
		}
		fetch("https://cors-anywhere.herokuapp.com/http://delivery-service-api.us-e2.cloudhub.io/ETA/" + currentOrderId, {
			method: 'post',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ "ETA": eta })
			}).then(res=>res.json())
			.then(res => {
				console.log(res);
			});
		$('#exampleRadios1').prop('disabled', true);
		$('#exampleRadios1').prop('checked', false); // Unchecks it
		$('#exampleRadios2').prop('disabled', false);
		$('#exampleRadios3').prop('disabled', false);
		//send a popup
		$('#msgText').html("Order update \"" + updateTxt + "\" sent with ETA of " + eta + " minutes")
		$("#msgModal").modal()
	})
});
