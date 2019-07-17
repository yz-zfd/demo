var type="注册新用户！！！";
var $queryURL="/getAllDriver?t="+Math.random();
//表格列属性----------------------------------------------------------------------------------------
var $columns=[
    {checkbox:true,visible:true},
    {field:"id",visible: false},
    {field:"name",title:"姓名",sortable:true,formatter: function (value,row,index) {
            //采用拼接字符串的方式传参不能传递对象，只能转成字符串。
            return "<a href='javascript:alertModelByDetails("+JSON.stringify(row)+")'><font color='red'>"+value+"</font></a>"
        }},
    {field:"nationality",title:"国籍"},
    {field:"phone_number",title:"号码"},
    {field:"marital_status",title:"婚姻状态",formatter:function (value,row,index) {
            return value==true ? "已婚":"未婚";
        }},
    {field:"person_id",title:"身份证号"},
    {field:"company",title:"所属公司"},
    {field:"sex",title:"性别",sortable:true},
    {field:"foreign_language_ability",title:"外语能力"},
    //前端日期需更改格式
    {field:"birthday",title:"生日"},
    {field:"education",title:"教育程度"},
    {field:"photo",visible:false},
]
//用于设置表格插件属性及fileinput插件属性--------------------------------------------------------
$(function () {
    $("#table1").bootstrapTable("destroy");
    $("#table1").bootstrapTable(
        {
            url:$queryURL,
            method:"GET",
            striped:true,
            cache:false,
            pagination:true,//是否分页
            sortable:true,
            sortName:"id",
            sortOrder:"desc",
            sidePagination:"client",
            pageNumber:1,
            pageSize:10,
            pageList:[10,20,50,100],

            search:true,
            strictSearch:false,
            showCloumns:true,
            showRefresh:true,
            clickToSelect:false,

            unniqueId:"id",
            showToggle:true,
            columns:$columns,

            toolbar:"#toolbar",
            getSelection:function (row) {
               return row;
            }
        }
    );
    $("#photo").fileinput({
        language:"zh",

        autoreplace:true,
        addlwedFileExtensions:["jpg","png"],
        maxFileCount:1,
        layoutTemplates:{
          actionUpload: '',
          actionZoom: '',
          actionDelete: '',
        },
        dropZoneTitle: "图片规格：1寸照片 大小 295 x 413",

        showCaption:false,//是否显示标题
        showUpload:false,//显示上传按钮
        showRemove:false,
        showPreview:false,
        showClose:false,
        borderTopWidth:{
            actionDelete:"",
        },
        browseClass:"btn btn-primary",//按钮样式
    })
    //选择文件后触发事件：（若是用户没有选择图片则不会触发，则默认为本身的图片）
    $("#photo").on("filebatchselected", function(event, files) {
        //新增图片后缀名判断
        var photoExtenName="";
        photoExtenName=$("#photo").val().substring($("#photo").val().indexOf('.'),$("#photo").val().length).toUpperCase();
        if(!(photoExtenName==".JPG" ||photoExtenName==".PNG"||photoExtenName==".JPRG")){
            $("#messageBody")[0].innerText = "图片格式不正确请重新上传！";
            $("#photo").val("");
            $("#messageModal").modal("show");
        }else{
            $filePath=URL.createObjectURL(files[0]);//这个方法很不错，将文件重新生成url给img
            $("#photoImg").attr("src",$filePath);
        }
    });


})
//判断身份证出生日期是否合理-----------------------------------------------------------------------------
function checkMyDate(birthday){
    var myDate=new Date();
    var myDateYear=myDate.getFullYear();
    var myDateMonth=myDate.getMonth();
    var myDateDay=myDate.getDate();
    //由于月份与天数是系统解析出的，所有不做大于0判断
    if(myDateMonth+1<=9){
        myDateMonth="0"+(myDateMonth+1);
    }
    if (myDateDay<=9){
        myDateDay="0"+myDateDay;
    }
    myDate=myDateYear+myDateMonth+myDateDay;
    console.debug(birthday+"=="+myDate)
    if (parseInt(birthday) <= parseInt(myDate)){
        return true;
    }
    return false;

}
//通过身份证号设置出生日期---------------------------------------------------------------------------------
$(function () {
    $("#person_id").blur(function () {
        //先判断证件号码是否正确，正确获取证件号码中的6-14位生成日期
        if((/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/.test($("#person_id")[0].value))){
            var birthday=this.value.slice(6,14)
            console.debug(birthday);
            if(birthday.trim().length==8 && checkMyDate(birthday)){
                $("#messageBody")[0].innerText = "";
                birthday=birthday.slice(0,4)+"-"+birthday.slice(4,6)+"-"+birthday.slice(6,8);
                $("#birthday")[0].value=birthday;
            }else{
                $("#messageBody")[0].innerText = "身份证号日期可能有错误，请检查！";
                $("#messageModal").modal("show");
            }
        }
    })
})
//提交时用于检验表单数据的正确性----------------------------------------------------------------
function checkInfo() {
    var status=true;
    $("#messageBody")[0].innerText = ""
    if (status && !(/^[\u4e00-\u9fa5]{2,16}$/.test($("#name")[0].value))) {
        $("#messageBody")[0].innerText = "请输入正确的姓名！"
        status=false;
    }
    if (status && !(/^1[3456789]\d{9}$/.test($("#phone_number")[0].value))) {
        $("#messageBody")[0].innerText = "电话号码不正确，请重新输入"
        status=false;
    }
    if(status && ($("#company")[0].value == "")){
        console.debug($("#company")[0].value)
        $("#messageBody")[0].innerText = "单位不能为空";
        status=false;
    }
    if (status && !(/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/.test($("#person_id")[0].value))) {
        $("#messageBody")[0].innerText = "身份证号不合法！"
        status=false;
    }
    if(status && !checkMyDate($("#person_id")[0].value.slice(6,14))){
        $("#messageBody")[0].innerText = "身份证号出生日期大于今日,请使用真实身份证！"
        status=false;
    }
    if (status) {
        $.ajax({
            url: "/personIdCheck",
            dataType: "json",
            async:false,
            data: {"person_id":$("#person_id")[0].value,"id":$("#id")[0].value},
            type: "get",
            success: function (data) {
                if (data == false) {
                    $("#messageBody")[0].innerText = "身份证号已经存在！";
                    status=false;
                }
            },
        })
    }
    return status;
}
//编辑时回显数据------------------------------------------------------------------
function setDiverDetails(row) {
    $("#name")[0].value=row.valueOf().name;
    $("#phone_number")[0].value=row.valueOf().phone_number;
    $("#person_id")[0].value=row.valueOf().person_id;
    $("#birthday")[0].value=row.valueOf().birthday;
    $("#nationality")[0].value=row.valueOf().nationality;
    $("#company")[0].value=row.valueOf().company;
    $("#foreign_language_ability")[0].value=row.valueOf().foreign_language_ability;
    $("#education")[0].value=row.valueOf().education;
    var status=row.valueOf().marital_status==true ? "已婚":"未婚"
    $("#marital_status").val(status);
    $("#sex").val(row.valueOf().sex);
    if(row.valueOf().photo!=null && row.valueOf().photo.trim()!=""){
        $("#photoImg").attr("src","../../driverImg/"+row.valueOf().photo);
    }
}
//设置注册独有的模态框属性---------------------------------------------------------------
function alertModelByRegister(){
    $("#actionType")[0].innerText="注册新用户！！！";
    $("#registerModal input").val("");
    $("#driverInfoForm").find("input").attr("disabled",false);
    $("#driverInfoForm").find("select").attr("disabled",false);
    $("#photoImg").attr("src","../../driverImg/default.png");
    $("#submitChangeButton")[0].disabled="";
}
//设置编辑的一些提示逻辑已经数据来源---------------------------------------------------------
function alertModelByEdit(){
    var row=$("#table1").bootstrapTable("getSelections",function (row) {
        return row;
    });
    if(row.length!=1){
        if(row.length>1)
            $("#messageBody")[0].innerHTML="<font color='red'>编辑操作只能选择一条记录！！！</font>"
        else
            $("#messageBody")[0].innerHTML="<font color='red'>请选择一条记录进行编辑！！！</font>"
        $("#messageModal").modal("show");
        return;
    }
    //设置独有的模态框属性
    $("#actionType")[0].innerText="编辑用户！！！"
    $("#id")[0].value=row[0].valueOf().id
    $("#driverInfoForm").find("input").attr("disabled",false);
    $("#driverInfoForm").find("select").attr("disabled",false);
    $("#photo").val("");
    $("#submitChangeButton")[0].disabled="";
    setDiverDetails(row[0]);
    $("#registerModal").modal("show");

}
/**
 * 这是从前台直接拿数据的方法
 */

