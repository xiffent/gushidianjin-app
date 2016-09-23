<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML >
<html>
<head>
<title>无标题文档</title>
<meta http-equiv="Content-Type" content="application/vnd.wap.xhtml+xml;charset=utf-8" />
<meta http-equiv="Cache-Control" content="must-revalidate,no-cache" />
<meta name="viewport" content="width=device-width;initial-scale=1.0;maximum-scale=2.0;user-scalable=1" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection" />
<!-- UC默认竖屏 ，UC强制全屏 
<meta name="full-screen" content="yes"/>
<meta name="browsermode" content="application"/>-->
<link href="<%=basePath %>static/css/main.css" rel="stylesheet" type="text/css" />
<script>
if (/Android (\d+\.\d+)/.test(navigator.userAgent)) {
	var version = parseFloat(RegExp.$1);
	if (version > 2.3) {
		var phoneScale = parseInt(window.screen.width) / 750;
		document.write('<meta name="viewport" content="width=750, minimum-scale = ' + phoneScale + ', maximum-scale = ' + phoneScale + ', target-densitydpi=device-dpi">');
	} else {
		document.write('<meta name="viewport" content="width=750, target-densitydpi=device-dpi">');
	}
} else {
	document.write('<meta name="viewport" content="width=750, user-scalable=no, target-densitydpi=device-dpi">');
}
</script>

<script type="text/javascript">
window.onload=function()//用window的onload事件，窗体加载完毕的时候
		{
			var list='${fn:length(sharesModels)}';
			//alert(list);
			//alert("ss");
			if(list==0){
				document.getElementById('shareId').style.display = "none";
			}
		}
</script>
</head>

<body>
<!-- <header>
	<a href="#" class="return" title="首页"><em>首页</em></a>
    <section class="topTitle">文章详情</section>
</header> -->
<section class="bannerImg"><img src="${ article.articleCoverUrl}" alt=""></section>
<section class="infoTop">
	<section class="clearfix"><span class="tip fl">${ articleType.articleTypeName}</span><time class="fl" >${ article.cDate}</time></section>
    <h1>${article.articleTitle }</h1>
</section>
<section class="infoCont">
${article.articleContent }

</section>

<div id="shareId">
<section class="columnTitle"><h1>相关股票</h1></section>
<section class="stockMain">
	<ul class="top">
    	<li>
        	<section class="name fl">证券/代码</section>
            <section class="num fr">涨跌幅</section>
            <section class="price fr">当前价</section>
        </li>
    </ul>
    <ul>
    	<c:forEach items="${sharesModels}" var="sharesModel">  
    	<!-- 去掉 li标签上的点击事件  onclick="javascript:document.getElementById('sharesDetail').click();" -->
		         <li>
		         	<a id="sharesDetail" href="apiStock://shareCode=${sharesModel.sharesCode}">
		        	<section class="name fl">${sharesModel.sharesName}<span>${sharesModel.sharesCode}</span></section>
		        	<c:if test="${sharesModel.increase>'0'}">
		        	<section class="num fr"><span class="up">${sharesModel.increase}%</span></section>
		        	</c:if>
		        	<c:if test="${sharesModel.increase<'0'}">
		        	<section class="num fr"><span class="down">${sharesModel.increase}%</span></section>
		        	</c:if>
		            
		            <section class="price fr">${sharesModel.currentPrice}</section>
		            </a>
		        </li>
		</c:forEach>  
    
    </ul>
</section> 
</div>


<script src="<%=basePath %>static/js/iZepto.js" type="text/javascript"></script>
<%-- <script type="text/javascript" src="<%=basePath %>static/js/goTop.js"></script> --%>

</body>
</html>
