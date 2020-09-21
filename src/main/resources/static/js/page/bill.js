layui.use(['table','form'],function () {
    var $ = layui.jquery
    table = layui.table;
    form = layui.form;
    var billQuery = function (data) {
        table.render({
            elem: '#billTable',
            url: '/bill/list',
            method: 'post',
            contentType: "application/json;charset=UTF-8",
            where: data,
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
            page: true,
            done: function (res, curr, count) {
                $("[data-field='billStatus']").children().each(function () {
                    switch ($(this).text()) {
                        case '0':
                            $(this).text("待开票");
                            break;
                        case '1':
                            $(this).text("已开票");
                            break;
                        case '2':
                            $(this).text("开票中");
                            break;
                        case '3':
                            $(this).text("已注销");
                            break;
                    }
                });

                $("[data-field='deliveryStatus']").children().each(function () {
                    switch ($(this).text()) {
                        case '0':
                            $(this).text("未寄送");
                            break;
                        case '1':
                            $(this).text("已寄送");
                            break;
                    }
                });
            }
        });
    }

    billQuery();

    laydate.render({
        elem: '#startDate'
    });
    laydate.render({
        elem: '#endDate'
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

    form.on('submit(queryBillInfoFilter)',function (data) {
        data = data.field;
        billQuery(data);
    });

    $("#resetBillFormBtn").on('click',function () {
        $("#custId").val("");
        $("#custName").val("");
        $("#taskId").val("");
        $("#taskName").val("");
        $("#startDate").val("");
        $("#endDate").val("");
        form.render();
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
                status = 3;
            var index = layer.confirm("确认"+btnName+"吗？",function () {
                var obj = {};
                obj.billId = lineObj.data.billId;
                obj.billStatus = status;
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