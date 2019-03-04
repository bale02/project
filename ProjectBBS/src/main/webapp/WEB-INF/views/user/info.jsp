
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
        <%-- Content Header (Page header) --%>
        <section class="content-header">
            <h1>
                회원 정보
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> user</a></li>
                <li class="active">profile</li>
            </ol>
        </section>
		        <section class="content container-fluid">
            <div class="col-md-8">

                <!-- Profile Image -->
                <div class="box box-primary">
                    <div class="box-body box-profile">
                        <img class="profile-user-img img-responsive img-circle"
                             src="${path}/user${login.userImg}" alt="User profile picture">
                        <h3 class="profile-username text-center">${login.user_Name}</h3>
                        <ul class="list-group list-group-unbordered">
                            <li class="list-group-item">
                                <div class="progress active">
                                    <div class="progress-bar progress-bar-success progress-bar-striped"
                                         role="progressbar"
                                         aria-valuenow="20"
                                         aria-valuemin="0"
                                         aria-valuemax="100" style="width: 20%">
                                        <span class="sr-only">20% Complete</span>
                                    </div>
                                </div>
                                <b>활동 포인트 / 레벨</b> <a class="pull-right">1,322 / lv. 10</a>
                            </li>
                            <li class="list-group-item">
                                <b>팔로잉</b> <a class="pull-right">543</a>
                            </li>
                            <li class="list-group-item">
                                <b>팔로우</b> <a class="pull-right">13,287</a>
                            </li>
                        </ul>
                        <div class="text-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myInfoMod">
                                    회원 정보 수정
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myPwMod">
                                    비밀번호 수정
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myProfileImgMod">
                                    프로필 이미지 수정
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#Withdrawal">
                                    회원 탈퇴
                                </button>
                            </div>
                        </div>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
            <div class="col-md-4">

                <!-- About Me Box -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">가입 정보</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <strong><i class="fa fa-user-plus margin-r-5"></i> 회원가입일</strong>
                        <p class="text-muted">
                            <fmt:formatDate value="${login.user_Join_Date}" pattern="yyyy-MM-dd"/>
                        </p>

                        <hr>

                        <strong><i class="fa fa-sign-in margin-r-5"></i> 최종 접속일</strong>
                        <p class="text-muted">
                            <fmt:formatDate value="${login.user_Login_Date}" pattern="yyyy-MM-dd a HH:mm"/>
                        </p>

                        <hr>

                        <strong><i class="fa fa-envelope-o margin-r-5"></i> 이메일</strong>
                        <p class="text-muted">
                            ${login.user_Email}
                        </p>

                        <hr>

                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
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