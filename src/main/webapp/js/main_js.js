var type="注册新用户！！！";
var $queryURL="/getAllDriver?t="+Math.random();
var $columns=[
    {checkbox:true,visible:true},
    {field:"id",visible: false},
    {field:"name",title:"姓名",sortable:true,formatter: function (value,row,index) {
            //采用拼接字符串的方式传参不能传递对象，只能转成字符串。
            return "<a href='javascript:alertModelByDetails("+JSON.stringify(row)+")'><font color='red'>"+value+"</font></a>"
        }},
    {field:"nationality",title:"国籍"},
    {field:"phone_number",title:"号码"},
    {field:"marital_status",title:"婚姻状态"},
    {field:"person_id",title:"身份证号"},
    {field:"company",title:"所属公司"},
    {field:"sex",title:"性别",sortable:true},
    {field:"foreign_language_ability",title:"外语能力"},
    //前端日期需更改格式
    {field:"birthday",title:"生日"},
    {field:"education",title:"教育程度"},
    {field:"photo",title:"图片"},
]
//用于设置表格插件属性，以及fileinput属性
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
            sortOrder:"asc",
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
           /* onClickCell:function (field,value,row,$element) {
                if(field=="name"){
                    console.debug(row);
                    alertModelByDetails(row);
                }
            }*/
           getSelection:function (row) {
               return row;
           }

        }
    );
    $("#photo").fileinput({
        language:"zh",
        uploadUrl: "/driverImg",//上传路径
        addlwedFileExtensions:["jpg","png","gif"],
        showCaption:false,//是否显示标题
        showUpload:false,//显示上传按钮
        showRemove:false,
        showClose:false,
        borderTopWidth:{
            actionDelete:"",
        },
        browseClass:"btn btn-primary",//按钮样式
    })
})
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
    // $("#photo")[0].value=row.valueOf().photo;
}
function alertModelByRegister(){
    $("#actionType")[0].innerText="注册新用户！！！"
    $("#submitChangeButton")[0].disabled="";
    $("#registerModal input").val("");
}
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
    $("#actionType")[0].innerText="编辑用户！！！"
    $("#submitChangeButton")[0].disabled="";
    $("#driverId")[0].value=row[0].valueOf().id;
    setDiverDetails(row[0]);
    $("#registerModal").modal("show");
}
function alertModelByDetails(row) {
    setDiverDetails(row);
    $("#actionType")[0].innerText="详情(只读)"
    $("#submitChangeButton")[0].disabled="disabled";
    $("#registerModal").modal("show");
}
function submitRegisterInfoByAjax() {
    var form=new FormData($("#driverInfoForm")[0]);
    $.ajax({
        url:"/operateDriver",
        type:"post",
        data:form,
        processData:false,
        contentType:false,
        success:function (result) {
            if(result == "true"){

                $("#resultText")[0].innerHTML="<h4>操作成功！！！</h4>";
                $("#registerModal").modal("hide");
                $("#resultModal").modal("show");
            }else{
                $("#resultText")[0].innerHTML="<h4 style='color:blue'>操作失败请重试！！！</h4>";
                $("#resultModal").modal("show");
            }
        },
        error:function (result) {
            $("#resultText")[0].innerHTML="<h4 style='color: red'>系统错误，请稍后再试！！！</h4>";
            $("#registerModal").modal("hide");
            $("#resultModal").modal("show");
        }
    })


}
