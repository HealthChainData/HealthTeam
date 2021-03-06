var prefix = "/activiti"
$().ready(function () {
	validateRule();
	loadUser();
	//loads();

});
$.validator.setDefaults({
	submitHandler: function () {
		save();
	}
});

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

function save() {
	$.ajax({
		cache: true,
		type: "POST",
		url: prefix + "/turnoverSave",
		data: $('#turnoverForm').serialize(), // 你的formid
		async: false,
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
			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#turnoverForm").validate({
		rules: {
			name: {
				required: true
			}
		},
		messages: {
			name: {
				required: icon + ""
			}
		}
	})
}

function loads() {
	$('#exampleTables')
		.bootstrapTable({
			method: 'get', // 服务器数据的请求方式 get or post
			url: prefix + "/listById", // 服务器数据的加载地址
			// showRefresh : true,
			// showToggle : true,
			// showColumns : true,
			iconSize: 'outline',
			//toolbar : '#exampleToolbar',
			striped: true, // 设置为true会有隔行变色效果
			dataType: "json", // 服务器返回的数据类型
			pagination: true, // 设置为true会在底部显示分页条
			// queryParamsType : "limit",
			// //设置为limit则会发送符合RESTFull格式的参数
			singleSelect: false, // 设置为true将禁止多选
			// contentType : "application/x-www-form-urlencoded",
			// //发送到服务器的数据编码类型
			pageSize: 10, // 如果设置了分页，每页数据条数
			pageNumber: 1, // 如果设置了分布，首页页码
			//search : true, // 是否显示搜索框
			showColumns: false, // 是否显示内容下拉框（选择显示的列）
			sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者
			// "server"
			queryParams: function (params) {
				return {
					// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
					limit: params.limit,
					offset: params.offset,
					name: ''
					//id : id
				};
			},
			// toolbar : '#exampleToolbar',
			columns: [
				/*{
						title : '来源',
						field : 'id',
						visible : false,
						align : 'center',
						valign : 'center',
						width : '50px',
						checkbox : true
                    },*/
				// {
				// 	checkbox: true
				// },
				{
					field: 'requestName',
					title: '请求名称',
					valign: 'center',
					witth: 20
				},
				{
					field: 'username',
					title: '责任人',
					align: 'center',
					valign: 'center',
				},
			]
		});
}