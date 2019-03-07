$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/clinic/save",
		data : $('#signupForm').serialize(),// 你的formid
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
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			clinicName : {
				required : true
			},
			clinicIndex : {
				required : true,
				remote : {
					url : "/clinic/exit", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						username : function() {
							return $("#clinicIndex").val();
						}
					}
				}
			},
			systemName: {
				required : true
			}
		},
		messages : {
			clinicName : {
				required : icon + "请输入部门名称"
			},
			clinicIndex : {
				required : icon + "请输入机构号",
				remote : icon + "机构号已经存在"
			},
			systemName : {
				required : icon + "请输入系统名称"
			},
		}
	})
}