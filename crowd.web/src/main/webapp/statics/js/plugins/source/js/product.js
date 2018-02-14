$(document).ready(function() {
	/*产品列表页*/
	if($('.met-product').length){
		/*图片高度预设*/
		imageSize('.met-product .met-page-ajax');
		//图片懒加载
		if($(".met-product [data-original]").length){
			$(".met-product [data-original]").lazyload();
			var $pro_fluid=$(".met-product .container-fluid");
			if($pro_fluid.length){
				$pro_fluid.each(function() {
					var $this=$(this);
					$(this).width($(this).width());
					setTimeout(function(){
						$this.width('');
					},2000)
				});
			}
			MetAnimOnScroll();
		}
	}

	/*详情页轮播图*/
	//产品详情页、图片模块详情页公用
	var met_img_carousel='#met-imgs-carousel',
		met_img_carousel_slide=met_img_carousel+' .slick-slide';
	if($(met_img_carousel_slide).length>1){
		var slickdots=met_img_carousel+' ul.slick-dots',
			slickdots_div=met_img_carousel+' ul.slick-dots div',
			slickdots_li=met_img_carousel+' ul.slick-dots li',
			showpro_index=0;
		//生成缩略图
		$(met_img_carousel).on('init', function(event, slick){
			var met_img_carousel_slide_true=met_img_carousel_slide+':not(.slick-cloned)';
			for (var i = 0; i < $(met_img_carousel_slide_true).length; i++) {
				var thumbsrc=$(met_img_carousel_slide_true+':eq('+i+')').data('exthumbimage'),
	    			thumbalt=$(met_img_carousel_slide_true+':eq('+i+') img').attr('alt'),
	    			showpro_thumb='<img src="'+thumbsrc+'" alt="'+thumbalt+'" />';
				$(slickdots_li).eq(i).html(showpro_thumb);
			}
			$(slickdots).wrapInner('<div></div>');
			$(slickdots_div).width($(slickdots_li).length*74-10);
		})
		//开始轮播
		var slick_swipe=true,
			slick_fade=false;
		if($(met_img_carousel).hasClass('fngallery') && deviceType=='d'){
			slick_swipe=false;
			slick_fade=true;
		}
		$(met_img_carousel).slick({
	        dots: true,
	        speed: 500,
	        fade:slick_fade,
	        swipe:slick_swipe,
	        lazyloadPrevNext:true,
	        prevArrow:met_prevArrow,
	        nextArrow:met_nextArrow,
		})
		$(met_img_carousel).on('beforeChange', function(event, slick, currentSlide, nextSlide) {
			paginationScroll(nextSlide);
			showpro_index=nextSlide;
		});
		$(window).resize(function() {
			paginationScroll(showpro_index);
		});
		//缩略图滚动
        function paginationScroll(index){
			var slickdots_w = $(slickdots).width(),
				slickdots_div_w = $(slickdots_div).width(),
				deviation = parseInt(index * 74- slickdots_w / 2 +32);
			if (slickdots_div_w > slickdots_w) {
				var translateX = deviation > 0 ? -deviation : 0;
				if (deviation + slickdots_w >= slickdots_div_w) translateX = -parseInt(slickdots_div_w - slickdots_w);
  				if($('html').hasClass('no-csstransitions')){
  					$(slickdots_div).stop().animate({left:translateX},500);// IE9兼容
  				}else{
  					$(slickdots_div).css({transform: 'translateX(' + translateX + 'px)'});
  				}
			}
		}
	}
	//画廊加载
	if($('.fngallery').length) $('.fngallery').galleryLoad();

	/*产品详情页标准模式*/
	if($('.met-showproduct.pagetype1').length){
		//选项卡点击切换触发图片延迟加载
		$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
			var href = $(this).attr('href');
			$(href).find('img:eq(0)').trigger('scroll');
		})
		/*选项卡滚动条（移动端）*/
		navtabSwiper(".met-showproduct-navtabs");
		/*推荐产品*/
		var prohot='.product-hot .mob-masonry';
		if($(prohot).length){
			/*图片高度预设*/
			imageSize(prohot);
			//推荐产品图片懒加载
			$(prohot+' img').lazyload();
			Breakpoints.on('xs sm',{
				enter: function(){
					$(prohot).masonry({itemSelector: "li"});
				}
			});
		}
	}

	/*产品详情页时尚模式*/
	var showprotype2='.met-showproduct.pagetype2';
	if($(showprotype2).length){
		window.navbar = $(showprotype2+' .navbar');
		var navbar_t = navbar.offset().top,
			wh=$(window).height();
		$(window).scroll(function (){
			var st = $(this).scrollTop();
			//标题工具栏固定
			if(st>navbar_t){
				navbar.addClass('navbar-fixed-top animation-slide-top');
			}else{
				navbar.removeClass('navbar-fixed-top animation-slide-top');
			}
			//选项卡自动选中
			navbar.find('.navbar-right li a').each(function(){
				var topsize = pro_topsize($(this));
				//30为区域上下内边距，根据需要调整
				if(st>=(topsize-30)) pro_active($(this));
			});
		});
		//选项卡点击事件
		$(document).on('click', showprotype2+' .navbar .navbar-right li a', function(e) {
			e.preventDefault();
			var thisobj=$(this),
				scrollTopInt=setInterval(function(){
					var w_scroll=$(window).scrollTop();
					if(w_scroll==pro_topsize(thisobj) || w_scroll+wh>=$(document).height()){
						pro_active(thisobj);
						clearInterval(scrollTopInt);
					}
					$('html,body').animate({scrollTop:pro_topsize(thisobj)},300,"linear");//页面滑动到指定位置
				},300)
		})
		/*选项卡滚动条（移动端）*/
		$(showprotype2+' .navbar .navbar-toggle').one("click", function () {
            setTimeout(function(){
				navtabSwiper(".met-showproduct-navtabs");
			},0)
        });
	}
})
/*选中选项卡*/
function pro_active(dom){
	navbar.find('.navbar-right li').removeClass('active');
	dom.parent('li').addClass('active');
}
/*获取选项卡内容距离顶部的位置*/
function pro_topsize(dom){
	var oftop = $(dom.attr("href")).offset().top,topsize = oftop - 100;
	if(navbar.hasClass('navbar-fixed-top')){
		topsize = topsize + 50;
	}else{
		if(Breakpoints.is('xs')){
			topsize = topsize - navbar.find(".navbar-collapse-toolbar").height();
		}
	}
	if(topsize<0)topsize = 10;
	return topsize;
}
/*瀑布流配置*/
function MetAnimOnScroll(okno){
	new AnimOnScroll( document.getElementById( 'met-grid' ), {
		minDuration : 0.4,
		maxDuration : 0.7,
		viewportFactor : 0.2
	});
}