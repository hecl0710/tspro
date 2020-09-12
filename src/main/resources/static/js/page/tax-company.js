layui.use(['table','form'],function () {
    var $ = layui.jquery
    table = layui.table;
    form = layui.form;
    form.on('submit(addTscFilter)',function (data) {
        data = data.field;
        $.ajax({
            type:"post",
            url:"/tsc/add",
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

})