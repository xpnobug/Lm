$(function (){
    initUser();
    function initUser(){
        $.post("/art/postshow",getAll,"JSON")
        function getAll(data){
            var $row=$("#post");
            $(data).each(function (){
                $("#post").append("<div class=\"col-md-4 col-sm-6\">\n" +
                    "                <div class=\"services-detail\">\n" +
                    /*"                    <div class=\"article-icon\">\n" +
                    "                        <span><a href=\"\" rel=\"category tag\">冒险生活</a></span>\n" +
                    "                    </div>\n" +*/
                    "                    <a href='/art/postinfo?id="+this.a_id+"'>\n" +
                    "                        <h4>"+this.title+"</h4>\n" +
                    "                        <hr>\n" +
                    "                        <p>"+this.present+"</p>\n" +
                    "                        <span>"+this.cdate+"</span>\n" +
                    "                        <span>阅读(0)</span>\n" +
                    "                        <span>评论(0)</span></a>\n" +
                    "                </div>\n" +
                    "            </div>")

            })
        }
    }
})