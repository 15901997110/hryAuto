
//分页
function pagination(data){

    $("#total").html("");
    $("#totalPages").html("");
    $("#now").html("");
    $("#pager").html("");

    var total=data.data.total;
    var pages=data.data.pages;
    var now=data.data.pageNum;
    var beforePage=data.data.prePage;
    var nextPage=data.data.nextPage;

    var pagesHtml="";
    var pageStart="<a class=\"paginate_button previous disabled\" href='javascript:void(0)' onclick='pageSkip("+beforePage+")' id=\"table_previous\">上一页</a>\n" +
        "            <span id=\"pages\">";
    var pageEnd="</span>\n" +
        "            <a class=\"paginate_button next disabled\" href='javacript:void(0)' onclick='pageSkip("+nextPage+")' id=\"table_next\">下一页</a>";

    if(pages<5){
        for(var k=0;k<pages;k++){
            if((k+1)==now){
                var pageHtml="<a class=\"paginate_button current\" href='javascript:void(0)' onclick='pageSkip("+(k+1)+")'>"+(k+1)+"</a>";
            }else{
                var pageHtml="<a class=\"paginate_button \" href='javascript:void(0)' onclick='pageSkip("+(k+1)+")'>"+(k+1)+"</a>";
            }

            pagesHtml= pagesHtml + pageHtml;
        }

    }else{
        if(now>4 && now<(pages-3)){
            var pagesHtml="<a class=\"paginate_button\" href='javascript:void(0)' onclick='pageSkip(1)'>1</a>" +
                "<span> …</span>";
            for(i=(now-1);i<now+2;i++){
                if(i==now){
                    var pageHtml="<a class=\"paginate_button current\" href='javascript:void(0)' onclick='pageSkip("+(i)+")'>"+(i)+"</a>";
                }else{
                    var pageHtml="<a class=\"paginate_button \" href='javascript:void(0)' onclick='pageSkip("+(i)+")'>"+(i)+"</a>";
                }
                pagesHtml = pagesHtml+pageHtml;
            }
            pagesHtml= pagesHtml + "<span> …</span>\n" +
                "<a class=\"paginate_button \" href='javascript:void(0)' onclick='pageSkip("+pages+")'>"+pages+"</a>";


        }else if(now>(pages-4) && now<=pages){
            var pagesHtml="<a class=\"paginate_button\" href='javascript:void(0)' onclick='pageSkip(1)'>1</a>" +
                "<span> …</span>";
            for(i=(pages-4);i<=pages;i++){
                if(i==now){
                    var pageHtml="<a class=\"paginate_button current\" href='javascript:void(0)' onclick='pageSkip("+(i)+")'>"+(i)+"</a>";
                }else{
                    var pageHtml="<a class=\"paginate_button \" href='javascript:void(0)' onclick='pageSkip("+(i)+")'>"+(i)+"</a>";
                }
                pagesHtml = pagesHtml+pageHtml;

            }

        }else if(now>0 && now<=4){

            for(var i=0;i<=4;i++){
                if((i+1)==now){
                    var pageHtml="<a class=\"paginate_button current\" href='javascript:void(0)' onclick='pageSkip("+(i+1)+")'>"+(i+1)+"</a>";
                }else{
                    var pageHtml="<a class=\"paginate_button \" href='javascript:void(0)' onclick='pageSkip("+(i+1)+")'>"+(i+1)+"</a>";
                }

                pagesHtml= pagesHtml + pageHtml;
            }
            pagesHtml= pagesHtml + "<span> …</span>\n" +
                "<a class=\"paginate_button \" href='javascript:void(0)' onclick='pageSkip("+pages+")'>"+pages+"</a>";
        }

    }

    $("#total").append(total);
    $("#totalPages").append(pages);
    $("#now").append(now);
    $("#pager").append(pageStart);
    $("#pages").append(pagesHtml);
    $("#pager").append(pageEnd);

}


//删除列表数据
function del(obj,id,url,ms){
    if(ms == null || ms == ""){
        ms="请确认是否要删除id="+id+"的数据！";
    }
    layer.confirm(ms,function(index){
        //alert("要删除的id="+id);
        $.ajax({
            type: 'POST',
            url: url,
            data:{
                id:id
            },
            dataType: 'json',
            success: function(data){
                var status=data.status;
                var msg=data.msg;
                if(status == 0){
                    $(obj).parents("tr").remove();
                    window.location.reload();
                    layer.msg('已删除!',{icon:1,time:1000});
                }else{
                    layer.alert(msg, {
                        icon: 0,
                        skin: 'layer-ext-moon'
                    });
                }

            },
            error:function(data) {
                console.log(data);
            },
        });
    });
}

