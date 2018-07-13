$(document).ready(function () {

    // function call for clear field
    $("#search").on('click', function () {
        $(this).searchUsers();
    });

    // function call for clear field
    $("#clear").on('click', function () {
        $(this).clearField();
    });

    $.fn.clearField = function () {
        document.getElementById("area").value = "";
        document.getElementById("bloodGr").value = "";
    };

    $.fn.searchUsers = function () {
        var geocoder = new google.maps.Geocoder();
        var address = document.getElementById("area").value;
        geocoder.geocode({'address': address}, function (results, status) {

            if (status == google.maps.GeocoderStatus.OK) {
                var latitude = results[0].geometry.location.lat();
                var longitude = results[0].geometry.location.lng();

                var collectionReq = new Object();
                collectionReq['latitude'] = latitude;
                collectionReq['longitude'] = longitude;

                if ($(".closed").hasClass("clicked")) {
                    collectionReq['range'] = '10';
                } else if ($(".processing").hasClass("clicked")) {
                    collectionReq['range'] = '20';
                } else if ($(".approved").hasClass("clicked")) {
                    collectionReq['range'] = '50';
                } else {
                    collectionReq['range'] = '5';
                }

                //collectionReq['range']= $("#range").val();
                collectionReq['bloodGroup'] = $('#bloodGr :selected').val();
                
                $.ajax({
                    type: "POST",
                    url: "/donors",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    data: JSON.stringify(collectionReq),
                    success: function (userList) {
                        $(".cd-gallery").html(userList.result);
                    },
                    error: function (userList) {
                        alert("fail!");
                    }
                });

            }
        });



    };


});
