var prefix = "/activiti"
$(function () {
	load();
});
function load() {
	$('#exampleTable')
		.bootstrapTable({
			method: 'get', // 服务器数据的请求方式 get or post
			url: prefix + "/requestStepList", // 服务器数据的加载地址
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
				{
					checkbox: true
				},
				{
					field: 'stepName',
					title: '步骤名称',
					valign: 'center',
					witth: 20
				},
				{
					field: 'stepDesc',
					title: '步骤描述',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'progressAdd',
					title: '状态推进',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'beforeOwnerId',
					title: '原责任人',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'afterOwnerId',
					title: '现责任人',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'recoTime',
					title: '处理时间',
					align: 'center',
					valign: 'center',
				},
				{
					field: 'recoUserId',
					title: '处理人',
					align: 'center',
					valign: 'center',
				},
			]
		});
}