//删除列表数据-json格式请求数据
function del_json(obj,id,url,ms){
    if(ms == null || ms == ""){
        ms="请确认是否要删除id="+id+"的数据！";
    }
    layer.confirm(ms,function(index){
        //alert("要删除的id="+id);
        var o=new Object();
        o.id=id;
        var json=JSON.stringify(o);
        $.ajax({
            type: 'POST',
            url: url,
            data:json,
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            success: function(data){
                var status=data.status;
                var msg=data.msg;
                if(status == 0){
                    $(obj).parents("tr").remove();
                    window.location.reload();
                    layer.msg('已删除!',{icon:1,time:1000});
                }else{
                    layer.alert(msg, {
                        icon: 0,
                        skin: 'layer-ext-moon'
                    });
                }

            },
            error:function(data) {
                console.log(data);
            },
        });
    });
}

//获取枚举值数组
function getAllEnum(){
    var allEnum=null;
    $.ajaxSetup({async : false});
    $.ajax({
        type: "get",
        url: "/enum/allEnum",
        data: {
        },
        dataType: "json",
        success: function (data) {
            allEnum=data;
        },
        fail:function (data) {
            layer.alert(JSON.stringify(data), {
                icon: 0,
                skin: 'layer-ext-moon'
            });
        },
        error: function(xhr) {
            layer.alert('Error' + JSON.stringify(xhr), {
                icon: 2,
                skin: 'layer-ext-moon'
            });
        }
    });
    return allEnum;
}

//获取用户组
function userGroup(){
    var usergroup=null;
    $.ajaxSetup({async : false});
    $.ajax({
        type: "get",
        url: "/enum/groupEnum",
        data: {
        },
        dataType: "json",
        success: function (data) {
            usergroup=data;
        },
        fail:function (data) {
            layer.alert(JSON.stringify(data), {
                icon: 0,
                skin: 'layer-ext-moon'
            });
        },
        error: function(xhr) {
            layer.alert('Error' + JSON.stringify(xhr), {
                icon: 2,
                skin: 'layer-ext-moon'
            })
        }
    });
    return usergroup;
}

//获取服务List
function getServiceList(){
    var service=null;
    $.ajaxSetup({async : false});
    $.ajax({
        type: "post",
        url: "/tservice/selectByConditionSimple",
        data: {

        },
        dataType: "json",
        success: function (data) {
            var status=data.status;
            var msg=data.msg;
            if(status == 0){
                service=data.data;
            }else{
                layer.alert(data.msg, {
                    icon: 0,
                    skin: 'layer-ext-moon'
                })
            }

        },
        fail:function (data) {
            layer.alert(JSON.stringify(data), {
                icon: 0,
                skin: 'layer-ext-moon'
            })
        },
        error: function(xhr) {
            layer.alert('Error' + JSON.stringify(xhr), {
                icon: 2,
                skin: 'layer-ext-moon'
            })
        }
    });
    return service;
}
//获取环境List
function getEnvList(){
    var envList=null;
    $.ajaxSetup({async : false});
    $.ajax({
        type: "post",
        url: "/tenv/selectAll",
        data: {
        },
        dataType: "json",
        success: function (data) {
            envList=data.data;
        },
        fail:function (data) {
            alert(JSON.stringify(data));
        },
        error: function(xhr) {
            alert('error:' + JSON.stringify(xhr));
        }
    });
    return envList;
}

//获取技术部人员List
function getUserList() {
    var dev = null;
    var groupId = $.cookie('groupidCookie');
    $.ajaxSetup({async: false});
    $.ajax({
        type: "post",
        url: "/user/selectByCondition",
        data: {},
        dataType: "json",
        success: function (data) {
            var status = data.status;
            var msg = data.msg;
            if (status == 0) {
                //layer.close(layerIndex);
                dev = data.data;
            } else {
                layer.close(layerIndex);
                layer.alert(msg, {
                    icon: 0,
                    skin: 'layer-ext-moon'
                })
            }
        },
        fail: function (data) {
            layer.close(layerIndex);
            layer.alert(JSON.stringify(data), {
                icon: 0,
                skin: 'layer-ext-moon'
            });
        },
        error: function (xhr) {
            layer.close(layerIndex);
            layer.alert('Error' + JSON.stringify(xhr), {
                icon: 2,
                skin: 'layer-ext-moon'
            })
        }
    });
    return dev;
}

