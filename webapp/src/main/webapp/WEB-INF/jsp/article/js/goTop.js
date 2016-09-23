//返回顶部
$('body').append('<a href="#" title="回到顶部" class="msGoTop">回到顶部</a>');

function returnTop() {
	var oScroll = getScrollTop();
	if (oScroll > $(window).height()) {
		$('.msGoTop').animate({ opacity: '1' }, 800, 'ease-in-out', function () { $('.msGoTop').show(); });
	} else {
		$('.msGoTop').animate({ opacity: '0' }, 800, 'ease-in-out', function () { $('.msGoTop').hide(); });
	}
}
returnTop();
$(window).scroll(function () {
	returnTop();
});


/*取窗口滚动条高度*/
function getScrollTop() {
    var scrollTop = 0;
    if (document.documentElement && document.documentElement.scrollTop) {
        scrollTop = document.documentElement.scrollTop;
    }
    else if (document.body) {
        scrollTop = document.body.scrollTop;
    }
    return scrollTop;
}


/*取窗口可视范围的高度*/
function getClientHeight() {
    var clientHeight = 0;
    if (document.body.clientHeight && document.documentElement.clientHeight) {
        var clientHeight = (document.body.clientHeight < document.documentElement.clientHeight) ? document.body.clientHeight : document.documentElement.clientHeight;
    }
    else {
        var clientHeight = (document.body.clientHeight > document.documentElement.clientHeight) ? document.body.clientHeight : document.documentElement.clientHeight;
    }
    return clientHeight;
}

/*取文档内容实际高度*/
function getScrollHeight() {
    return Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);
}