//详情操作重新请求后台数据-------------------------------------------------------------------
function getDetailsByAjax(id){
    $.ajax({
        url:"/getDriverDetails",
        dataType:"json",
        data: {"id":id},
        type:"get",
        success:function (data) {
            var driver=data;
            $("#name")[0].value=driver.name;
            $("#phone_number")[0].value=driver.phone_number;
            $("#person_id")[0].value=driver.person_id;
            $("#birthday")[0].value=driver.birthday;
            $("#nationality")[0].value=driver.nationality;
            $("#company")[0].value=driver.company;
            $("#foreign_language_ability")[0].value=driver.foreign_language_ability;
            $("#education")[0].value=driver.education;
            var status=driver.marital_status==true ? "已婚":"未婚";
            $("#sex").val(driver.sex);
            $("#photoImg").attr("src","../../driverImg/"+driver.photo);
        },
        error:function () {
            console.debug("sss");
        },
    })
}
//弹出详情框-------------------------------------------------------------------------------------------
function alertModelByDetails(row){
//通过ajax重新读取详情缓存数据
    getDetailsByAjax(row.valueOf().id);
    $("#actionType")[0].innerText="详情(只读)"
    $("#submitChangeButton")[0].disabled="disabled";
    $("#driverInfoForm").find("input").attr("disabled",true);
    $("#driverInfoForm").find("select").attr("disabled",true);
    $("#registerModal").modal("show");
}
//编辑与注册提交---------------------------------------------------------------------------------------
function submitRegisterInfoByAjax() {
    if(!checkInfo()){
        $("#messageModal").modal("show");
    }else{
        var form=new FormData($("#driverInfoForm")[0]);
        $.ajax({
            url:"/operateDriver",
            type:"post",
            data:form,
            processData:false,
            contentType:false,
            success:function (data) {
                if(data == true){
                    $("#resultText")[0].innerText="操作成功！！！";
                    $("#table1").bootstrapTable("refresh");
                    $("#registerModal").modal("hide");
                    $("#resultModal").modal("show");
                    return;
                }
                if(data == false){
                    $("#resultText")[0].innerText="操作失败,请重试！！！";
                    $("#resultModal").modal("show");
                    return;
                }
                if(true){
                    $("#resultText")[0].innerText=data;
                    $("#resultModal").modal("show");
                    return;
                }
            },
            error:function (result) {
                $("#resultText")[0].innerText="系统错误，请稍后再试！";
                $("#registerModal").modal("hide");
                $("#resultModal").modal("show");
            }
        })

        $("#registerModal").modal("hide");
    }
}
//日期控件---------------------------------------------------------------------------------------
$(function () {
    $("#birthday").datetimepicker({
        minView:"month",
        language:"zh-CN",
        format:"yyyy-mm-dd",
        //显示的当前日期
        setData:new Date(),
        //最大可选
        endDate:new Date(),
    });
})
//图片显示---------------------------------------------------------------------------------------
function photoCut(p) {
//图片加载完后设置大小
    if (p.width>215 || p.height>146){
        //下面只是为了保持图片的比例不让其失真
        if (p.width/p.height>215/146){
            p.width=215;
        }
        else{
            p.height=146;
        }
    }
}
