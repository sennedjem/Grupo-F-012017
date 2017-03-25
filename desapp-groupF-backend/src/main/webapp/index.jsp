<html>
<head>
<title>Google Map Hello World Example</title>
<style type="text/css">
div#map_container{
	width:50%;
	height:50%;
}
</style>
<script type="text/javascript"
   src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

<script type="text/javascript">
  function loadMap() {
    var homelatlng = new google.maps.LatLng(-34.8192083, -58.26899709999998);
    var marketlatlng = new google.maps.LatLng(-34.7583823, -58.275060800000006);

    var myOptions = {
      zoom: 11,
      center: homelatlng,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    var map = new google.maps.Map(document.getElementById("map_container"),myOptions);

    var homeMarker = new google.maps.Marker({
      position: homelatlng,
      map: map,
      title:"Casa"
    });

    var marketMarker = new google.maps.Marker({
      position: marketlatlng,
      map: map,
      title:"Mercado cercano"
    });

  }
</script>
</head>

<body onload="loadMap()">
<div id="map_container"></div>
</body>

</html>
