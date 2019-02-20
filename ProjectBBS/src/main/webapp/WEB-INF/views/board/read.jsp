
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<%@ include file="../include/head.jsp"%>

<body class="hold-transition skin-blue sidebar-mini layout-boxed">

<div class="wrapper">

    <!-- Main Header -->
    <%@ include file="../include/main_header.jsp"%>

    <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="../include/left_column.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1> 
                게시판
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/"><i class="fa fa-dashboard"></i> home</a></li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
			<div class="col-lg-12">
				<div class="box box-primary">
					<h3 class="box-title">글 제목 : ${board.title}</h3>
				</div>
				<div class="box-body" style="height: 600px">
					${board.content}
				</div>
				<div class="box-footer">
					<div class="user-block">
						<img class="img-circle img-bordered-sm" src="../dist/img/user1-128x128.jpg" alt="user image">
						<span class="username">
							<a href="#">${board.writer}</a>
						</span>
						<span class="description"><fmt:formatDate pattern="yyyy-MM-dd a HH:mm" value="${board.regdate}"/></span>
					</div>
				</div>
				<div class="box-footer">
					<form role="form" method="post">
						<input type="hidden" name="board_no" value="${board.board_no}">
					</form>
					<button type="submit" class="btn btn-primary listBtn" ><i class="fa fa-list"></i> 목록</button>
					<div class="pull-right">
						<button type="submit" class="btn btn-warning modBtn" ><i class="fa fa-edit"></i> 수정</button>
						<button type="submit" class="btn btn-danger delBtn" ><i class="fa fa-trash" ></i> 삭제</button>
					</div>
				</div> 
			</div>
			
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <%@ include file="../include/main_footer.jsp"%>

</div>
<!-- ./wrapper -->

<%@ include file="../include/plugin_js.jsp"%>

<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".modBtn").on("click",function(){
			formObj.attr("action","modify.do");
			formObj.attr("method","GET");
			formObj.submit();
		});
		$(".listBtn").on("click",function(){
			self.location="listCriteria.do";
		});
		$(".delBtn").on("click",function(){
			formObj.attr("action","delete.do");
			formObj.attr("method","GET");
			formObj.submit();
		});
	});
</script>

</body>

</html>