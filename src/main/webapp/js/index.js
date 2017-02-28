/**
 * Created by nikolaykombarov on 12.01.17.
 */

function main() {
    $container = $(".container");

    $container.hide();
    $container.fadeIn(1000);


}

$(document).ready(function () {

    main();

    $("h2").on({
        mouseenter: function() {
            $("[href]").fadeToggle("slow");
        },
        mouseleave: function() {
            $("[href]").fadeToggle("slow");
        }
    })
});

