
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
					<h3 class="box-title">글 제목 : ${board.title}</h3>
				</div>
				<div class="box-body" style="height: 600px">
					${board.content}
				</div>
				<div class="box-footer">
					<div class="user-block">
						<img class="img-circle img-bordered-sm" src="../dist/img/user1-128x128.jpg" alt="user image">
						<span class="username">
							<a href="#">${board.writer}</a>
						</span>
						<span class="description"><fmt:formatDate pattern="yyyy-MM-dd a HH:mm" value="${board.regdate}"/></span>
					</div>
				</div>
				<div class="box-footer">
					<form role="form" method="post">
						<input type="hidden" name="board_No" value="${board.board_No}">
					</form>
					<button type="submit" class="btn btn-primary listBtn" ><i class="fa fa-list"></i> 목록</button>
					<div class="pull-right">
						<button type="submit" class="btn btn-warning modBtn" ><i class="fa fa-edit"></i> 수정</button>
						<button type="submit" class="btn btn-danger delBtn" ><i class="fa fa-trash" ></i> 삭제</button>
					</div>
				</div> 
			
			
				<div class="box box-warnig">
					<div class="box-header with-border">
						<a class="link-black text-lg"><i class="fa fa-pencil"></i> 댓글작성</a>
					</div>
					<div class="box-body">
						<form class="form-horizontal">
							<div class="form-group margin">
								<div class="col-sm-10">
									<textarea class="form-control" id="newReplyText" rows="3" placeholder="댓글 내용 입력" style="resize:none"></textarea>
								</div>
								<div class="col-sm-2">
									<input class="form-control" id="newReplyWriter" type="text" placeholder="댓글 작성자..">
								</div>
								<hr/>
								<div class="col-sm-2">
									<button type="button" class="btn btn-primary btn-block replyAddBtn"><i class="fa fa-save"></i> 저장</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="box box-success collapsed-box">
					<div class="box-header with-border">
						<a href="" class="link-black text-lg"><i class="fa fa-comments-o margin-r-5 replyCount"></i></a>
						<div class="box-tools">
							<button type="button" class="btn btn-box-tool" data-widget="collapse">
								<i class="fa fa-plus"></i>
							</button>
						</div>
					</div>
					<div class="box-body repliesDiv">
						<ul id="replies">
						
						</ul>
					</div>
				</div>
				<%--댓글 수정 영역 --%>
				<div class="modal fade" id="modModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span></button>
								<h4 class="modal-title">댓글 수정</h4>
							</div>
							<div class="modal-body" data-rno>
								<input type="hidden" class="reply_No"/>
								<textarea class="form-control" id="reply_Text" name="reply_Text" rows="3" style="resize:none"></textarea>	
							</div>
							<div class="modal-footer">
								<div>
									<button type="button" class="btn btn-primary modalModBtn">수정</button>
									<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%--댓글 삭제 영역 --%>
				 <div class="modal fade" id="delModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">댓글 삭제</h4>
                                <input type="hidden" class="rno"/>
                            </div>
                            <div class="modal-body" data-rno>
                                <p>댓글을 삭제하시겠습니까?</p>
                                <input type="hidden" class="rno"/>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary modalDelBtn">삭제</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
                            </div>
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

