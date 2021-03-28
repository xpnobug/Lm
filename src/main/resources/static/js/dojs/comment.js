function initCom(){
    $.post("/comment/com",successCom,"JSON")
}
//回调函数
function successCom(data){
    //1.选中要添加的标签
    var $mytbody=$("#mytbody");
    //2.添加显示的内容
    if(data.length>0){
        for(var i=0;i<data.length;i++){
            $mytbody.append("<tr>" +
                "<td>" +
                "<div class=\"comment-parent comment-author vcard\">\n" +
                "            <a class=\"pull-left thumb-sm\">\n" +
                "                <img class=\"avatar avatar-32 photo\" alt='"+data[i].author+"' src='"+data[i].img+"'>\n" +
                "            </a>\n" +
                "            <div class=\"m-b m-l-xxl\">\n" +
                "                <div class=\"comment-meta\">\n" +
                "                                        <span class=\"comment-author vcard\">\n" +
                "                                            <b class=\"fn\">\n" +
                "                                                <a href=\"\">"+data[i].author+"</a>\n" +
                "                                            </b>\n" +
                "                                        </span>\n" +
                "                    <div class=\"comment-metadata\">\n" +
                "                        <time class=\"format_time text-muted text-xs block m-t-xs\">"+data[i].cdate+"</time>\n" +
                "                    </div>\n" +
                "                    <div class=\"comment-content m-t-sm\">\n" +
                "                        <span class=\"comment-author-at\"><b></b></span>\n" +
                "                                            <span class=\"comment-content-true\">\n" +
                "                                                <p>"+data[i].comment+"</p>\n" +
                "                                            </span>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>" +
                "</td>" +
                "</tr>");
            /*$mytbody.append("<td colspan=\"2\"><hr/></td>");*/
        }
    }else{
        $mytbody.append("<span>暂无评论！</span>");
    }

}
initCom();
//-------------------------------

$("#submit").click(function(){
    var $inputs=$("#commentform").find(":input");
    var paramArray= $inputs.serializeArray();//先获取到所有表单元素的json对象数组
    var paramStr= $.param(paramArray);
    var x=document.getElementById("email").value;
    var y=document.getElementById("comment").value;
    if(x==""){
        alert("请输入QQ！(必填)");
        return false;
    }
    if(y==""){
        alert("请输入评论内容！(必填)");
        return false;
    }
    $.post("/comment/addCom",paramStr,successAdd);
});



function successAdd(data){

    if(data=='success'){//成功 直接刷新评论
        $("#mytbody").html("");//清空评论区
        $("#comment").val("");//清空多行文本域
        initCom();
    }else{
        alert("评论成功");
        initCom();
    }
}
