<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
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
</head>

<body>
<!-- <header>
	<a href="#" class="return" title="首页"><em>首页</em></a>
    <section class="topTitle">文章详情</section>
</header> -->
<section class="infoTop_style_1">
	<section class="infoTop">
        <h1>2月16日股市操盘内参</h1>
        <p>深度剖析，掌握先机</p>
    </section>
    <section class="bannerImg"><img src="<%=basePath %>static/images/1.jpg" alt=""></section>
    
    <section class="infoCont">
    <p class="red">你还不是我们的vip会员，暂时无法浏览以下内容，请升级会员，最新牛股追踪， 最新的政策实时解读，及时的盘前盘后 点评尽收眼底，从此股市新手变达人！ </p>
    <a class="butVip" href="apiVip://updateVip" title="立即升级会员">立即升级会员</a>
    </section>
</section>

<section class="ranking ranking_style_2">
    <section class="rankingTop">
        <strong>牛股点金排行</strong>
        实力说话，带你赚钱
    </section> 
    <section class="rankingTop">
    	<ul>
        	<li class="one clearfix">
                <section class="name">累计涨幅</section>
                <section class="num">+7.65%</section>
                <section class="cont clearfix"><span class="fl">双林股份</span><span class="fr">02-05 09:05</span></section>
            </li>
            <li class="two clearfix">
                <section class="name">累计涨幅</section>
                <section class="num">+7.65%</section>
                <section class="cont clearfix"><span class="fl">双林股份</span><span class="fr">02-05 09:05</span></section>
            </li>
        </ul>
        <p>（过去两周最高涨幅榜）</p>
    </section>
    <section class="rankingDwon">
    	<ul class="top">
            <li>
            	<section class="xh fl">序号</section>
                <section class="name fl">证券/代码</section>
                <section class="num fr">涨跌幅</section>
                <section class="price fr">当前价</section>
            </li>
        </ul>
    	<ul>
        	<li class="one clearfix">
            	<section class="xh fl"><span>1</span></section>
                <section class="name fl">累计涨幅</section>
                <section class="num fr">+7.65%</section>
                <section class="price fr">28.88</section>
            </li>
            <li class="two clearfix">
            	<section class="xh fl"><span>2</span></section>
                <section class="name fl">累计涨幅</section>
                <section class="num fr">+7.65%</section>
                <section class="price fr">28.88</section>
            </li>
            <li class="two clearfix">
            	<section class="xh fl"><span>3</span></section>
                <section class="name fl">累计涨幅</section>
                <section class="num fr">+7.65%</section>
                <section class="price fr">28.88</section>
            </li>
            <li class="two clearfix">
            	<section class="xh fl"><span>4</span></section>
                <section class="name fl">累计涨幅</section>
                <section class="num fr">+7.65%</section>
                <section class="price fr">28.88</section>
            </li>
            <li class="two clearfix">
            	<section class="xh fl"><span>5</span></section>
                <section class="name fl">累计涨幅</section>
                <section class="num fr">+7.65%</section>
                <section class="price fr">28.88</section>
            </li>
            <li class="two clearfix">
            	<section class="xh fl"><span>6</span></section>
                <section class="name fl">累计涨幅</section>
                <section class="num fr">+7.65%</section>
                <section class="price fr">28.88</section>
            </li>
            <li class="two clearfix">
            	<section class="xh fl"><span>7</span></section>
                <section class="name fl">累计涨幅</section>
                <section class="num fr">+7.65%</section>
                <section class="price fr">28.88</section>
            </li>
            <li class="two clearfix">
            	<section class="xh fl"><span>8</span></section>
                <section class="name fl">累计涨幅</section>
                <section class="num fr">+7.65%</section>
                <section class="price fr">28.88</section>
            </li>
            <li class="two clearfix">
            	<section class="xh fl"><span>9</span></section>
                <section class="name fl">累计涨幅</section>
                <section class="num fr">+7.65%</section>
                <section class="price fr">28.88</section>
            </li>
            <li class="two clearfix">
            	<section class="xh fl"><span>10</span></section>
                <section class="name fl">累计涨幅</section>
                <section class="num fr">+7.65%</section>
                <section class="price fr">28.88</section>
            </li>
        </ul>
        <p>（过去三个月最高涨幅榜）</p>
    </section>
    
</section> 



<script src="<%=basePath %>static/js/iZepto.js" type="text/javascript"></script>
<%-- <script type="text/javascript" src="<%=basePath %>static/js/goTop.js"></script> --%>
</body>
</html>
