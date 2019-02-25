var prefix = "/healthDataDefine"
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
									field : 'fieldName',
									title : '字段名'
								},
								{
									field : 'classfyId',
									title : '字段分类'
								},
								{
									field : 'fieldDesc',
									title : '字段描述'
								},
								{
									field : 'flag',
									title : '状态',
									formatter : function(value, row, index) {
										if (row.flag == '0') {
											return '<span class="label label-primary">可用</span>';
										} else if (row.flag == '1') {
											return '<span class="label label-danger">禁用</span>';
										}
									}
								},
								{
									field : 'fieldType',
									title : '字段类型',
									formatter : function(value, row, index) {
										if (row.fieldType == 'C') {
											return '<span>字符</span>';
										} else if (row.fieldType == 'N') {
											return '<span>数字</span>';
										} else if (row.fieldType == 'D') {
											return '<span>日期</span>';
										} else if (row.fieldType == 'T') {
											return '<span>时间</span>';
										}
									}
								},
								{
									field : 'parentField',
									title : '父字段'
								},
								{
									field : 'relatedField',
									title : '相关字段'
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var a = '<a class="btn btn-primary btn-sm '
												+ s_edit_h
												+ '" href="#" mce_href="#" title="查看"  onclick="edit(\''
												+ row.defineId + '\')">查看</a> ';
										if (row.flag == 0) {
											var b = '<a class="btn btn-warning btn-sm '
													+ s_ban_h
													+ '" href="#" title="禁用"  mce_href="#" onclick="ban(\''
													+ row.defineId
													+ '\')">禁用</i></a> ';
										} else if (row.flag == 1) {
											var b = '<a class="btn btn-info btn-sm '
													+ s_ban_h
													+ '" href="#" title="启用"  mce_href="#" onclick="start(\''
													+ row.defineId
													+ '\')">启用</i></a> ';
										}
										var c = '<a class="btn btn-primary btn-sm '
												+ s_update_h
												+ '" href="#" mce_href="#" title="修改"  onclick="update(\''
												+ row.defineId
												+ '\',\''
												+ row.symptoms + '\')">修改</a> ';
										return a + b + c;
									}
								} ]
					});
}
function reLoad() {
	var opt = {
		query: {
			fieldName: $('#fieldName').val(),
			classfyId:$('#classfyId').val(),
			fieldType:$('#fieldType').val(),
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
		area : [ '900px', '820px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '查看',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '900px', '820px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}

function update(id) {
	layer.open({
		type : 2,
		title : '修改',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '900px', '820px' ],
		content : prefix + '/update/' + id // iframe的url
	});
}

function ban(defineId) {
	layer.confirm('确认要禁用吗？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/ban",
			type : "post",
			data : {
				'defineId' : defineId
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

function start(defineId) {
	layer.confirm('确定要启用吗？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/start",
			type : "post",
			data : {
				'defineId' : defineId
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
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'defineId' : id
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
			ids[i] = row['defineId'];
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