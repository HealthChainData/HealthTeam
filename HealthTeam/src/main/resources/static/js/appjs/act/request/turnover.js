var prefix = "/activiti"
$().ready(function () {
	 validateRule();
	 loadUser();

});
$.validator.setDefaults({
	submitHandler: function () {
		save();
	}
});

function loadUser(){
	var html = "";
	$.ajax({
		url : prefix +"/userList",
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].userId + '">' + data[i].name + '</option>'
			}
			$(".chosen-select-user").append(html);
			$(".chosen-select-user").chosen({
				maxHeight : 200
			});
			//点击事件
			$('.chosen-select-user').on('change', function(e, params) {
				console.log(params.selected);
				var opt = {
					query : {
						type : params.selected,
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