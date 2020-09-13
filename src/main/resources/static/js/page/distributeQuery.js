layui.use(['form', 'table', 'laydate'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;
    var laydate = layui.laydate;


    //日期控件
    laydate.render({
        elem: '#creatTime'
        , type: 'datetime'
    });

    var search = function (patamData) {
        table.render({
            elem: '#distributeQueryTable',
            url: '/distribute/trade/list',
            defaultToolbar: [],
            page: true,//是否分页
            method: 'post',
            where: patamData,
            contentType: "application/json;charset=UTF-8",
            request: {
                pageName: 'pageNumber',
                limitName: 'pageSize'
            },
            //处理返回参数
            parseData: function (res) {
                if (res.code != '0000') {
                    return {
                        "code": res.code,
                        "msg": res.msg
                    };
                }
                if (res.code == '0000') {
                    return {
                        "code": res.code,
                        "msg": res.msg,
                        "count": res.data.total,
                        "data": res.data.list
                    };
                }
            },
            //设置返回的属性值，依据此值进行解析
            response: {
                statusName: 'code',
                statusCode: "0000",
                msgName: 'msg',
                dataName: 'data'
            },
            cols: [[
                {field: 'custId', title: '企业编号', hide: true},
                {field: 'creatTime', title: '发起时间'},
                {field: 'status', title: '打款状态'},
                {field: 'amount', title: '打款金额'},
                {field: 'empName', title: '收款人'},
                {field: 'accountNo', title: '银行卡号',},
                {field: 'accountName', title: '开户行'},
                {field: 'documentType', title: '证件类型'},
                {field: 'identifyId', title: '证件号码'},
                {field: 'phone', title: '手机号码'}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 10,
            done: function (res, curr, count) {
                $("[data-field='status']").children().each(function () {
                    if ($(this).text() == '1') {
                        $(this).text("已结算")
                    }
                    if ($(this).text() == '2') {
                        $(this).text("待结算")
                    }
                    if ($(this).text() == '3') {
                        $(this).text("结算失败")
                    }
                });
            }
        });
    }
    //页面加载就查询列表
    search();

    //条件查询
    form.on('submit(queryDistributeOrderFilter)', function (data) {
        data = data.field;
        search(data);
    })

    //重置按钮
    $("#clearDistributeOrderBtn").on("click", function () {
        $("#empName").val("");
        $("#phone").val("");
        $("#identifyId").val("");
        $("#creatTime").val("");
        $("#accountNo").val("");
        $("#status").val("");
        form.render();
    });
});
