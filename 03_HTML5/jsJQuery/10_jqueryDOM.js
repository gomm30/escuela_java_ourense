// jQuery(...) se abrevia como $(...)
jQuery(document).ready(function () {
    $("article").hide();
    $("body").append("<h1 id='movida'>NO CLIQUES AQUÍ</h1>");
    $("#movida").click(function () {
        $("body").fadeOut(3000);
        // $("body").html("");
        // $("body").append("<h1 style='background-color:transparent !important'><span style='display:block; transform: rotate(90deg);font-size: 10em; margin: 0; padding: 0;'>:(</span><br/>¿Por qué has hecho eso...?</h1>");
        // $("body").css({ "height": "100vh", "display": "flex", "justify-content": "center", "align-items": "center" });
    });
    jQuery('section').append("<div><p>LEYENDA DE LO QUE SEA</p></div>");
    $('tr').append("<td>Info</td>");
    $(".articulo").append("<p>UN PÁRRAFO EN CADA ELEMENTO CON CLASS ARTICULO</p>");

    $("td:nth-child(5)").attr("style", "color:white;");
    $("td:nth-child(5)").css("background-color", "red");

    $("td:nth-child(5)").click(() => { alert('un click de jquery') });

    $("#otro_menu").html("<h2>Menú de artículo</h2><br/><br/>");
    $("#otro_menu").click(function () {
        $("#otro_menu p").slideToggle();
    });

    $("article h4").css("cursor", "pointer");
    // Ocultar todos los articles de entrada y unos botones para mostrarlos.
    $("article h4").click(function () {
        $(this).siblings().slideToggle();
    });

    // Añadir por cada artículo una entrada en el menú #otro_menu
    $("article").each(function (index) {
        let idArticulo = "articulo_menu_" + index;
        $(this).attr("id", idArticulo);
        $("#otro_menu").append("<a href='#" + idArticulo + "' class='enlace-articulo'>Artículo nº" + index + "</a>");
    });

    // Al clicar sobre los enlaces de los artículos del menú desplegar los artículos.
    $("#otro_menu a").click(function () {
        let id_articulo = $(this).attr("href");
        $("article").hide();
        $(id_articulo).slideToggle();
        
    });

    // Ejemplo German
    // $("article, section > section").each(function (index) {
    //     let id_articulo = $(this).attr("id");
    //     $(this).slideUp();
    //     $(this).attr("id", id_articulo);
    //     $("#otro_menu").append("<a id='enlace_" + id_articulo + "' href='#" + id_articulo
    //     +"' class='enlace_Articulo'>Articulo nº " + index + "</a>");
    //     $("#enlace_" + id_articulo).click(function(){
    //         if(typeof(articuloActivo) === "undefined"){
    //             $("#" + idArticulo).slideDown(1500);
    //         }else{
    //             $(articuloActivo).slideUp(800, function(){
    //                 $("#" + id_articulo).slideDown(1500);
    //             });
    //         }
    //         articuloActivo = $("#" + idArticulo);
    //     });
    // });

    // var articuloActivo;

});