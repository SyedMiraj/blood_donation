$(document).ready(function(){

    var nameOkay, dobOkay, mobileOkay, passOkay, groupOkay, positionOkay = false;
	var markers = [];
	var map;
    function initialize() {
        var myLatlng = new google.maps.LatLng(23.6850,90.3563);
        var myOptions = {
            zoom:7,
            center: myLatlng,
            mapTypeId: google.maps.MapTypeId.ROADMAP 
        }
        map = new google.maps.Map(document.getElementById("gmap"), myOptions);
    }  
    
    initialize();
    
	google.maps.event.addListener(map, "click", function(event) {
		setMapOnAll(null);
        var clickLat = event.latLng.lat();
        var clickLon = event.latLng.lng();
        
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
        
      var marker = new google.maps.Marker({
            position: new google.maps.LatLng(clickLat,clickLon),
            map: map
         }); 
      markers.push(marker);
    });
	
	// Sets the map on all markers in the array.
    function setMapOnAll(map) {
      for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
      }
    }
    
    //validation checking
    
    $("#name-ok").hide();
    $("#name-error").hide();    
    $("#dob-ok").hide();
    $("#dob-error").hide();
    $("#mobile-ok").hide();
    $("#mobile-error").hide();
    $("#password-error").hide();
    $("#password-length-error").hide();
    $("#password-ok").hide();
    $("#re-password-ok").hide();
    $("#re-password-error").hide();
    $("#group-ok").hide();
	$("#group-error").hide();
    $("#ldd-ok").hide();
    $("#ldd-error").hide();
    $("#position-ok").hide();
    $("#position-error").hide();
    
    $("#name").focusout(function(){
    	if($(this).val() != ''){
    		$("#name-ok").show();
    		$("#name-error").hide();
    		nameOkay = true;
    	}else{
    		$("#name-error").show();
    		$("#name-ok").hide();
    		nameOkay = false;
    	}
    });
    
    $("#dob").focusout(function(){
    	$("#dob").datepicker().on('change',function(){
        	if($(this).val() != ''){
        		$("#dob-ok").show();
        		$("#dob-error").hide();
        		dobOkay = true;
        	}else{
        		$("#dob-error").show();
        		$("#dob-ok").hide();
        		dobOkay = flase;
        	}    		
    	});
    });
    
    $("#mobile").focusout(function(){
    	if($(this).val() != ''){
    		$("#mobile-ok").show();
    		$("#mobile-error").hide();
    		mobileOkay = true;
    	}else{
    		$("#mobile-error").show();
    		$("#mobile-ok").hide();
    		mobileOkay = false;
    	}
    });
    
    $("#password").focusout(function(){
    	if($(this).val() != ''){
    		if($(this).val().length >= 6){
    			$("#password-ok").show();
        		$("#password-error").hide();
        		$("#password-length-error").hide();
    		}else{
    			$("#password-length-error").show();
        		$("#password-ok").hide();
        		$("#password-error").hide();
    		}  			
    	}else{
    		$("#password-error").show();
    		$("#password-ok").hide();
    		$("#password-length-error").hide();
    	}
    });
    
    $("#retype_password").focusout(function(){
    	if($(this).val() === $("#password").val()){
    		$("#re-password-ok").show();
    		$("#re-password-error").hide();
    		passOkay = true;
    	}else{
    		$("#re-password-error").show();
    		$("#re-password-ok").hide();
    		passOkay = false;
    	}
    });
    
    $("#bld-group").on('change', function(){
    	if($(this).val() != 'null'){
    		$("#group-ok").show();
    		$("#group-error").hide();
    		groupOkay = true;
    	}else{
    		$("#group-ok").hide();
    		$("#group-error").show();
    		groupOkay = false;
    	}
    });
    
    $("#ldd").focusout(function(){
    	$(this).datepicker().on('change',function(){
        	if($(this).val() != ''){
        		$("#ldd-ok").show();
        		$("#ldd-error").hide();
        		lddOkay = true;
        	}else{
        		$("#ldd-error").show();
        		$("#ldd-ok").hide();
        		lddOkay = flase;
        	}    		
    	});
    });
  
    $("#submit").on("click", function(){
    	if(nameOkay && dobOkay && mobileOkay && passOkay && groupOkay && positionOkay){
    		var userData =new Object();
    		userData["name"] = $("#name").val();
    		userData["dateOfBith"] = $("#dob").val();
    		userData["mobileNumber"] = $("#mobile").val();
    		userData["password"] = $("#password").val();
    		userData["latitude"] = $("#position").data("location").split(",")[0];
    		userData["longitude"] = $("#position").data("location").split(",")[1];
    		userData["bloodGroupId"] = $("#bld-group").find(":selected").val();
    		userData["lastBloodDonate"] = $("#ldd").val();
    		
    		$.ajax({
    			  type: "POST",
    			  url: "/api/users",
    			  dataType : "json",
    			  data : JSON.stringify(userData),
    			  contentType : "application/json;charset=utf-8",
    			  success : function(data) {
						window.location.href = "/login";
    			  },
    			  error: function(){
//    				  window.location.reload();
    			  }
    			});
    	}else{
    		if(nameOkay){
    			$("#name-error").show();
    		}
			if(dobOkay){
				$("#dob-error").show();		
    		}
			if(mobileOkay){
				$("#mobile-error").show();
			}
			if(passOkay){
				$("#password-error").show();
			}
			if(groupOkay){
				$("#group-error").show();
			}
			if(positionOkay){
				$("#position-error").show();
			}
    	}
    });
    
    $("#searchh").on('click', function () {
        $(this).searchUser();
    });
    
    $.fn.searchUser = function () {
        var userId = document.getElementById("userid").value;                
        $.ajax({
            type: "GET",
            url: "/api/users/" + userId,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: {userId: userId},
            success: function (user) {
            	$(".sign-up-htm").html(user.result);
            	 console.log(user);
            },
            error: function (user) {
                alert("fail!");
            }
        });
    }; 
    
    
    $("#updateuser").on("click", function(){
    		var userData =new Object();
    		userData["id"] = $("#userid").val();
    		userData["name"] = $("#name").val();
    		userData["dateOfBith"] = $("#dob").val();
    		userData["mobileNumber"] = $("#mobile").val();
    		userData["password"] = $("#password").val();
    		userData["latitude"] = $("#position").data("location").split(",")[0];
    		userData["longitude"] = $("#position").data("location").split(",")[1];
    		userData["bloodGroupId"] = $("#bld-group").find(":selected").val();
    		userData["lastBloodDonate"] = $("#ldd").val();
    		
    		$.ajax({
    			  type: "POST",
    			  url: "/api/users",
    			  dataType : "json",
    			  data : JSON.stringify(userData),
    			  contentType : "application/json;charset=utf-8",
    			  success : function(data) {
						window.location.href = "/login";
    			  },
    			  error: function(){
    				  alert("fail!");
//    				  window.location.reload();
    			  }
    			});
    });
    
});
	