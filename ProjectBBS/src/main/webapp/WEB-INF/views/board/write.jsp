
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>

<jsp:include page="../include/head.jsp"/>

<body class="hold-transition skin-blue sidebar-mini layout-boxed">

<div class="wrapper">

    <!-- Main Header -->
    <jsp:include page="../include/main_header.jsp"/>

    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="../include/left_column.jsp"/>

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
				<form role="form" id="writeForm" method="post" action="${path}/board/write">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">게시글 작성</h3>
						</div> 
						<div class="box-body">
							<div class="form-group">
								<label for="title">제목</label>
								<input class="form-control" id="title" name="title" placeholder="제목을 입력해주세요">
							</div>
							<div class="form-group">
								<label for="content">내용</label>
								<textarea class="form-control" id="content" name="content" placeholder="내용을 입력해주세요" 
									rows="30" style="resize: none"></textarea>
							</div>
							<div class="form-group">
								<label for="writer">작성자</label>
								<input class="form-control" id="writer" name="writer">
							</div>
						</div>
						<div class="box-footer">
							<button type="button" class="btn btn-primary"><i class="fa fa-list"> 목록</i></button>
							<div class="pull-right">
								<button type="submit" class="btn btn-success"><i class="fa fa-save"> 저장</i></button>
								<button type="reset" class="btn btn-warning"><i class="fa fa-reply"> 초기화</i></button>
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
    <jsp:include page="../include/main_footer.jsp"/>

</div>
<!-- ./wrapper -->

<jsp:include page="../include/plugin_js.jsp"/>

</body>

</html>