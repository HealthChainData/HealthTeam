var prefix = "/diseaseDefine"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTreeTable(
					{
						id : 'diseaseId',
						code : 'diseaseId',
						parentCode : 'diseaseParentId',
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
									field : 'diseaseName',
									title : '疾病名称'
								},
								{
									field : 'icdNumber',
									title : 'ICD编码'
								},
								{
									field : 'mnemonicCode',
									title : '助记码'
								},
								{
									field : 'tenderLimit',
									title : '性别限制',
									formatter : function(item, index) {
										if (item.tenderLimit == '0') {
											return '<span>无限制</span>';
										} else if (item.tenderLimit == '1') {
											return '<span>女</span>';
										} else if (item.tenderLimit == '2') {
											return '<span>男</span>';
										}
									}
								},
								{
									field : 'curativeLimit',
									title : '疗效限制',
									formatter : function(item, index) {
										if (item.curativeLimit == '0') {
											return '<span>治愈</span>';
										} else if (item.curativeLimit == '1') {
											return '<span>好转</span>';
										} else if (item.curativeLimit == '2') {
											return '<span>无定义</span>';
										}
									}
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var a = '<a class="btn btn-primary btn-sm '
												+ s_edit_h
												+ '" href="#" mce_href="#" title="查看"  onclick="edit(\''
												+ value.diseaseId
												+ '\')">查看</a> ';
										var b = '<a class="btn btn-primary btn-sm '
												+ s_delete_h
												+ '" href="#" mce_href="#" title="删除"  onclick="remove(\''
												+ value.diseaseId
												+ '\',\''
												+ value.diseaseName
												+ '\')">删除</a> ';
										var c = '<a class="btn btn-primary btn-sm '
												+ s_update_h
												+ '" href="#" mce_href="#" title="修改"  onclick="updates(\''
												+ value.diseaseId
												+ '\',\''
												+ value.diseaseName
												+ '\')">修改</a> ';
										if (value.diseaseParentId == null
												|| value.diseaseParentId == '') {
											c = '<a class="btn btn-primary btn-sm '
													+ s_update_h
													+ '" href="#" mce_href="#" title="修改"  onclick="update(\''
													+ value.diseaseId
													+ '\')">修改</a> ';
										}
										var d = '';
										if (value.diseaseParentId == null
												|| value.diseaseParentId == '') {
											var d = '<a class="btn btn-primary btn-sm '
													+ s_add_h
													+ '" href="#" mce_href="#" title="增加疾病"  onclick="adds(\''
													+ value.diseaseId
													+ '\',\''
													+ value.diseaseName
													+ '\')">增加疾病</a> ';
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
function adds(diseaseId, diseaseName) {
	layer.open({
		type : 2,
		title : diseaseName + '类型增加分类',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/adds/' + diseaseId // iframe的url
	});
}
function edit(diseaseId) {
	layer.open({
		type : 2,
		title : '查看',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + diseaseId // iframe的url
	});
}

function updates(diseaseId,diseaseName) {
	layer.open({
		type : 2,
		title :diseaseName + '修改',
		maxmin : true,
		shadeClose : false,
		area : [ '800px', '520px' ],
		content : prefix + '/updates/' + diseaseId // iframe的url
	});
}

function update(diseaseId) {
	layer.open({
		type : 2,
		title : '修改',
		maxmin : true,
		shadeClose : false,
		area : [ '800px', '220px' ],
		content : prefix + '/update/' + diseaseId // iframe的url
	});
}

function remove(diseaseId, diseaseName) {
	layer.confirm('确定要删除' + diseaseName + '？如果该疾病目录下还有其他疾病时将会一起删除', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'diseaseId' : diseaseId
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
			ids[i] = row['diseaseId'];
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