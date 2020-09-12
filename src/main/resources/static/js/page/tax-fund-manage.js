layui.use(['table','form'],function () {
    var $ = layui.jquery
        table = layui.table;
        form = layui.form;
    table.render({
    elem: '#tsfTable',
    url: '/tsf/list',
    method: 'post',
    toolbar: '#tsfToolBar',
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
        {field: 'tsId', title: '税源编码'},
        {field: 'tsName', title: '税源名称'},
        {field: 'tsAgreement', title: '协议'},
        {field: 'perVAT', title: '增值税标准税率'},
        {field: 'perCMT', title: '城建税标准税率',},
        {field: 'perEST', title: '教育附加税'},
        {field: 'perPIT', title: '个人所得税'},
        {field: 'perVatRemain', title: '增值税地方留存比例'},
        {field: 'perVatRefund', title: '增值税返还比例'},
        {field: 'perPitRemain', title: '个税地方留存比例'},
        {field: 'perPitRefund', title: '个税返还比例'},
        {field: 'pitAvoidAmount', title: '个税免征额'},
        {field: 'status', title: '状态'},
        {field: 'createTime', title: '创建时间', sort: true},
        {field: 'updateTime', title: '更新时间'},
        {field: 'optUser', title: '最后更新操作人'},
        {title: '操作', minWidth: 150, toolbar: '#tsf-tool', align: "center"}
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
    table.on('toolbar(tsfTableFilter)',function (obj) {
        if(obj.event=='add'){
            var index = parent.layer.open({
                title: '新增税源',
                type: 2,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: ['50%', '80%'],
                content: '/page/bounced/addTaxSource.html',
                btn: ['关闭', '确认'],
                btn1: function (index,layero) {
                    parent.layer.close(index);
                },
                btn2: function (index,layero) {
                    parent.layer.getChildFrame('body', index).find('#addTsfBtn').click();
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