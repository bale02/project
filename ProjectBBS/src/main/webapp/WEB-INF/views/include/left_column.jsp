<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <c:if test="${empty login}">
                <div class="pull-left image">
                    <img src="resources/dist/img/default-user.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>Guest</p>
                        <%-- Status --%>
                    <a href="#"><i class="fa fa-circle text-danger"></i> OFFLINE</a>
                </div>
            </c:if>
            <c:if test="${not empty login}">
                <div class="pull-left image">
                    <img src="resources/dist/img/default-user.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${login.user_Name}</p>
                        <%-- Status --%>
                    <a href="#"><i class="fa fa-circle text-success"></i> ONLINE</a>
                </div>
            </c:if>
        </div>

        <!-- search form (Optional) -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                    <button type="submit" name="search" id="search-btn" class="btn btn-flat">
                        <i class="fa fa-search"></i>
                    </button>
                </span>
            </div>
        </form>
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">테스트 예제</li>
            <li class="treeview">
                <a href="#"><i class="fa fa-folder"></i> <span>회원</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <c:if test="${empty login}">
                <ul class="treeview-menu">
                    <li><a href="login.do"><i class="glyphicon glyphicon-log-in"></i> 로그인</a></li>
                    <li><a href="register.do"><i class="fa fa-user-plus"></i> 회원가입</a></li>
                </ul>
                </c:if>
                <c:if test="${not empty login}">
                 <ul class="treeview-menu">
                    <li><a href="info"><i class="fa fa-info-circle"></i> 회원정보</a></li>
                    <li><a href="logout"><i class="glyphicon glyphicon-log-out"></i> 로그아웃</a></li>
                </ul>
                </c:if>
            </li>
            <li class="header">게시판</li>
            <li class="treeview">
                <a href="#"><i class="fa fa-edit"></i> <span>도서관</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="library"><i class="fa fa-pencil"></i>도서 목록</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-edit"></i> <span>게시판</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="write.do"><i class="fa fa-pencil"></i> 게시글 쓰기</a></li>
                    <li><a href="listCriteria.do"><i class="fa fa-list"></i> 게시글 목록</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-edit"></i> <span>채팅방</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="chat"><i class="fa fa-pencil"></i> 채팅방</a></li>
                </ul>
            </li>
            

        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>