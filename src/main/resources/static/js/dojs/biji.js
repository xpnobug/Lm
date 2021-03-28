var div = document.getElementById('series');
var width = div.style.width || div.clientWidth || div.offsetWidth || div.scrollWidth;
var s = 'position:fixed;top:80px;width:' + width + 'px;';
    wg();
    initUser();
    function initUser(){
        $.get("/biji",getAll,"JSON")
        function getAll(data){
            var $row=$("#series");
            $(data).each(function (){
                $("#series").append("<a href='/index/bijifenlei?id="+this.id+"' class=\"list-group-item type-link\">"+this.name+"</a>")
            })

        }
    }


    function wg() {
        $.get("/art/channel?channer="+getUrlValue('id'), getPageAll, "JSON")
        function getPageAll(data) {
            var $noteTable = $("#noteTable");
            $(data).each(function () {
                $("#noteTable").append(
                    "<div class=\"article\">\n" +
                    "     <p class=\"article_title\"><a href=\"\">" + this.title + "</a></p>\n" +
                    "\n" +
                    "     <span class=\"glyphicon glyphicon-time\"></span>" + this.cdate + "\n" +
                    "     <p class=\"article_content\">" + this.present + "</p>\n" +
                    " </div>\n" +
                    "\n" +
                    " <hr>")
            })
        }
        //-----------------遍历js获取地址栏参数-------------------------
        function getUrlValue(key){
            var query = window.location.search.substring(1);
            var vars = query.split("&");
            for (var i = 0; i < vars.length; i++) {
                var pair = vars[i].split("=");
                if (pair[0] == key) {
                    return pair[1];
                }
            }
            return 0;
        }


    }
    function setFixed() {
        window.addEventListener("scroll", function(e) {
            var scrollHeight = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
            if (!is_mobile() && document.body.offsetWidth >= 753 && scrollHeight > 1080) {
                $('#series').attr('style', s);
                $('#officialAccount').hide();
            } else {
                $('#series').removeAttr('style');
                $('#officialAccount').show();
            }
        });
    }

    function is_mobile() {
        var ua = navigator.userAgent.toLowerCase();
        if (/(ip(hone|od)|android|opera m(ob|in)i|windows (phone|ce)|blackberry|s(ymbian|eries60|amsung)|p(laybook|alm|rofile\/midp|laystation portable)|nokia|fennec|htc[-_]|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})/i.test(ua)) {
            return true;
        } else {
            return false;
        }
    }