//
function getParameter(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

//根据serviceKey 获取测试类列表
function getTClassListByServiceKey(serviceKey) {
    var tClassList = null;
    $.ajaxSetup({async: false});
    $.ajax({
        type: "post",
        url: "/tservice/getTestClassesBySKey",
        data: {
            sKey:serviceKey
        },
        dataType: "json",
        success: function (data) {
            var status = data.status;
            var msg = data.msg;
            if (status == 0) {
                //layer.close(layerIndex);
                tClassList = data.data;
            } else {
                layer.close(layerIndex);
                layer.alert(msg, {
                    icon: 0,
                    skin: 'layer-ext-moon'
                })
            }
        },
        fail: function (data) {
            layer.close(layerIndex);
            layer.alert(JSON.stringify(data), {
                icon: 0,
                skin: 'layer-ext-moon'
            });
        },
        error: function (xhr) {
            layer.close(layerIndex);
            layer.alert('Error' + JSON.stringify(xhr), {
                icon: 2,
                skin: 'layer-ext-moon'
            })
        }
    });
    return tClassList;
}

//根据serviceId 获取serviceKey
function getServiceKey(serviceId){
    var serviceKey=null;
    $.ajaxSetup({async : false});
    $.ajax({
        type: "post",
        url: "/tservice/selectByConditionSimple",
        data: {

        },
        dataType: "json",
        success: function (data) {
            layer.close(layerIndex);
            var status=data.status;
            var msg=data.msg;
            if(status == 0){
                var list=data.data;
                for(var i=0;i<list.length;i++){
                    var row=list[i];
                    if(row.id== serviceId){
                        serviceKey=row.servicekey;
                    }

                }
            }else{
                layer.alert(data.msg, {
                    icon: 0,
                    skin: 'layer-ext-moon'
                })
            }

        },
        fail:function (data) {
            layer.close(layerIndex);
            layer.alert(JSON.stringify(data), {
                icon: 0,
                skin: 'layer-ext-moon'
            })
        },
        error: function(xhr) {
            layer.close(layerIndex);
            layer.alert('Error' + JSON.stringify(xhr), {
                icon: 2,
                skin: 'layer-ext-moon'
            })
        }
    });
    return serviceKey;
}

//获取环境List
function getTenvList(){
    var env=null;
    $.ajaxSetup({async : false});
    $.ajax({
        type: "post",
        url: "/tenv/selectAll",
        data: {

        },
        dataType: "json",
        success: function (data) {
            layer.close(layerIndex);
            var status=data.status;
            var msg=data.msg;
            if(status == 0){
                env=data.data;
            }else{
                layer.alert(msg, {
                    icon: 0,
                    skin: 'layer-ext-moon'
                })
            }

        },
        fail:function (data) {
            layer.close(layerIndex);
            layer.alert(JSON.stringify(data), {
                icon: 0,
                skin: 'layer-ext-moon'
            })
        },
        error: function(xhr) {
            layer.close(layerIndex);
            layer.alert('Error' + JSON.stringify(xhr), {
                icon: 2,
                skin: 'layer-ext-moon'
            })
        }
    });
    return env;
}

//根据接口id查询接口信息
function getTiById(tiId){
    var ti=null;
    $.ajaxSetup({async : false});
    $.ajax({
        type: "post",
        url: "/ti/selectOne",
        data: {
            id:tiId
        },
        dataType: "json",
        success: function (data) {
            layer.close(layerIndex);
            var status=data.status;
            var msg=data.msg;
            if(status == 0){
                ti=data.data;
            }else{
                layer.alert(msg, {
                    icon: 0,
                    skin: 'layer-ext-moon'
                })
            }

        },
        fail:function (data) {
            layer.close(layerIndex);
            layer.alert(JSON.stringify(data), {
                icon: 0,
                skin: 'layer-ext-moon'
            })
        },
        error: function(xhr) {
            layer.close(layerIndex);
            layer.alert('Error' + JSON.stringify(xhr), {
                icon: 2,
                skin: 'layer-ext-moon'
            })
        }
    });
    return ti;
}

//根据用例id查询用例信息
function getTcaseById(caseId){
    var tcase=null;
    $.ajaxSetup({async : false});
    $.ajax({
        type: "post",
        url: "/tcase/selectOne",
        data: {
            id:caseId
        },
        dataType: "json",
        success: function (data) {
            layer.close(layerIndex);
            var status=data.status;
            var msg=data.msg;
            if(status == 0){
                tcase=data.data;
            }else{
                layer.alert(msg, {
                    icon: 0,
                    skin: 'layer-ext-moon'
                })
            }

        },
        fail:function (data) {
            layer.close(layerIndex);
            layer.alert(JSON.stringify(data), {
                icon: 0,
                skin: 'layer-ext-moon'
            })
        },
        error: function(xhr) {
            layer.close(layerIndex);
            layer.alert('Error' + JSON.stringify(xhr), {
                icon: 2,
                skin: 'layer-ext-moon'
            })
        }
    });
    return tcase;
}

//根据serviceId 获取服务下所有接口及接口下所有用例
function getAllTiAndCaseByServiceId(serviceId){
    var all=null;
    $.ajaxSetup({async : false});
    $.ajax({
        type: "post",
        url: "/ti/selectTiWithCaseVO",
        data: {
            serviceid:serviceId
        },
        dataType: "json",
        success: function (data) {
            layer.close(layerIndex);
            var status=data.status;
            var msg=data.msg;
            if(status == 0){
                all=data.data;
            }else{
                layer.alert(msg, {
                    icon: 0,
                    skin: 'layer-ext-moon'
                })
            }

        },
        fail:function (data) {
            layer.close(layerIndex);
            layer.alert(JSON.stringify(data), {
                icon: 0,
                skin: 'layer-ext-moon'
            })
        },
        error: function(xhr) {
            layer.close(layerIndex);
            layer.alert('Error' + JSON.stringify(xhr), {
                icon: 2,
                skin: 'layer-ext-moon'
            })
        }
    });
    return all;
}






