<script id="replyTemplate" type="text/x-handlebars-template">
    {{#each.}}
    <div class="post replyDiv" data-reply_No={{reply_No}}>
		<%--댓글 작성자 프로필사진--%>
        <div class="user-block">
		<img class="img-circle img-bordered-sm" src="/dist/img/user1-128x128.jpg" alt="user image">
            <%--댓글 작성자--%>
            <span class="username">
                <%--작성자 이름--%>
                <a href="#">{{reply_Writer}}</a>
                <%--댓글 삭제 버튼--%>
                <a href="#" class="pull-right btn-box-tool replyDelBtn" data-toggle="modal" data-target="#delModal">
                    <i class="fa fa-times"> 삭제</i>
                </a>
                <%--댓글 수정 버튼--%>
                <a href="#" class="pull-right btn-box-tool replyModBtn" data-toggle="modal" data-target="#modModal">
                    <i class="fa fa-edit"> 수정</i>
                </a>
            </span>
            <%--댓글 작성일자--%>
            <span class="description">{{prettifyDate regDate}}</span>
        </div>
        <%--댓글 내용--%>
        <div class="oldReplyText">{{{escape reply_Text}}}</div>
        <br/>
    </div>
    {{/each}}
</script>
<script>
$(document).ready(function () {

    var board_No = "${board.board_No }";  // 현재 게시글 번호
   
    // 댓글 내용 : 줄바꿈/공백처리
    Handlebars.registerHelper("escape", function (replyText) {
        var text = Handlebars.Utils.escapeExpression(replyText);
        text = text.replace(/(\r\n|\n|\r)/gm, "<br/>");
        text = text.replace(/( )/gm, "&nbsp;");
        return new Handlebars.SafeString(text);
    });

    // 댓글 등록일자 : 날짜/시간 2자리로 맞추기
    Handlebars.registerHelper("prettifyDate", function (timeValue) {
        var dateObj = new Date(timeValue);
        var year = dateObj.getFullYear();
        var month = dateObj.getMonth() + 1;
        var date = dateObj.getDate();
        var hours = dateObj.getHours();
        var minutes = dateObj.getMinutes();
        // 2자리 숫자로 변환
        month < 10 ? month = '0' + month : month;
        date < 10 ? date = '0' + date : date;
        hours < 10 ? hours = '0' + hours : hours;
        minutes < 10 ? minutes = '0' + minutes : minutes;
        return year + "-" + month + "-" + date + " " + hours + ":" + minutes;
    });

    // 댓글 목록 함수 호출
    getReplies();

    // 댓글 목록 함수
    function getReplies() {
        $.getJSON("count/"+board_No, function (data) {
            printReplies(data.replies, $(".repliesDiv"), $("#replyTemplate"));
        });
    }
    getReplyCount();

 		function getReplyCount(){
			$.getJSON("count/"+board_No,function(data){
			
			var repliesCount = data.repliesCount; 
			var replyCount = $(".replyCount");
			var collapsedBox = $(".collapsed-box");
			
			if(repliesCount ===0){
				replyCount.html(" 댓글이 없습니다.");
				collapsedBox.find(".btn-box-tool").remove();
				return;
			}else{
			replyCount.html(' 댓글목록 ('+repliesCount+')');
			collapsedBox.find(".box-tools").html(
				"<button type='button' class='btn btn-box-tool' data-widget='collapse'>"
				+ "<i class='fa fa-plus'></i>"
				+ "</button>"
			)};
		})
		}


    // 댓글 목록 출력 함수
    function printReplies(replyArr, targetArea, templateObj) {
        var replyTemplate = Handlebars.compile(templateObj.html());
        var html = replyTemplate(replyArr);
        $(".replyDiv").remove();
        targetArea.html(html);
    }
	
		$(".replyAddBtn").on("click",function(){
			var replyWriterObj = $("#newReplyWriter");
			var replyTextObj = $("#newReplyText");
			var replyWriter = replyWriterObj.val();
			var replyText = replyTextObj.val();
			
            $.ajax({
                type: "post",
                url: "replies/",
                headers: {
                    "Content-Type": "application/json",
                    "X-HTTP-Method-Override": "POST"
                },
                dataType: "text",
                data: JSON.stringify({
                    board_No: board_No,
                    reply_Writer: replyWriter,
                    reply_Text: replyText
                }),
                success: function (result) {
                    console.log("result : " + result);
                    if (result === "regSuccess") {
                        alert("댓글이 등록되었습니다.");
                       
                        getReplies(); // 댓글 목록 호출
                        getReplyCount();
                        replyTextObj.val("");   // 댓글 입력창 공백처리
                        replyWriterObj.val("");   // 댓글 입력창 공백처리
                    }
                },
                error: function(){
                	alert("error");
                }
            });

		});
		//댓글수정을 위한 modal 값에 데이터 넣기
		
		$(".repliesDiv").on("click",".replyDiv",function(event){
			var reply = $(this);
			$(".reply_No").val(reply.attr("data-reply_No"));
		});
		
		//modal 창의 댓글 수정버튼 클릭
		$(".modalModBtn").on("click",function(){
			var reply_No = $(".reply_No").val();
			var reply_TextObj = $("#reply_Text");
			var reply_Text = reply_TextObj.val();
			
			if(reply_Text == null || reply_Text == ""){
				alert("글을 입력하세요.");
				return;
			}
			
			$.ajax({
				type : "PUT",
				url : "update/" + reply_No,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "PUT"
				},
				dataType : "text",
				data : JSON.stringify({
					reply_Text : reply_Text
				}),
				success : function(result){
					console.log("result : " + result);
					if(result=="modSuccess"){
						alert("댓글이 수정되었습니다.");
						getReplies();
						getReplyCount();
						$("#modModal").modal("hide");
						reply_TextObj.val("");
					}
				}
			});
		});
		
		$(".ModalDelBtn").on("click",function(){
			var reply_No = $(".reply_No").val();
			$.ajax({
				type : "DELETE",
				url : "delete/" + reply_No,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : "text",
				success : function(result){
					console.log("result : " + result);
					if(result=="delSuccess"){
						alert("댓글이 삭제되었습니다.");
						getReplies();
						getReplyCount();
						$("#delModal").modal("hide");
					}
				}
			});
		});
		
	});
</script>


<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".modBtn").on("click",function(){
			formObj.attr("action","modify.do");
			formObj.attr("method","GET");
			formObj.submit();
		});
		$(".listBtn").on("click",function(){
			self.location="listCriteria.do";
		});
		$(".delBtn").on("click",function(){
			formObj.attr("action","delete.do");
			formObj.attr("method","GET");
			formObj.submit();
		});
	});
	
</script>

</body>

</html>