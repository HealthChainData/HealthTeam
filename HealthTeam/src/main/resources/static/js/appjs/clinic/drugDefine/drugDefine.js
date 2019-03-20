var prefix = "/drugDefine"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						// showRefresh : true,
						// showToggle : true,
						// showColumns : true,
						iconSize : 'outline',
						// toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						// search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
						// "server"
						queryParams : function(params) {
							return {
								// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit : params.limit,
								offset : params.offset,
								name : ''
							// id : id
							};
						},
						columns : [
								{
									field : 'id',
									title : '序号',
								},
								{
									field : 'drugName',
									title : '药品名称'
								},
								{
									field : 'drugTypeName',
									title : '药品分类'
								},
								{
									field : 'drugIndex',
									title : '药品编号'
								},
								{
									field : 'drugSpecification',
									title : '药品规格'
								},
								{
									field : 'manufacturer',
									title : '生产厂家'
								},
								{
									field : 'approvalNumber',
									title : '批准文号'
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var a = '<a class="btn btn-primary btn-sm '
												+ s_edit_h
												+ '" href="#" mce_href="#" title="查看"  onclick="edit(\''
												+ row.drugId
												+ '\')">查看</a> ';
										var b = '<a class="btn btn-primary btn-sm '
												+ s_delete_h
												+ '" href="#" mce_href="#" title="删除"  onclick="remove(\''
												+ row.drugId
												+ '\',\''
												+ row.drugName
												+ '\')">删除</a> ';
										var c = '<a class="btn btn-primary btn-sm '
												+ s_update_h
												+ '" href="#" mce_href="#" title="修改"  onclick="updates(\''
												+ row.drugId
												+ '\',\''
												+ row.drugName
												+ '\')">修改</a> ';
										/*if (value.drugParentId == null
												|| value.drugParentId == '') {
											c = '<a class="btn btn-primary btn-sm '
													+ s_update_h
													+ '" href="#" mce_href="#" title="修改"  onclick="update(\''
													+ value.drugId
													+ '\')">修改</a> ';
										}*/
										/*var d = '';
										if (value.drugParentId == null
												|| value.drugParentId == '') {
											var d = '<a class="btn btn-primary btn-sm '
													+ s_add_h
													+ '" href="#" mce_href="#" title="增加药品"  onclick="adds(\''
													+ value.drugId
													+ '\',\''
													+ value.drugName
													+ '\')">增加药品</a> ';
										}*/
										return a + b + c ;
									}
								} ]
					});
}

function reLoad() {
	var opt = {
		query: {

		}
	}
	$('#exampleTable').bootstrapTable('refresh', opt);
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '220px' ],
		content : prefix + '/add' // iframe的url
	});
}
function addType() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '220px' ],
		content : prefix + '/add' // iframe的url
	});
}
function adds() {
	layer.open({
		type : 2,
		title :  '增加药品',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '620px' ],
		content : prefix + '/adds' // iframe的url
	});
}
function edit(drugId) {
	layer.open({
		type : 2,
		title : '查看',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '600px' ],
		content : prefix + '/edit/' + drugId // iframe的url
	});
}
function remove(id,name) {
	layer.confirm('确定要删除' + name + '？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'drugId' : id
			},
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	})
}

function updates(drugId,drugName) {
	layer.open({
		type : 2,
		title :drugName + '修改',
		maxmin : true,
		shadeClose : false,
		area : [ '800px', '620px' ],
		content : prefix + '/updates/' + drugId // iframe的url
	});
}

function update(drugId) {
	layer.open({
		type : 2,
		title : '修改',
		maxmin : true,
		shadeClose : false,
		area : [ '800px', '220px' ],
		content : prefix + '/update/' + drugId // iframe的url
	});
}

function resetPwd(id) {
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['drugId'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}