<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="common/taglib.jsp"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

<script src="${basePath}/static/js/jQuery.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/public.css"/>
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/index.css"/>


</head>
<body>
<!-- 头部页面 -->
<%@include file="common/header.jsp"%>
	
	<div class="banner">
		<div class="content">
			<ul>
				<li class="fl">
					<a href="javascript:void(0)">
						<img src="${basePath}/static/img/5.jpg"/>
					</a>
				</li>			
				<li class="fl">
					<a href="javascript:void(0)">
						<img src="${basePath}/static/img/1.jpg"/>
					</a>
				</li>
				<li class="fl">
					<a href="javascript:void(0)">
						<img src="${basePath}/static/img/2.png"/>
					</a>
				</li>
				<li class="fl">
					<a href="javascript:void(0)">
						<img src="${basePath}/static/img/3.png"/>
					</a>
				</li>
				<li class="fl">
					<a href="javascript:void(0)">
						<img src="${basePath}/static/img/4.png"/>
					</a>
				</li>
				<li class="fl">
					<a href="javascript:void(0)">
						<img src="${basePath}/static/img/5.png"/>
					</a>
				</li>
				<li class="fl">
					<a href="javascript:void(0)">
						<img src="${basePath}/static/img/1.jpg"/>
					</a>
				</li>
			</ul>
		<!-- 按钮区 -->
		<span class='banner_left'><i class='btn_left'></i></span>
		<span class='banner_right'><i class='btn_right'></i></span>
		</div>
	</div>
<!-- 底部页面 -->
<%@include file="common/footer.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	
	var leftBtn = $('.btn_left').eq(0);
	var rightBtn = $('.btn_right').eq(0);
	var ul = $('.banner .content ul').eq(0);
	
	var index = 0;
	var imgwidth = $('.banner .content ul li').width();
	var len = $('.banner .content ul li').length - 2;
	
	function movePicture(){
		$('.banner .content ul').animate({'margin-left':-imgwidth*(index+1)},500,function(){
			if(index == len){
				$(this).css('margin-left',-imgwidth);
				index = 0;
			}
			if(index == -1){
				$(this).css('margin-left',-imgwidth*len);
				index = len - 1;
			}
		})
	}
	var timer = null;
	var delay = false;
	rightBtn.on('click',function(){
		if(!delay)
		{
			index ++;
			movePicture();
			delay = true;
		}
		timer = setTimeout(function(){
			delay = false;
		},500);


	});
	leftBtn.on('click',function(){
		if(!delay)
		{
			index --;
			movePicture();
			delay = true;
		}
		timer = setTimeout(function(){
			delay = false;
		},500);
	});
	
});
	
</script>
</body>
</html>