var prefix = "/activiti"
$().ready(function () {


	loadType();
	loadSource();
	validateRule();
	loadUser();

});
$.validator.setDefaults({
	submitHandler: function () {
		save();
	}
});

function loadType() {
	var html = "";
	$.ajax({
		url: '/common/dict/list/request_type',
		success: function (data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
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

function loadSource() {
	var html = "";
	$.ajax({
		url: '/common/dict/list/request_src',
		success: function (data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
			}
			$(".chosen-select-source").append(html);
			$(".chosen-select-source").chosen({
				maxHeight: 200
			});
			//点击事件
			$('.chosen-select-source').on('change', function (e, params) {
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

function loadUser() {
	var html = "";
	$.ajax({
		url: prefix + "/userList",
		success: function (data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].userId + '">' + data[i].name + '</option>'
			}
			$(".chosen-select-user").append(html);
			$(".chosen-select-user").chosen({
				maxHeight: 200
			});
			//点击事件
			$('.chosen-select-user').on('change', function (e, params) {
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

function loadDate(url_l) {
	var result;
	$.ajax({
		url: url_l,
		async: false,
		success: function (data) {
			result = data;
		}
	});
	return result;
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#requestForm").validate({
		rules: {
			name: {
				required: true
			},
			username: {
				required: true,
				minlength: 2,
				remote: {
					url: prefix + "/exit", // 后台处理程序
					type: "post", // 数据发送方式
					dataType: "json", // 接受数据格式
					data: { // 要传递的数据
						username: function () {
							return $("#ownerId").val();
						}
					}

				}

			},
			agree: "required"
		},
		messages: {
			ownerId: {
				required: icon + "请选择指定责任的用户",
				remote: icon + "用户不存在"
			},
		}
	})
}

function save() {
	var formData = new FormData($("#requestForm")[0]);
	$.ajax({
		cache: true,
		type: "POST",
		url: prefix + "/save",
		data: formData,
		//data: $('#requestForm').serialize(), // 你的formid
		async: false,
        cache: false,
        contentType: false,
        processData: false,
		error: function (request) {
			parent.layer.alert("Connection error");
		},
		success: function (data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else if (data.code == 3) {
				parent.layer.alert("请选择用户")
			} else if (data.code == 4) {
				parent.layer.alert("请选择请求类型")
			} else if (data.code == 5) {
				parent.layer.alert("请选择请求来源")
			} else {
				parent.layer.alert(data.msg)
			}

		}
	});
}


// layui.use('upload', function () {
// 	var upload = layui.upload;
// 	//执行实例
// 	var uploadInst = upload.render({
// 		elem: '#file1', //绑定元素
// 		url: prefix + "/upload", //上传接口
// 		size: 100000,
// 		accept: 'file',
// 		done: function (r) {
// 			 layer.msg(r.msg);
// 			// app.getData();
// 		},
// 		error: function (r) {
// 			layer.msg(r.msg);
// 		}
// 	});
// });