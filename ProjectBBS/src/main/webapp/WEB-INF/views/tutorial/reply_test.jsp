
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
                메인페이지
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/"><i class="fa fa-dashboard"></i> home</a></li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
			<div class="col-lg-12">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">댓글 작성</h3>
					</div>
					<div class="box-body">
						<div class="form-group">
							<label for="newReplyText">댓글 내용</label>
							<input class="form-control" id="newReplyText" name="reply_Text" 
								placeholder="댓글 내용을 입력해주세요.">
						</div>
						<div class="form-group">
							<label for="newReplyWriter">댓글 작성자</label>
							<input class="form-control" id="newReplyWriter" name="reply_Writer"
								placeholder="댓글 작성자를 입력해주세요.">
						</div>
						 <div class="pull-right">
                            <button type="button" id="replyAddBtn" class="btn btn-primary"><i class="fa fa-save"></i> 댓글 저장</button>
                        </div>
					</div>
					<div class="box-footer">
						<ul id="replies">
						
						</ul>
					</div>
				</div>
			</div>
			
			<div class="modal fade" id="modifyModal" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">댓글 수정창</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label for="reply_No">댓글 번호</label>
								<input class="form-control" id="reply_No" name="reply_No" readonly="readonly">
							</div>
							<div class="form-group">
								<label for="reply_Text">댓글 내용</label>
								<input class="form-control" id="reply_Text" name="reply_Text" placeholder="댓글 내용을 입력해주세요.">
							</div>
							<div class="form-group">
								<label for="reply_Writer">댓글 작성자</label>
								<input class="form-control" id="reply_Writer" name="reply_Writer" readonly="readonly">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal">닫기</button>
							<button type="button" class="btn btn-success modalModBtn">수정</button>
							<button type="button" class="btn btn-danger modalDelBtn">삭제</button>
						</div>
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

</body>

</html>