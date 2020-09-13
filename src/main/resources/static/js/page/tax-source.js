layui.use(['table','form'],function () {
    var $ = layui.jquery
    table = layui.table;
    form = layui.form;
    form.on('submit(addTsfFilter)',function (data) {
        data = data.field;
        $.ajax({
            type:"post",
            url:"/tsf/add",
            contentType :'application/json',
            data:JSON.stringify(data),
            dataType:"json",
            success:function (data) {
                if (data.code=="0000"){
                    layer.alert("新增成功",function () {
                        parent.layer.closeAll();
                    });
                } else {
                    layer.alert("新增失败："+data.msg);
                }
            }
        });
    })

    form.on('submit(editTsfFilter)',function (data) {
        data = data.field;
        $.ajax({
            type:"post",
            url:"/tsf/edit",
            contentType :'application/json',
            data:JSON.stringify(data),
            dataType:"json",
            success:function (data) {
                if (data.code=="0000"){
                    layer.alert("编辑成功",function () {
                        parent.layer.closeAll();
                    });
                } else {
                    layer.alert("编辑失败："+data.msg);
                }
            }
        });
    })

})