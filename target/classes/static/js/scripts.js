"use strict";

function initMap() {
  const myLatLng = {
    lat: -25.363,
    lng: 131.044,
  };
  const myLatLng2 = {
    lat: -24.363,
    lng: 131.044,
  };
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 4,
    center: myLatLng,
  });
  new google.maps.Marker({
    position: myLatLng,
    map,
    title: "Hello World!",
  });
    new google.maps.Marker({
    position: myLatLng2,
    map,
    title: "Hello World 2!",
  });
}

$(document).ready(function() {

});
