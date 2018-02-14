$(document).ready(function() {
	/*文章列表页*/
    /*图片高度预设*/
    imageSize('.met-news .met-news-list [data-scale]');
    var news_original='.met-news .met-page-ajax [data-original]';
	if($(news_original).length){
        //图片预加载
		$(news_original).lazyload();
	}
    /*模式3*/
    if($('.news-headlines .slick-slide').length>1){
        $('.news-headlines').slick({
            autoplay:true,
            dots: true,
            autoplaySpeed: 4000,
            speed: 500,
            swipe:false,
            prevArrow:met_prevArrow,
            nextArrow:met_nextArrow,
            lazyloadPrevNext:true,
            responsive: [{
                breakpoint: 1200,
                settings: {
                    swipe:true
                }
            }]
        });
    }
})