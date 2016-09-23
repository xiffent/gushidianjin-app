<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>GSDJ管理后台 - 登录页</title>
    <!-- Bootstrap -->
    <link href="<%=basePath %>static/admin/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="<%=basePath %>static/admin/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="<%=basePath %>static/admin/assets/styles.css" rel="stylesheet" media="screen">
     <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="<%=basePath %>static/admin/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
  </head>
  <body id="login">
    <div class="container">

      <form class="form-signin" action="<%=basePath %>admin/adminLogin" method="post">
        <h2 class="form-signin-heading">GSDJ管理后台</h2>
        <input type="text" class="input-block-level" placeholder="用户名" id="usernmae" name="username">
        <input type="password" class="input-block-level" placeholder="密码" id="password" name="password">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> 记住我
        </label>
        <button class="btn btn-large btn-primary" type="submit">登录</button>
        <input type="hidden" value="${result }" id="result">
      </form>

    </div> <!-- /container -->
    <script src="<%=basePath %>static/admin/vendors/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath %>static/admin/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    $(function() {
    	var result = $('#result').val();
    	if(result != null && result != ''){
    		alert(result);
    	}
    });
    </script>
  </body>
</html>