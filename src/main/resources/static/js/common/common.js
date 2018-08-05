$(window).on("load",getWeahter());

function  getWeahter() {
    $.ajax({
        type: "get",
        url: "/ip",
        dataType: "json",
        success: function(d){
            console.log("状态码"+d.code);
            if(d.code!=0){
                $("#mytab").html("<li class='active'><a href='#'>努力获取地理位置中...😂</a></li><li ><a href='#'></a> </li><li ><a href='#'></li><li ><a href=''></a> </li>");
            }else{
                $("#mytab").html("<li class='active'><a href='#'>"+d.data.city+"</a></li><li ><a href='#'>"+d.data.temp+"</a> </li><li ><img src="+d.data.weatherimg+" height='50px'></li><li ><a href='#'>"+d.data.wind+"</a> </li>");

            }
        },
        error: function(e){
            console.log("错误代码"+d.code);
            console.log("错误内容"+d.msg);
        }
    });
}
