layui.use(['table','form'],function () {
    var $ = layui.jquery
    table = layui.table;
    form = layui.form;
    table.render({
        elem: '#billTable',
        url: '/bill/list',
        method: 'post',
        toolbar: '#billToolBar',
        defaultToolbar: [],
        //处理返回参数
        parseData: function (res) {
            return {
                "code": res.code,
                "msg": res.msg,
                "count": res.data.total,
                "data": res.data.list
            };
        },
        //设置返回的属性值，依据此值进行解析
        response: {
            statusName: 'code',
            statusCode: "0000",
            msgName: 'msg',
            dataName: 'data'
        },
        cols: [[
            {field: 'billId', title: '系统编号'},
            {field: 'billCode', title: '发票编码'},
            {field: 'custId', title: '客户编号'},
            {field: 'custName', title: '客户名称'},
            {field: 'taskId', title: '任务编号'},
            {field: 'taskName', title: '任务名称',},
            {field: 'taskAmount', title: '任务金额',},
            {field: 'billStatus', title: '开票状态'},
            {field: 'billAmount', title: '开票金额'},
            {field: 'deliveryStatus', title: '寄送状态'},
            {field: 'createTime', title: '创建时间', sort: true},
            {field: 'updateTime', title: '更新时间'},
            {field: 'optUser', title: '最后更新操作人'},
            {title: '操作', minWidth: 150, toolbar: '#billOptionTool', align: "center"}
        ]],
        limits: [10, 15, 20, 25, 50, 100],
        limit: 15,
        page: true
        // done: function (res, curr, count) {
        //     $("[data-field='status']").children().each(function () {
        //         if($(this).text()=='1')
        //             $(this).text = "正常";
        //         if($(this).text()=='0')
        //             $(this).text = "注销";
        //     })
        // }
    });

    table.on('toolbar(billTableFilter)',function (obj) {
        if(obj.event=='add'){
            var index = parent.layer.open({
                title: '新增发票',
                type: 2,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: ['50%', '80%'],
                content: '/page/bounced/add-bill.html',
                btn: ['关闭', '确认'],
                btn1: function (index,layero) {
                    parent.layer.close(index);
                },
                btn2: function (index,layero) {
                    parent.layer.getChildFrame('body', index).find('#addBillBtn').click();
                    return false;
                },
                end: function () {
                    window.location.reload();
                }
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
        }
    })

    table.on('tool(billTableFilter)', function (lineObj) {
        var data = lineObj.data;
        if (lineObj.event === 'edit') {
            var index = parent.layer.open({
                title: '编辑发票',
                type: 2,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: ['50%', '80%'],
                content: '/page/bounced/add-bill.html',
                btn: ['关闭', '确认'],
                success: function(layero,index){
                    var billBody = parent.layer.getChildFrame('body', index);
                    var iframeWin = $("div.layui-layer-content > iframe", layero)[0].contentWindow;
                    var editForm = iframeWin.layui.form;
                    billBody.find("#billId").val(data.billId);
                    billBody.find("#billCode").val(data.billCode);
                    billBody.find("#custName").val(data.custName);
                    billBody.find("#taskName").val(data.taskName);
                    billBody.find("#taskAmount").val(data.taskAmount);
                    billBody.find("#billAmount").val(data.billAmount);
                    billBody.find("#billStatus").val(data.billStatus);
                    billBody.find("#deliveryStatus").val(data.deliveryStatus);
                    billBody.find("#deliveryCode").val(data.deliveryCode);
                    editForm.render();
                },
                btn1: function (index,layero) {
                    parent.layer.close(index);
                },
                btn2: function (index,layero) {
                    parent.layer.getChildFrame('body', index).find('#editBillBtn').click();
                    return false;
                },
                end: function () {
                    window.location.reload();
                }
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
        }

        if (lineObj.event == 'forbidden'){
            var btnName = $(this).html();
            var status = 1;
            if (btnName=='撤销')
                status = 0;
            var index = layer.confirm("确认"+btnName+"吗？",function () {
                var obj = {};
                obj.billID = lineObj.data.billID;
                obj.status = status;
                $.ajax({
                    url:'/bill/edit',
                    type:'post',
                    data:JSON.stringify(obj),
                    contentType:'application/json',
                    success:function (data) {
                        if (data.code=="0000"){
                            layer.alert(btnName+"成功",function () {
                                layer.close(index);
                                window.location.reload();
                            });
                        } else {
                            layer.alert(btnName+"失败："+data.msg);
                        }

                    }

                })
            })
        }

    })
})