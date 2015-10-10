

$(document).ready(function () {
    $("#error").hide();
    resetFields();
    
    $("#createNewPersonbtn").click(function () {

        createNewPerson();

    });
});


function createNewPerson() {

    var fName = $("#newPersonFirstName").val();
    var lName = $("#newPersonLastName").val();
    var email = $("#newPersonemail").val();
    var phone1 = $("#newPersonPhone1").val();
    var phone1description = $("#newPersonPhone1description").val();
    var phone2 = $("#newPersonPhone2").val();
    var phone2description = $("#newPersonPhone2description").val();
    var phones = [{
            number: phone1,
            description: phone1description
        },
        {
            number: phone2,
            description: phone2description
        }];
    var city = $("#newPersonCity").val();
    var zipcode = $("#newPersonZipcode").val();
    var street = $("#newPersonStreet").val();
    var additionalInfoAddress = $("#newPersonAddressAdditionalInfo").val();
    var hobby1 = $("#newPersonHobby1").val();
    var hobbydescription1 = $("#newPersonHobbyDescription1").val();
    var hobby2 = $("#newPersonHobby2").val();
    var hobbydescription2 = $("#newPersonHobbyDescription2").val();
    var hobby3 = $("#newPersonHobby3").val();
    var hobbydescription3 = $("#newPersonHobbyDescription3").val();
    var hobbies = [{
            name: hobby1,
            description: hobbydescription1
        },
        {
            name: hobby2,
            description: hobbydescription2
        },
        {
            name: hobby3,
            description: hobbydescription3
        }];

    var q = JSON.stringify({
        fName: fName,
        lName: lName,
        email: email,
        phones: phones,
        city: city,
        zipcode: zipcode,
        street: street,
        additionalInfoAddress: additionalInfoAddress,
        hobbies: hobbies
    });
    
    $.ajax({
        type: "POST",
        url: "api/person",
        data: q,
        contentType: "application/json",
        dataType: "json"

    }).done(function (dataFromServer) {
//        $("#quote").val(dataFromServer.quote);
//        $("#q-id").val(dataFromServer.id);
        console.log("Thats it!!!!!");
    }).fail(function (error) {
//        var json = error.responseJSON;
//        $("#error").show().html(json.message);
        var json = error.responseJSON;
        $("#errorEditor").show().html(json.message);
    });
}
;