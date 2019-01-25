var prefix = "/activiti"
$().ready(function() {


    loadType();
    loadSource();
    validateRule();
    
    // 点击事件
    // $('#ownerUser').on('blur', function(e, params) {
    //     var value = $(this).val();
    //     var url = prefix+"/isExistsUser/"+value;
    //     var data = loadDate(url);
    //     console.info(data);
    //     if (!data.isExists) {
    //         alert('用户不存在');
    //     }else{
    //         alert('用户存在');
    //     }
    // });

});
$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
// function loadType(){
// 	var html = "";
    
//     var url = prefix + "/queryTypeList/request_type";
//     var data = loadDate(url);
//     //加载数据
//     for (var i = 0; i < data.length; i++) {
//         html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
//     }
//     $("#requestType").append(html);
//     $("#requestType").chosen({
//         maxHeight : 200
//     });
//     html = "";
//     url = prefix + "/queryTypeList/request_src";
//     var data = loadDate(url);
//     //加载数据
//     for (var i = 0; i < data.length; i++) {
//         html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
//     }
//     $("#requestSource").append(html);
//     $("#requestSource").chosen({
//         maxHeight : 200
//     });
// }

function loadType(){
	var html = "";
	$.ajax({
		url : '/common/dict/list/request_type',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
			}
			$(".chosen-select-type").append(html);
			$(".chosen-select-type").chosen({
				maxHeight : 200
			});
			//点击事件
			$('.chosen-select-type').on('change', function(e, params) {
				console.log(params.selected);
				var opt = {
					query : {
						type : params.selected,
					}
				}
				$('#exampleTable').bootstrapTable('refresh', opt);
			});
		}
	});
}
function loadSource(){
	var html = "";
	$.ajax({
		url : '/common/dict/list/request_src',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
			}
			$(".chosen-select-source").append(html);
			$(".chosen-select-source").chosen({
				maxHeight : 200
			});
			//点击事件
			$('.chosen-select-source').on('change', function(e, params) {
				console.log(params.selected);
				var opt = {
					query : {
						type : params.selected,
					}
				}
				$('#exampleTable').bootstrapTable('refresh', opt);
			});
		}
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

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#requestForm").validate({
		rules : {
			name : {
				required : true
			},
			username : {
				required : true,
				minlength : 2,
				remote : {
					url : prefix +"/exit", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						username : function() {
							return $("#username").val();
						}
                    }
                    
                }
                
			},
			agree : "required"
		},
		messages : {
			username : {
				required : icon + "请输入指定责任的用户",
                remote : icon + "用户不存在"
			},
		}
	})
}

function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : prefix +"/save",
		data : $('#requestForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}