
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="../include/head.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/dist/js/sockjs.js"></script>

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
                채팅창
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/"><i class="fa fa-dashboard"></i> home</a></li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
			<form name="contact-form" class="form" action="<c:url value='/sendMail'/>" method="POST">
			    <div class="col-xs-12">
			        <label>
			            <span>제목:</span>
			            <input type="text" name="subject" value="" placeholder="제목" required>
			        </label>
			    </div>
			    <div class="col-xs-12">
			        <label>
			            <span>내용:</span>
			            <textarea name="message" rows="4" placeholder="메시지" required></textarea>
			        </label>
			        <button type="submit" class="button">
			            <span class="default">Send <i class="icon fa fa-paper-plane"></i></span>
			        </button>
			    </div>
			</form>
			
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