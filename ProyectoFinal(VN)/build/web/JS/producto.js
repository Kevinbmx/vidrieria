$(document).ready(function () {
    $(".pro").remove();
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: "api/producto/",
        success: function (data) {
            data = typeof data == 'string' ? JSON.parse(data) : data;
            console.log(JSON.stringify(data));
            var htmlTemplate = $("#product-template").html();
            var generador = _.template(htmlTemplate);
            for (var i in data) {
                var producto = data[i];
                var html = generador(producto);
                $("#productos").append(html);
            }
        }
    });

});
function loadCatalog() {


}
