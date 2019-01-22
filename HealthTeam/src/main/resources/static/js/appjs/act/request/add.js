var prefix = "/activiti"
$().ready(function() {
    loadType();
    
    //点击事件
    $('#ownerUser').on('blur', function(e, params) {
        var value = $(this).val();
        var url = prefix+"/isExistsUser/"+value;
        var data = loadDate(url);
        console.info(data);
        if (!data.isExists) {
            alert('用户不存在');
        }else{
            alert('用户存在');
        }
    });

    // $("#ownerUser").focus(function(){
    //     alert(1111);
    // });
    // $("#ownerUser").blur(function(){
    //      alert(2222);
    // });
});
function loadType(){
	var html = "";
    
    var url = prefix + "/queryTypeList/request_type";
    var data = loadDate(url);
    //加载数据
    for (var i = 0; i < data.length; i++) {
        html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
    }
    $("#requestType").append(html);
    $("#requestType").chosen({
        maxHeight : 200
    });
    html = "";
    url = prefix + "/queryTypeList/request_status";
    var data = loadDate(url);
    //加载数据
    for (var i = 0; i < data.length; i++) {
        html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
    }
    $("#requestStatus").append(html);
    $("#requestStatus").chosen({
        maxHeight : 200
    });
}

function loadDate(url_l){
    var result;
    $.ajax({
		url : url_l,
        async: false,
        success : function(data) {
			result = data;
		}
    });
    return result;
}
