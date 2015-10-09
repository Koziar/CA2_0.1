
//Show person by phone
$(document).ready(function () {
    $("#buttonphone").click(function () {
        var index = $("#phone").val();
        //var $url = "/api/quote/" + $index;//servlet url
        var $url = "api/person/complete/phone/" + index;
        var $show = $("#showPhone");
       
        
            $.ajax({
                type: "GET",
                url: $url
//                dataType: 'json'
            }).done(function (phonePerson) {
                alert(index + "done");
            }).fail(function (error) {
                alert("fail" + index + "Url: " + $url);
            });
        
    });

});



