/**/
var M=document.querySelector('meta[name="generator"]').getAttribute('data-variable'),D=M.split(',');M=new Array();M['weburl']=D[0];M['lang']=D[1];M['classnow']=parseInt(D[2]);M['id']=parseInt(D[3]);M['module']=parseInt(D[4]);M['tem']=D[0]+'templates/'+D[5];var deviceType = /iPad/.test(navigator.userAgent) ? 't' : /Mobile|iP(hone|od)|Android|BlackBerry|IEMobile|Silk/.test(navigator.userAgent) ? 'm' : 'd',is_ucbro=/UC/.test(navigator.userAgent);
$(document).ready(function() {
   
	var isMobile = $('html').hasClass('isMobile') ? true: false;
    var IE9 = (navigator.userAgent.indexOf("MSIE 9.0") > 0) ? true: false;
    M['class'] = new Swiper('.product-class', {
        wrapperClass: 'product-class-wrapper',
        slideClass: 'product-class-slide',
        slidesPerView: 'auto',
        direction: 'vertical',
        freeMode: true,
        mousewheelControl: true,
        mousewheelSensitivity: 1,
        observer: true,
        observeParents: true
    });
    $('.product-class-slide').mouseover(function() {
        that = $(this);
        clearTimeout(M['pro_class']);
        M['pro_class'] = window.setTimeout(function() {
            $('.product-class-slide').removeClass('active');
            that.addClass('active');
            $('.product-list').removeClass('active');
            $('.product-list').eq(that.index()).addClass('active').find('[data-original]').lazyload({
                load: function() {
                    $(this).removeAttr('data-original');
                }
            });
        },
        10);
    });
    $('.product-class').mouseout(function() {
        clearTimeout(M['pro_class']);
        M['pro_class'] = window.setTimeout(function() {
            $('.product-class-slide').removeClass('active');
            $('.product-list').removeClass('active');
        },
        10);
    });
    $('.product-list').mouseover(function() {
        clearTimeout(M['pro_class']);
    }).mouseout(function() {
        clearTimeout(M['pro_class']);
        M['pro_class'] = window.setTimeout(function() {
            $('.product-list').removeClass('active');
        },
        10);
    });
    $('.product-cut').mouseout(function() {
        clearTimeout(M['pro_class']);
        M['pro_class'] = window.setTimeout(function() {
            $('.nav-class').removeClass('active');
            $('.product-cut').removeClass('active');
            $('.product-class-slide').removeClass('active');
            $('.product-list').removeClass('active');
        },
        10);
    });
    $('.nav-class').mouseover(function() {
        clearTimeout(M['pro_class']);
        M['pro_class'] = window.setTimeout(function() {
            $('.nav-class').addClass('active');
            $('.product-cut').addClass('active');
        },
        10);
    }).mouseout(function() {
        clearTimeout(M['pro_class']);
        M['pro_class'] = window.setTimeout(function() {
            $('.nav-class').removeClass('active');
            $('.product-cut').removeClass('active');
        },
        500);
    });
    $(window).resize(function() {
        $('.nav-class').removeClass('active');
        $('.product-cut').removeClass('active');
        $('.product-class-slide').removeClass('active');
        $('.product-list').removeClass('active');
    });
    $('.product-ul').each(function(index, element) {
        var pro_all = $(this).find('.product-li').html();
        M['pro_all' + index] = pro_all ? pro_all.split('　') : [];
    });
    function main_height() {
        $('.met-showproduct.pagetype2 nav.navbar h1.navbar-brand').css('max-width', $('.met-showproduct.pagetype2 nav.navbar .container').width() - $('.met-showproduct.pagetype2 nav.navbar .nav.shop-btn-body').width() - $('#navbar-showproduct-pagetype2 .nav').width() - 36);
    }
    var win_width = $(window).width();
    main_height();
    $(window).resize(function() {
        win_width = $(window).width();
        main_height();
    });
    function pro_html_fun(mun) {
        $('.product-ul').each(function(index, element) {
            pro_all_num = M['pro_all' + index].length;
            if (pro_all_num != 0) {
                pro_html = '<li class="product-li">';
                for (i = 0; i < pro_all_num; i++) {
                    pro_html += M['pro_all' + index][i].replace('data-style', 'style');
                    if ((i + 1) % mun == 0 && i && M['pro_all' + index][i + 1]) pro_html += '</li>\n<li class="product-li">';
                }
                pro_html += '</li>';
                $(this).html(pro_html);
            } else {
                $(this).parent('.product-list').hide();
            }
        });
    }
    function pro_fun(res) {
        pro_cut_hgt = $('.product-class').outerHeight();
       // $('.product-content').height(pro_cut_hgt);
        $('.product-content').height(400);
        pro_num = Math.floor(pro_cut_hgt / (win_width >= 768 ? 70 : 60));
        pro_pad = Math.floor((pro_cut_hgt / pro_num - 40) / 2);
        pro_html_fun(pro_num);
        var pro_width = $('.product-cut').width() - $('.product-class').outerWidth() - 1;
        if (win_width >= 1200) pro_con = 4;
        else if (win_width >= 992) pro_con = 3;
        else if (win_width >= 460) pro_con = 2;
        else pro_con = 1;
        pro_list_width = pro_width / pro_con;
        $('.product-li').width(pro_list_width);
        $('.product-list').each(function(index, element) {
            var pro_len = Math.ceil(M['pro_all' + index].length / pro_num);
            $(this).width((pro_len <= pro_con ? pro_len: pro_con) * pro_list_width);
        });
        $('.product-list a').css('padding-top', pro_pad).css('padding-bottom', pro_pad);
        if (!res) $(window).resize(function() {
            clearTimeout(M['pro_time']);
            M['pro_time'] = window.setTimeout(function() {
                pro_fun(true);
            },
            300);
        });
    }
    pro_fun();
    M['pro_list'] = new Swiper('.product-list', {
        wrapperClass: 'product-ul',
        slideClass: 'product-li',
        slidesPerView: 'auto',
        lazyLoading: true,
        freeMode: true,
        watchSlidesProgress: true,
        watchSlidesVisibility: true,
        mousewheelControl: true,
        mousewheelSensitivity: 1,
        observer: true,
        observeParents: true
    });

    function active_fun(res) {
        if (win_width >= 460) $('.active-box').width($('.acromion-box .container').width() - $('.column-box').width());
        else $('.active-box').width('auto');
        if (!res) $(window).resize(function() {
            active_fun(true);
        });
    }
    active_fun();
    M['active'] = new Swiper('.active-box', {
        wrapperClass: 'active-box-wraper',
        slideClass: 'active-box-slide',
        slidesPerView: IE9 ? 3 : 'auto',
        autoplay: 3500,
        watchSlidesProgress: true,
        watchSlidesVisibility: true,
        observer: true,
        observeParents: true
    });
    $('.active-box img[data-original]').lazyload({
        load: function() {
            active_fun();
        }
    });

    M['groom'] = new Swiper('.groom-cut', {
        wrapperClass: 'groom-cut-wraper',
        slideClass: 'groom-cut-slide',
        slidesPerView: IE9 ? 5 : 'auto',
        autoplay: 3800,
        watchSlidesProgress: true,
        watchSlidesVisibility: true,
        prevButton: '.groom-box .fa-chevron-left',
        nextButton: '.groom-box .fa-chevron-right',
        observer: true,
        observeParents: true
    });
    $('.groom-cut img[data-original]').lazyload();
    $('.host-adver [data-original]').lazyload();
    $('.host-box').each(function(index, element) {
        $('.host-box:eq(' + index + ') .host-title li').click(function(e) {
            e.preventDefault();
            $('.host-box:eq(' + index + ') .host-title li').removeClass('active');
            $(this).addClass('active');
            $('.host-box:eq(' + index + ') .host-list').removeClass('active').eq($(this).index()).addClass('active').find('img[data-original]').lazyload();
        });
    });

    M['host'] = new Swiper('.host-list.index', {
        wrapperClass: 'host-list-wraper',
        slideClass: 'host-list-slide',
        slidesPerView: 4,
        slidesPerColumn: 2,
        slidesPerColumnFill: 'row',
        autoplay: 2500,
        lazyLoading: true,
        watchSlidesProgress: true,
        watchSlidesVisibility: true,
        observer: true,
        observeParents: true,
        breakpoints: {
            1199 : {
                slidesPerView: 3,
                slidesPerColumn: 2
            },
            992 : {
                slidesPerView: 2,
                slidesPerColumn: 2
            },
            640 : {
                slidesPerView: 2,
                slidesPerColumn: 1
            }
        }
    });
    $('.host-list.active [data-original]').each(function(index, element) {
        $(this).lazyload();
    });
    $('.host-list dd').mouseover(function() {
        $(this).parent('dl').find('dd').removeClass('active');
        $(this).addClass('active');
		$(this).parents('li').find('img').attr('src', $(this).attr('src'));
    });

    M['info'] = new Swiper('.info-cut.index', {
        wrapperClass: 'info-cut-wraper',
        slideClass: 'info-cut-slide',
        slidesPerView: IE9 ? 4 : 'auto',
        lazyLoading: true,
        autoplay: 4000,
        watchSlidesProgress: true,
        watchSlidesVisibility: true,
        prevButton: '.info-box .fa-chevron-left',
        nextButton: '.info-box .fa-chevron-right',
        observer: true,
        observeParents: true
    });
    $('.info-cut img[data-original]').lazyload();

    M['foot_service'] = new Swiper('.foot-service', {
        wrapperClass: 'foot-service-wraper',
        slideClass: 'foot-service-slide',
        slidesPerView: IE9 ? 5 : 'auto',
        autoplay: 2900,
        watchSlidesProgress: true,
        watchSlidesVisibility: true,
        observer: true,
        observeParents: true
    });

    M['foot_nav'] = new Swiper('.foot-nav', {
        wrapperClass: 'foot-nav-wraper',
        slideClass: 'foot-nav-slide',
        slidesPerView: IE9 ? 6 : 'auto',
        autoplay: 3010,
        watchSlidesProgress: true,
        watchSlidesVisibility: true,
        observer: true,
        observeParents: true
    });

    new Swiper('.column-nav', {
        initialSlide: $('.column-li.active').index(),
        wrapperClass: 'column-ul',
        slideClass: 'column-li',
        freeMode: true,
        slidesPerView: 'auto',
        freeModeSticky: true,
        onReachEnd: function(swiper) {
            $('.column-nav').addClass('active');
        },
        onTouchStart: function(swiper, even) {
            $('.column-hover ul').removeClass('active');
        }
    });
    if ($('.column-hover').length > 0) {
        var navtime = '';
        $('.column-li').mouseover(function() {
            if (win_width >= 1200 || !isMobile) {
                clearTimeout(navtime);
                var nowleft = $(this).position().left;
                var navul = $('.column-hover ul').removeClass('active').eq($(this).index());
                navul.css('left', nowleft - (navul.width() - $(this).width()) / 2).addClass('active');
            }
        }).click(function() {
            if (win_width < 1200 && isMobile) {
                clearTimeout(navtime);
                var nowleft = $(this).position().left;
                var navul = $('.column-hover ul').removeClass('active').eq($(this).index());
                navul.css('left', nowleft - (navul.width() - $(this).width()) / 2).addClass('active');
            }
        });
        $('.column-side').mouseleave(function() {
            clearTimeout(navtime);
            navtime = window.setTimeout(function() {
                $('.column-hover ul').removeClass('active');
            },
            200);
        });
        $('.column-hover ul').mouseenter(function() {
            clearTimeout(navtime);
        });
        $('.column-li a').click(function(e) {
            if (win_width < 1200 && isMobile && $(this).parent().hasClass('navs')) {
                e.preventDefault();
            }
        });
    }

    if (M['classnow'] == 10001) {
        var $index_original = $('.met-index-body [data-original]');
        if ($index_original.length) {
            $index_original.lazyload({
                load: function() {
                    if ($(this).parents('.met-index-service').length) $('.met-index-service [class*=block] li').matchHeight();
                }
            });
        }

        var $met_indexbody1_appear = $('.met-index-body:eq(0) [data-plugin=appear]');
        if ($met_indexbody1_appear.length) {
            $met_indexbody1_appear.scrollFun(function(val) {
                val.appearDiy();
            });
        }

        if ($(".met-index-product").length) {
            Breakpoints.on('xs sm', {
                enter: function() {
                    navtabSwiper('.met-index-product .nav-tabs');
                }
            });
			var problock = '.met-index-product #indexprolist',
            protab = '.met-index-product .nav-tabs li';
            imageSize(problock);
            IsotopeNum(problock, protab);
        }

        if ($('.met-index-news ul.blocks-2').length) imageSize('.met-index-news ul.blocks-2');
    }
});
function IsotopeNum(itObj, itControl) {
    var itFun = $(itObj).isotope(),
    intItControlAttr = $(itControl + '.active a').data('filter');
    $(itControl).on('click', 'a',
    function() {
        var filterValue = $(this).data('filter'),
        filterValues = filterValue == '*' ? '[data-type]': '[data-type=' + filterValue + ']',
        num = $(this).data('num');
        if (num) filterValues = function() {
            return $(this).index() < num;
        } || filterValues;
        itFun.isotope({
            filter: filterValues
        });
        if (filterValue != intItControlAttr) {
            $(filterValues + ' [data-original]').each(function() {
                if ($(this).data('original') != $(this).attr('src')) $(this).lazyload({
                    event: 'sporty'
                }).trigger('sporty');
            });
        }
    });
    if ($(itControl + '.active a').data('num')) {
        setTimeout(function() {
            $(itControl + '.active a').trigger('click');
        },
        500);
    }
}
$(window).load(function() {
    $('.load-box').addClass('active');
});
/*own.js*/
(function(document, window, $) {
    'use strict';
    var Site = window.Site;
    $(function() {
        Site.run();

        var wh = $(window).height();

        var $metbanner = $('.met-banner'),
        metbanner_slide = '.met-banner .slick-slide';
        if ($metbanner.length) {
            imageloadFun('.met-banner img:eq(0)',
            function() {
                var bannerh_default = new Array(300, 150, 150),
                datah = $metbanner.data('height').split('|');
                if ($metbanner.hasClass('banner-ny-h')) bannerh_default = new Array(150, 100, 100);
                var bannerh = datah ? datah: bannerh_default,
                bannerAutoH = function() {
                    $metbanner.removeClass('fixedheight').height('auto').find('img').height('');
                    if (Breakpoints.is('xs') && $metbanner.height() <= bannerh_default[2]) $metbanner.addClass('fixedheight').height('');
                };
                if ($metbanner.hasClass('fixedheight')) {
                    Breakpoints.on('md lg', {
                        enter: function() {
                            $metbanner.height(bannerh[0]);
                        }
                    }) ;
					Breakpoints.on('sm', {
                        enter: function() {
                            $metbanner.height(bannerh[1]);
                        }
                    })
					Breakpoints.on('xs', {
                        enter: function() {
                            $metbanner.height(bannerh[2]);
                        }
                    })
                } else {
                    bannerAutoH();
                    $(window).resize(function() {
                        bannerAutoH();
                    })
                };
                if ($(metbanner_slide).length > 1) {
                    $metbanner.slick({
                        autoplay: true,
                        dots: true,
                        autoplaySpeed: 4000,
                        pauseOnHover: false,
                        prevArrow: met_prevArrow,
                        nextArrow: met_nextArrow,
                        lazyloadPrevNext: true,
                    });
                    $metbanner.on('setPosition',
                    function(event, slick) {
                        $(metbanner_slide + ' .banner-text').addClass('hide');
                        $(metbanner_slide + '.slick-active .banner-text').removeClass('hide');
                    });
                    if (deviceType == 'd' && !Breakpoints.is('xs')) $metbanner.slick('slickSetOption', 'swipe', false);
                }
            })
        }

        if ($('.met-column-nav-ul').length) {
            Breakpoints.on('xs sm', {
                enter: function() {
                    navtabSwiper('.met-column-nav-ul');
                }
            })
        }

        if ($('#met-weixins').length) {
            var $met_weixin = $('#met-weixins');
            Breakpoints.on('xs', {
                enter: function() {
                    if ($met_weixin.offset().left < 80) $met_weixin.find('i[data-plugin=webuiPopover]').attr({
                        'data-placement': 'right'
                    });
                    if ($(window).width() - $met_weixin.offset().left - $met_weixin.outerWidth() < 80) $met_weixin.find('i[data-plugin=webuiPopover]').attr({
                        'data-placement': 'left'
                    });
                }
            })
        }

        if ($('#met-weixin').length) {
            var $met_weixin = $('#met-weixin');
            Breakpoints.on('xs', {
                enter: function() {
                    if ($met_weixin.offset().left < 80) $met_weixin.find('i[data-plugin=webuiPopover]').attr({
                        'data-placement': 'right'
                    });
                    if ($(window).width() - $met_weixin.offset().left - $met_weixin.outerWidth() < 80) $met_weixin.find('i[data-plugin=webuiPopover]').attr({
                        'data-placement': 'left'
                    });
                }
            })
        }

        if ($('.met-footnav').length) {
            Breakpoints.get('xs').on({
                enter: function() {
                    $('.met-footnav .mob-masonry').masonry({
                        itemSelector: ".masonry-item"
                    });
                }
            });
        }
        $(".met-scroll-top").click(function() {
            $('html,body').animate({
                'scrollTop': 0
            },
            300);
        });
        $(window).scroll(function() {
            if ($(this).scrollTop() > wh) {
                $(".met-scroll-top").removeClass('hide').addClass("animation-slide-bottom");
            } else {
                $(".met-scroll-top").addClass('hide').removeClass('animation-slide-bottom');
            }
        });

        if ($(".metvideobox").length > 0) {
            $(".metvideobox").each(function() {
                var data = $(this).attr("data-metvideo");
                data = data.split("|");
                var width = data[0],
                height = data[1],
                poster = data[2],
                autoplay = data[3],
                src = data[4];
                var vhtml = '<div class="metvideobox" style="height:' + height + 'px;">';
                vhtml += '<video class="metvideo video-js vjs-default-skin" controls preload="none" width="' + width + '" height="' + height + '" poster="' + poster + '" data-setup=\'{\"autoplay\":' + autoplay + '}\'>';
                vhtml += '<source src="' + src + '" type="video/mp4" />';
                vhtml += '</video></div>';
                $(this).after(vhtml).remove();
            });
            include(M["weburl"] + 'public/ui/v1/js/effects/video-js/video-js.css');
            if (deviceType == 'd') {
                include(M["weburl"] + "public/ui/v1/js/effects/video-js/video_hack.js",
                function() {
                    setTimeout(function() {
                        videoSizeRes('.metvideo');
                    },
                    0)
                });
            } else {
                videoSizeRes('.metvideo');
            }
        }
        if ($('.met-editor iframe,.met-editor embed').length) videoSizeRes('.met-editor iframe,.met-editor embed');
        $(document).on('click', '.modal-dialog.modal-center',
        function(e) {
            if (!$(e.target).closest(".modal-dialog.modal-center .modal-content").length) $(this).parents('.modal').modal('hide');
        });

        function main_height() {
            $('.met-showproduct.pagetype2 nav.navbar h1.navbar-brand').css('max-width', $('.met-showproduct.pagetype2 nav.navbar .container').width() - $('.met-showproduct.pagetype2 nav.navbar .nav.shop-btn-body').width() - $('#navbar-showproduct-pagetype2 .nav').width() - 36);
        }
        

        var win_width = $(window).width();
        main_height();
        $(window).resize(function() {
            win_width = $(window).width();
            main_height();
        });

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
    })
})(document, window, jQuery);
$(window).load(function() {
    $('.load-box').addClass('active');
});

