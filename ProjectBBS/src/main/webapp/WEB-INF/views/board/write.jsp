
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
				<form role="form" id="writeForm" method="post" action="write.do">
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
							<%-- 첨부파일 --%>
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
               			 <%--첨부파일 영역 추가--%>
			            </div>
			            <div class="box-footer">
			                <ul class="mailbox-attachments clearfix uploadedFileList"></ul>
			            </div>
						<div class="box-footer">
							<button type="button" class="btn btn-primary" onclick="location.href='listCriteria.do'"><i class="fa fa-list"> 목록</i></button>
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