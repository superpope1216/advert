/**
 * 
 */
$(document).ready(function() {
 var isMobile = $('html').hasClass('isMobile') ? true: false;
    var IE9 = (navigator.userAgent.indexOf("MSIE 9.0") > 0) ? true: false;

    if ($('#map').length > 0) {
        var script = document.createElement("script"),
        coordinate = $('#map').attr('coordinate') || '105,25';
        script.src = "//api.map.baidu.com/api?v=2.0&ak=aL2Gwp389Kxj3bFhSMq7cf9w&callback=map_func";
        document.body.appendChild(script);
        map_func = function() {
            var coo = coordinate && coordinate.split(',');
            var map = new BMap.Map("map");
            map.centerAndZoom(new BMap.Point(coo[0] * 1, coo[1] * 1), 19);
            map.enableScrollWheelZoom();
            var Icon = new BMap.Icon(M['tem'] + "/min/svg/point.svg\" class=\"point_svg", new BMap.Size(28, 56));
            var marker = new BMap.Marker(new BMap.Point(coo[0] * 1, coo[1] * 1), {
                icon: Icon
            });
            marker.setAnimation(BMAP_ANIMATION_BOUNCE);
            map.addOverlay(marker);
        }
    }

    var win_width = $(window).width();
    if ($('.advert-box').length) {
        if (!$('.advert-box').hasClass('auto')) {
            var data_height = $('.advert-box').attr('data-height') || '120|100|80';
            resize_height($('.advert-box'), data_height.split('|'));
        }
        $('.advert-box img[data-original]').lazyload();
    }
    function resize_height(obj, arr, res) {
        if (win_width >= 1200) obj.height(arr[0] || 120);
        else if (win_width >= 768) obj.height(arr[1] || 100);
        else obj.height(arr[2] || 80);
        if (!res) $(window).resize(function() {
            win_width = $(window).width();
            resize_height(obj, arr, true);
        });
    }
    function head_width(res) {
        $('.head-left').css('max-width', $('.head-box .container').width() - $('.head-right').width());
        if (!res) $(window).resize(function() {
            win_width = $(window).width();
            head_width(true);
        });
    }
    head_width();
    M['head'] = new Swiper('.head-left', {
        wrapperClass: 'head-left-wrapper',
        slideClass: 'head-left-slide',
        slidesPerView: 'auto',
        freeMode: true,
        freeModeSticky: true,
        mousewheelControl: true,
        mousewheelSensitivity: 1,
        observer: true,
        observeParents: true
    });

    function nav_width_fun(res) {
        nav_width = 0;
        $('.nav-cut ul li').each(function(index, element) {
            nav_width += $(this).outerWidth();
        });
        if (win_width > 460) {
            neck_width = $('.neck-box .container').width() - $('.logo-box').width() - $('.search-box').width() - $('.nav-class').width() - $('.nav-box').css('margin-left').replace('px', '') - $('.nav-box').css('margin-right').replace('px', '') - 1;
            $('.nav-cut').css('max-width', nav_width > neck_width ? neck_width: nav_width);
        } else {
            neck_width = $('.neck-box .container').width() - $('.nav-class').width() - $('.nav-box').css('margin-left').replace('px', '') - $('.nav-box').css('margin-right').replace('px', '') - 1;
            $('.nav-cut').css('max-width', nav_width > neck_width ? neck_width: nav_width);
            $('.logo-box').css('max-width', $('.neck-box .container').width() - $('.search-box').width() - 15);
        }
        $('.nav-hover').css('left', $('.nav-class').css('display') == 'block' ? $('.nav-class').width() : 0);
        if (!res) $(window).resize(function() {
            clearTimeout(M['nav_width']);
            M['nav_width'] = window.setTimeout(function() {
                nav_width_fun(true);
            },
            1);
        });
    }
    nav_width_fun();

    var logo = new Image();
    logo.src = $('.logo-box img').attr('src');
    logo.onload = function() {
        nav_width_fun(true);
    }

    new Swiper('.nav-cut', {
        initialSlide: $('.nav-li.active').index(),
        wrapperClass: 'nav-ul',
        slideClass: 'nav-li',
        freeMode: true,
        freeModeMomentumRatio: .1,
        freeModeSticky: true,
        freeModeSticky: true,
        slidesPerView: 'auto',
        mousewheelControl: true,
        observer: true,
        observeParents: true,
        onTouchStart: function(swiper, even) {
            $('.nav-hover ul').removeClass('active');
        }
    });
    if ($('.nav-hover').length > 0) {
        var navtime = '';
        $('.nav-li').mouseover(function() {
            if (win_width >= 1200 || !isMobile) {
                clearTimeout(navtime);
                var nowleft = $(this).position().left;
                var navul = $('.nav-hover ul').removeClass('active').eq($(this).index());
                navul.css('left', nowleft - (navul.width() - $(this).width()) / 2).addClass('active');
                if (nowleft > win_width / 2 && win_width < 768) navul.addClass('right');
                else navul.removeClass('right');
            }
        }).click(function() {
            if (win_width < 1200 && isMobile) {
                clearTimeout(navtime);
                var nowleft = $(this).position().left;
                var navul = $('.nav-hover ul').removeClass('active').eq($(this).index());
                navul.css('left', nowleft - (navul.width() - $(this).width()) / 2).addClass('active');
                if (nowleft > win_width / 2 && win_width < 768) navul.addClass('right');
                else navul.removeClass('right');
            }
        });
        $('.nav-cut,.nav-hover').mouseleave(function() {
            clearTimeout(navtime);
            navtime = window.setTimeout(function() {
                $('.nav-hover ul').removeClass('active');
            },
            200);
        });
        $('.nav-hover').find('ol,ul').each(function(index, element) {
            if (!$(this).find('li').length) $(this).css('opacity', '0');
        });
        $('.nav-hover ul').mouseenter(function() {
            clearTimeout(navtime);
        });
        $('.nav-li a').click(function(e) {
            if (win_width < 1200 && isMobile && $(this).parent().hasClass('navs')) {
                e.preventDefault();
            }
        });
        $('.nav-hover ol').prev('a').click(function(e) {
            if (win_width < 1200 && isMobile) {
                e.preventDefault();
            }
        });
        $(window).resize(function() {
            $('.nav-hover ul').removeClass('active');
        });
    }

    if($('#met-weixins').length){
    		var $met_weixin=$('#met-weixins');
    		Breakpoints.on('xs',
    				{
    				enter:function()
    					{
    						if($met_weixin.offset().left < 80) {
    							$met_weixin.find('i[data-plugin=webuiPopover]').attr({'data-placement':'right'});
    						}
    						if($(window).width()-$met_weixin.offset().left-$met_weixin.outerWidth() < 80){
    							$met_weixin.find('i[data-plugin=webuiPopover]').attr({'data-placement':'left'});
    						}
    					}
    				});
    }

	$.components.register("webuiPopover",
			{mode:"default",defaults:{trigger:"click",width:320,multi:!0,cloaseable:!1,style:"",delay:300,padding:!0}});
	
    if ($('.search-box').length) {
        if ($('.search-box input[type=text]').val() != '') $('.search-box').addClass('active');
        $('.search-box input[type=text]').focus(function() {
            if ($(this).val() == '') $('.search-box').addClass('active');
        }).blur(function() {
            if ($(this).val() == '') $('.search-box').removeClass('active');
        });
    }
    });