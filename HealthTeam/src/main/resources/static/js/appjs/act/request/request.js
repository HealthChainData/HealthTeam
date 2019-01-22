var prefix = "/activiti"
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
				//toolbar : '#exampleToolbar',
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
				//search : true, // 是否显示搜索框
				showColumns : false, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
				// "server"
				queryParams : function(params) {
					return {
						// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
						name : ''
						//id : id
					};
				},
				// toolbar : '#exampleToolbar',
				columns : [
					/*{
						title : '来源',
						field : 'id',
						visible : false,
						align : 'center',
						valign : 'center',
						width : '50px',
						checkbox : true
                    },*/
                    {
						checkbox : true
					},
					{
						field : 'requestName',
						title : '请求名称',
                        valign : 'center',
						witth :20
					},
					{
						field : 'requestType',
						title : '请求类型',
                        align : 'center',
                        valign : 'center',
					},
					{
						field : 'requestDesc',
						title : '请求描述',
                        align : 'center',
                        valign : 'center',
					},
					{
						field : 'requestPic',
						title : '相关截图',
                        align : 'center',
                        valign : 'center',
					},
					{
						field : 'requestSrc',
						title : '请求来源',
                        align : 'center',
                        valign : 'center',
					},
					{
						field : 'expectTime',
						title : '预定期限',
                        align : 'center',
                        valign : 'center',
					},
					{
						field : 'ownerId',
						title : '责任人',
                        align : 'center',
                        valign : 'center',
					},
					{
						field : 'requestProgress',
						title : '目前进度',
                        align : 'center',
                        valign : 'center',
					},
					{
						field : 'requestStatus',
						title : '目前状态',
                        align : 'center',
                        valign : 'center',
					},
					{
						field : 'updateUserId',
						title : '最后更新',
                        align : 'center',
                        valign : 'center',
					},
					{
						title : '操作',
						field : 'id',
						align : 'center',
                        valign : 'center',
						formatter : function(item, index) {
							var a = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="查看"  onclick="edit(\''
								+ item.id
								+ '\')">查看</a> ';
							var b = '<a class="btn btn-primary btn-sm ' + s_add_h + '" href="#" title="推进"  mce_href="#" onclick="add(\''
								+ item.id
								+ '\')">推进</i></a> ';
							var c = '<a class="btn btn-primary btn-sm ' + s_push_h + '" href="#" title="移交"  mce_href="#" onclick="push(\''
								+ item.id
								+ '\')">移交</a> ';
							var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="搁置"  mce_href="#" onclick="removeone(\''
								+ item.id
								+ '\')">搁置</a> ';
							var e = '<a class="btn btn-primary btn-sm '+s_activate_h+'＂ href="#" title="激活"  mce_href="#" onclick="resetPwd(\''
								+ item.id
								+ '\')">激活</a> ';
							return a + b + c + d + e;
						}
					} ]
			});
}

function add() {
	// iframe层
	layer.open({
		type : 2,
		title : '增加请求',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add'
	});
}
