$('.table').hide();
$('.map-one').click(function() {
   $(this).addClass('active-tog-butt');
   $('.list-one').removeClass('active-tog-butt');
   $('#this-one').removeClass('table-responsive');
   $('.table').hide();
   function initMap() {
        var uluru = {lat: 23.6850, lng: 90.3563};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: uluru
        });
//        var marker = new google.maps.Marker({
//          position: uluru,
//          map: map
//        });
    // add to clusterd 
    var markers = locations.map(function(location, i) {
          return new google.maps.Marker({
            position: location,
            label: labels[i % labels.length]
          });
        });

        // Add a marker clusterer to manage the markers.
        var markerCluster = new MarkerClusterer(map, markers,
            {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
      }
      var locations = [
        {lat: -31.563910, lng: 147.154312},
        {lat: -33.718234, lng: 150.363181},
        {lat: -33.727111, lng: 150.371124},
        {lat: -33.848588, lng: 151.209834},
        {lat: -33.851702, lng: 151.216968},
        {lat: -34.671264, lng: 150.863657},
        {lat: -35.304724, lng: 148.662905},
        {lat: -36.817685, lng: 175.699196},
        {lat: -36.828611, lng: 175.790222},
        {lat: -37.750000, lng: 145.116667},
        {lat: -37.759859, lng: 145.128708},
        {lat: -37.765015, lng: 145.133858},
        {lat: -37.770104, lng: 145.143299},
        {lat: -37.773700, lng: 145.145187},
        {lat: -37.774785, lng: 145.137978},
        {lat: -37.819616, lng: 144.968119},
        {lat: -38.330766, lng: 144.695692},
        {lat: -39.927193, lng: 175.053218},
        {lat: -41.330162, lng: 174.865694},
        {lat: -42.734358, lng: 147.439506},
        {lat: -42.734358, lng: 147.501315},
        {lat: -42.735258, lng: 147.438000},
        {lat: -43.999792, lng: 170.463352}
      ]
   $('#map').show();
   document.getElementById('hoho').style.pointerEvents = 'auto';
});
$('.list-one').click(function(){
   $(this).addClass('active-tog-butt');
   $('.map-one').removeClass('active-tog-butt');
   $('#this-one').addClass('table-responsive');
   $('#map').hide();
   $('.table').show();
   document.getElementById('hoho').style.pointerEvents = 'none';
});