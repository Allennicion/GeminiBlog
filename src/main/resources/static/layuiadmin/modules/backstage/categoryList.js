/**
 * 分类管理js
 */
;layui.define(["table", "form"], function (t) {
    var $ = layui.$, table = layui.table, form = layui.form, admin = layui.admin;
    table.render({
        elem: "#LAY-app-content-list",
        url: "/backstage/dict/categoryList",
        cols: [[
            {type: "checkbox", fixed: "left"},
            {field: "id", width: 300, title: "分类ID"},
            {field: "name", title: "分类名称"},
            {field: "createName", title: "创建者"},
            {field: "createTime",title: "创建时间",sort: true},
            {field: "updateName", title: "更新者"},
            {field: "updateTime",title: "更新时间",sort: true},
            {title: "操作",minWidth: 100,align: "center",fixed: "right",toolbar: "#table-content-list"}
        ]],
        page: true,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        request: {
            pageName: 'current', //页码的参数名称，默认：page
            limitName: 'size' //每页数据量的参数名，默认：limit
        },
        initSort: {
            field: 'createTime',
            type: 'desc'
        },
        text: "对不起，加载出现异常！"
    }), table.on("tool(LAY-app-content-list)", function (t) {
        var e = t.data;
        "del" === t.event ? layer.confirm("确定删除此分类？", function (e) {
            /*t.del(),*/ batchdel(t), layer.close(e)
        }) : "edit" === t.event && layer.open({
            type: 2,
            title: "修改分类",
            content: "/backstage/dict/categoryForm?id=" + e.id,
            maxmin: !0,
            area: ["300px", "200px"],
            btn: ["确定", "取消"],
            yes: function (e, i) {
                var l = window["layui-layer-iframe" + e],
                    a = i.find("iframe").contents().find("#layuiadmin-app-form-submit");
                l.layui.form.on("submit(layuiadmin-app-form-submit)"), a.trigger("click");
            }
        })
    });


    //监听搜索
    form.on('submit(LAY-app-contlist-search)', function(data){
        var field = data.field;

        //执行重载
        table.reload('LAY-app-content-list', {
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: field
        });
    });

    //监听搜索
    form.on('submit(LAY-app-contlist-reload)', function(data){
        $("input[name=name]").val('');
        //执行重载
        table.reload('LAY-app-content-list', {
            page: {
                curr: 1 //重新从第 1 页开始
            }
            , where: {
                name: '',
            }
        });
    });

    // 列删除 test 提交
    function batchdel(t) {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/backstage/dict/categoryFormDelById",
            data: {
                id : t.data.id
            },
            success: function (resp) {
                if (resp.code == 200) {
                    table.reload('LAY-app-content-list');
                    layer.msg('已删除');
                } else {
                    layer.msg("删除失败！", {time: 500});
                }
            },
            error : function() {
                layer.msg("数据异常！", {time: 500});
            }
        })
    }

    // 增加 冲突1
    $("#add").click(function () {
        layer.open({
            type: 2
            ,title: '添加分类'
            ,content: '/backstage/dict/categoryForm'
            ,area: ['300px', '200px']
            ,btn: ['确定', '取消']
            ,yes: function(index, layero){
                //点击确认触发 iframe 内容中的按钮提交
                var submit = layero.find('iframe').contents().find("#layuiadmin-app-form-submit");
                submit.click();
            }
        });
    });

    // 批量删除
    $("#batchdel").click(function(){
        var checkStatus = table.checkStatus('LAY-app-content-list')
            ,checkData = checkStatus.data; //得到选中的数据
        if(checkData.length === 0){
            return layer.msg('请选择数据');
        }
        layer.confirm('确定删除吗？', function(index) {

            $.ajax({
                type: "post",
                dataType: "json",
                contentType: "application/json",
                url: "/backstage/dict/categoryFormDel",
                data: JSON.stringify(checkData),
                success: function (resp) {
                    if (resp.code == 200) {
                        table.reload('LAY-app-content-list');
                        layer.msg('已删除');
                    } else {
                        layer.msg("删除失败！", {time: 500});
                    }
                },
                error : function() {
                    layer.msg("数据异常！", {time: 500});
                }
            })
        });
    });
});