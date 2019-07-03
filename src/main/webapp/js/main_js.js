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
            clickToSelect:true,

            unniqueId:"id",
            showToggle:true,
            columns:$columns,

            toolbar:"#toolbar",
        }
    );
    $("#driverPhoto").fileinput({
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

function submitRegisterInfoByAjax() {
    var form=new FormData($("#driverInfoForm")[0]);
    $.ajax({
        url:"/registerDriver",
        type:"post",
        data:form,
        processData:false,
        contentType:false,
        success:function (result) {
            if(result == "true"){

                $("#resultText")[0].innerHTML="<h4>注册成功！！！</h4>";
                $("#registerModal").modal("hide");
                $("#resultModal").modal("show");
            }else{
                $("#resultText")[0].innerHTML="<h4 style='color:blue'>注册失败请重试！！！</h4>";
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
