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
                        <#if users??>
                        <#list users as user>
                        <tr>
                            <th scope="row"><i class="fa fa-check"></i></th>
                            <td>${user.name?if_exists}</td>
                            <td>${user.bloodGroup?if_exists}</td>
                            <td>${user.mobileNumber?if_exists}</td>
                            <td>${user.lastBloodDonate?if_exists}</td>
                        </tr>
                        </#list>
                        </#if>
                           
                        </tbody>
                    </table>
                    <br class="hidden-lg">
                    <br class="hidden-lg">
                </div>
                
            </div>
        </div>
        <script>
        	var latitudes = [<#list users as user>${user.latitude},</#list>];
        	var longitudes = [<#list users as user>${user.longitude},</#list>]; 
        	var mobileNumbers = [<#list users as user>'${user.mobileNumber?if_exists}',</#list>];
        	var names = [<#list users as user>'${user.name?if_exists}',</#list>];
        	var latlong = [];
                for (i = 0; i < latitudes.length; i++) {
                        var latt = latitudes[i];
                        var long = longitudes[i];
                        var usermarker = 'Name: '+names[i] + ' Mobile: '+mobileNumbers[i];
                        var locations = [latt, long, usermarker];
                        latlong.push(locations);       		
                    }
          			
                var map = new google.maps.Map(document.getElementById('map'), {
                     zoom: 15,
                     center: new google.maps.LatLng(latlong[0][0], latlong[0][1]),
                     mapTypeControl: false,
                     fullscreenControl: false
                   });

                   var infowindow = new google.maps.InfoWindow();

                   var marker, j;

                   for (j = 0; j < locations.length; j++) { 
                     marker = new google.maps.Marker({
                       position: new google.maps.LatLng(latlong[j][0], latlong[j][1]),
                       map: map
                     });				      

                     google.maps.event.addListener(marker, 'click', (function(marker, j) {
                       return function() {
                         infowindow.setContent(latlong[j][2]);
                         infowindow.open(map, marker);
                       }
                     })(marker, j));				      

                       $('.table-responsive').hide();				      
                   }
       
        </script>