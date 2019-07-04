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
    <link rel="stylesheet" href="../../css/bootstrap-table.css"/>
    <link rel="stylesheet" href="../../css/bootstrap-fileinput.min.css">
    <script src="../../js/main_js.js"></script>
    <script src="../../js/bootstrap-table.js"></script>
    <script src="../../js/bootstrap-table-zh-CN.js"></script>
    <script src="../../js/bootstrap-fileinput.min.js"></script>
    <script src="../../js/bootstrap-fileinput.zh.js"></script>
</head>
<body>
<div class="container">
    <div id="toolbar">
        <button id="registerButton" class="btn btn-primary" data-toggle="modal" data-target="#registerModal">注册</button>
        <button class="btn btn-primary">编辑</button>
    </div>
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                  <h4 class="modal-title" id="myModalLabel">
                        注册新用户!!!
                  </h4>
                </div>
                <div class="modal-body">
                    <form id="driverInfoForm" class="bs-example bs-example-form" role="form" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-xs-4 col-sm-4 col-xs-6">
                                <div class="input-group">
                                    <span class="input-group-addon"><font color="red">*</font> 姓 名</span>
                                    <input id="name" name="name" class="form-control" type="text" />
                                </div>
                                <br/>
                                <div class="input-group">
                                    <span class="input-group-addon"><font color="red">*</font>手机号</span>
                                    <input id="phone_number" name="phone_number" class="form-control" type="text" />
                                </div>
                                <br/>
                                <div class="input-group">
                                    <span class="input-group-addon"><font color="red">*</font>身份证号</span>
                                    <input id="person_id" name="person_id" class="form-control" type="text" />
                                </div>
                                <br/>
                                <div class="input-group">
                                    <span class="input-group-addon"><font color="red">*</font> 性 别</span>
                                    <select class="form-control" name="sex">
                                        <option>男</option>
                                        <option>女</option>
                                    </select>
                                </div>
                                <br/>
                                <div class="input-group">
                                    <span class="input-group-addon"><font color="red">*</font>出生日期</span>
                                    <input id="birthday" name="birthday" class="form-control" type="text" />
                                </div>
                                <br/>
                            </div>
                            <div class="col-xs-4 col-sm-4 col-xs-6">
                                <div class="input-group">
                                    <span class="input-group-addon"> 国 籍</span>
                                    <input id="nationality" name="nationality" class="form-control" type="text"/>
                                </div>
                                <br/>
                                <div class="input-group">
                                    <span class="input-group-addon"><font color="red">*</font>婚姻状态</span>
                                    <select class="form-control" name="marital_status">
                                        <option>未婚</option>
                                        <option>已婚</option>
                                    </select>
                                </div>
                                <br/>
                                <div class="input-group">
                                    <span class="input-group-addon"><font color="red">*</font>所属单位</span>
                                    <input id="company" name="company" class="form-control" type="text" />
                                </div>
                                <br/>
                                <div class="input-group">
                                    <span class="input-group-addon">外语能力</span>
                                    <input id="foreign_language_ability" name="foreign_language_ability" class="form-control" type="text" value=""/>
                                </div>
                                <br/>
                                <div class="input-group">
                                    <span class="input-group-addon"> 学 历</span>
                                    <input  id="education" name="education" class="form-control" type="text" value=""/>
                                </div>
                                <br/>
                            </div>
                            <div class="col-xs-4 col-sm-4 col-xs-6 ">
                                <div class="fileinput fileinput-new" data-provides="fileinput" id="uploadImgDiv" align="center">
                                    <input type="file" name="photo" id="photo">
                                </div>
                          </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary" onclick="submitRegisterInfoByAjax()">
                        提交更改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <div class="modal fade" id="resultModal" tabindex="-1" role="dialog" aria-labelledby="registerLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        注册结果！！！
                    </h4>
                </div>
                <div class="modal-body" id="resultText">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">确定
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <table class="table table-striped table-bordered table-hover" id="table1"></table>
</div>
</body>
</html>