function navtabSwiper(navObj) {
    var navtabSdefault = function() {
        var navObjW = sonWidthSum(navObj + '>li') + $('.caret', navObj).length;
        if (navObjW > $(navObj).parent().width()) {
            if ($(navObj).hasClass('swiper-wrapper')) {
                if (!$(navObj).hasClass('flex-start')) $(navObj).addClass('flex-start');
            } else {
                $(navObj).addClass("swiper-wrapper flex-start").wrap("<div class=\"swiper-container swiper-navtab\"></div>").after('<div class="swiper-scrollbar"></div>').find(">li").addClass("swiper-slide");
                var swiperNavtab = new Swiper('.swiper-navtab', {
                    slidesPerView: 'auto',
                    scrollbar: '.swiper-scrollbar',
                    scrollbarHide: false,
                    scrollbarDraggable: true
                });
            }
            if ($(navObj).parents('.sidebar-tile').length && $('.product-search').length) $(navObj).parents('.sidebar-tile').height('auto').css({
                'margin-bottom': 10
            });
            if ($('.dropdown', navObj).length && $(".swiper-navtab").length) {
                if (!$(".swiper-navtab").hasClass('overflow-visible')) $(".swiper-navtab").addClass("overflow-visible");
            }
        } else if ($(navObj).hasClass('flex-start')) {
            $(navObj).removeClass('flex-start');
        }
    };
    navtabSdefault();
    $(window).resize(function() {
        navtabSdefault();
    }) 
	$(navObj).removeClass('invisible-xs');
    Breakpoints.on('xs sm', {
        enter: function() {
            $('.dropdown-menu', navObj).each(function() {
                if ($(this).parent('li').offset().left > $(window).width() / 2 - $(this).parent('li').width() / 2) {
                    $(this).addClass('dropdown-menu-right');
                }
            });
        }
    });
}

