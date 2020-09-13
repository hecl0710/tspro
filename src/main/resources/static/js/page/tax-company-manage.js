layui.use(['table','form'],function () {
    var $ = layui.jquery
    table = layui.table;
    form = layui.form;
    table.render({
        elem: '#tscTable',
        url: '/tsc/list',
        method: 'post',
        toolbar: '#tscToolBar',
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
            {field: 'companyId', title: '企业编码'},
            {field: 'companyName', title: '企业名称'},
            {field: 'businessLicence', title: '工商注册编码'},
            {field: 'legalName', title: '法人姓名'},
            {field: 'legalId', title: '法人身份证',},
            {field: 'status', title: '状态'},
            {field: 'createTime', title: '创建时间', sort: true},
            {field: 'updateTime', title: '更新时间'},
            {field: 'optUser', title: '最后更新操作人'},
            {title: '操作', minWidth: 150, toolbar: '#tscOptionTool', align: "center"}
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
    table.on('toolbar(tscTableFilter)',function (obj) {
        if(obj.event=='add'){
            var index = parent.layer.open({
                title: '新增税源企业',
                type: 2,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: ['50%', '80%'],
                content: '/page/bounced/add-tax-company.html',
                btn: ['关闭', '确认'],
                btn1: function (index,layero) {
                    parent.layer.close(index);
                },
                btn2: function (index,layero) {
                    parent.layer.getChildFrame('body', index).find('#addTscBtn').click();
                    return false;
                    // var tscForm = parent.layer.getChildFrame('#tscForm', index);
                    // var fields = tscForm.serializeArray();
                    // var obj = {};
                    // $.each(fields, function(index, field) {
                    //     obj[field.name] = field.value; //通过变量，将属性值，属性一起放到对象中
                    // })
                    // console.info(JSON.stringify(obj));
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

    table.on('tool(tscTableFilter)', function (lineObj) {
        var data = lineObj.data;
        if (lineObj.event === 'edit') {
            var index = parent.layer.open({
                title: '编辑税源企业',
                type: 2,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: ['50%', '80%'],
                content: '/page/bounced/add-tax-company.html',
                btn: ['关闭', '确认'],
                success: function(layero,index){
                    var tscBody = parent.layer.getChildFrame('body', index);
                    tscBody.find("#companyId").val(data.companyId);
                    tscBody.find("#companyName").val(data.companyName);
                    tscBody.find("#businessLicence").val(data.businessLicence);
                    tscBody.find("#legalName").val(data.legalName);
                    tscBody.find("#legalId").val(data.legalId);
                },
                btn1: function (index,layero) {
                    parent.layer.close(index);
                },
                btn2: function (index,layero) {
                    parent.layer.getChildFrame('body', index).find('#editTscBtn').click();
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
})