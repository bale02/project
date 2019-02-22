
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
				<div class="box box-body">
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
							<td>${board.board_No}</td>
							<td><a href="read.do?board_No=${board.board_No}">${board.title}</a></td>
							<td>${board.writer}</td>
							<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd a HH:mm"/></td>
							<td><span class="badge bg-red">${board.viewcnt}</span></td>
						</tr>
					</c:forEach>
					</tbody>
					</table>
				</div>
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
							<c:if test="${startpage>10}">
								<li><a href="listCriteria.do?page=${startpage-10}${returnpage}">이전</a></li>
							</c:if>
							<c:forEach var="i" begin="${startpage}" end="${endpage}">
								<li <c:out value="${pageNUM == i ? 'class=active' : ''}"/>>
									<a href="listCriteria.do?page=${i}${returnpage}">${i}</a>
								</li>
							</c:forEach>
							<c:if test="${endpage<pagecount}">
								<li><a href="listCriteria.do?page=${startpage+10}${returnpage}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<div class="box-footer">
					<div class="form-group col-sm-2">
						<select class="form-control" name="keyfield" id="keyfield">
							<option value="all" selected>전체검색</option>
						<option value="writer"
							<c:if test="${skey == 'writer'}">selected</c:if>>이름조회</option>
						<option value="title"
							<c:if test="${skey == 'title' }">selected</c:if>>제목검색</option>
						<option value="content"
							<c:if test="${skey == 'content' }">selected</c:if>>내용검색</option>
						</select>
					</div>
					<div class="form-group col-sm-10">
						<div class="input-group">
							<input type="text" class="form-control" name="keyword" 
							id="keyword" value="${sval}" placeholder="검색">
							<span class="input-group-btn">
								<button type="button" class="btn btn-primary btn-flat" id="searchBtn" >
									<i class="fa fa-search"></i> 검색
								</button>
							</span>
						</div>
					</div>
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

<script type="text/javascript">
	$(function(){
		setSearchTypeSelect();
		function setSearchTypeSelect(){
			var $keyfield = $('keyfield');
			var $keyword = $('keyword');
			
		$('#searchBtn').on('click',function(){
			var keyfieldVal = $keyfield.val();
			var keywordVal = $keyword.val();
			self.location.href="listCriteria.do?page=1&" +
					"keyfield=" +$('#keyfield').val() + "&keyword=" + $('#keyword').val();
			})
		
		}	
	})


</script>

</body>

</html>