var prefix = "/activiti"
$(function () {
	load();
	loadType();
	loadSource();
	loadStauts();
});

function load() {
	$('#exampleTable')
		.bootstrapTable({
			method: 'get', // 服务器数据的请求方式 get or post
			url: prefix + "/list", // 服务器数据的加载地址
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
					field: 'requestType',
					title: '请求类型',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'requestDesc',
					title: '请求描述',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'requestPic',
					title: '相关截图',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'requestSrc',
					title: '请求来源',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'expectTime',
					title: '预定期限',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'username',
					title: '责任人',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'requestProgress',
					title: '目前进度',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'requestStatus',
					title: '目前状态',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'updateTime',
					title: '最后更新',
					align: 'center',
					valign: 'center',
				},
				{
					title: '操作',
					field: 'id',
					align: 'center',
					valign: 'center',
					formatter: function (value, row, index) {
						var a = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="查看"  onclick="edit(\'' +
							row.id +
							'\')">查看</a> ';
						var b = '<a class="btn btn-primary btn-sm ' + s_add_h + '" href="#" title="推进"  mce_href="#" onclick="push(\'' +
							row.id +
							'\')">推进</i></a> ';
						var c = '<a class="btn btn-primary btn-sm ' + s_push_h + '" href="#" title="移交"  mce_href="#" onclick="turnover(\'' +
							row.id +
							'\')">移交</a> ';
						var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="搁置"  mce_href="#" onclick="shelve(\'' +
							row.id +
							'\')">搁置</a> ';
						var e = '<a class="btn btn-primary btn-sm ' + s_activate_h + '＂ href="#" title="激活"  mce_href="#" onclick="activate(\'' +
							row.id +
							'\')">激活</a> ';
						return a + b + c + d + e;
					}
				}
			]
		});
}

function add() {
	// iframe层
	layer.open({
		type: 2,
		title: '增加请求',
		maxmin: true,
		shadeClose: false, // 点击遮罩关闭层
		area: ['800px', '520px'],
		content: prefix + '/add'
	});
}

function edit(id) {
	// iframe层
	layer.open({
		type: 2,
		title: '请求详情',
		maxmin: true,
		shadeClose: false, // 点击遮罩关闭层
		area: ['1200px', '720px'],
		content: prefix + '/details' + id
	});
}

function push(id) {
	// iframe层
	layer.open({
		type: 2,
		title: '进度更新',
		maxmin: true,
		shadeClose: false, // 点击遮罩关闭层
		area: ['800px', '520px'],
		content: prefix + '/push' + id
	});
}

function turnover(id) {
	// iframe层
	layer.open({
		type: 2,
		title: '移交事务',
		maxmin: true,
		shadeClose: false, // 点击遮罩关闭层
		area: ['800px', '420px'],
		content: prefix + '/turnover' + id
	});
}

// function push(id) {
// 	layer.confirm('确定要推进更新当前请求？', {
// 		btn : [ '确定', '取消' ]
// 	}, function() {
// 		$.ajax({
// 			url : prefix + '/push',
// 			type : "post",
// 			data : {
// 				'id' : id
// 			},
// 			success : function(r) {
// 				if (r.code == 0) {
// 					layer.msg("更新成功，进度+10");
// 					reLoad();
// 				} else {
// 					layer.msg("更新失败");
// 				}
// 			}
// 		});
// 	})
// }

function shelve(id) {
	layer.confirm('确定要搁置当前请求？', {
		btn: ['确定', '取消']
	}, function () {
		$.ajax({
			url: prefix + '/shelve',
			type: "post",
			data: {
				'id': id
			},
			success: function (r) {
				if (r.code == 0) {
					layer.msg("搁置成功");
					reLoad();
				} else if (r.code == 2) {
					layer.msg("您不是该事务负责人，不能进行此操作");
					reLoad();
				} else if (r.code == 4) {
					layer.msg("当前已经是搁置状态");
					reLoad();
				} else if (r.code == 5) {
					layer.msg("当前任务已完成");
					reLoad();
				} else {
					layer.msg("搁置失败");
				}
			}
		});
	})
}

function activate(id) {
	layer.confirm('确定要激活当前请求？', {
		btn: ['确定', '取消']
	}, function () {
		$.ajax({
			url: prefix + '/activate',
			type: "post",
			data: {
				'id': id
			},
			success: function (r) {
				if (r.code == 0) {
					layer.msg("激活成功");
					reLoad();
				} else if (r.code == 2) {
					layer.msg("您不是该事务负责人，不能进行此操作");
					reLoad();
				} else if (r.code == 4) {
					layer.msg("当前已经是激活状态");
					reLoad();
				} else if (r.code == 5) {
					layer.msg("当前任务已完成");
					reLoad();
				} else {
					layer.msg("激活失败");
				}
			}
		});
	})
}

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
		}
	});
}


function loadStauts() {
	var html = "";
	$.ajax({
		url: '/common/dict/list/request_status',
		success: function (data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
			}
			$(".chosen-select-status").append(html);
			$(".chosen-select-status").chosen({
				maxHeight: 200
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
		}
	});
}

function reLoad() {
	var opt = {
		query: {
			requestType: $('.chosen-select-type').val(),
			requestStatus: $('.chosen-select-status').val(),
			requestSrc: $('.chosen-select-source').val(),
			ownerId: $("input[name='ownerId']:checked").val(),
		}
	}
	$('#exampleTable').bootstrapTable('refresh', opt);
}