function include(file, fun) {
    var files = typeof file == "string" ? [file] : file;
    for (var i = 0; i < files.length; i++) {
        var name = files[i].replace(/^\s|\s$/g, ""),
        att = name.split('.'),
        ext = att[att.length - 1].toLowerCase();
        if (ext == 'js') {
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

function imageSize(risObj, risImg) {
    var risObjs = risObj.split(','),
    risImg = risImg ? risImg: 'img';
    for (var i = 0; i < risObjs.length; i++) {
        $(risObjs[i]).each(function() {
            var scale = $(this).data('scale');
            if (scale) {
                $(risImg, this).height($(risImg, this).width() * scale);
                $(risImg, this).each(function() {
                    var thisimg = $(this);
                    imageloadFun(this,
                    function() {
                        thisimg.height('').removeAttr('height');
                    })
                });
                var $this = $(this);
                $(window).resize(function() {
                    var resImg = $this.find(risImg + '.imgloading');
                    resImg.height(resImg.width() * scale);
                });
            }
        });
    }
}

function imageloadFun(risObj, fun) {
    $(risObj).each(function() {
        if ($(this).data('lazy') || $(this).data('original')) {
            var thisimg = $(this),
            loadtime = setInterval(function() {
                if (thisimg.attr('src') == thisimg.data('original') || thisimg.attr('src') == thisimg.data('lazy')) {
                    clearInterval(loadtime);
                    var img = new Image(),
                    img_url = thisimg.attr('src');
                    img.src = img_url;
                    if (img.complete) {
                        if (typeof fun === "function") fun();
                        return;
                    }
                    img.onload = function() {
                        if (typeof fun === "function") fun();
                    };
                }
            },
            100)
        } else if ($(this).attr('src')) {
            var img = new Image(),
            img_url = $(this).attr('src');
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

function sonWidthSum(sonObj, sonNum) {
    var sonObjs = $(sonObj),
    sonTrueNum = sonObjs.length,
    parentObjW = 0;
    if (sonNum > sonTrueNum || !sonNum) sonNum = sonTrueNum;
    for (var i = 0; i < sonNum; i++) {
        var sonObjW = sonObjs.eq(i).outerWidth() + parseInt(sonObjs.eq(i).css('marginLeft')) + parseInt(sonObjs.eq(i).css('marginRight'));
        parentObjW += sonObjW;
    }
    return parentObjW + sonNum;
}
$.fn.extend({
    galleryLoad: function(dynamic) {
        $("body").addClass("met-white-lightGallery");
        if (dynamic) {
            $(this).lightGallery({
                autoplayControls: false,
                getCaptionFromTitleOrAlt: false,
                dynamic: true,
                dynamicEl: dynamic,
                thumbWidth: 64,
                thumbContHeight: 84,
            });
        } else {
            $(this).lightGallery({
                selector: '.lg-item-box:not(.slick-cloned)',
                autoplayControls: false,
                exThumbImage: 'data-exthumbimage',
                getCaptionFromTitleOrAlt: false,
                thumbWidth: 64,
                thumbContHeight: 84,
            });
        }
        $(this).on('onSlideClick.lg',
        function() {
            $('.lg-outer .lg-toolbar').toggleClass('opacity0');
            if ($('.lg-outer .lg-toolbar').hasClass('opacity0')) {
                $('.lg-outer').removeClass('lg-thumb-open');
            } else {
                $('.lg-outer').addClass('lg-thumb-open');
            }
            if (Breakpoints.is('xs')) {
                if ($('.lg-outer .lg-toolbar').hasClass('opacity0')) {
                    $('.lg-outer .lg-actions').addClass('hide');
                } else {
                    $('.lg-outer .lg-actions').removeClass('hide');
                }
            } else {
                $('.lg-outer .lg-actions').removeClass('hide');
            }
        });
    },
    scrollFun: function(fun, set) {
        if (typeof fun === "function") {
            var defaultSetting = {
                top: 30,
                loop: false,
                skip_invisible: true,
                is_scroll: false
            };
            $.extend(defaultSetting, set);
            $(this).each(function() {
                var $this = $(this),
                fun_open = true,
                windowDistanceFun = function() {
                    if (fun_open) {
                        var this_t = $this.offset().top,
                        scroll_t = $(window).scrollTop(),
                        this_scroll_t = this_t - scroll_t - $(window).height(),
                        this_scroll_b = this_t + $this.outerHeight() - scroll_t,
                        visible = defaultSetting.skip_invisible ? $this.is(":visible") : true;
                        if (this_scroll_t < defaultSetting.top && this_scroll_b > 0 && visible) {
                            if (!defaultSetting.loop) fun_open = false;
                            fun($this);
                        }
                    }
                };
                windowDistanceFun();
                if (defaultSetting.is_scroll) {
                    $(window).scroll(function() {
                        if (fun_open) windowDistanceFun();
                    })
                }
            });
        }
    },
    appearDiy: function(is_reset) {
        $(this).each(function() {
            var $this = $(this),
            animation = 'animation-' + $(this).data('animate');
            if (is_reset) {
                $(this).removeClass(animation).removeClass('appear-no-repeat').addClass('invisible');
            } else {
                $(this).addClass(animation).addClass('appear-no-repeat');
                setTimeout(function() {
                    $this.removeClass('invisible');
                },
                0)
            }
        });
    }
})

function videoSizeRes(obj) {
    $(obj).each(function() {
        var $this = $(this),
        scale = $(this).attr('height') / $(this).attr('width');
        if (!scale) scale = parseInt($(this).css('height')) / parseInt($(this).css('width'));
        if (scale) {
            $(this).height($(this).width() * scale);
            $(window).resize(function() {
                $this.height($this.width() * scale);
            });
        }
    });
}
/*sys.js*/
if (M["module"] && M["id"]) {
    var modulename = "";
    switch (M["module"]) {
    case 2:
        modulename = "news";
        break;
    case 3:
        modulename = "product";
        break;
    case 4:
        modulename = "download";
        break;
    case 5:
        modulename = "img";
        break
    }
    if (modulename != "") {
        $.ajax({
            type: "POST",
            url: M["weburl"] + "include/hits.php?type=" + modulename + "&id=" + M["id"] + "&metinfover=v1"
        })
    }
}
//var url = M["weburl"] + "include/interface/uidata.php?lang=" + M["lang"],
var url="";
h = window.location.href;
if (h.indexOf("preview=1") != -1) {
    url = url + "&theme_preview=1"
}
$.ajax({
    type: "POST",
    url: url,
    dataType: "json",
    success: function(msg) {
        var c = msg.config;
        if (c.met_online_type != 3) {
            include(M["weburl"] + "public/css/online.css");

            jQuery.migrateMute === void 0 && (jQuery.migrateMute = !0),
            function(e, t, n) {
                function r(n) {
                    var r = t.console;
                    i[n] || (i[n] = !0, e.migrateWarnings.push(n), r && r.warn && !e.migrateMute && (r.warn("JQMIGRATE:" + n), e.migrateTrace && r.trace && r.trace()))
                }
                function a(t, a, i, o) {
                    if (Object.defineProperty) {
                        try {
                            return Object.defineProperty(t, a, {
                                configurable: !0,
                                enumerable: !0,
                                get: function() {
                                    return r(o),
                                    i
                                },
                                set: function(e) {
                                    r(o),
                                    i = e
                                }
                            }),
                            n
                        } catch(s) {}
                    }
                    e._definePropertyBroken = !0,
                    t[a] = i
                }
                var i = {};
                e.migrateWarnings = [],
                !e.migrateMute && t.console && t.console.log && t.console.log("JQMIGRATE:Logging is active"),
                e.migrateTrace === n && (e.migrateTrace = !0),
                e.migrateReset = function() {
                    i = {},
                    e.migrateWarnings.length = 0
                },
                "BackCompat" === document.compatMode && r("jQuery is not compatible with Quirks Mode");
                var o = e("<input/>", {
                    size: 1
                }).attr("size") && e.attrFn,
                s = e.attr,
                u = e.attrHooks.value && e.attrHooks.value.get ||
                function() {
                    return null
                },
                c = e.attrHooks.value && e.attrHooks.value.set ||
                function() {
                    return n
                },
                l = /^(?:input|button)$/i,
                d = /^[238]$/,
                p = /^(?:autofocus|autoplay|async|checked|controls|defer|disabled|hidden|loop|multiple|open|readonly|required|scoped|selected)$/i,
                f = /^(?:checked|selected)$/i;
                a(e, "attrFn", o || {},
                "jQuery.attrFn is deprecated"),
                e.attr = function(t, a, i, u) {
                    var c = a.toLowerCase(),
                    g = t && t.nodeType;
                    return u && (4 > s.length && r("jQuery.fn.attr( props,pass ) is deprecated"), t && !d.test(g) && (o ? a in o: e.isFunction(e.fn[a]))) ? e(t)[a](i) : ("type" === a && i !== n && l.test(t.nodeName) && t.parentNode && r("Can't change the 'type' of an input or button in IE 6/7/8"), !e.attrHooks[c] && p.test(c) && (e.attrHooks[c] = {
                        get: function(t, r) {
                            var a, i = e.prop(t, r);
                            return i === !0 || "boolean" != typeof i && (a = t.getAttributeNode(r)) && a.nodeValue !== !1 ? r.toLowerCase() : n
                        },
                        set: function(t, n, r) {
                            var a;
                            return n === !1 ? e.removeAttr(t, r) : (a = e.propFix[r] || r, a in t && (t[a] = !0), t.setAttribute(r, r.toLowerCase())),
                            r
                        }
                    },
                    f.test(c) && r("jQuery.fn.attr('" + c + "') may use property instead of attribute")), s.call(e, t, a, i))
                },
                e.attrHooks.value = {
                    get: function(e, t) {
                        var n = (e.nodeName || "").toLowerCase();
                        return "button" === n ? u.apply(this, arguments) : ("input" !== n && "option" !== n && r("jQuery.fn.attr('value') no longer gets properties"), t in e ? e.value: null)
                    },
                    set: function(e, t) {
                        var a = (e.nodeName || "").toLowerCase();
                        return "button" === a ? c.apply(this, arguments) : ("input" !== a && "option" !== a && r("jQuery.fn.attr('value',val) no longer sets properties"), e.value = t, n)
                    }
                };
                var g, h, v = e.fn.init,
                m = e.parseJSON,
                y = /^([^<]*)(<[\w\W]+>)([^>]*)$/;
                e.fn.init = function(t, n, a) {
                    var i;
                    return t && "string" == typeof t && !e.isPlainObject(n) && (i = y.exec(e.trim(t))) && i[0] && ("<" !== t.charAt(0) && r("$(html) HTML strings must start with '<' character"), i[3] && r("$(html) HTML text after last tag is ignored"), "#" === i[0].charAt(0) && (r("HTML string cannot start with a '#' character"), e.error("JQMIGRATE:Invalid selector string (XSS)")), n && n.context && (n = n.context), e.parseHTML) ? v.call(this, e.parseHTML(i[2], n, !0), n, a) : v.apply(this, arguments)
                },
                e.fn.init.prototype = e.fn,
                e.parseJSON = function(e) {
                    return e || null === e ? m.apply(this, arguments) : (r("jQuery.parseJSON requires a valid JSON string"), null)
                },
                e.uaMatch = function(e) {
                    e = e.toLowerCase();
                    var t = /(chrome)[ \/]([\w.]+)/.exec(e) || /(webkit)[ \/]([\w.]+)/.exec(e) || /(opera)(?:.*version|)[ \/]([\w.]+)/.exec(e) || /(msie) ([\w.]+)/.exec(e) || 0 > e.indexOf("compatible") && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec(e) || [];
                    return {
                        browser: t[1] || "",
                        version: t[2] || "0"
                    }
                },
                e.browser || (g = e.uaMatch(navigator.userAgent), h = {},
                g.browser && (h[g.browser] = !0, h.version = g.version), h.chrome ? h.webkit = !0 : h.webkit && (h.safari = !0), e.browser = h),
                a(e, "browser", e.browser, "jQuery.browser is deprecated"),
                e.sub = function() {
                    function t(e, n) {
                        return new t.fn.init(e, n)
                    }
                    e.extend(!0, t, this),
                    t.superclass = this,
                    t.fn = t.prototype = this(),
                    t.fn.constructor = t,
                    t.sub = this.sub,
                    t.fn.init = function(r, a) {
                        return a && a instanceof e && !(a instanceof t) && (a = t(a)),
                        e.fn.init.call(this, r, a, n)
                    },
                    t.fn.init.prototype = t.fn;
                    var n = t(document);
                    return r("jQuery.sub() is deprecated"),
                    t
                },
                e.ajaxSetup({
                    converters: {
                        "text json": e.parseJSON
                    }
                });
                var b = e.fn.data;
                e.fn.data = function(t) {
                    var a, i, o = this[0];
                    return ! o || "events" !== t || 1 !== arguments.length || (a = e.data(o, t), i = e._data(o, t), a !== n && a !== i || i === n) ? b.apply(this, arguments) : (r("Use of jQuery.fn.data('events') is deprecated"), i)
                };
                var j = /\/(java|ecma)script/i,
                w = e.fn.andSelf || e.fn.addBack;
                e.fn.andSelf = function() {
                    return r("jQuery.fn.andSelf() replaced by jQuery.fn.addBack()"),
                    w.apply(this, arguments)
                },
                e.clean || (e.clean = function(t, a, i, o) {
                    a = a || document,
                    a = !a.nodeType && a[0] || a,
                    a = a.ownerDocument || a,
                    r("jQuery.clean() is deprecated");
                    var s, u, c, l, d = [];
                    if (e.merge(d, e.buildFragment(t, a).childNodes), i) {
                        for (c = function(e) {
                            return ! e.type || j.test(e.type) ? o ? o.push(e.parentNode ? e.parentNode.removeChild(e) : e) : i.appendChild(e) : n
                        },
                        s = 0; null != (u = d[s]); s++) {
                            e.nodeName(u, "script") && c(u) || (i.appendChild(u), u.getElementsByTagName !== n && (l = e.grep(e.merge([], u.getElementsByTagName("script")), c), d.splice.apply(d, [s + 1, 0].concat(l)), s += l.length))
                        }
                    }
                    return d
                });
                var Q = e.event.add,
                x = e.event.remove,
                k = e.event.trigger,
                N = e.fn.toggle,
                T = e.fn.live,
                M = e.fn.die,
                S = "ajaxStart|ajaxStop|ajaxSend|ajaxComplete|ajaxError|ajaxSuccess",
                C = RegExp("\\b(?:" + S + ")\\b"),
                H = /(?:^|\s)hover(\.\S+|)\b/,
                A = function(t) {
                    return "string" != typeof t || e.event.special.hover ? t: (H.test(t) && r("'hover' pseudo-event is deprecated,use 'mouseenter mouseleave'"), t && t.replace(H, "mouseenter$1 mouseleave$1"))
                };
                e.event.props && "attrChange" !== e.event.props[0] && e.event.props.unshift("attrChange", "attrName", "relatedNode", "srcElement"),
                e.event.dispatch && a(e.event, "handle", e.event.dispatch, "jQuery.event.handle is undocumented and deprecated"),
                e.event.add = function(e, t, n, a, i) {
                    e !== document && C.test(t) && r("AJAX events should be attached to document:" + t),
                    Q.call(this, e, A(t || ""), n, a, i)
                },
                e.event.remove = function(e, t, n, r, a) {
                    x.call(this, e, A(t) || "", n, r, a)
                },
                e.fn.error = function() {
                    var e = Array.prototype.slice.call(arguments, 0);
                    return r("jQuery.fn.error() is deprecated"),
                    e.splice(0, 0, "error"),
                    arguments.length ? this.bind.apply(this, e) : (this.triggerHandler.apply(this, e), this)
                },
                e.fn.toggle = function(t, n) {
                    if (!e.isFunction(t) || !e.isFunction(n)) {
                        return N.apply(this, arguments)
                    }
                    r("jQuery.fn.toggle(handler,handler...) is deprecated");
                    var a = arguments,
                    i = t.guid || e.guid++,
                    o = 0,
                    s = function(n) {
                        var r = (e._data(this, "lastToggle" + t.guid) || 0) % o;
                        return e._data(this, "lastToggle" + t.guid, r + 1),
                        n.preventDefault(),
                        a[r].apply(this, arguments) || !1
                    };
                    for (s.guid = i; a.length > o;) {
                        a[o++].guid = i
                    }
                    return this.click(s)
                },
                e.fn.live = function(t, n, a) {
                    return r("jQuery.fn.live() is deprecated"),
                    T ? T.apply(this, arguments) : (e(this.context).on(t, this.selector, n, a), this)
                },
                e.fn.die = function(t, n) {
                    return r("jQuery.fn.die() is deprecated"),
                    M ? M.apply(this, arguments) : (e(this.context).off(t, this.selector || "**", n), this)
                },
                e.event.trigger = function(e, t, n, a) {
                    return n || C.test(e) || r("Global events are undocumented and deprecated"),
                    k.call(this, e, t, n || document, a)
                },
                e.each(S.split("|"),
                function(t, n) {
                    e.event.special[n] = {
                        setup: function() {
                            var t = this;
                            return t !== document && (e.event.add(document, n + "." + e.guid,
                            function() {
                                e.event.trigger(n, null, t, !0)
                            }), e._data(this, n, e.guid++)),
                            !1
                        },
                        teardown: function() {
                            return this !== document && e.event.remove(document, n + "." + e._data(this, n)),
                            !1
                        }
                    }
                })
            } (jQuery, window);
            var t, x, y; (function($) {
                jQuery.fn.PositionFixed = function(options) {
                    var defaults = {
                        css: "",
                        x: 0,
                        y: 0
                    };
                    var o = jQuery.extend(defaults, options);
                    var isIe6 = false;
                    if ($.browser.msie && parseInt($.browser.version) == 6) {
                        isIe6 = true
                    }
                    var html = $("html");
                    if (isIe6 && html.css("backgroundAttachment") !== "fixed") {
                        html.css("backgroundAttachment", "fixed")
                    }
                    return this.each(function() {
                        var domThis = $(this)[0];
                        var objThis = $(this);
                        if (isIe6) {
                            var left = parseInt(o.x) - html.scrollLeft(),
                            top = parseInt(o.y) - html.scrollTop();
                            objThis.css("position", "absolute");
                            domThis.style.setExpression("left", "eval((document.documentElement).scrollLeft + " + o.x + ') + "px"');
                            domThis.style.setExpression("top", "eval((document.documentElement).scrollTop + " + o.y + ') + "px"')
                        } else {
                            objThis.css("position", "fixed").css("top", o.y).css("left", o.x)
                        }
                    })
                }
            })(jQuery);
            var Floaters = {
                delta: 0.08,
                queue: null,
                collection: {},
                items: [],
                addItem: function(Obj, left, top, ani) {
                    Obj.style["top"] = top + "px";
                    Obj.style["left"] = left + "px";
                    var newItem = {
                        object: Obj,
                        oLeft: left,
                        oTop: top
                    };
                    this.items[this.items.length] = newItem;
                    this.delta = ani ? ani: this.delta
                },
                sPlay: function() {
                    this.collection = this.items;
                    this.queue = setInterval(function() {
                        metplay()
                    },
                    10)
                }
            };
            function checkStandard() {
                var scrollY;
                if (document.documentElement && document.documentElement.scrollTop) {
                    scrollY = document.documentElement.scrollTop
                } else {
                    if (document.body) {
                        scrollY = document.body.scrollTop
                    }
                }
                return scrollY
            }
            function metplay() {
                var diffY = checkStandard();
                for (var i in Floaters.collection) {
                    var obj = Floaters.collection[i].object;
                    var obj_y = Floaters.collection[i].oTop;
                    var total = diffY + obj_y;
                    if (obj.offsetTop != total) {
                        var oy = (total - obj.offsetTop) * Floaters.delta;
                        oy = (oy > 0 ? 1 : -1) * Math.ceil(Math.abs(oy));
                        obj.style["top"] = obj.offsetTop + oy + "px"
                    } else {
                        clearInterval(Floaters.queue);
                        Floaters.queue = setInterval(function() {
                            metplay()
                        },
                        10)
                    }
                }
            }
            function onlineclose() {
                $("#onlinebox").hide();
                return false
            }
            function olne_domx(type, onlinex) {
                var maxr = document.body.offsetWidth - $("#onlinebox").width();
                if (type > 1) {
                    onlinex = document.body.scrollWidth - $("#onlinebox").width() - onlinex
                }
                if (onlinex < 0) {
                    onlinex = 0
                }
                if (onlinex > maxr) {
                    onlinex = maxr;
                    if ($.browser.msie && parseInt($.browser.version) == 6) {
                        onlinex = maxr - 18
                    }
                }
                return onlinex
            }
            function olne_domx_op(type, onlinex) {
                var zwd = document.documentElement.clientWidth;
                var oboxw = $("#onlinebox").width();
                oboxw = oboxw == 0 ? $("#onlinebox .onlinebox-conbox").width() : oboxw;
                var maxr = zwd - oboxw;
                if (type > 1) {
                    onlinex = zwd - oboxw - onlinex
                }
                if (onlinex < 0) {
                    onlinex = 0
                }
                if (onlinex > maxr) {
                    onlinex = maxr;
                    if ($.browser.msie && parseInt($.browser.version) == 6) {
                        onlinex = maxr - 18
                    }
                }
                return onlinex
            }
            function olne_dd_wd(d) {
                var w = 0;
                d.each(function() {
                    w = w > $(this).outerWidth(true) ? w: $(this).outerWidth(true)
                });
                return w
            }
            function olne_mouse_on(t, my, nex, type) {
                if (t == 1) {
                    my.hide();
                    nex.show();
                    var dmk = $("div.onlinebox-conbox .online-tbox").size() ? $("div.onlinebox-conbox .online-tbox").outerWidth(true) : 0;
                    var dt = olne_dd_wd($("div.onlinebox-conbox dd"));
                    dt = dt > dmk ? dt: $("div.onlinebox-conbox .online-tbox").outerWidth(true);
                    if (dt <= 0) {
                        dt = 100
                    }
                    nex.css({
                        "width": dt + "px"
                    })
                } else {
                    nex.css({
                        "position": "absolute",
                        "left": "0px"
                    });
                    nex.hide();
                    my.show()
                }
                olne_resize()
            }
            function olne_resize() {
                mx = Number(olne_domx_op(t, x));
                my = Number(y);
                if (t > 0 && t < 3) {
                    var floatDivr = document.getElementById("onlinebox");
                    Floaters.addItem(floatDivr, mx, my);
                    Floaters.sPlay()
                } else {
                    $("#onlinebox").PositionFixed({
                        x: mx,
                        y: my
                    })
                }
            }
            function olne_mouse(dom, type) {
                var nex = dom.next("div.onlinebox-conbox");
                if ($(".onlinebox_2").size() > 0) {
                    dom.click(function() {
                        olne_mouse_on(1, $(this), nex, type)
                    })
                } else {
                    dom.hover(function() {
                        olne_mouse_on(1, $(this), nex, type)
                    },
                    function() {})
                }
                $("#onlinebox .onlinebox-top").click(function() {
                    if (!nex.is(":hidden")) {
                        olne_mouse_on(0, dom, nex, type)
                    }
                });
                textWrap($(".onlinebox-showbox span"))
            }
            function textWrap(my) {
                var text = "",
                txt = my.text();
                txt = txt.split("");
                for (var i = 0; i < txt.length; i++) {
                    text += txt[i] + "<br/>"
                }
                my.html(text)
            }
            function olne_app(msg, type, mxq, myq) {
                $("body").append(msg);
                mx = Number(olne_domx_op(type, mxq));
                my = Number(myq);
                if (type > 0 && type < 3) {
                    var floatDivr = document.getElementById("onlinebox");
                    Floaters.addItem(floatDivr, mx, my);
                    Floaters.sPlay()
                } else {
                    $("#onlinebox").PositionFixed({
                        x: mx,
                        y: my
                    })
                }
                $(window).resize(function() {
                    olne_resize()
                });
                $("#onlinebox").show();
                if ($("div.onlinebox-showbox").size() > 0) {
                    olne_mouse($("div.onlinebox-showbox"), type)
                }
            }
            $(document).ready(function() {
                var url = M["weburl"] + "include/online.php?lang=" + M["lang"];
                $.ajax({
                    type: "POST",
                    url: url,
                    dataType: "json",
                    success: function(msg) {
                        t = msg.t,
                        x = msg.x,
                        y = msg.y;
                        if (t != 3) {
                            olne_app(msg.html, t, x, y)
                        }
                    }
                })
            })
        }
        if (c.met_stat == 1) {
            var navurl = M["classnow"] == 10001 ? "": "../";
            var stat_d = M["classnow"] + "-" + M["id"] + "-" + M["lang"];
            var url = M["weburl"] + "include/stat/stat.php?type=para&u=" + navurl + "&d=" + stat_d;
            $.getScript(url)
        }
    }
});