/*
 * M['weburl'] 		//网站网址
 * M['lang']  		//网站语言
 * M['tem']  		//模板目录路径
 * M['classnow']  	//当前栏目ID
 * M['id']  		//当前页面ID
 * M['module']  	//当前页面所属模块
 * lazyloadbg       //系统调用的延迟加载背景图片路径,base64：灰色
 * met_prevArrow,met_nextArrow //slick插件翻页按钮自定义html
 * deviceType       //客户端判断（d：桌面电脑，t：平板电脑，m：手机）
*/
(function(document, window, $) {
    'use strict';
    var Site=window.Site;
    $(function(){
        Site.run();

        var wh = $(window).height();
 
        /*大图轮播*/
        var $metbanner=$('.met-banner'),
            metbanner_slide='.met-banner .slick-slide';
        if($metbanner.length){
            imageloadFun('.met-banner img:eq(0)',function(){
                var bannerh_default=new Array(300,150,150),
                    datah=$metbanner.data('height').split('|');
                if($metbanner.hasClass('banner-ny-h')) bannerh_default=new Array(150,100,100);
                var bannerh=datah?datah:bannerh_default,
                    bannerAutoH=function(){//宽高自适应模式
                        $metbanner.removeClass('fixedheight').height('auto').find('img').height('');
                        if(Breakpoints.is('xs') && $metbanner.height()<=bannerh_default[2]) $metbanner.addClass('fixedheight').height('');
                    };
                //固定高度模式
                if($metbanner.hasClass('fixedheight')){
                    Breakpoints.on('md lg',{
                        enter: function(){
                            $metbanner.height(bannerh[0]);
                        }
                    })
                    Breakpoints.on('sm',{
                        enter: function(){
                            $metbanner.height(bannerh[1]);
                        }
                    })
                    Breakpoints.on('xs',{
                        enter: function(){
                            $metbanner.height(bannerh[2]);
                        }
                    })
                }else{
                    bannerAutoH();
                    $(window).resize(function() {
                        bannerAutoH();
                    })
                };
                // 开始轮播
                if($(metbanner_slide).length>1){
                    $metbanner.slick({
                        autoplay:true,
                        dots: true,
                        autoplaySpeed: 4000,
                        pauseOnHover:false,
                        prevArrow:met_prevArrow,
                        nextArrow:met_nextArrow,
                        lazyloadPrevNext:true,
                    });
                    $metbanner.on('setPosition', function(event, slick){
                        $(metbanner_slide+' .banner-text').addClass('hide');
                        $(metbanner_slide+'.slick-active .banner-text').removeClass('hide');
                    });
                    if(deviceType=='d' && !Breakpoints.is('xs')) $metbanner.slick('slickSetOption','swipe',false);
                }
            })
        }

    	/*内页栏目导航水平滚动条（移动端）*/
        if($('.met-column-nav-ul').length){
            Breakpoints.on('xs sm',{
                enter: function(){
                    navtabSwiper('.met-column-nav-ul');
                }
            })
        }
    	/*顶部微信*/
    	if($('#met-weixins').length){
            var $met_weixin=$('#met-weixins');
    		Breakpoints.on('xs',{
                enter: function(){
                    if($met_weixin.offset().left < 80) $met_weixin.find('i[data-plugin=webuiPopover]').attr({'data-placement':'right'});
                    if($(window).width()-$met_weixin.offset().left-$met_weixin.outerWidth() < 80) $met_weixin.find('i[data-plugin=webuiPopover]').attr({'data-placement':'left'});
                }
            })
    	}

    	/*底部微信*/
    	if($('#met-weixin').length){
            var $met_weixin=$('#met-weixin');
    		Breakpoints.on('xs',{
                enter: function(){
                    if($met_weixin.offset().left < 80) $met_weixin.find('i[data-plugin=webuiPopover]').attr({'data-placement':'right'});
                    if($(window).width()-$met_weixin.offset().left-$met_weixin.outerWidth() < 80) $met_weixin.find('i[data-plugin=webuiPopover]').attr({'data-placement':'left'});
                }
            })
    	}
    	/*底部导航手机端处理*/
    	if($('.met-footnav').length){
    		Breakpoints.get('xs').on({
    			enter: function(){
    				$('.met-footnav .mob-masonry').masonry({itemSelector: ".masonry-item"});
    			}
    		});
    	}
    	/*返回顶部*/
    	$(".met-scroll-top").click(function(){
    		$('html,body').animate({'scrollTop':0},300);
    	});
    	//
    	$(window).scroll(function (){
    		if($(this).scrollTop()>wh){
    			$(".met-scroll-top").removeClass('hide').addClass("animation-slide-bottom");
    		}else{
    			$(".met-scroll-top").addClass('hide').removeClass('animation-slide-bottom');
    		}
    	});
        /*视频插件异步加载*/
        if($(".metvideobox").length>0){
            $(".metvideobox").each(function(){
                var data = $(this).attr("data-metvideo");
                    data = data.split("|");
                var width  = data[0],
                    height = data[1],
                    poster = data[2],
                    autoplay = data[3],
                    src = data[4];
                var vhtml = '<div class="metvideobox" style="height:'+height+'px;">';
					vhtml+= '<video class="metvideo video-js vjs-default-skin" controls preload="none" width="'+width+'" height="'+height+'" poster="'+poster+'" data-setup=\'{\"autoplay\": '+autoplay+'}\'>';
                    vhtml+= '<source src="'+src+'" type="video/mp4" />';
                    vhtml+= '</video></div>';
                    $(this).after(vhtml).remove();
            });
            include(M["weburl"]+'public/ui/v1/js/effects/video-js/video-js.css');
            if(deviceType=='d'){
                include(M["weburl"]+"public/ui/v1/js/effects/video-js/video_hack.js",function () {
                    setTimeout(function(){
                        videoSizeRes('.metvideo');
                    },0)
                });
            }else{
                videoSizeRes('.metvideo');
            }
        }
        if($('.met-editor iframe,.met-editor embed').length) videoSizeRes('.met-editor iframe,.met-editor embed');
        // 中间弹窗隐藏效果优化（点击弹窗框外上下方隐藏弹窗）
        $(document).on('click', '.modal-dialog.modal-center', function(e) {
            if(!$(e.target).closest(".modal-dialog.modal-center .modal-content").length) $(this).parents('.modal').modal('hide');
        });
		
		
		
		function main_height(){
			//$('section.main').css('min-height',$(window).height()-$('header').height()-60-$('.banner-box').height()-$('footer').height());
			$('.met-showproduct.pagetype2 nav.navbar h1.navbar-brand').css('max-width', $('.met-showproduct.pagetype2 nav.navbar .container').width() - $('.met-showproduct.pagetype2 nav.navbar .nav.shop-btn-body').width() - $('#navbar-showproduct-pagetype2 .nav').width() - 36 );
			
		}
		var isMobile=$('html').hasClass('isMobile')?true:false; 
		
		var win_width=$(window).width();
		main_height();
		$(window).resize(function(){
			win_width=$(window).width();
			main_height();
		});
		
		if($('#map').length>0){
			var script = document.createElement("script"),
				coordinate = $('#map').attr('coordinate')||'105,25';
			script.src = "//api.map.baidu.com/api?v=2.0&ak=aL2Gwp389Kxj3bFhSMq7cf9w&callback=map_func";
			document.body.appendChild(script);
			map_func = function(){
				var coo = coordinate&&coordinate.split(',');
				var map = new BMap.Map("map");
				map.centerAndZoom(new BMap.Point(coo[0]*1,coo[1]*1), 19);
				map.enableScrollWheelZoom();  
				var Icon = new BMap.Icon(M['tem']+"/min/svg/point.svg\" class=\"point_svg", new BMap.Size(28,56));
				var marker = new BMap.Marker(new BMap.Point(coo[0]*1,coo[1]*1),{icon:Icon});
				marker.setAnimation(BMAP_ANIMATION_BOUNCE); 
				map.addOverlay(marker);
			}	
		}
    })
})(document, window, jQuery);
$(window).load(function(){
	$('.load-box').addClass('active');
});
/*选项卡水平滚动标准处理（移动端）*/
function navtabSwiper(navObj) {
    var navtabSdefault=function(){
        var navObjW=sonWidthSum(navObj+'>li')+$('.caret',navObj).length;
        if(navObjW>$(navObj).parent().width()){
            if($(navObj).hasClass('swiper-wrapper')){
                if(!$(navObj).hasClass('flex-start')) $(navObj).addClass('flex-start');
            }else{
                $(navObj)
                .addClass("swiper-wrapper flex-start")
                .wrap("<div class=\"swiper-container swiper-navtab\"></div>").after('<div class="swiper-scrollbar"></div>')
                .find(">li").addClass("swiper-slide");
                var swiperNavtab = new Swiper('.swiper-navtab', {
                    slidesPerView: 'auto',
                    scrollbar:'.swiper-scrollbar',
                    scrollbarHide:false,
                    scrollbarDraggable:true
                });
            }
            if($(navObj).parents('.sidebar-tile').length && $('.product-search').length) $(navObj).parents('.sidebar-tile').height('auto').css({'margin-bottom':10});
            //下拉菜单被隐藏特殊情况处理
            if($('.dropdown',navObj).length && $(".swiper-navtab").length){
                if(!$(".swiper-navtab").hasClass('overflow-visible')) $(".swiper-navtab").addClass("overflow-visible");
            }
        }else if($(navObj).hasClass('flex-start')){
            $(navObj).removeClass('flex-start');
        }
    };
    navtabSdefault();
    $(window).resize(function() {
        navtabSdefault();
    })
    $(navObj).removeClass('invisible-xs');
    Breakpoints.on('xs sm',{
        enter: function(){
            $('.dropdown-menu',navObj).each(function() {
                if($(this).parent('li').offset().left > $(window).width()/2-$(this).parent('li').width()/2){
                    $(this).addClass('dropdown-menu-right');
                }
            });
        }
    });
}
/*异步加载文件*/
function include(file,fun) {
    var files = typeof file == "string" ? [file] : file;
    for (var i = 0; i < files.length; i++) {
        var name = files[i].replace(/^\s|\s$/g,""),
            att = name.split('.'),
            ext = att[att.length - 1].toLowerCase();
        if (ext=='js') {
            var filesi = document.createElement('script');
            filesi.src = name;
            filesi.type = "text/javascript";
            if (typeof filesi != "undefined") document.getElementsByTagName('html')[0].appendChild(filesi);
        } else if (ext == 'css') {
            var filesi = document.createElement('link');
            filesi.href = name;
            filesi.type = 'text/css';
            filesi.rel = "stylesheet";
            if (typeof filesi != "undefined") document.getElementsByTagName('head')[0].appendChild(filesi);
        }
    }
    if (typeof fun === "function") {
        filesi.onload = filesi.onreadystatechange = function() {
            var r = filesi.readyState;
            if (!r || r === 'loaded' || r === 'complete') {
                filesi.onload = filesi.onreadystatechange = null;
                fun();
            }
        };
    }
}
/*图片高度预设及删除*/
function imageSize(risObj,risImg) {
    var risObjs = risObj.split(','),
        risImg=risImg?risImg:'img';
    for (var i = 0; i < risObjs.length; i++) {
        $(risObjs[i]).each(function() {
            var scale=$(this).data('scale');
            if(scale){
                $(risImg,this).height($(risImg,this).width()*scale);
                $(risImg,this).each(function() {
                    var thisimg=$(this);
                    imageloadFun(this,function(){
                        thisimg.height('').removeAttr('height');
                    })
                });
                var $this=$(this);
                $(window).resize(function() {
                    var resImg=$this.find(risImg+'.imgloading');
                    resImg.height(resImg.width()*scale);
                });
            }
        });
    }
}
/*图片加载完成回调*/
function imageloadFun(risObj,fun) {
	$(risObj).each(function() {
        if($(this).data('lazy') || $(this).data('original')){
            var thisimg=$(this),
                loadtime=setInterval(function(){
                    if(thisimg.attr('src')==thisimg.data('original') || thisimg.attr('src')==thisimg.data('lazy')){
                        clearInterval(loadtime);
                        var img = new Image(),
                            img_url=thisimg.attr('src');
                        img.src = img_url;
                        if (img.complete) {
                            if (typeof fun === "function") fun();
                            return;
                        }
                        img.onload = function() {
                            if (typeof fun === "function") fun();
                        };
                    }
                },100)
        }else if($(this).attr('src')){
            var img = new Image(),
                img_url=$(this).attr('src');
            img.src = img_url;
            if (img.complete) {
                if (typeof fun === "function") fun();
                return;
            }
            img.onload = function() {
                if (typeof fun === "function") fun();
            };
        }
    });
}
/*父元素宽度计算*/
function sonWidthSum(sonObj,sonNum){
    var sonObjs=$(sonObj),
        sonTrueNum=sonObjs.length,
        parentObjW=0;
    if(sonNum>sonTrueNum||!sonNum) sonNum=sonTrueNum;
    for (var i = 0; i < sonNum; i++) {
        var sonObjW=sonObjs.eq(i).outerWidth()+parseInt(sonObjs.eq(i).css('marginLeft'))+parseInt(sonObjs.eq(i).css('marginRight'));
        parentObjW+=sonObjW;
    }
    return parentObjW+sonNum;
}
/*画廊*/
$.fn.extend({
    galleryLoad:function(dynamic){
        $("body").addClass("met-white-lightGallery");//画廊皮肤
        if(dynamic){
            $(this).lightGallery({
                autoplayControls:false,
                getCaptionFromTitleOrAlt:false,
                dynamic: true,
                dynamicEl: dynamic,
                thumbWidth:64,
                thumbContHeight:84,
            });
        }else{
            $(this).lightGallery({
                selector:'.lg-item-box:not(.slick-cloned)',
                autoplayControls:false,
                exThumbImage:'data-exthumbimage',
                getCaptionFromTitleOrAlt:false,
                thumbWidth:64,
                thumbContHeight:84,
            });
        }
        $(this).on('onSlideClick.lg',function(){
            $('.lg-outer .lg-toolbar').toggleClass('opacity0');
            if($('.lg-outer .lg-toolbar').hasClass('opacity0')){
                $('.lg-outer').removeClass('lg-thumb-open');
            }else{
                $('.lg-outer').addClass('lg-thumb-open');
            }
            if(Breakpoints.is('xs')){
                if($('.lg-outer .lg-toolbar').hasClass('opacity0')){
                    $('.lg-outer .lg-actions').addClass('hide');
                }else{
                    $('.lg-outer .lg-actions').removeClass('hide');
                }
            }else{
                $('.lg-outer .lg-actions').removeClass('hide');
            }
        });
    },
    scrollFun:function(fun,set){
        if (typeof fun==="function") {
            var defaultSetting={
                    top:30,
                    loop:false,
                    skip_invisible:true,
                    is_scroll:false
                };
            $.extend(defaultSetting,set);
            $(this).each(function(){
                var $this=$(this),
                    fun_open=true,
                    windowDistanceFun=function(){// 窗口距离触发回调
                        if(fun_open){
                            var this_t=$this.offset().top,
                                scroll_t=$(window).scrollTop(),
                                this_scroll_t=this_t-scroll_t-$(window).height(),
                                this_scroll_b=this_t+$this.outerHeight()-scroll_t,
                                visible=defaultSetting.skip_invisible?$this.is(":visible"):true;
                            if(this_scroll_t<defaultSetting.top && this_scroll_b>0 && visible){
                                if(!defaultSetting.loop) fun_open=false;
                                fun($this);
                            }
                        }
                    };
                windowDistanceFun();
                // 滚动时窗口距离触发回调
                if(defaultSetting.is_scroll){
                    $(window).scroll(function(){
                        if(fun_open) windowDistanceFun();
                    })
                }
            });
        }
    },
    /**
     * appearDiy 手动appear动画
     * @param  {Boolean} is_reset 是否重置动画
     */
    appearDiy:function(is_reset){
        $(this).each(function(){
            var $this=$(this),
                animation='animation-'+$(this).data('animate');
            if(is_reset){
                // 重置动画
                $(this).removeClass(animation).removeClass('appear-no-repeat').addClass('invisible');
            }else{
                // 执行动画
                $(this).addClass(animation).addClass('appear-no-repeat');
                setTimeout(function(){
                    $this.removeClass('invisible');
                },0)
            }
        });
    }
})
/*视频尺寸自适应*/
function videoSizeRes(obj) {
    $(obj).each(function() {
        var $this=$(this),
            scale=$(this).attr('height')/$(this).attr('width');
        if(!scale) scale=parseInt($(this).css('height'))/parseInt($(this).css('width'));
        if(scale){
            $(this).height($(this).width()*scale);
            $(window).resize(function() {
                $this.height($this.width()*scale);
            });
        }
    });
}