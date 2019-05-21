$(document).ready(function(){
    var date_input=$('input[name="date"]');
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";

    date_input.datepicker(
        {

            format: 'dd/mm/yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true,
        })
})

$( function() {
    $('#timepicker1').timepicki();
} );


var $tbody = document.querySelector("tbody");
var $datetimeInput = document.querySelector("#datetime");
var $searchButton = document.querySelector("#search");


$searchButton.addEventListener("click", handleSearchButtonClick);

var filteredUFOData = data;

function renderTable() {

    $tbody.innerHTML = "";

    for (var i=0; i<filteredUFOData.length; i++) {

        var UFOdata = filteredUFOData[i];

        var fields = Object.keys(UFOdata);

        var $row = $tbody.insertRow(i);

        for (var j = 0; j < fields.length; j++) {


            var field = fields[j];

            var $cell = $row.insertCell(j);

            $cell.innerText = UFOdata[field];
        }
    }
}
function handleSearchButtonClick() {

    var filterDatetime = $datetimeInput.value;

    filteredUFOData = data.filter(function(UFOdata) {

        var UFOdatetime = UFOdata.datetime;

        return UFOdatetime === filterDatetime;

    });
    renderTable();
}
renderTable();