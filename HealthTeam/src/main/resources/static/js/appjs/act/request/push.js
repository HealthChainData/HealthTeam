var prefix = "/activiti"
$().ready(function () {
	validateRule();
	loads();
	loadProgress();

});
$.validator.setDefaults({
	submitHandler: function () {
		save();
	}
});

function save() {
	$.ajax({
		cache: true,
		type: "POST",
		url: prefix + "/pushSave",
		data: $('#pushForm').serialize(), // 你的formid
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

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#pushForm").validate({
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
					field: 'requestProgress',
					title: '目前进度',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'updateTime',
					title: '最后更新',
					align: 'center',
					valign: 'center',
				},
			]
		});
}

function loadProgress() {
	var html = "";
	for (var i = 0; i <= 100; i++) {
		html += '<option value="' + i+'%' + '">' + i+'%' + '</option>'
	}
	$(".chosen-select-progress").append(html);
	$(".chosen-select-progress").chosen({
		maxHeight: 200
	});
}