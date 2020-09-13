layui.use(['form', 'table'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;

    var search = function (patamData) {
        table.render({
            elem: '#customerTable',
            url: '/customer/list',
            method: 'post',
            toolbar: '#customerToolbar',
            contentType: "application/json;charset=UTF-8",
            defaultToolbar: [],
            page: true,//是否分页
            where: patamData,
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
                {field: 'custId', title: '客户编码', hide: true},
                {field: 'custName', title: '客户名称', width: 100},
                {field: 'businessLicence', title: '营业执照编码', width: 100},
                {field: 'mcc', title: '所属行业', width: 100},
                {field: 'companyBusiness', title: '公司业务', width: 100},
                {field: 'legalId', title: '法人身份证', width: 100},
                {field: 'legalName', title: '法人姓名', width: 100},
                {field: 'accountNo', title: '打款账户', width: 100},
                {field: 'accountName', title: '账户名称', width: 100},
                {field: 'accountBank', title: '开户行', width: 100},
                {field: 'phone', title: '联系手机号', width: 100},
                {field: 'address', title: '联系地址', width: 100},
                {field: 'status', title: '状态', width: 100},
                {field: 'agreement', title: '合同存放路径', width: 100},
                {field: 'serviceFee', title: '服务费率', width: 100},
                {field: 'createTime', title: '创建时间', width: 100, sort: true},
                {field: 'updateTime', title: '更新时间', width: 100, sort: true},
                {field: 'optUser', title: '最后更新操作人', width: 100},
                {title: '操作', minWidth: 150, toolbar: '#customerTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 10,
            done: function (res, curr, count) {
                $("[data-field='status']").children().each(function () {
                    if ($(this).text() == '1') {
                        $(this).text("正常")
                    }
                    if ($(this).text() == '0') {
                        $(this).text("关闭")
                    }
                });
            }
        });
    }
    //页面加载就查询列表
    search();

    //条件查询
    form.on('submit(queryCustomerFilter)', function (data) {
        data = data.field;
        search(data);
    })

    //重置按钮
    $("#resetCustomerQueryBtn").on("click", function () {
        $("#custName").val("");
        $("#legalName").val("");
    });

    /**
     * toolbar监听事件
     */
    table.on('toolbar(customerTableFilter)', function (obj) {
        // contentData = myData;
        if (obj.event === 'add') {  // 监听添加操作
            var index = parent.layer.open({
                title: '增加客户信息',
                type: 2,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: ['50%', '80%'],
                content: '/page/bounced/addCustomerSource.html',
                btn: ['关闭', '添加'],
                btn2: function (index, layero) {
                    // var formData = new FormData(parent.layer.getChildFrame('body', index).find('#addCustomerSource'));
                    var addCustomerBody = parent.layer.getChildFrame('body', index);
                    var contract = addCustomerBody.find("#uploadContract").val();
                    parent.layer.getChildFrame('body', index).find('#addCustomerInfoBtn').click();
                    // 触发点击事件，会对表单进行验证，验证成功则提交表单，失败则返回错误信息
                    var custName = addCustomerBody.find("#custName").val();
                    var legalId = addCustomerBody.find("#legalId").val();
                    var accountName = addCustomerBody.find("#accountName").val();
                    var accountBank = addCustomerBody.find("#accountBank").val();
                    var phone = addCustomerBody.find("#phone").val();
                    var serviceFee = addCustomerBody.find("#serviceFee").val();
                    if (Object.keys(custName).length != 0 && Object.keys(legalId).length != 0 && Object.keys(accountName).length != 0
                        && Object.keys(accountBank).length != 0 && Object.keys(phone).length != 0 && Object.keys(serviceFee).length != 0) {
                        customerAdd(addCustomerBody, index);
                    }

                    return false;
                }
                // end: function () {
                //     window.location.reload();
                // }
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
        }
    });

    table.on('tool(customerTableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'editCustomer') {
            var index = parent.layer.open({
                title: '编辑客户信息',
                type: 2,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: ['50%', '80%'],
                content: '/page/bounced/addCustomerSource.html',
                btn: ['关闭', '修改'],
                btn1: function (index, layero) {//点击关闭按钮
                    parent.layer.close(index);
                },
                btn2: function (index, layero) {//点击发布按钮
                    var addCustomerBody = parent.layer.getChildFrame('body', index);
                    var contract = addCustomerBody.find("#uploadContract").val();
                    parent.layer.getChildFrame('body', index).find('#addCustomerInfoBtn').click();
                    // 触发点击事件，会对表单进行验证，验证成功则提交表单，失败则返回错误信息
                    var custName = addCustomerBody.find("#custName").val();
                    var legalId = addCustomerBody.find("#legalId").val();
                    var accountName = addCustomerBody.find("#accountName").val();
                    var accountBank = addCustomerBody.find("#accountBank").val();
                    var phone = addCustomerBody.find("#phone").val();
                    var serviceFee = addCustomerBody.find("#serviceFee").val();
                    if (Object.keys(custName).length != 0 && Object.keys(legalId).length != 0 && Object.keys(accountName).length != 0
                        && Object.keys(accountBank).length != 0 && Object.keys(phone).length != 0 && Object.keys(serviceFee).length != 0) {
                        editCustomer(addCustomerBody, index);
                    }
                    return false
                },
                success: function (layero, index) {
                    // var res = window["layui-layer-iframe" + index];
                    // res.form.val("formTest", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
                    //     "custName": "贤心"
                    // });
                    setChildVlue(index, obj);//显示值
                }
            });
            // $(window).on("resize", function () {
            //     layer.full(index);
            // });
            return false;
        }
        if (obj.event === 'deleteCustomer') {
            var index = layer.confirm("确定删除吗？", function () {
                deleteCustomer(data, index);
            })
        }
    });

    /**
     * 表单显示值
     * @param index
     * @param obj
     */
    function setChildVlue(index, obj) {
        var addCustomerBody = parent.layer.getChildFrame('body', index);
        addCustomerBody.find("#custId").val(obj.data.custId);
        addCustomerBody.find("#custName").val(obj.data.custName);
        addCustomerBody.find("#businessLicence").val(obj.data.businessLicence);
        addCustomerBody.find("#mcc").val(obj.data.mcc);
        addCustomerBody.find("#companyBusiness").val(obj.data.companyBusiness);
        addCustomerBody.find("#legalId").val(obj.data.legalId);
        addCustomerBody.find("#legalName").val(obj.data.legalName);
        addCustomerBody.find("#accountNo").val(obj.data.accountNo);
        addCustomerBody.find("#accountName").val(obj.data.accountName);
        addCustomerBody.find("#accountBank").val(obj.data.accountBank);
        addCustomerBody.find("#phone").val(obj.data.phone);
        addCustomerBody.find("#address").val(obj.data.address);
        addCustomerBody.find("#serviceFee").val(obj.data.serviceFee);
    }

    /**
     *  添加
     * @type {null}
     */
    var closeIndex = null;

    function customerAdd(addCustomerBody, index) {
        closeIndex = index;
        $.ajax({
            url: '/customer/add',
            type: 'post',
            data: {
                custName: addCustomerBody.find("#custName").val(),
                businessLicence: addCustomerBody.find("#businessLicence").val(),
                mcc: addCustomerBody.find("#mcc").val(),
                companyBusiness: addCustomerBody.find("#companyBusiness").val(),
                legalId: addCustomerBody.find("#legalId").val(),
                legalName: addCustomerBody.find("#legalName").val(),
                accountNo: addCustomerBody.find("#accountNo").val(),
                accountName: addCustomerBody.find("#accountName").val(),
                accountBank: addCustomerBody.find("#accountBank").val(),
                phone: addCustomerBody.find("#phone").val(),
                address: addCustomerBody.find("#address").val(),
                serviceFee: addCustomerBody.find("#serviceFee").val()
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == "0000") {
                    parent.layer.close(closeIndex);
                    var index = layer.alert("添加成功", function () {
                        layer.closeAll();
                        search();
                    });
                } else {
                    parent.layer.open({
                        title: '添加失败',
                        type: 2,
                        shade: 0.2,
                        area: ['20%', '30%'],
                        content: '/page/bounced/prompt.html',
                        btn: ['关闭'],
                        success: function (layero, index) {
                            var addCustomerBody = parent.layer.getChildFrame('body', index);
                            addCustomerBody.find("#msg").html(data.msg);
                        }
                    });
                }
            },
            error: function () {
                // var addTaskBody = parent.layer.getChildFrame('body', index);
                // addTaskBody.alert("修改失败，请重试！");
            }
        });
    }

    function editCustomer(addCustomerBody, index) {
        closeIndex = index;
        $.ajax({
            url: '/customer/edit',
            type: 'post',
            data: {
                custId: addCustomerBody.find("#custId").val(),
                custName: addCustomerBody.find("#custName").val(),
                businessLicence: addCustomerBody.find("#businessLicence").val(),
                mcc: addCustomerBody.find("#mcc").val(),
                companyBusiness: addCustomerBody.find("#companyBusiness").val(),
                legalId: addCustomerBody.find("#legalId").val(),
                legalName: addCustomerBody.find("#legalName").val(),
                accountNo: addCustomerBody.find("#accountNo").val(),
                accountName: addCustomerBody.find("#accountName").val(),
                accountBank: addCustomerBody.find("#accountBank").val(),
                phone: addCustomerBody.find("#phone").val(),
                address: addCustomerBody.find("#address").val(),
                serviceFee: addCustomerBody.find("#serviceFee").val()
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == "0000") {
                    parent.layer.close(closeIndex);
                    var index = layer.alert("修改成功", function () {
                        layer.closeAll();
                        search();
                    });
                } else {
                    parent.layer.open({
                        title: '修改失败',
                        type: 2,
                        shade: 0.2,
                        area: ['20%', '30%'],
                        content: '/page/bounced/prompt.html',
                        btn: ['关闭'],
                        success: function (layero, index) {
                            var addCustomerBody = parent.layer.getChildFrame('body', index);
                            addCustomerBody.find("#msg").html(data.msg);
                        }
                    });
                }
            },
            error: function () {
                var addCustomerBody = parent.layer.getChildFrame('body', index);
                addCustomerBody.alert("修改失败，请重试！");
            }
        });
    }

    /**
     * 删除客户信息
     * @param customerBody
     * @param index
     */
    function deleteCustomer(data, index) {
        closeIndex = index;
        $.ajax({
            url: '/customer/delete',
            type: 'post',
            data: {
                custId: data.custId
            },
            dataType: 'json',
            success: function (data) {
                layer.close(index);
                if (data.code == "0000") {
                    search();
                } else {
                    layer.alert(data.msg);
                }
            },
            error: function () {
                layer.alert("操作失败，请重试！");
            }
        });
    }

});
