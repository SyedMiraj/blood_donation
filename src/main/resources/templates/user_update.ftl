<#include "header.ftl">
<div style="width: 100%">
<div class="regi-wrap">
	<div class="login-html">
		<input id="tab-2" type="radio" name="tab" class="sign-up" checked><label for="tab-2" class="tab">Update User Form</label>
		<div class="login-form">
			<div class="sign-up-htm">
			<div class="login-form">
							<div class="group">
								<input id="userid" type="hidden" class="userid" value="${user.id?if_exists}">	
							</div>
							<div class="group">
								<input id="name" type="text" class="input" value="${user.name?if_exists}" placeholder="First Name">	
							</div>
							<div class="group">
								<input id="dob" type="text" class="input" value="${user.dateOfBith?if_exists}" placeholder="Date of Birth">
							</div>
							<div class="group">
								<input id="mobile" type="text" class="input" value="${user.mobileNumber?if_exists}" placeholder="Mobile No">
							</div>				
							<div class="group">
								<select class="form-control" id="bld-group" value="${user.bloodGroup?if_exists}">
								   <option value="null">Select your blood group</option>
							       <option value="1" <#if user.bloodGroup?if_exists?contains("A+")>selected</#if>>A+ (A positive)</option>
							       <option value="2" <#if user.bloodGroup?if_exists?contains("A-")>selected</#if>>A- (A minus)</option>
							       <option value="3" <#if user.bloodGroup?if_exists?contains("B+")>selected</#if>>B+ (B positive)</option>
							       <option value="4" <#if user.bloodGroup?if_exists?contains("B-")>selected</#if>>B- (B minus)</option>
							       <option value="5" <#if user.bloodGroup?if_exists?contains("O+")>selected</#if>>O+ (O positive)</option>
							       <option value="6" <#if user.bloodGroup?if_exists?contains("O-")>selected</#if>>O- (O minus)</option>				       
							       <option value="7" <#if user.bloodGroup?if_exists?contains("AB+")>selected</#if>>AB+ (AB positive)</option>
							       <option value="8" <#if user.bloodGroup?if_exists?contains("AB-")>selected</#if>>AB- (AB minus)</option>
							    </select>
							</div>
							<div class="group">
								<input id="ldd" type="text" class="input" value="${user.lastBloodDonate?if_exists}" placeholder="Last Blood Donation Date">
							</div>
							<div class="group">
								<input id="position" type="text" class="input" data-location="dummy" placeholder="Location (Please Choose From Map)" disabled>
							</div>
							<div class="group">
								<input type="submit" class="button" id="updateuser" value="Update User">
							</div>
						</div>
						</div>
					</div>
			</div>
			<div id="gmap"></div>
			</div>
			</div>
			<script>
			window.onload = function() {
			  	var clickLat = ${user.latitude?if_exists};
		        var clickLon = ${user.longitude?if_exists};
		        
		        var geocoder;
		        geocoder = new google.maps.Geocoder();
		        var latlng = new google.maps.LatLng(clickLat, clickLon);
		
		        geocoder.geocode(
		            {'latLng': latlng}, 
		            function(results, status) {
		                if (status == google.maps.GeocoderStatus.OK) {
		                        if (results[0]) {
		                            $("#position").val(results[0].formatted_address) ;
		                            $("#position").data("location", clickLat+","+clickLon);
		                            $("#position-ok").show();
		                    		$("#position-error").hide();
		                    		positionOkay = true;
		                        }else  {
		                            alert("address not found");
		                        }
		                }else {
		                    alert("Geocoder failed due to: " + status);
		                }
		            }
		        );
		        };
			</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/datepicker/0.6.4/datepicker.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAUp5JapQeoA-T8IeRhwNWfKsEVduzLSw4">
	</script>
	<script src="/js/registration.js"></script>

<#include "footer.ftl">