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
                limitName: 'pageSize'
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
                statusCode: "0000",
                msgName: 'msg',
                dataName: 'data'
            },
            cols: [[
                {field: 'taskName', title: '任务名称'},
                {field: 'taskDetail', title: '任务内容'},
                {field: 'companyName', title: '服务公司'},
                {field: 'status', title: '任务状态'},
                {field: 'amount', title: '发放金额',},
                {field: 'taxFee', title: '综合税费'},
                {field: 'fee', title: '服务费'},
                {field: 'companyBusiness', title: '公司业务',hide:true},
                {field: 'createTime', title: '创建时间', sort: true},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,//是否分页
            done: function (res, curr, count) {
                $("[data-field='companyName']").children().each(function (i) {
                    var index = parseInt(i)-1;
                    if( index >= 0){
                        var companyName = res.data[index].tsPlatforms[0].companyName;//服务商
                        $(this).text(companyName)
                    }
                });
                $("[data-field='companyBusiness']").children().each(function (i) {
                    var index = parseInt(i)-1;
                    if( index >= 0){
                        var companyBusiness = res.data[index].customerInfoBacks[0].companyBusiness;//公司业务
                        $(this).text(companyBusiness)
                    }
                });
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

    /**
     * toolbar监听事件
     */
    table.on('toolbar(currentTableFilter)', function (obj) {
        // contentData = myData;
        if (obj.event === 'add') {  // 监听添加操作
            var index = parent.layer.open({
                title: '新建任务',
                type: 2,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: ['50%', '80%'],
                content: '/page/bounced/add_task.html',
                btn: ['关闭', '发布'],
                btn1: function(index,layero) {//点击关闭按钮
                    parent.layer.close(index);
                },
                btn2: function(index,layero) {//点击发布按钮

                    var addTaskBody = parent.layer.getChildFrame('body', index);
                    var submited = addTaskBody.find('button')[0];
                    // 触发点击事件，会对表单进行验证，验证成功则提交表单，失败则返回错误信息
                    submited.click();
                    var taskName = addTaskBody.find("#taskName").val();
                    if(Object.keys(taskName).length != 0){
                        taskAdd(addTaskBody,index);
                    }
                    return false
                },
                success: function (layero, index) {
                    setChildVlue(index);//设置值
                }
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
        }
    });

    table.on('tool(currentTableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            var index = parent.layer.open({
                title: '编辑任务',
                type: 2,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: ['50%', '80%'],
                content: '/page/bounced/add_task.html',
                btn: ['关闭', '发布'],
                success: function (layero, index) {
                    setChildVlue(index);
                }
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
            return false;
        }
    });

    function setChildVlue(index){
        var contentValue = layui.table.cache.currentTableId;
        var custName = contentValue[0].customerInfoBacks[0].custName;
        var companyBusiness = contentValue[0].customerInfoBacks[0].companyBusiness;
        var companyName = contentValue[0].tsPlatforms[0].companyName;//税源地名称
        var custId = contentValue[0].customerInfoBacks[0].custId;
        var addTaskBody = parent.layer.getChildFrame('body', index);
        addTaskBody.find("#custName").val(custName);
        addTaskBody.find("#companyBusiness").val(companyBusiness);
        addTaskBody.find("#companyName").val(companyName);
        addTaskBody.find("#custId").val(custId);
    }

    var closeIndex = null;
    function taskAdd(addTaskBody,index){
        closeIndex = index;
        $.ajax({
            url: '/task/add',
            type: 'post',
            data: {
                custId : addTaskBody.find("#custId").val(),
                taskName : addTaskBody.find("#taskName").val(),
                taskDetail :addTaskBody.find("#taskDetail").val(),
                staffSkills :addTaskBody.find("#staffSkills").val()
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == "0000") {
                    parent.layer.close(closeIndex);
                    var index = layer.alert("添加成功", function () {
                        layer.closeAll();
                        search();
                        // parent.layer.close(index);
                        // layer.alert("添加成功!")
                    });
                } else {
                    layer.alert(data.msg);
                }
            },
            error: function () {
                layer.alert("添加失败，请重试！");
            }
        });
    }

});
