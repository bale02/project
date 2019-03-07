
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
				<form role="form" id="writeForm" method="post" action="book_insert">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">도서 입력</h3>
						</div> 
						<div class="box-body">
							<div class="form-group">
								<input type="hidden" id="user_Id" name="user_Id" value="admin">
								<label for="title">제목</label>
								<input class="form-control" id="book_Name" name="book_Name" placeholder="책 제목을 입력해주세요">
							</div>
							<div class="form-group">
								<label for="content">저자</label>
								<input class="form-control" id="book_Writer" name="book_Writer" placeholder="책 저자을 입력해주세요">
							</div>
							<div class="form-group">
								<label for="writer">출판사</label>
								<input class="form-control" id="book_Publisher" name="book_Publisher" placeholder="출판사를 입력해주세요">
							</div>
							<%-- 첨부파일 --%>
			                <div class="form-group">
			                    <div class="fileDrop">
			                        <br/>
			                        <br/>
			                        <br/>
			                        <br/>
			                        <p class="text-center"><i class="fa fa-paperclip"></i> 책 사진을 드래그해주세요.</p>
			                    </div>
			                </div>
						</div>
               			 <%--첨부파일 영역 추가--%>
			            </div>
			            <div class="box-footer">
			                <ul class="mailbox-attachments clearfix uploadedFileList"></ul>
			            </div>
						<div class="box-footer">
							<button type="button" class="btn btn-primary" onclick="location.href='library'"><i class="fa fa-list"> 목록</i></button>
							<div class="pull-right">
								<button type="submit" class="btn btn-success"><i class="fa fa-save"> 저장</i></button>
								<button type="reset" class="btn btn-warning"><i class="fa fa-reply"> 초기화</i></button>
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
<script id="fileTemplate" type="text/x-handlebars-template">
    <li data-src="{{fullName}}">
        <span class="mailbox-attachment-icon has-img">
            <img src="{{imgSrc}}" alt="Attachment">
        </span>
        <div class="mailbox-attachment-info">
            <a href="{{originalFileUrl}}" class="mailbox-attachment-name">
                <i class="fa fa-paperclip"></i> {{originalFileName}}
            </a>
        </div>
    </li>
</script>

<script type="text/javascript">
	$("#writeForm").submit(function(event){
		event.preventDefault();
		var that = $(this);
		filesSubmit(that);
	});
	
	$(document).on("click",".delBtn",function(event){
		event.preventDefault();
		var that = $(this);
		deleteFileWrtPage(that);
	});
</script>
</body>

</html>