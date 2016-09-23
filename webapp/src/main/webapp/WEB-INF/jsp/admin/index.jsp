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
        <link href="<%=basePath %>static/admin/vendors/easypiechart/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
        <link href="<%=basePath %>static/admin/assets/styles.css" rel="stylesheet" media="screen">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="<%=basePath %>static/admin/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <style>
        	.control-group ul{ padding:15px 0;}
			.control-group ul li{ line-height:30px;}
			.control-group ul li a{ color:#ccc;}
        </style>
    </head>
    
    <body>
    	<input id="token" type="hidden" value="${token }">
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
                            <a href="<%=basePath %>admin/toIndexPage?token=${token }"><i class="icon-chevron-right"></i> 添加文章</a>
                        </li>
                        <li class="active">
                            <a href="<%=basePath %>admin/toListArticlePage?token=${token }"><i class="icon-chevron-right"></i> 所有文章</a>
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
                                <div class="muted pull-left">添加文章</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                    <form class="form-horizontal">
                                      <fieldset>
                                        <legend>开始添加</legend>
                                        <div class="control-group">
                                          <label class="control-label" for="typeahead">标题 </label>
                                          <div class="controls">
                                            <input type="text" class="span6" id="typeahead"  data-provide="typeahead" data-items="4" >
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="select01">所属栏目</label>
                                          <div class="controls controls_style_1">
                                            <select id="select01" class="chzn-select">
                                              <option id="MRNC">每日内参</option>
                                              <option id="RMTC">热门题材</option>
                                              <option id="GSRY">股市热议</option>
                                              <option id="NGZZ">牛股追踪</option>
                                              <option id="GSXD">高手心得</option>
                                              <option id="GJXW">高级席位</option>
                                            </select>
                                          </div>
                                        </div>
                                          <div class="control-group control-group-style-1">
                                          <label class="control-label" for="typeahead">建议仓位 </label>
                                          <div class="controls">
                                            <input type="text" class="span6 typeaheadspan6" id="cangwei"  data-provide="typeahead" data-items="4" >
                                          </div>
                                        </div>
                                        
                                        <div class="control-group control-group-style-1">
                                          <label class="control-label" for="typeahead">短期</label>
                                          <div class="controls">
                                            <input type="text" class="span6 typeaheadspan6" id="duanqi"  data-provide="typeahead" data-items="4" >
                                          </div>
                                        </div>
                                        
                                        <div class="control-group control-group-style-1">
                                          <label class="control-label" for="typeahead">中期</label>
                                          <div class="controls">
                                            <input type="text" class="span6 typeaheadspan6" id="zhongqi"  data-provide="typeahead" data-items="4" >
                                          </div>
                                        </div>
                                        
                                        <div class="control-group control-group-style-1">
                                          <label class="control-label" for="typeahead">题材热点</label>
                                          <div class="controls">
                                            <input type="text" class="span6 typeaheadspan6" id="redian"  data-provide="typeahead" data-items="4" >
                                          </div>
                                        </div>
                                        <div class="control-group control-group-style-1">
                                          <label class="control-label" for="typeahead">操作策略</label>
                                          <div class="controls">
                                            <input type="text" class="span6 typeaheadspan6" id="celue"  data-provide="typeahead" data-items="4" >
                                          </div>
                                        </div>
                                        <div class="control-group control-group-style-1">
                                          <label class="control-label" for="typeahead">风险提示</label>
                                          <div class="controls">
                                            <input type="text" class="span6 typeaheadspan6" id="fengxian"  data-provide="typeahead" data-items="4" >
                                          </div>
                                        </div>
                                        
                                        <div class="control-group">
                                          <label class="control-label" for="typeahead">作者 </label>
                                          <div class="controls">
                                            <input type="text" class="span6 typeaheadspan6" id="zuozhe"  data-provide="typeahead" data-items="4" >
                                          </div>
                                        </div>
                                        
                                        <div class="control-group">
                                         <label class="control-label" for="optionsCheckbox">发布时间</label>
                                          <div class="controls">
                                            <label style="float:left"><input type="radio" name="cdate" value="0" id="liji">立即发送</label>
                                            <label style="float:left;margin-left: 20px; "><input type="radio" name="cdate" value="1" id="dingshi">  定时发送</label>
                                          </div>
                                        </div>
                                         
                                         
                                        <div class="control-group">
                                          <label class="control-label" for="fileInput">文章封面图</label>
                                          <div class="controls">
                                            <input class="input-file uniform_on" id="file" type="file" name="file">
                                            <input class="addGupiaoButton" name="" type="button" value="上传" id="upload">
                                            <input type="hidden" value="" id="url">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="textarea2">文章详情</label>
                                          <div class="controls">
                                            <textarea class="input-xlarge textarea" placeholder="Enter text ..." style="width: 810px; height: 200px" id="xiangqing"></textarea>
                                          </div>
                                        </div>
                                        
                                        <div class="control-group">
                                          <label class="control-label" for="typeahead">相关股票 </label>
                                          <div class="controls">
                                          <!--<input type="text" class="span6" id="typeahead"  data-provide="typeahead" data-items="4" ><button class="btn btn-success" style="width:100px; margin-left:20px">添加</button><br>-->
                                            <div class="filed">
                                                <input id="addGupiao" class="addGupiao" name="addGupiao" type="text" placeholder="">
                                            </div>


                                                  <input class="addGupiaoButton" name="" type="button" value="添加">

                                            <ul id="gupiaolist">
                                            </ul>
                                          </div>
                                        </div>
                                        
                                        <div class="control-group">
                                          <label class="control-label" for="optionsCheckbox">文章属性</label>
                                          <div class="controls">
                                            <label style="float:left"><input type="radio" name="RadioGroup1" value="1" id="vip">  设为VIP</label>
                                            <label style="float:left;margin-left: 20px; "><input type="radio" name="RadioGroup1" value="0" id="no_vip">  公开</label>
                                          </div>
                                        </div>
                                        
                                        
                                        
                                        
                                        <div class="form-actions">
                                          <button type="button" class="btn btn-primary btn-large" id="fabu">发布</button>  
                                          <button type="button" class="btn btn-large" id="caogao">保持为草稿</button>
                                        </div>
                                      </fieldset>
                                    </form>

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
        <link href="<%=basePath %>static/admin/vendors/datepicker.css" rel="stylesheet" media="screen">
        <link href="<%=basePath %>static/admin/vendors/uniform.default.css" rel="stylesheet" media="screen">
        <link href="<%=basePath %>static/admin/vendors/chosen.min.css" rel="stylesheet" media="screen">

        <link href="<%=basePath %>static/admin/vendors/wysiwyg/bootstrap-wysihtml5.css" rel="stylesheet" media="screen">

        <script src="<%=basePath %>static/admin/vendors/jquery-1.9.1.js"></script>
        <script src="<%=basePath %>static/admin/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=basePath %>static/admin/vendors/jquery.uniform.min.js"></script>
        <script src="<%=basePath %>static/admin/vendors/chosen.jquery.min.js"></script>
        <script src="<%=basePath %>static/admin/vendors/bootstrap-datepicker.js"></script>

        <script src="<%=basePath %>static/admin/vendors/wysiwyg/wysihtml5-0.3.0.js"></script>
        <script src="<%=basePath %>static/admin/vendors/wysiwyg/bootstrap-wysihtml5.js"></script>

        <script src="<%=basePath %>static/admin/vendors/wizard/jquery.bootstrap.wizard.min.js"></script>

	<script type="text/javascript" src="<%=basePath %>static/admin/vendors/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="<%=basePath %>static/admin/assets/form-validation.js"></script>
    <script src="<%=basePath %>static/admin/assets/scripts.js"></script>
	<script src="<%=basePath %>static/admin/assets/jquery.autocompleter.js"></script>
	<script src="<%=basePath %>static/admin/js/ajaxfileupload.js"></script>

    <script>

	jQuery(document).ready(function() {   
	   FormValidation.init();
	});
		

            $(function() {
                setTimeout(function () {
                    $('.autocompleter').addClass('autocompleter-closed');
                });

                $.ajax({
                    url : "<%=basePath %>static/admin/json/gupiao.txt",
                    type : 'get',
                    dataType : 'json'
                }).done(function (data) {
                    $('#addGupiao').autocompleter({
                        highlightMatches: true,
                        source: data,
                        template: '{{ sharesCode }} - {{ sharesName }}',
                        hint: true,
                        empty: false,
                        limit: 5,
                        callback: function (value, index, selected) {
                            if (selected) {
                                $('#addGupiao').val(selected.sharesCode+' '+selected.sharesName)
                            }
                        }
                    });
                });


            });


        $(function() {
            $(".datepicker").datepicker();
            $(".uniform_on").uniform();
            $(".chzn-select").chosen();
            $('.textarea').wysihtml5();

            $('#rootwizard').bootstrapWizard({onTabShow: function(tab, navigation, index) {
                var $total = navigation.find('li').length;
                var $current = index+1;
                var $percent = ($current/$total) * 100;
                $('#rootwizard').find('.bar').css({width:$percent+'%'});
                // If it's the last tab then hide the last button and show the finish instead
                if($current >= $total) {
                    $('#rootwizard').find('.pager .next').hide();
                    $('#rootwizard').find('.pager .finish').show();
                    $('#rootwizard').find('.pager .finish').removeClass('disabled');
                } else {
                    $('#rootwizard').find('.pager .next').show();
                    $('#rootwizard').find('.pager .finish').hide();
                }
            }});
            $('#rootwizard .finish').click(function() {
                alert('Finished!, Starting over!');
                $('#rootwizard').find("a[href*='tab1']").trigger('click');
            });
        });
		
		
		$(function(){
			$('.addGupiaoButton').click(function(){
				var oVal=$('.addGupiao').val();
				$(this).parents('.controls').find('ul').append('<li>'+oVal+'  <a href="javascript:void(0);" class="delete">（删除）</a></li>');	
			});
			
			$(".controls").delegate(".delete", "click", function(event){
				$(this).parents('li').remove();	
			});
			$('.controls_style_1').change(function(){
				var oVal=$('.controls_style_1 .chzn-single span').html();
				if(oVal=='每日内参'){
					$('.control-group-style-1').show();
				}else{
					$('.control-group-style-1').hide();
				}
			});
				
		});
		
		$(function() {
		   
			$('#upload').on('click', function() {
				$.ajaxFileUpload({
		            url : " <%=basePath %>fileUpload/imgFileUpload ",
		            secureuri :false,
		            fileElementId : 'file',
		            type : "POST",
		            dataType : 'application/json',
		            success : function(data) {
		            	//var t = JSON.stringify(data);
		            	//console.log(data);
		            	//var reg = /<pre.+?>(.+)<\/pre>/g;  
		            	//var result = t.match(reg);  
		            	//data = RegExp.$1;
		            	var obj = jQuery.parseJSON(jQuery(data).text());
		            	if(obj.retCode == "1"){
		            		$('#url').val(obj.url);
		            		//alert($('#url').val());
		            		
		            		alert(obj.retMessage);
		            	
		            	}
		            },
		            error : function(data) {
		            	//var reg = /<pre.+?>(.+)<\/pre>/g;  
		            	//var result = data.match(reg);  
		            	//data = RegExp.$1;
		            	var obj = jQuery.parseJSON(jQuery(data).text());
		            	alert(obj.retMessage);
		            }
		        });
				
			})
		});
		
		//提交
		$(function() {
			$('#fabu').on('click', function() {
				
				var json = {};
				json.article = {};
				json.articleType = {};
				json.articleSharesRelations = [];
				
				var ul = document.getElementById('gupiaolist'); 
				var lis=ul.childNodes;
				for(var i=1;i<lis.length;i++){ 
					//alert("Item "+i+": "+lis.item(i).innerHTML); 
					//alert(lis.item(i).innerHTML);
					var values = lis.item(i).innerHTML.trim().split(" ");
					//alert(values[0]+","+values[1]);
					var json1={};
					json1.sharesId = values[0];
					json1.sharesName = values[1];
					json.articleSharesRelations.push(json1);
				}  
				
				var str = jQuery("#select01  option:selected").attr("id");
				
				if(str == "MRNC"){
					//alert(str);
					json.dayReference = {};
					json.dayReference.storeNum=$('#cangwei').val();
					json.dayReference.shortDate=$('#duanqi').val();
					json.dayReference.longDate=$('#zhongqi').val();
					json.dayReference.hotPoint=$('#redian').val();
					json.dayReference.operStrategy=$('#celue').val();
					json.dayReference.dangerCue=$('#fengxian').val();
				}
				
				json.article.articleTitle = $('#typeahead').val();
				json.article.articleAuthor = $('#zuozhe').val();
				json.article.cDate =  $('input[name="cdate"]:checked').val();
				json.article.articleCoverUrl = $('#url').val();
				json.article.articleContent = $('#xiangqing').val();
				json.article.isVipArticle = $('input[name="RadioGroup1"]:checked').val();
				
				json.articleType.articleTypeName=jQuery("#select01  option:selected").text();
				
				//alert(JSON.stringify(json));
				console.log(JSON.stringify(json));
				//alert($('#token').val());
				var token = $('#token').val();
				var strPath ="<%=basePath %>/article/addArticle";
                $.ajax( {    
        				url:strPath,// 跳转到 action    
        				data:{"token":token,"jsondata":JSON.stringify(json)},		//{"patentData":JSON.stringify(json)}传的参数，用jsondata自己组合
        				type:'post',     
        				cache:false,    
        				dataType:'json',    
        				success:function(data) {
        					alert("添加成功！");
        					//alert(data.retContent);
        					var token = data.retContent;
        					window.location.href="<%=basePath %>admin/toListArticlePage?token="+token;
        				 },    
        				 error : function() {    
        					  // view("异常！");    
        					  alert("异常！");    
        				 }    
        			});
			})
		});
		
		
        </script>
    </body>

</html>