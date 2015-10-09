function hideTables() {

    $('#companyTable body').hide();
    $(this).parents('table').find('body').toggle();

}

function resetFields() {
    $("#error").html("").hide();
    $("#errorEditor").html("").hide();
    //$("#quote").val("");
}
$(document).ready(function () {
    $("#error").hide();
    resetFields();
    $("#loadCompanies").click(function () {
        resetFields();
        $.ajax({
            type: "GET",
            url: "api/company/complete"
        }).done(function (companies) {

            makeTable($("#companyTable"), companies);

        }).fail(function (error) {
            var json = error.responseJSON;
            $("#error").show().html(json.message);
        });
    });

    $("#createNewCompanybtn").click(function () {

        createNewCompany();

    });
});

function createNewCompany() {

    var name = $("#newCompanyName").val();
    var cvr = $("#newCompanyCVR").val();
    var city = $("#newCompanyCity").val();
    var zipcode = $("#newCompanyZipcode").val();
    var street = $("#newCompanyStreet").val();
    var additionalInfoAddress = $("#newCompanyAddressAdditionalInfo").val();
    var email = $("#newCompanyEmail").val();
    var phone1 = $("#newCompanyPhone1").val();
    var phone1description = $("#newCompanyPhone1description").val();
    var phone2 = $("#newCompanyPhone2").val();
    var phone2description = $("#newCompanyPhone2description").val();
    var phones = [{
            number: phone1,
            description: phone1description
        },
        {
            number: phone2,
            description: phone2description
        }];
    var description = $("#newCompanyDescription").val();
    var marketValue = $("#newCompanyMarketValue").val();
    var numEmployees = $("#newCompanyNumEmployees").val();
    var additionalInfo = $("#newCompanyAdditionalInfo").val();

    var q = JSON.stringify({
        name: name,
        cvr: cvr,
        city: city,
        zipcode: zipcode,
        street: street,
        email: email,
        phones: phones,
        additionalInfoAddress: additionalInfoAddress,
        description: description,
        marketValue: marketValue,
        numEmployees: numEmployees,
        additionalInfo: additionalInfo
    });
    
    $.ajax({
        type: "POST",
        url: "api/company",
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

function makeTable(container, data) {
        var table = $("#companyTable");
        $.each(data, function (rowIndex, r) {
                var row = $("<tr/>");
                $.each(r, function (colIndex, c) {
            //return(c === "phones");
                        row.append($("<t" + (rowIndex == 0 ?  "h" : "d") + "/>").text(c));
                });
                table.append(row);
        });
        return container.append(table);
}
;


