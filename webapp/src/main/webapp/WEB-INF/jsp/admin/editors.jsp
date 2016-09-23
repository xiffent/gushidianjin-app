<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html class="no-js">
    
    <head>
    	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>GSDJ管理后台</title>
        <!-- Bootstrap -->
        <link href="<%=basePath %>static/admin/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="<%=basePath %>static/admin/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="<%=basePath %>static/admin/assets/styles.css" rel="stylesheet" media="screen">
        <link href="<%=basePath %>static/admin/assets/DT_bootstrap.css" rel="stylesheet" media="screen">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="<%=basePath %>static/admin/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">GSDJ管理后台</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> 超级管理员 <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                   
                                    <li class="divider"></li>
                                    <li>
                                        <a tabindex="-1" href="login.html">退出</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3" id="sidebar">
                    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                        <li>
                            <a href="<%=basePath %>admin/toIndexPage"><i class="icon-chevron-right"></i> 添加文章</a>
                        </li>
                        <li class="active">
                            <a href="<%=basePath %>admin/toListArticlePage"><i class="icon-chevron-right"></i> 所有文章</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon-chevron-right"></i> 分类管理</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon-chevron-right"></i> 股票池</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon-chevron-right"></i> 所有股票</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon-chevron-right"></i> 会员管理</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon-chevron-right"></i> 意见反馈</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon-chevron-right"></i> 广告管理</a>
                        </li>
                        <!--<li>
                            <a href="#"><span class="badge badge-success pull-right">731</span> Orders</a>
                        </li> -->
                    </ul>
                </div>
                
                <!--/span-->
                <div class="span9" id="content">
                     
                   <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">意见反馈</div>
                            </div>                              
                            <div class="block-content collapse in">
                                <div class="span12">
                                    
  									<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
										<thead>
											<tr>
												<th>会员ID（手机号）</th>
												<th>反馈内容</th>
												<th>提交时间</th>
											</tr>
										</thead>
										<tbody>
											<tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            <tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            <tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            <tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            <tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            <tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            <tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            <tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            <tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            <tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            <tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            <tr class="odd gradeX">
												<td>13256521021</td>
												<td>我觉得我们的软件挺好的，但是还需要提高</td>
                                                <td>2016-03-20 15:21</td>
											</tr>
                                            
                                             
										</tbody>
									</table>
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                     
                  
                     
                </div>
            </div>
            <hr>
            <footer>
                <p>&copy; GSDJ 2016</p>
            </footer>
        </div>
        <!--/.fluid-container-->

        <script src="<%=basePath %>static/admin/vendors/jquery-1.9.1.js"></script>
        <script src="<%=basePath %>static/admin/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=basePath %>static/admin/vendors/datatables/js/jquery.dataTables.min.js"></script>


        <script src="<%=basePath %>static/admin/assets/scripts.js"></script>
        <script src="<%=basePath %>static/admin/assets/DT_bootstrap.js"></script>
        <script>
        $(function() {
            
        });
        </script>
    </body>

</html>