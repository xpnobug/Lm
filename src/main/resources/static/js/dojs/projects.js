$(function (){
    initUser();
    function initUser(){
        $.post("/pro/proshow",getAll,"JSON")
        function getAll(data){
            var $row=$("#row");
            $(data).each(function (){
                $("#row").append("<div class='col-md-4 col-sm-6 col-xs-6 padding-0 mix tag"+this.tagid+"' style='display: inline-block' >\n" +
                    "                    <a href='/pro/proid?t_id="+this.pro_id+"'>\n" +
                    "                        <div class=\"grid\">\n" +
                    "                            <figure class=\"effect-sarah\">\n" +
                    "                                <img class=\"img-sarah\" src='"+this.pro_img+"' alt=\"\" style='width: 390px;height: 260px;'/>\n" +
                    "                                <figcaption>\n" +
                    "                                    <h2>"+this.pro_title+"</h2>\n" +
                    "                                    <p>"+this.pro_present+"</p>\n" +
                    "                                </figcaption>\n" +
                    "                            </figure>\n" +
                    "                        </div>\n" +
                    "                    </a>\n" +
                    "                </div>")

            })
        }
    }
})