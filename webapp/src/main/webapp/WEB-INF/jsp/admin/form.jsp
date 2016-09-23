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
                                <div class="muted pull-left">股票池</div>
                            </div>
                            <div class="sdfsdfsdf clearfix" style="padding:20px;">
                                <select class="span6 m-wrap" name="category" style="width:200px; float:left; margin-right:10px;">
                                    <option value="">推荐日期</option>
                                    <option value="Category 1">2016-04-05</option>
                                    <option value="Category 2">2016-04-06</option>
                                    <option value="Category 3">2016-04-07</option>
                                    <option value="Category 4">2016-04-08</option>
                                </select>
                                <button style="float:right" type="submit" class="btn btn-primary">筛选</button>
                            </div>                                    
                            <div class="block-content collapse in">
                                <div class="span12">
                                    
  									<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
										<thead>
											<tr>
												<th>推荐日期</th>
												<th>股票代码</th>
												<th>股票名称</th>
												<th>至今涨幅</th>
												<th>所在文章ID</th>
											</tr>
										</thead>
										<tbody>
											<tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
											</tr>
                                            <tr class="odd gradeX">
												<td>2016-04-03</td>
												<td>600056</td>
												<td>中国医药</td>
                                                <td>25%</td>
                                                <td><a href="#">041315</a> 、 <a href="#">041316</a> 、 <a href="#">041317</a></td>
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