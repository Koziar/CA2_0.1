function hideTables() {

    $('#companyTable body').hide();
    $(this).parents('table').find('body').toggle();

}
function resetFields() {
    $("#error").html("").hide();
    //$("#quote").val("");
}
$(document).ready(function () {
    $("#error").hide();
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
});
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


