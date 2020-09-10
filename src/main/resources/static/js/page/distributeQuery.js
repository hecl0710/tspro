layui.use(['form', 'table', 'laydate'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;
    var laydate = layui.laydate;


    //日期控件
    laydate.render({
        elem: '#test5'
        , type: 'datetime'
    });

    var search = function () {
        table.render({
            elem: '#distributeQueryTable',
            url: '/task/list',
            defaultToolbar: [],
            page: true,//是否分页
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
                {field: 'taskId', title: '任务id', hide: true},
                {field: 'taskName', title: '任务名称'},
                {field: 'taskDetail', title: '任务内容'},
                {field: 'companyName', title: '服务公司'},
                {field: 'status', title: '任务状态'},
                {field: 'amount', title: '发放金额',},
                {field: 'taxFee', title: '综合税费'},
                {field: 'fee', title: '服务费'},
                {field: 'companyBusiness', title: '公司业务', hide: true},
                {field: 'createTime', title: '创建时间', sort: true}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 10,
            done: function (res, curr, count) {
                $("[data-field='status']").children().each(function () {
                    if ($(this).text() == '1') {
                        $(this).text("发送完成")
                    }
                    if ($(this).text() == '2') {
                        $(this).text("待发放")
                    }
                    if ($(this).text() == '3') {
                        $(this).text("部分发放失败")
                    }
                    if ($(this).text() == '4') {
                        $(this).text("已取消")
                    }
                });
            }
        });
    }
    //页面加载就查询列表
    search();
});
