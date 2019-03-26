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
		url : "/healthDataDefine/saveCode",
		data : $('#signupForms').serialize(),// 你的formid
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
	$("#signupForms").validate({
		rules : {
			codeType : {
				required : true
			},
			codeNo : {
				required : true
			},
			codeVal : {
				required : true
			}
		},
		messages : {
			codeType : {
				required : icon + "请输入代码类型"
			},
			codeNo : {
				required : icon + "请输入代码代号"
			},
			codeVal : {
				required : icon + "请输入代码值"
			}
		}
	})
}