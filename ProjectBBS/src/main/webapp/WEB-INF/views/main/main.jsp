
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="../include/head.jsp"%>
<style>
#map {
        width: 100%;
        height: 400px;
        background-color: grey;
      }
 </style>
 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC3d0HaRVsLDfLo2g7fX9zdVt3GbV1rSss" type="text/javascript"></script>
<script>
function initialize() {
 var LatLng = new google.maps.LatLng(37.496736, 127.030084);
	var mapProp = {
  	center: LatLng, // 위치
    zoom:15, // 어느정도까지 세세하게 볼 것인지.
    mapTypeId:google.maps.MapTypeId.ROADMAP
  };
  var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
  var marker = new google.maps.Marker({
	position: LatLng,
	map: map,
  });
}
google.maps.event.addDomListener(window, 'load', initialize);
</script>


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
                정보도서관
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/"><i class="fa fa-dashboard"></i> home</a></li>
            </ol>
        </section>
        	<div style="width: 800px;height: 400px">
        	</div>
        	<!-- 
			<div id="googleMap" style="margin-left:20px;width:900px;height:400px;"></div>
        	 -->

        <!-- Main content -->
        <section class="content container-fluid">
				
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