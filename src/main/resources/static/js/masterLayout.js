$(function() {
    $("#student-radio").change(function () {
        console.log("Aluno selecionado");
        $("#specific-form").empty().append($("#student-form").clone().removeClass("hidden"));
    });

    $("#professor-radio").change(function () {
        console.log("Professor selecionado");
        $("#specific-form").empty().append($("#professor-form").clone().removeClass("hidden"));
    });
});