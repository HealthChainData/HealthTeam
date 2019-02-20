var prefix = "/drugDefine"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTreeTable(
					{
						id : 'drugId',
						code : 'drugId',
						parentCode : 'drugParentId',
						type : "GET", // 请求数据的ajax类型
						url : prefix + '/list', // 请求数据的ajax的url
						ajaxParams : {}, // 请求数据的ajax的data属性
						expandColumn : '0', // 在哪一列上面显示展开按钮
						striped : true, // 是否各行渐变色
						bordered : true, // 是否显示边框
						expandAll : false, // 是否全部展
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
												+ value.drugId
												+ '\')">查看</a> ';
										var b = '<a class="btn btn-primary btn-sm '
												+ s_delete_h
												+ '" href="#" mce_href="#" title="删除"  onclick="remove(\''
												+ value.drugId
												+ '\',\''
												+ value.drugName
												+ '\')">删除</a> ';
										var c = '<a class="btn btn-primary btn-sm '
												+ s_update_h
												+ '" href="#" mce_href="#" title="修改"  onclick="updates(\''
												+ value.drugId
												+ '\',\''
												+ value.drugName
												+ '\')">修改</a> ';
										if (value.drugParentId == null
												|| value.drugParentId == '') {
											c = '<a class="btn btn-primary btn-sm '
													+ s_update_h
													+ '" href="#" mce_href="#" title="修改"  onclick="update(\''
													+ value.drugId
													+ '\')">修改</a> ';
										}
										var d = '';
										if (value.drugParentId == null
												|| value.drugParentId == '') {
											var d = '<a class="btn btn-primary btn-sm '
													+ s_add_h
													+ '" href="#" mce_href="#" title="增加药品"  onclick="adds(\''
													+ value.drugId
													+ '\',\''
													+ value.drugName
													+ '\')">增加药品</a> ';
										}
										return a + b + c + d;
									}
								} ]
					});
}
function reLoad() {
	load();
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
function adds(drugId, drugName) {
	layer.open({
		type : 2,
		title : drugName + '类型增加分类',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '620px' ],
		content : prefix + '/adds/' + drugId // iframe的url
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
	layer.confirm('确定要删除' + name + '？如果该药品目录下还有其他药品时将会一起删除。', {
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
		area : [ '800px', '520px' ],
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