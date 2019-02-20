
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<html>
<%@ include file="../include/head.jsp"%>

<body class="hold-transition skin-blue sidebar-mini layout-boxed">
<script type="text/javascript">
	var result = "${msg}";
	if(result=="regSuccess"){
		alert("게시글 등록이 완료되었습니다.");
	}else if(result=="delSuccess"){
		alert("게시글 삭제가 완료되었습니다.");
	}
</script>
</script>
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
					<h3 class="box-title">게시글 목록</h3>
				</div>
				<div  class="box box-body">
					<table class="table table-bordered">
					<tbody>
					<tr>
						<th style="width: 30px">#</th>
						<th>제목</th>
						<th style="width: 100px">작성자</th>
						<th style="width: 150px">작성시간</th>
						<th style="width: 60px">조회</th>
					</tr>
					<c:forEach var="board" items="${boards}">
						<tr>
							<td>${board.board_no}</td>
							<td><a href="read.do?board_no=${board.board_no}">${board.title}</a></td>
							<td>${board.writer}</td>
							<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd a HH:mm"/></td>
							<td><span class="badge bg-red">${board.viewcnt}</span></td>
						</tr>
					</c:forEach>
					</tbody>
					</table>
				</div>
				<div class="box-footer">
					<div class="pull-right">
						<button class="btn btn-success btn-flat" id="writeBtn" onclick="location.href='write.do'" >
							<i class="fa fa-pencil"></i>글쓰기
						</button>
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