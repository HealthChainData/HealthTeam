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
		url : "/healthDataDefine/save",
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
			fieldName : {
				required : true
			},
			fieldSeq : {
				required : true
			},	
			fieldDesc : {
				required : true
			},	
			fieldLenth : {
				required : true
			},
			fieldDec : {
				required : true
			}	
		},
		messages : {
			fieldName : {
				required : icon + "请输入字段名"
			},
			fieldSeq : {
				required : icon + "请输入字段排列顺序"
			},
			fieldDesc : {
				required : icon + "请输入字段描述"
			},
			fieldLenth : {
				required : icon + "请输入字段长度"
			},
			fieldDec : {
				required : icon + "请输入字段小数"
			}
		}
	})
}