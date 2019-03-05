
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
			<form id="chatForm">
				<input type="text" id="message"/>
				<button>send</button>
			</form>
			<div id="chat"></div>
			<script>
				$(document).ready(function(){
					$("#chatForm").submit(function(event){
						event.preventDefault();
						sock.send($("#message").val());
						$("#message").val('').focus();
					});
				});
				
				var sock = new SockJS("/echo");
				sock.onmessage = function(e){
					$("#chat").append(e.data + "<br/>");
				}
				
				sock.onclose = function(){
					$("#chat").append("연결 종료");
				}
			
			</script>
			
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