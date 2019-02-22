
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
<script>
    var board_No = 1000;
    
	getReplies();
    
    function getReplies() {
        $.getJSON("list/" + board_No, function (data) {
            console.log(data);
            var str = "";
            
            $.each(data,function () {
                str += "<div class='post replyDiv' data-reply_No="+this.reply_No+">"
                	+	"<div class='user-block'>"
                	+	"<img class='img-circle img-bordered-sm' src='/dist/img/user1-128x128.jpg' alt='user image'>"
                	+	"<span class='username'>"
                    +   "<a href='#'>"+this.reply_Writer+"</a>"
                    +	"<a href='#' class='pull-right btn-box-tool replyDelBtn' data-toggle='modal' data-target='#delModal'><i class='fa fa-times'> 삭제</i>"
                    +   "</a>"
                    +   "<a href='#' class='pull-right btn-box-tool replyModBtn' data-toggle='modal' data-target='#modModal'>"
                    +   "<i class='fa fa-edit'> 수정</i>"
                   	+	"</a>"
                   	+	"</sapn>"
                   	+	"<span class='description'>"+this.regDate+"</span>"
                   	+	"</div>"
                   	+	"<div class='oldReplyText'>"+this.reply_Text+"</div>"
                   	+	"<br/>"
            });
            $("#replies").html(str);
        });
    }
    
    $('#replyAddBtn').on('click',function(){
    	var reply_Text = $("#newReplyText");
    	var reply_Writer = $("#newReplyWriter");
    	
    	var replyTextVal = reply_Text.val();
    	var replyWriterVal = reply_Writer.val();
    	
    	$.ajax({
    		type: "POST",
    		url:"replies",
    		headers : {
    			"Content-type" : "application/json",
    			"X-HTTP-Method-Override" : "POST"
    		},
    		dataType : "text",
    		data : JSON.stringify({
    			board_No : board_No,
    			reply_Text : replyTextVal,
    			reply_Writer : replyWriterVal
    		}),
    		success : function(result){
    			if(result == "regSuccess"){
    				alert("댓글 등록 완료!");
    			}
    			getReplies();
    			reply_Text.val("");
    			reply_Writer.val("");
    		}
    	});
    });
    
    $("#replies").on("click",".replyLi button", function(){
    	var reply = $(this).parent();
    	
    	var reply_No = reply.attr("data-reply_No");
    	var reply_Text = reply.find(".reply_Text").text();
    	var reply_Writer = reply.find(".reply_Writer").text();
    	
    	$("#reply_No").val(reply_No);
    	$("#reply_Text").val(reply_Text);
    	$("#reply_Writer").val(reply_Writer);
    });
    
    $(".modalDelBtn").on("click",function(){
    	var reply_No=$(this).parent().parent().find("#reply_No").val();
    	
    	$.ajax({
    		type :"delete",
    		url : "delete/" + reply_No,
    		headers : {
    			"Content-type" : "application/json",
    			"X-HTTP-Method-Override" : "DELETE"
    		},
    		dataType : "text",
    		success : function (result){
    			console.log("result : " + result);
    			if(result == "delSuccess"){
    				alert("댓글 삭제 완료!");
    				$("#modifyModal").modal("hide");
    				getReplies();
    			}
    		}
    	})
    })
    
    $(".modalModBtn").on("click",function(){
    	var reply = $(this).parent().parent();
    	var reply_No = reply.find("#reply_No").val();
    	var reply_Text = reply.find("#reply_Text").val();
    	
    	$.ajax({
    		type :"put",
    		url : "update/" + reply_No,
    		headers : {
    			"Content-type" : "application/json",
    			"X-HTTP-Method-Override" : "PUT"
    		},
    		data : JSON.stringify(
    			{reply_Text : reply_Text}
    		),
    		dataType : "text",
    		success : function(result){
    			console.log("result : " + result);
    			if(result == "modSuccess"){
    				alert("댓글 수정 완료!");
    				$("#modifyModal").modal("hide");
    				getReplies();
    			}
    		}
    		
    	})
    })
    
    
    
    
</script>
</body>

</html>