
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="../include/head.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/dist/js/sockjs.js"></script>
<script type="text/javascript">
	var result = "${msg}";
	if(result=="ADD"){
		alert("책 등록이 완료되었습니다.");
	}else if(result=="DEL"){
		alert("책 삭제가 완료되었습니다.");
	}else if(result=="Overcnt"){
		alert("3권까지만 대출 가능합니다.");
	}else if(result=="Rental"){
		alert("대여 완료되었습니다.");
	}else if(result=="Return"){
		alert("반납되었습니다.")
	}
</script>
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
                정보도서관
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/"><i class="fa fa-dashboard"></i> home</a></li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
			<div class="col-lg-12">
				<div class="box box-primary">
					<h3 class="box-title">도서 목록</h3>
				</div>
				<div class="box box-body">
					<table class="table table-bordered">
					<tbody>
					<tr>
						<th>책제목</th>
						<th style="width: 50px">저자</th>
						<th style="width: 80px">출판사</th>
						<th style="width: 150px">반납일자</th>
						<th style="width: 60px">댓글 수</th>
					</tr>
					<c:forEach var="library" items="${library}">
						<tr>
							<td><a href="book_read?book_No=${library.book_No}" >${library.book_Name}</a></td>
							<td>${library.book_Writer}</td>
							<td>${library.book_Publisher}</td>
							<td>
							<c:if test="${library.book_Check==0}">
								<fmt:formatDate value="${library.book_LimitDate}" pattern="yyyy-MM-dd a HH:mm"/>
							</c:if>
							</td>
							<td>${library.book_replycnt}</td>
						</tr>
					</c:forEach>
					</tbody>
					</table>
				</div>
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
							<c:if test="${startpage>10}">
								<li><a href="library?page=${startpage-10}${returnpage}">이전</a></li>
							</c:if>
							<c:forEach var="i" begin="${startpage}" end="${endpage}">
								<li <c:out value="${pageNUM == i ? 'class=active' : ''}"/>>
									<a href="library?page=${i}${returnpage}">${i}</a>
								</li>
							</c:forEach>
							<c:if test="${endpage<pagecount}">
								<li><a href="library?page=${startpage+10}${returnpage}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<div class="box-footer">
					<div class="form-group col-sm-2">
						<select class="form-control" name="keyfield" id="keyfield">
							<option value="all" selected>전체검색</option>
						<option value="title"
							<c:if test="${skey == 'title'}">selected</c:if>>책이름 검색</option>
						<option value="writer"
							<c:if test="${skey == 'writer' }">selected</c:if>>저자 검색</option>
						<option value="publisher"
							<c:if test="${skey == 'publisher' }">selected</c:if>>출판사 검색</option>
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
					<c:if test="${login.user_Id == 'admin' }">
						<div class="pull-right">
							<button class="btn btn-success btn-flat" id="writeBtn" onclick="location.href='book'" >
								<i class="fa fa-pencil"></i>책 입력
							</button>
						</div>
					</c:if>
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