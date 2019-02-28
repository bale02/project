
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>

<%@ include file="../include/head.jsp"%>
<style>
	.fileDrop{
		width: 100%;
		height: 200px;
		border: 2px dotted #0b58a2;
	}
</style>
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
							<input type="hidden" name="board_No" value="${board.board_No}">
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
							<div class="form-group">
								<div class="fileDrop">
									<br/>
									<br/>
									<br/>
									<br/>
									<p class="text-center"><i class="fa fa-paperclip"></i> 첨부파일을 드래그해주세요.</p>
								</div>
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

<script id="fileTemplate" type="text/x-handlebars-template">
    <li>
        <span class="mailbox-attachment-icon has-img">
            <img src="{{imgSrc}}" alt="Attachment">
        </span>
        <div class="mailbox-attachment-info">
            <a href="{{originalFileUrl}}" class="mailbox-attachment-name">
                <i class="fa fa-paperclip"></i> {{originalFileName}}
            </a>
            <a href="{{fullName}}" class="btn btn-default btn-xs pull-right delBtn">
                <i class="fa fa-fw fa-remove"></i>
            </a>
        </div>
    </li>
</script>

<script type="text/javascript">
	$(document).ready(function(){
		
		var board_No = ${board.board_No};
		
		$(document).on("click",".delBtn", function(event){
			event.preventDefault();
			if(confirm("삭제하시겠습니까?")){
				var that = $(this);
				deleteFileModPage(that,board_No);
			}
		});
		
		getFiles(board_No);
		
		$("#modifyForm").submit(function(event){
			event.preventDefault();
			var that = $(this);
			filesSubmit(that);
		});
		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".saveBtn").on("click",function(){
			formObj.submit();
		});
		$(".cancelBtn").on("click",function(){
			history.go(-1);
		});
		$(".listBtn").on("click",function(){
			self.location = "listCriteria.do"
		});
	})
</script>

</body>

</html>