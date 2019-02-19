
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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
                글쓰기페이지
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/"><i class="fa fa-dashboard"></i> home</a></li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
			<div class="col-lg-12">
				<form role="form" id="writeForm" method="post" action="modify.do">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">게시글 수정</h3>
						</div> 
						<div class="box-body">
							<input type="hidden" name="board_no" value="${board.board_no}">
							<div class="form-group">
								<label for="title">제목</label>
								<input class="form-control" id="title" name="title" placeholder="제목을 입력해주세요" value="${board.title}">
							</div>
							<div class="form-group">
								<label for="content">내용</label>
								<textarea class="form-control" id="content" name="content" placeholder="내용을 입력해주세요" 
									rows="30" style="resize: none">${board.content}</textarea>
							</div>
							<div class="form-group">
								<label for="writer">작성자</label>
								<input class="form-control" id="writer" name="writer" value="${board.writer}" readonly>
							</div>
						</div>
						<div class="box-footer">
							<button type="button" class="btn btn-primary listBtn"><i class="fa fa-list"> 목록</i></button>
							<div class="pull-right">
								<button type="submit" class="btn btn-success saveBtn"><i class="fa fa-save"> 저장</i></button>
								<button type="button" class="btn btn-warning cancelBtn"><i class="fa fa-trash"> 취소</i></button>
							</div>
						</div>
					</div>
				</form>
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
		
		$(".saveBtn").on("click",function(){
			formObj.submit();
		});
		$(".cancelBtn").on("click",function(){
			history.go(-1);
		});
		$(".listBtn").on("click",function(){
			self.location = "list.do"
		});
	})
</script>

</body>

</html>