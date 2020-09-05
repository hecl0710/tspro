layui.use(['form', 'table'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;

    var search = function () {
        table.render({
            elem: '#currentTableId',
            url: '/task/list',
            toolbar: '#toolbarDemo',
            defaultToolbar: [],
            request: {
                pageNumber: 'pageNumber',
                pageSize: 'pageSize'
            },
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
                statusCode: "00000",
                msgName: 'msg',
                dataName: 'data'
            },
            cols: [[
                {field: 'taskName', title: '任务名称'},
                {field: 'taskDetail', title: '任务内容'},
                // {field: 'sex', title: '服务公司'},
                {field: 'status', title: '任务状态'},
                {field: 'amount', title: '发放金额',},
                {field: 'taxFee', title: '综合税费'},
                {field: 'fee', title: '服务费'},
                {field: 'createTime', title: '创建时间', sort: true},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line'
        });
    }

    //页面加载就查询列表
    search();


    /**
     * toolbar监听事件
     */
    table.on('toolbar(currentTableFilter)', function (obj) {
        if (obj.event === 'add') {  // 监听添加操作
            var index = parent.layer.open({
                title: '新建任务',
                type: 2,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: ['50%', '80%'],
                content: '/page/bounced/add_task.html',
                btn: ['关闭', '发布']
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
        }
    });

    //监听表格复选框选择
    table.on('checkbox(currentTableFilter)', function (obj) {
        console.log(obj)
    });

    table.on('tool(currentTableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {

            var index = layer.open({
                title: '编辑用户',
                type: 2,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: ['100%', '100%'],
                content: '../page/table/edit.html',
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
            return false;
        }
    });

});