$(function (){
    initUser();
    function initUser(){
        $.post("/typing/list",getAll,"JSON")
        function getAll(data){
            var $typings=$("#typings");
            $(data).each(function (){
                $("#typings").append(
                    "        <p>"+this.typ_name+"</p>" +
                    "        <p id='typing'>"+this.typ_content+"</p>" +
                    "        <h2><span class='typing'></span></h2>" +
                    "        <noscript><h2>"+this.typ_content+"</h2></noscript>")

            })

        }
    }
})