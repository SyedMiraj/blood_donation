<#include "header.ftl">

<link rel="stylesheet" type="text/css" href="/css/blood_donation.css">
	<link rel="stylesheet" type="text/css" href="/css/menu_sideslide.css" />
	<link rel="stylesheet" type="text/css" href="/css/filter.css">
	<link rel="stylesheet" type="text/css" href="/css/datepicker.css">
	<link rel="stylesheet" type="text/css" href="/css/datatable.css">
	<link rel="stylesheet" type="text/css" href="/css/custom-donation.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
	<!--[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

         <div class="container reports">
            <div class="content-wrap">
                <div class="content">
                    <main class="cd-main-content">
                        <div class="cd-tab-filter-wrapper">
                            <div class="cd-tab-filter">
                                <div class="buttons-tog">
                                    <span class="butt-tog map-one active-tog-butt" ><i class="fa fa-map" aria-hidden="true"></i></span>
                                    <span class="butt-tog list-one" id="hoho"><i class="fa fa-list-alt" aria-hidden="true"></i></span>
                                </div>
                            </div>
                        </div>

                        <div class="cd-filter">
                            <form>
                                <div class="cd-filter-block">
                                    <div class="cd-filter-content">
                                        <div class="cd-text cd-filters">
                                            <input id="area" class="filter" type="text" placeholder="Area">
                                        </div>
                                        <div class="datepiker">
                                            <div class="datepiker_to">
                                                <div class="group">
                                                    <select class="dt_input" id="bloodGr">
                                                        <option value="">Select Blood Group</option>
                                                        <option value="1">A+ (A positive)</option>
                                                        <option value="2">A- (A minus)</option>
                                                        <option value="3">B+ (B positive)</option>
                                                        <option value="4">B- (B minus)</option>
                                                        <option value="5">O+ (O positive)</option>
                                                        <option value="6">O- (O minus)</option>				       
                                                        <option value="7">AB+ (AB positive)</option>
                                                        <option value="8">AB- (AB minus)</option>
                                                    </select>
                                                </div>
                                        </div>
                                        </div>
                                    </div>
                                    <!-- cd-filter-content -->
                                </div>
                                
                                <div class="cd-filter-block">
                                    <span class="filter_text"><b>Select preferred zone<b></span>
                                    <div class="cd-filter-content">
                                        <div class="cd-select cd-filters">
                                            
                                            <div class="status-filter">
                                                <div class="status-inner">
                                                    <span class="open clicked">Around 5 KM<i class="fa fa-check"></i></span>
                                                    <span class="closed">Around 10 KM<i class="fa fa-check"></i></span>
                                                    <span class="processing">Around 20 KM<i class="fa fa-check"></i></span>
                                                    <span class="approved"> All Around<i class="fa fa-check"></i></span>
                                                </div>
                                            </div>

                                        </div>
                                        <!-- cd-select -->
                                    </div>
                                    <!-- cd-filter-content -->
                                </div>
                                <div class="clearfix">                                                
                                    <input type="button" id = "search" value="Search">
                                    <input type="button" id = "clear" value="Clear">
                                </div>
                            </form>

                            <a href="#filter" class="cd-close"><i class="fa fa-times" aria-hidden="true"></i></a>

                        </div>
                        <!-- cd-filter -->
                        <div class="cd-gallery">
                            <div class="loaded-expense">
                                <div class="add-expense-parent visible-xs" style="float:left;">
                                    <div class="add-expense-action"><a href="newreport.html" style="color:white;">New Report<!--<i class="fa fa-chevron-down"></i>--></a></div>
                                </div>
                                <div id ="map">
                                    
                                </div>
                        <div class="table-responsive" id="this-one" style="margin-top:40px;">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th scope="col" style="font-size:1.3em;"><i class="fa fa-check"></i></th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Blood Group</th>
                                            <th scope="col">Mobile</th>
                                            <th scope="col">Last Donate Date</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <th scope="row">1</th>
                                                <td>Mark</td>
                                                <td>Otto</td>
                                                <td>@mdo</td>
                                                <td>@mdo</td>
    </tr>                                   </tr>
                                        </tbody>
                                    </table>
                                    <br class="hidden-lg">
                                    <br class="hidden-lg">
                                </div>
                                
                            </div>
                        </div>

                        <a href="#filter" class="cd-filter-trigger"><i class="fa fa-filter"></i> Filters</a>

                    </main>
                </div>
<#include "footer.ftl">
            </div>
        </div>

        <script src="/js/jquery-2.1.1.js"></script>
        <script src="/js/common.js"></script>
        <!-- Datepiker -->
        <script src="/js/datepicker.js"></script>
        <!-- Data Table -->
        <script src="/js/data-table.js"></script>
        <script src="/js/custom-donation.js"></script>
        <script src="/js/donate.js"></script>
        <script>              
              function initAutocomplete() {
                var map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: 23.8, lng: 90.4},
                zoom: 9,
                mapTypeId: 'roadmap'
              });

            // Create the search box and link it to the UI element.
            var input = document.getElementById('area');
            var searchBox = new google.maps.places.SearchBox(input);

            // Bias the SearchBox results towards current map's viewport.
       

          // For each place, get the icon, name and location.
          var bounds = new google.maps.LatLngBounds();
          places.forEach(function(place) {
            if (!place.geometry) {
              console.log("Returned place contains no geometry");
              return;
            }
            var icon = {
              url: place.icon,
              size: new google.maps.Size(71, 71),
              origin: new google.maps.Point(0, 0),
              anchor: new google.maps.Point(17, 34),
              scaledSize: new google.maps.Size(25, 25)
            };

            // Create a marker for each place.
            
        });
      };
      $("#hoho").on('click', function(){
                        $(this).showList();

    });

     $.fn.showList = function() {
        $('.table-responsive').show();
    }; 
        </script>
        
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBmaEWgyLRg3rvul70hDILbQ-aFzmiJnbA&libraries=places&callback=initAutocomplete"
         async defer></script>
        <script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"/>
    
