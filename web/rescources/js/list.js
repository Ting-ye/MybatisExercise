
//调用后台批量删除的方法
function deleteBatch(basePath){
    $("#mainForm").attr("action",basePath+"DeleteBatchServlet");
    $("#mainForm").submit();
}
//修改当前页码，条用后台查询
function changeCurrentPage(currentPage) {
    $("#currentPage").val(currentPage);
    $("#mainForm").submit();
}
//调用后台插入数据
function insertOne(basePath){
    $("#mainForm").attr("action",basePath+"insertOneServlet");
    $("#mainForm").submit();
}