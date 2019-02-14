var prefix = "/clinic"
$(function () {
	load();
});

function load() {
	$('#exampleTable')
		.bootstrapTreeTable({
			id: 'clinicId',
			code: 'clinicId',
			parentCode: 'clinicParentId',
			type: "GET", // 请求数据的ajax类型
			url: prefix + '/list', // 请求数据的ajax的url
			ajaxParams: {}, // 请求数据的ajax的data属性
			expandColumn: '2', // 在哪一列上面显示展开按钮
			striped: true, // 是否各行渐变色
			bordered: true, // 是否显示边框
			expandAll: false, // 是否全部展开
			columns: [{
					field: 'id',
					title: '序号',
				}, {
					title: '编号',
					field: 'clinicId',
					visible: false,
					align: 'center',
					valign: 'center',
					width: '50px',
					checkbox: true,
				},
				{
					field: 'clinicName',
					title: '机构名称',

				},
				{
					field: 'clinicAddress',
					title: '机构地址'
				},
				{
					field: 'status',
					title: '机构状态',
					formatter: function (item, index) {
						if (item.status == '0') {
							return '<span class="label label-primary">可用</span>';
						} else if (item.status == '1') {
							return '<span class="label label-danger">禁用</span>';
						}
					}
				},
				{
					field: 'superAdminId',
					title: '超级管理员'
				},
				{
					field: 'createTime',
					title: '新建时间'
				},
				{
					title: '操作',
					field: 'clinicId',
					align: 'center',
					valign: 'center',
					formatter: function (value, row, index) {
						var a = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="查看"  onclick="edit(\'' +
							value.clinicId +
							'\')">查看</a> ';
						var b = '<a class="btn btn-warning btn-sm ' + s_ban_h + '" href="#" title="禁用"  mce_href="#" onclick="ban(\'' +
							value.clinicId +
							'\')">禁用</i></a> ';
						var c = '<a class="btn btn-primary btn-sm ' + s_set_h + '" href="#" title="管理员设置"  mce_href="#" onclick="set(\'' +
							value.clinicId +
							'\')">管理员设置</a> ';
						var d = '<a class="btn btn-primary btn-sm ' + s_add_h + '" href="#" title="增加分公司"  mce_href="#" onclick="adds(\'' +
							value.clinicId +
							'\',\'' +
							value.clinicName +
							'\')">增加分公司</a> ';
						return a + b + c + d;
					}
				}
			]
		});
}

function reLoad() {
	load();
}

function add() {
	layer.open({
		type: 2,
		title: '增加机构',
		maxmin: true,
		shadeClose: false, // 点击遮罩关闭层
		area: ['800px', '520px'],
		content: prefix + '/add' // iframe的url
	});
}

function adds(clinicId, name) {
	layer.open({
		type: 2,
		title: '为     "' + name + '"   增加分公司',
		maxmin: true,
		shadeClose: false, // 点击遮罩关闭层
		area: ['800px', '520px'],
		content: prefix + '/adds' + clinicId // iframe的url
	});
}

function edit(clinicId) {
	layer.open({
		type: 2,
		title: '查看',
		maxmin: true,
		shadeClose: false, // 点击遮罩关闭层
		area: ['800px', '520px'],
		content: prefix + '/edit/' + clinicId // iframe的url
	});
}

function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn: ['确定', '取消']
	}, function () {
		$.ajax({
			url: prefix + "/remove",
			type: "post",
			data: {
				'clinicId': id
			},
			success: function (r) {
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

function resetPwd(id) {}

function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn: ['确定', '取消']
		// 按钮
	}, function () {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function (i, row) {
			ids[i] = row['clinicId'];
		});
		$.ajax({
			type: 'POST',
			data: {
				"ids": ids
			},
			url: prefix + '/batchRemove',
			success: function (r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function () {

	});
}