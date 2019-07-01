<%--
  Created by IntelliJ IDEA.
  User: ZFD
  Date: 2019/6/27 0027
  Time: 下午 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/bootstrap-table.css"/>
    <script src="../js/bootstrap-table.js"></script>
    <script src="../js/bootstrap-table-zh-CN.js"></script>
</head>
<body>
<div class="container">
    <div id="toolbar">
        <button class="btn btn-primary" data-toggle="modal" data-target="#register">注册</button>
        <button class="btn btn-primary">编辑</button>
    </div>
    <div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="registerLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        注册新用户
                    </h4>
                </div>
                <div class="modal-body">
                    <form>
                        <div></div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary">
                        提交更改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <table class="table table-striped table-bordered table-hover" id="table1"></table>
</div>
</body>
<script language="JavaScript">
    var $queryURL="/getAllDriver?t="+Math.random();
    var $columns=[
        {checkbox:true,visible:true},
        {field:"name",title:"姓名",sortable:true},
        {field:"nationality",title:"国籍"},
        {field:"phone_number",title:"号码"},
        {field:"marital_status",title:"婚姻状态"},
        {field:"person_id",title:"身份证号"},
        {field:"company",title:"所属公司"},
        {field:"sex",title:"性别",sortable:true},
        {field:"foreign_language_ability",title:"外语能力"},
        {field:"birthday",title:"生日",sortable:true},
        {field:"education",title:"教育程度"},
        {field:"photo",title:"图片"},
    ]
    $("#table1").bootstrapTable("destroy");
    $("#table1").bootstrapTable(
        {
            url:$queryURL,
            method:"GET",
            striped:true,
            cache:false,
            pagination:true,//是否分页
            sortable:true,
            sortOrder:"asc",
            sidePagination:"client",
            pageNumber:1,
            pageSize:10,
            pageList:[10,20,50,100],

            search:true,
            strictSearch:false,
            showCloumns:true,
            showRefresh:true,
            clickToSelect:true,

            unniqueId:"id",
            showToggle:true,
            columns:$columns,

            toolbar:"#toolbar",
        }
    );
</script>
</html>
