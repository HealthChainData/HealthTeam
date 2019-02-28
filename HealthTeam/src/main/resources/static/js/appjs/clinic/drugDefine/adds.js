$().ready(function() {
	validateRule();
	loadType();
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
		url : "/drugDefine/save",
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

function loadType() {
	var html = "";
	$.ajax({
		url: "/drugDefine/drugTypeList",
		success: function (data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].id + '">' + data[i].drugTypeName + '</option>'
			}
			$(".chosen-select-type").append(html);
			$(".chosen-select-type").chosen({
				maxHeight: 200
			});
			//点击事件
			$('.chosen-select-type').on('change', function (e, params) {
				console.log(params.selected);
				var opt = {
					query: {
						type: params.selected,
					}
				}
				$('#exampleTable').bootstrapTable('refresh', opt);
			});
		}
	});
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			drugName : {
				required : true
			}
		},
		messages : {
			drugName : {
				required : icon + "请输入名称"
			}
		}
	})
}