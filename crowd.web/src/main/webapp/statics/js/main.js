/**
 * 
 */

/**/
var M=document.querySelector('meta[name="generator"]').getAttribute('data-variable'),D=M.split(',');M=new Array();M['weburl']=D[0];M['lang']=D[1];M['classnow']=parseInt(D[2]);M['id']=parseInt(D[3]);M['module']=parseInt(D[4]);M['tem']=D[0]+'templates/'+D[5];var deviceType = /iPad/.test(navigator.userAgent) ? 't' : /Mobile|iP(hone|od)|Android|BlackBerry|IEMobile|Silk/.test(navigator.userAgent) ? 'm' : 'd',is_ucbro=/UC/.test(navigator.userAgent);

var met_prevArrow='<button type="button" class="slick-prev"><i class="icon pe-angle-left vertical-align-middle"></button>',met_nextArrow='<button type="button" class="slick-next"><i class="icon pe-angle-right vertical-align-middle"></i></button>';
/*form.js*/
$(document).ready(function() {if ($(".met-form-validation").length) {$(".met-form-validation").formValidation({framework:"bootstrap"
    })}$(document).on('keyup', ".met-form input[name='code']",function() {$(this).val($(this).val().toUpperCase());});})
function codeimgRefresh(){var url = $(".met-form-codeimg").data("url");$(".met-form-codeimg").attr("src",url+'&random='+Math.floor(Math.random()*9999+1));}$(document).on("change", ".input-group-file [type=file]",function() {var $this = $(this),
    $text = $(this).parents('.input-group-file').find('.form-control'),value = "";$.each($this[0].files,function(i,file) {value += file.name + ", ";});
  value = value.substring(0,value.length - 2);$text.val(value);});
/*job.js*/
$(document).ready(function() {if($("#met-job-cv").length){$(document).on('click',".met-job-cvbtn",function(){var cvurl = $(this).data('cvurl'),jobid = $(this).data('jobid');
if($("#met-job-cv .modal-body .form-group").length){$("#met-job-cv .met-form").data('formValidation').resetForm();$("#met-job-cv .modal-body input[name='jobid']").val(jobid);}else{$("#met-job-cv .modal-body").html('<div class="height-100 vertical-align text-center cart-loader"><div class="loader vertical-align-middle loader-default"></div></div>');$.ajax({url:cvurl+'&jobid='+jobid,type:'POST',success:function(data) {$("#met-job-cv .modal-body").html(data).hide().slideDown(500);$.components.init('placeholder');$("#met-job-cv .met-form").formValidation({framework:"bootstrap"
})
if(!$("#met-job-cv .modal-body input[name='jobid']").val()) $("#met-job-cv .modal-body input[name='jobid']").val(jobid);}});}$("#met-job-cv").modal('show');});}})
/*img.js*/
$(document).ready(function() {if($('.met-img').length){imageSize('.met-img .met-page-ajax');$(".met-img [data-original]").lazyload();}
if($(".met-img-showbtn").length){$(document).on('click',".met-img-showbtn",function(){var imglist = $(this).data("imglist"),dyarr = new Array(),arlt = imglist.split('|');$.each(arlt,function(name,value) {if(value!=''){var st = value.split('*'),key=name;
dyarr[key] = new Array();
dyarr[key]['src'] = st[1];
dyarr[key]['thumb'] = st[1];
dyarr[key]['subHtml'] = st[0];}})
$(this).galleryLoad(dyarr);});}

var $imgpara=$('.imgpara');
if($imgpara.length){if(!$imgpara.find('li').length) $imgpara.remove();}})
/*product.js*/
$(document).ready(function() {if($('.met-product').length){imageSize('.met-product .met-page-ajax');
if($(".met-product [data-original]").length){$(".met-product [data-original]").lazyload();
var $pro_fluid=$(".met-product .container-fluid");
if($pro_fluid.length){$pro_fluid.each(function() {var $this=$(this);$(this).width($(this).width());
setTimeout(function(){$this.width('');},2000)});}
MetAnimOnScroll();}}


var met_img_carousel='#met-imgs-carousel',met_img_carousel_slide=met_img_carousel+' .slick-slide';
if($(met_img_carousel_slide).length>1){var slickdots=met_img_carousel+' ul.slick-dots',slickdots_div=met_img_carousel+' ul.slick-dots div',slickdots_li=met_img_carousel+' ul.slick-dots li',showpro_index=0;$(met_img_carousel).on('init',function(event,slick){var met_img_carousel_slide_true=met_img_carousel_slide+':not(.slick-cloned)';
for (var i = 0; i < $(met_img_carousel_slide_true).length; i++) {var thumbsrc=$(met_img_carousel_slide_true+':eq('+i+')').data('exthumbimage'),thumbalt=$(met_img_carousel_slide_true+':eq('+i+') img').attr('alt'),showpro_thumb='<img src="'+thumbsrc+'" alt="'+thumbalt+'" />';$(slickdots_li).eq(i).html(showpro_thumb);}$(slickdots).wrapInner('<div></div>');$(slickdots_div).width($(slickdots_li).length*74-10);})
var slick_swipe=true,slick_fade=false;
if($(met_img_carousel).hasClass('fngallery') && deviceType=='d'){slick_swipe=false;
slick_fade=true;}$(met_img_carousel).slick({dots:true,speed:500,fade:slick_fade,swipe:slick_swipe,lazyloadPrevNext:true,prevArrow:met_prevArrow,nextArrow:met_nextArrow,
})
$(met_img_carousel).on('beforeChange',function(event,slick,currentSlide,nextSlide) {paginationScroll(nextSlide);
showpro_index=nextSlide;});$(window).resize(function() {paginationScroll(showpro_index);});
    function paginationScroll(index){var slickdots_w = $(slickdots).width(),slickdots_div_w = $(slickdots_div).width(),deviation = parseInt(index * 74- slickdots_w / 2 +32);
if (slickdots_div_w > slickdots_w) {var translateX = deviation > 0 ? -deviation :0;
if (deviation + slickdots_w >= slickdots_div_w) translateX = -parseInt(slickdots_div_w - slickdots_w);
 if($('html').hasClass('no-csstransitions')){$(slickdots_div).stop().animate({left:translateX},500);}else{$(slickdots_div).css({transform:'translateX(' + translateX + 'px)'});}}
}}
if($('.fngallery').length) $('.fngallery').galleryLoad();


if($('.met-showproduct.pagetype1').length){$('a[data-toggle="tab"]').on('shown.bs.tab',function (e) {var href = $(this).attr('href');$(href).find('img:eq(0)').trigger('scroll');})

navtabSwiper(".met-showproduct-navtabs");

var prohot='.product-hot .mob-masonry';
if($(prohot).length){imageSize(prohot);$(prohot+' img').lazyload();
Breakpoints.on('xs sm',{enter:function(){$(prohot).masonry({itemSelector:"li"});}});}}


var showprotype2='.met-showproduct.pagetype2';
if($(showprotype2).length){window.navbar = $(showprotype2+' .navbar');
var navbar_t = navbar.offset().top,wh=$(window).height();$(window).scroll(function (){var st = $(this).scrollTop();
if(st>navbar_t){navbar.addClass('navbar-fixed-top animation-slide-top');}else{navbar.removeClass('navbar-fixed-top animation-slide-top');}
navbar.find('.navbar-right li a').each(function(){var topsize = pro_topsize($(this));
if(st>=(topsize-30)) pro_active($(this));});});$(document).on('click',showprotype2+' .navbar .navbar-right li a',function(e) {e.preventDefault();
var thisobj=$(this),scrollTopInt=setInterval(function(){var w_scroll=$(window).scrollTop();
if(w_scroll==pro_topsize(thisobj) || w_scroll+wh>=$(document).height()){pro_active(thisobj);
clearInterval(scrollTopInt);}$('html,body').animate({scrollTop:pro_topsize(thisobj)},300,"linear");},300)})

$(showprotype2+' .navbar .navbar-toggle').one("click",function () {setTimeout(function(){navtabSwiper(".met-showproduct-navtabs");},0)});}})

function pro_active(dom){navbar.find('.navbar-right li').removeClass('active');
dom.parent('li').addClass('active');}

function pro_topsize(dom){var oftop = $(dom.attr("href")).offset().top,topsize = oftop - 100;
if(navbar.hasClass('navbar-fixed-top')){topsize = topsize + 50;}else{if(Breakpoints.is('xs')){topsize = topsize - navbar.find(".navbar-collapse-toolbar").height();}}
if(topsize<0)topsize = 10;
return topsize;}

function MetAnimOnScroll(okno){new AnimOnScroll( document.getElementById( 'met-grid' ), {minDuration :0.4,maxDuration :0.7,viewportFactor :0.2
});}
/*news.js*/
$(document).ready(function() {imageSize('.met-news .met-news-list [data-scale]');
  var news_original='.met-news .met-page-ajax [data-original]';
if($(news_original).length){$(news_original).lazyload();}
  
  if($('.news-headlines .slick-slide').length>1){$('.news-headlines').slick({autoplay:true,dots:true,autoplaySpeed:4000,speed:500,swipe:false,prevArrow:met_prevArrow,nextArrow:met_nextArrow,lazyloadPrevNext:true,responsive:[{breakpoint:1200,settings:{swipe:true
        }}]
    });}})
/*page.js*/
$(document).ready(function() {if($(".met-page-ajax").length){if($(".met_pager a").length==1)$(".met_pager").addClass('hide');
if($(".met-page-ajax-body").hasClass("visible-xs-block")){
Breakpoints.get('xs').on({enter:function(){metpageajax();}});}else{metpageajax();
setTimeout(function(){$('.met-page-ajax-body').scrollFun(function(val){val.appearDiy();});},0)}}})

function metpageajax(){var pagebtn  = $("#met-page-btn"),pageul = $(".met-page-ajax");
window.pagemax = $(".met_pager a").length-1;
window.page = pagebtn.data("page");
if(window.pagemax <= window.page)pagebtn.addClass('hide');
pagebtn.click(function(){var dom = $(this);
page++;$.ajax({url:dom.data("url")+'&page='+page,type:'POST',success:function(data) {pageul.append(data);
pagespecial();
if(pagemax <= page)dom.addClass('hide');}});});}

function pagespecial(){setTimeout(function(){imageSize(".met-page-ajax",".page"+page+" [data-original]");},0)
  $(".met-page-ajax .page"+page+" [data-original]").lazyload();$('html,body').stop().animate({scrollTop:$(window).scrollTop()+1},10);
if($('#met-grid').length) MetAnimOnScroll();}
/*editor.js*/
$(document).ready(function() {if($(".met-editor table").length){$(".met-editor table").addClass('table table-bordered table-hover table-striped table-responsive');
tablexys();}

if($(".met-editor img").length){$(".met-editor.lazyload img").lazyload();
  if (!$(".met-editor.no-gallery").length) {$(".met-editor").wrapInner("<div class='editorlightgallery'></div>");$(".met-editor").each(function() {var img_gallery_open=1,this_editor=this;$("img",this).one('click',function() {if(img_gallery_open){$('img',this_editor).each(function() {if($(this).parent("a").length==0){var data_thumb=data_src = $(this).data("original") ? $(this).data("original"):$(this).attr("src");
if($(this).hasClass('imgloading')){var data_thumbs=data_src.split('upload/');
data_thumb='../include/thumb.php?dir=../upload/'+data_thumbs[1]+'&x=60&y=60';}$(this).wrap("<div class='lg-item-box' data-src='"+data_src+"' data-exthumbimage='"+data_thumb+"'></div>");}});$('.editorlightgallery',this_editor).galleryLoad();$(this).parent('.lg-item-box').trigger('click');
img_gallery_open=0;}});});}}
})

function tablexys(){
Breakpoints.get('xs').on({enter:function(){$(".met-editor table").each(function(){var table = $(this);
if(table.is(':visible')&&!table.hasClass('tablesaw')){if(table.find("thead").length){table.addClass('tablesaw').attr("data-tablesaw-mode","swipe");}else{var td = table.find("tbody tr:eq(0) td"),th;
if(td.length==0)td = table.find("tbody tr:eq(0) th");
td.each(function(){th+='<th>'+$(this).html()+'</th>';});
table.prepend("<thead><tr>"+th+"</tr></thead>");
table.find("tbody tr:eq(0)").remove();
table.find("tbody td").attr('width','auto');
table.addClass('tablesaw').attr("data-tablesaw-mode","swipe");}}
});$('.met-editor .table-responsive').parent().addClass('table-saw');$( document ).trigger( "enhance.tablesaw");}});}
/*isotope.pkgd.min.js*/


!function(a){function b(){}function c(a){function c(b){b.prototype.option||(b.prototype.option=function(b){a.isPlainObject(b)&&(this.options=a.extend(!0,this.options,b))})}function e(b,c){a.fn[b]=function(e){if("string"==typeof e){for(var g=d.call(arguments,1),h=0,i=this.length;i>h;h++){var j=this[h],k=a.data(j,b);if(k)if(a.isFunction(k[e])&&"_"!==e.charAt(0)){var l=k[e].apply(k,g);if(void 0!==l)return l}else f("no such method '"+e+"' for "+b+" instance");else f("cannot call methods on "+b+" prior to initialization; attempted to call '"+e+"'")}return this}return this.each(function(){var d=a.data(this,b);d?(d.option(e),d._init()):(d=new c(this,e),a.data(this,b,d))})}}if(a){var f="undefined"==typeof console?b:function(a){console.error(a)};return a.bridget=function(a,b){c(b),e(a,b)},a.bridget}}var d=Array.prototype.slice;"function"==typeof define&&define.amd?define("jquery-bridget/jquery.bridget",["jquery"],c):c("object"==typeof exports?require("jquery"):a.jQuery)}(window),function(a){function b(b){var c=a.event;return c.target=c.target||c.srcElement||b,c}var c=document.documentElement,d=function(){};c.addEventListener?d=function(a,b,c){a.addEventListener(b,c,!1)}:c.attachEvent&&(d=function(a,c,d){a[c+d]=d.handleEvent?function(){var c=b(a);d.handleEvent.call(d,c)}:function(){var c=b(a);d.call(a,c)},a.attachEvent("on"+c,a[c+d])});var e=function(){};c.removeEventListener?e=function(a,b,c){a.removeEventListener(b,c,!1)}:c.detachEvent&&(e=function(a,b,c){a.detachEvent("on"+b,a[b+c]);try{delete a[b+c]}catch(d){a[b+c]=void 0}});var f={bind:d,unbind:e};"function"==typeof define&&define.amd?define("eventie/eventie",f):"object"==typeof exports?module.exports=f:a.eventie=f}(window),function(){"use strict";function a(){}function b(a,b){for(var c=a.length;c--;)if(a[c].listener===b)return c;return-1}function c(a){return function(){return this[a].apply(this,arguments)}}var d=a.prototype,e=this,f=e.EventEmitter;d.getListeners=function(a){var b,c,d=this._getEvents();if(a instanceof RegExp){b={};for(c in d)d.hasOwnProperty(c)&&a.test(c)&&(b[c]=d[c])}else b=d[a]||(d[a]=[]);return b},d.flattenListeners=function(a){var b,c=[];for(b=0;b<a.length;b+=1)c.push(a[b].listener);return c},d.getListenersAsObject=function(a){var b,c=this.getListeners(a);return c instanceof Array&&(b={},b[a]=c),b||c},d.addListener=function(a,c){var d,e=this.getListenersAsObject(a),f="object"==typeof c;for(d in e)e.hasOwnProperty(d)&&-1===b(e[d],c)&&e[d].push(f?c:{listener:c,once:!1});return this},d.on=c("addListener"),d.addOnceListener=function(a,b){return this.addListener(a,{listener:b,once:!0})},d.once=c("addOnceListener"),d.defineEvent=function(a){return this.getListeners(a),this},d.defineEvents=function(a){for(var b=0;b<a.length;b+=1)this.defineEvent(a[b]);return this},d.removeListener=function(a,c){var d,e,f=this.getListenersAsObject(a);for(e in f)f.hasOwnProperty(e)&&(d=b(f[e],c),-1!==d&&f[e].splice(d,1));return this},d.off=c("removeListener"),d.addListeners=function(a,b){return this.manipulateListeners(!1,a,b)},d.removeListeners=function(a,b){return this.manipulateListeners(!0,a,b)},d.manipulateListeners=function(a,b,c){var d,e,f=a?this.removeListener:this.addListener,g=a?this.removeListeners:this.addListeners;if("object"!=typeof b||b instanceof RegExp)for(d=c.length;d--;)f.call(this,b,c[d]);else for(d in b)b.hasOwnProperty(d)&&(e=b[d])&&("function"==typeof e?f.call(this,d,e):g.call(this,d,e));return this},d.removeEvent=function(a){var b,c=typeof a,d=this._getEvents();if("string"===c)delete d[a];else if(a instanceof RegExp)for(b in d)d.hasOwnProperty(b)&&a.test(b)&&delete d[b];else delete this._events;return this},d.removeAllListeners=c("removeEvent"),d.emitEvent=function(a,b){var c,d,e,f,g=this.getListenersAsObject(a);for(e in g)if(g.hasOwnProperty(e))for(d=g[e].length;d--;)c=g[e][d],c.once===!0&&this.removeListener(a,c.listener),f=c.listener.apply(this,b||[]),f===this._getOnceReturnValue()&&this.removeListener(a,c.listener);return this},d.trigger=c("emitEvent"),d.emit=function(a){var b=Array.prototype.slice.call(arguments,1);return this.emitEvent(a,b)},d.setOnceReturnValue=function(a){return this._onceReturnValue=a,this},d._getOnceReturnValue=function(){return this.hasOwnProperty("_onceReturnValue")?this._onceReturnValue:!0},d._getEvents=function(){return this._events||(this._events={})},a.noConflict=function(){return e.EventEmitter=f,a},"function"==typeof define&&define.amd?define("eventEmitter/EventEmitter",[],function(){return a}):"object"==typeof module&&module.exports?module.exports=a:e.EventEmitter=a}.call(this),function(a){function b(a){if(a){if("string"==typeof d[a])return a;a=a.charAt(0).toUpperCase()+a.slice(1);for(var b,e=0,f=c.length;f>e;e++)if(b=c[e]+a,"string"==typeof d[b])return b}}var c="Webkit Moz ms Ms O".split(" "),d=document.documentElement.style;"function"==typeof define&&define.amd?define("get-style-property/get-style-property",[],function(){return b}):"object"==typeof exports?module.exports=b:a.getStyleProperty=b}(window),function(a,b){function c(a){var b=parseFloat(a),c=-1===a.indexOf("%")&&!isNaN(b);return c&&b}function d(){}function e(){for(var a={width:0,height:0,innerWidth:0,innerHeight:0,outerWidth:0,outerHeight:0},b=0,c=h.length;c>b;b++){var d=h[b];a[d]=0}return a}function f(b){function d(){if(!m){m=!0;var d=a.getComputedStyle;if(j=function(){var a=d?function(a){return d(a,null)}:function(a){return a.currentStyle};return function(b){var c=a(b);return c||g("Style returned "+c+". Are you running this code in a hidden iframe on Firefox? See http://bit.ly/getsizebug1"),c}}(),k=b("boxSizing")){var e=document.createElement("div");e.style.width="200px",e.style.padding="1px 2px 3px 4px",e.style.borderStyle="solid",e.style.borderWidth="1px 2px 3px 4px",e.style[k]="border-box";var f=document.body||document.documentElement;f.appendChild(e);var h=j(e);l=200===c(h.width),f.removeChild(e)}}}function f(a){if(d(),"string"==typeof a&&(a=document.querySelector(a)),a&&"object"==typeof a&&a.nodeType){var b=j(a);if("none"===b.display)return e();var f={};f.width=a.offsetWidth,f.height=a.offsetHeight;for(var g=f.isBorderBox=!(!k||!b[k]||"border-box"!==b[k]),m=0,n=h.length;n>m;m++){var o=h[m],p=b[o];p=i(a,p);var q=parseFloat(p);f[o]=isNaN(q)?0:q}var r=f.paddingLeft+f.paddingRight,s=f.paddingTop+f.paddingBottom,t=f.marginLeft+f.marginRight,u=f.marginTop+f.marginBottom,v=f.borderLeftWidth+f.borderRightWidth,w=f.borderTopWidth+f.borderBottomWidth,x=g&&l,y=c(b.width);y!==!1&&(f.width=y+(x?0:r+v));var z=c(b.height);return z!==!1&&(f.height=z+(x?0:s+w)),f.innerWidth=f.width-(r+v),f.innerHeight=f.height-(s+w),f.outerWidth=f.width+t,f.outerHeight=f.height+u,f}}function i(b,c){if(a.getComputedStyle||-1===c.indexOf("%"))return c;var d=b.style,e=d.left,f=b.runtimeStyle,g=f&&f.left;return g&&(f.left=b.currentStyle.left),d.left=c,c=d.pixelLeft,d.left=e,g&&(f.left=g),c}var j,k,l,m=!1;return f}var g="undefined"==typeof console?d:function(a){console.error(a)},h=["paddingLeft","paddingRight","paddingTop","paddingBottom","marginLeft","marginRight","marginTop","marginBottom","borderLeftWidth","borderRightWidth","borderTopWidth","borderBottomWidth"];"function"==typeof define&&define.amd?define("get-size/get-size",["get-style-property/get-style-property"],f):"object"==typeof exports?module.exports=f(require("desandro-get-style-property")):a.getSize=f(a.getStyleProperty)}(window),function(a){function b(a){"function"==typeof a&&(b.isReady?a():g.push(a))}function c(a){var c="readystatechange"===a.type&&"complete"!==f.readyState;b.isReady||c||d()}function d(){b.isReady=!0;for(var a=0,c=g.length;c>a;a++){var d=g[a];d()}}function e(e){return"complete"===f.readyState?d():(e.bind(f,"DOMContentLoaded",c),e.bind(f,"readystatechange",c),e.bind(a,"load",c)),b}var f=a.document,g=[];b.isReady=!1,"function"==typeof define&&define.amd?define("doc-ready/doc-ready",["eventie/eventie"],e):"object"==typeof exports?module.exports=e(require("eventie")):a.docReady=e(a.eventie)}(window),function(a){"use strict";function b(a,b){return a[g](b)}function c(a){if(!a.parentNode){var b=document.createDocumentFragment();b.appendChild(a)}}function d(a,b){c(a);for(var d=a.parentNode.querySelectorAll(b),e=0,f=d.length;f>e;e++)if(d[e]===a)return!0;return!1}function e(a,d){return c(a),b(a,d)}var f,g=function(){if(a.matches)return"matches";if(a.matchesSelector)return"matchesSelector";for(var b=["webkit","moz","ms","o"],c=0,d=b.length;d>c;c++){var e=b[c],f=e+"MatchesSelector";if(a[f])return f}}();if(g){var h=document.createElement("div"),i=b(h,"div");f=i?b:e}else f=d;"function"==typeof define&&define.amd?define("matches-selector/matches-selector",[],function(){return f}):"object"==typeof exports?module.exports=f:window.matchesSelector=f}(Element.prototype),function(a,b){"use strict";"function"==typeof define&&define.amd?define("fizzy-ui-utils/utils",["doc-ready/doc-ready","matches-selector/matches-selector"],function(c,d){return b(a,c,d)}):"object"==typeof exports?module.exports=b(a,require("doc-ready"),require("desandro-matches-selector")):a.fizzyUIUtils=b(a,a.docReady,a.matchesSelector)}(window,function(a,b,c){var d={};d.extend=function(a,b){for(var c in b)a[c]=b[c];return a},d.modulo=function(a,b){return(a%b+b)%b};var e=Object.prototype.toString;d.isArray=function(a){return"[object Array]"==e.call(a)},d.makeArray=function(a){var b=[];if(d.isArray(a))b=a;else if(a&&"number"==typeof a.length)for(var c=0,e=a.length;e>c;c++)b.push(a[c]);else b.push(a);return b},d.indexOf=Array.prototype.indexOf?function(a,b){return a.indexOf(b)}:function(a,b){for(var c=0,d=a.length;d>c;c++)if(a[c]===b)return c;return-1},d.removeFrom=function(a,b){var c=d.indexOf(a,b);-1!=c&&a.splice(c,1)},d.isElement="function"==typeof HTMLElement||"object"==typeof HTMLElement?function(a){return a instanceof HTMLElement}:function(a){return a&&"object"==typeof a&&1==a.nodeType&&"string"==typeof a.nodeName},d.setText=function(){function a(a,c){b=b||(void 0!==document.documentElement.textContent?"textContent":"innerText"),a[b]=c}var b;return a}(),d.getParent=function(a,b){for(;a!=document.body;)if(a=a.parentNode,c(a,b))return a},d.getQueryElement=function(a){return"string"==typeof a?document.querySelector(a):a},d.handleEvent=function(a){var b="on"+a.type;this[b]&&this[b](a)},d.filterFindElements=function(a,b){a=d.makeArray(a);for(var e=[],f=0,g=a.length;g>f;f++){var h=a[f];if(d.isElement(h))if(b){c(h,b)&&e.push(h);for(var i=h.querySelectorAll(b),j=0,k=i.length;k>j;j++)e.push(i[j])}else e.push(h)}return e},d.debounceMethod=function(a,b,c){var d=a.prototype[b],e=b+"Timeout";a.prototype[b]=function(){var a=this[e];a&&clearTimeout(a);var b=arguments,f=this;this[e]=setTimeout(function(){d.apply(f,b),delete f[e]},c||100)}},d.toDashed=function(a){return a.replace(/(.)([A-Z])/g,function(a,b,c){return b+"-"+c}).toLowerCase()};var f=a.console;return d.htmlInit=function(c,e){b(function(){for(var b=d.toDashed(e),g=document.querySelectorAll(".js-"+b),h="data-"+b+"-options",i=0,j=g.length;j>i;i++){var k,l=g[i],m=l.getAttribute(h);try{k=m&&JSON.parse(m)}catch(n){f&&f.error("Error parsing "+h+" on "+l.nodeName.toLowerCase()+(l.id?"#"+l.id:"")+":"+n);continue}var o=new c(l,k),p=a.jQuery;p&&p.data(l,e,o)}})},d}),function(a,b){"use strict";"function"==typeof define&&define.amd?define("outlayer/item",["eventEmitter/EventEmitter","get-size/get-size","get-style-property/get-style-property","fizzy-ui-utils/utils"],function(c,d,e,f){return b(a,c,d,e,f)}):"object"==typeof exports?module.exports=b(a,require("wolfy87-eventemitter"),require("get-size"),require("desandro-get-style-property"),require("fizzy-ui-utils")):(a.Outlayer={},a.Outlayer.Item=b(a,a.EventEmitter,a.getSize,a.getStyleProperty,a.fizzyUIUtils))}(window,function(a,b,c,d,e){"use strict";function f(a){for(var b in a)return!1;return b=null,!0}function g(a,b){a&&(this.element=a,this.layout=b,this.position={x:0,y:0},this._create())}function h(a){return a.replace(/([A-Z])/g,function(a){return"-"+a.toLowerCase()})}var i=a.getComputedStyle,j=i?function(a){return i(a,null)}:function(a){return a.currentStyle},k=d("transition"),l=d("transform"),m=k&&l,n=!!d("perspective"),o={WebkitTransition:"webkitTransitionEnd",MozTransition:"transitionend",OTransition:"otransitionend",transition:"transitionend"}[k],p=["transform","transition","transitionDuration","transitionProperty"],q=function(){for(var a={},b=0,c=p.length;c>b;b++){var e=p[b],f=d(e);f&&f!==e&&(a[e]=f)}return a}();e.extend(g.prototype,b.prototype),g.prototype._create=function(){this._transn={ingProperties:{},clean:{},onEnd:{}},this.css({position:"absolute"})},g.prototype.handleEvent=function(a){var b="on"+a.type;this[b]&&this[b](a)},g.prototype.getSize=function(){this.size=c(this.element)},g.prototype.css=function(a){var b=this.element.style;for(var c in a){var d=q[c]||c;b[d]=a[c]}},g.prototype.getPosition=function(){var a=j(this.element),b=this.layout.options,c=b.isOriginLeft,d=b.isOriginTop,e=a[c?"left":"right"],f=a[d?"top":"bottom"],g=this.layout.size,h=-1!=e.indexOf("%")?parseFloat(e)/100*g.width:parseInt(e,10),i=-1!=f.indexOf("%")?parseFloat(f)/100*g.height:parseInt(f,10);h=isNaN(h)?0:h,i=isNaN(i)?0:i,h-=c?g.paddingLeft:g.paddingRight,i-=d?g.paddingTop:g.paddingBottom,this.position.x=h,this.position.y=i},g.prototype.layoutPosition=function(){var a=this.layout.size,b=this.layout.options,c={},d=b.isOriginLeft?"paddingLeft":"paddingRight",e=b.isOriginLeft?"left":"right",f=b.isOriginLeft?"right":"left",g=this.position.x+a[d];c[e]=this.getXValue(g),c[f]="";var h=b.isOriginTop?"paddingTop":"paddingBottom",i=b.isOriginTop?"top":"bottom",j=b.isOriginTop?"bottom":"top",k=this.position.y+a[h];c[i]=this.getYValue(k),c[j]="",this.css(c),this.emitEvent("layout",[this])},g.prototype.getXValue=function(a){var b=this.layout.options;return b.percentPosition&&!b.isHorizontal?a/this.layout.size.width*100+"%":a+"px"},g.prototype.getYValue=function(a){var b=this.layout.options;return b.percentPosition&&b.isHorizontal?a/this.layout.size.height*100+"%":a+"px"},g.prototype._transitionTo=function(a,b){this.getPosition();var c=this.position.x,d=this.position.y,e=parseInt(a,10),f=parseInt(b,10),g=e===this.position.x&&f===this.position.y;if(this.setPosition(a,b),g&&!this.isTransitioning)return void this.layoutPosition();var h=a-c,i=b-d,j={};j.transform=this.getTranslate(h,i),this.transition({to:j,onTransitionEnd:{transform:this.layoutPosition},isCleaning:!0})},g.prototype.getTranslate=function(a,b){var c=this.layout.options;return a=c.isOriginLeft?a:-a,b=c.isOriginTop?b:-b,n?"translate3d("+a+"px, "+b+"px, 0)":"translate("+a+"px, "+b+"px)"},g.prototype.goTo=function(a,b){this.setPosition(a,b),this.layoutPosition()},g.prototype.moveTo=m?g.prototype._transitionTo:g.prototype.goTo,g.prototype.setPosition=function(a,b){this.position.x=parseInt(a,10),this.position.y=parseInt(b,10)},g.prototype._nonTransition=function(a){this.css(a.to),a.isCleaning&&this._removeStyles(a.to);for(var b in a.onTransitionEnd)a.onTransitionEnd[b].call(this)},g.prototype._transition=function(a){if(!parseFloat(this.layout.options.transitionDuration))return void this._nonTransition(a);var b=this._transn;for(var c in a.onTransitionEnd)b.onEnd[c]=a.onTransitionEnd[c];for(c in a.to)b.ingProperties[c]=!0,a.isCleaning&&(b.clean[c]=!0);if(a.from){this.css(a.from);var d=this.element.offsetHeight;d=null}this.enableTransition(a.to),this.css(a.to),this.isTransitioning=!0};var r="opacity,"+h(q.transform||"transform");g.prototype.enableTransition=function(){this.isTransitioning||(this.css({transitionProperty:r,transitionDuration:this.layout.options.transitionDuration}),this.element.addEventListener(o,this,!1))},g.prototype.transition=g.prototype[k?"_transition":"_nonTransition"],g.prototype.onwebkitTransitionEnd=function(a){this.ontransitionend(a)},g.prototype.onotransitionend=function(a){this.ontransitionend(a)};var s={"-webkit-transform":"transform","-moz-transform":"transform","-o-transform":"transform"};g.prototype.ontransitionend=function(a){if(a.target===this.element){var b=this._transn,c=s[a.propertyName]||a.propertyName;if(delete b.ingProperties[c],f(b.ingProperties)&&this.disableTransition(),c in b.clean&&(this.element.style[a.propertyName]="",delete b.clean[c]),c in b.onEnd){var d=b.onEnd[c];d.call(this),delete b.onEnd[c]}this.emitEvent("transitionEnd",[this])}},g.prototype.disableTransition=function(){this.removeTransitionStyles(),this.element.removeEventListener(o,this,!1),this.isTransitioning=!1},g.prototype._removeStyles=function(a){var b={};for(var c in a)b[c]="";this.css(b)};var t={transitionProperty:"",transitionDuration:""};return g.prototype.removeTransitionStyles=function(){this.css(t)},g.prototype.removeElem=function(){this.element.parentNode.removeChild(this.element),this.css({display:""}),this.emitEvent("remove",[this])},g.prototype.remove=function(){if(!k||!parseFloat(this.layout.options.transitionDuration))return void this.removeElem();var a=this;this.once("transitionEnd",function(){a.removeElem()}),this.hide()},g.prototype.reveal=function(){delete this.isHidden,this.css({display:""});var a=this.layout.options,b={},c=this.getHideRevealTransitionEndProperty("visibleStyle");b[c]=this.onRevealTransitionEnd,this.transition({from:a.hiddenStyle,to:a.visibleStyle,isCleaning:!0,onTransitionEnd:b})},g.prototype.onRevealTransitionEnd=function(){this.isHidden||this.emitEvent("reveal")},g.prototype.getHideRevealTransitionEndProperty=function(a){var b=this.layout.options[a];if(b.opacity)return"opacity";for(var c in b)return c},g.prototype.hide=function(){this.isHidden=!0,this.css({display:""});var a=this.layout.options,b={},c=this.getHideRevealTransitionEndProperty("hiddenStyle");b[c]=this.onHideTransitionEnd,this.transition({from:a.visibleStyle,to:a.hiddenStyle,isCleaning:!0,onTransitionEnd:b})},g.prototype.onHideTransitionEnd=function(){this.isHidden&&(this.css({display:"none"}),this.emitEvent("hide"))},g.prototype.destroy=function(){this.css({position:"",left:"",right:"",top:"",bottom:"",transition:"",transform:""})},g}),function(a,b){"use strict";"function"==typeof define&&define.amd?define("outlayer/outlayer",["eventie/eventie","eventEmitter/EventEmitter","get-size/get-size","fizzy-ui-utils/utils","./item"],function(c,d,e,f,g){return b(a,c,d,e,f,g)}):"object"==typeof exports?module.exports=b(a,require("eventie"),require("wolfy87-eventemitter"),require("get-size"),require("fizzy-ui-utils"),require("./item")):a.Outlayer=b(a,a.eventie,a.EventEmitter,a.getSize,a.fizzyUIUtils,a.Outlayer.Item)}(window,function(a,b,c,d,e,f){"use strict";function g(a,b){var c=e.getQueryElement(a);if(!c)return void(h&&h.error("Bad element for "+this.constructor.namespace+":"+(c||a)));this.element=c,i&&(this.$element=i(this.element)),this.options=e.extend({},this.constructor.defaults),this.option(b);var d=++k;this.element.outlayerGUID=d,l[d]=this,this._create(),this.options.isInitLayout&&this.layout()}var h=a.console,i=a.jQuery,j=function(){},k=0,l={};return g.namespace="outlayer",g.Item=f,g.defaults={containerStyle:{position:"relative"},isInitLayout:!0,isOriginLeft:!0,isOriginTop:!0,isResizeBound:!0,isResizingContainer:!0,transitionDuration:"0.4s",hiddenStyle:{opacity:0,transform:"scale(0.001)"},visibleStyle:{opacity:1,transform:"scale(1)"}},e.extend(g.prototype,c.prototype),g.prototype.option=function(a){e.extend(this.options,a)},g.prototype._create=function(){this.reloadItems(),this.stamps=[],this.stamp(this.options.stamp),e.extend(this.element.style,this.options.containerStyle),this.options.isResizeBound&&this.bindResize()},g.prototype.reloadItems=function(){this.items=this._itemize(this.element.children)},g.prototype._itemize=function(a){for(var b=this._filterFindItemElements(a),c=this.constructor.Item,d=[],e=0,f=b.length;f>e;e++){var g=b[e],h=new c(g,this);d.push(h)}return d},g.prototype._filterFindItemElements=function(a){return e.filterFindElements(a,this.options.itemSelector)},g.prototype.getItemElements=function(){for(var a=[],b=0,c=this.items.length;c>b;b++)a.push(this.items[b].element);return a},g.prototype.layout=function(){this._resetLayout(),this._manageStamps();var a=void 0!==this.options.isLayoutInstant?this.options.isLayoutInstant:!this._isLayoutInited;this.layoutItems(this.items,a),this._isLayoutInited=!0},g.prototype._init=g.prototype.layout,g.prototype._resetLayout=function(){this.getSize()},g.prototype.getSize=function(){this.size=d(this.element)},g.prototype._getMeasurement=function(a,b){var c,f=this.options[a];f?("string"==typeof f?c=this.element.querySelector(f):e.isElement(f)&&(c=f),this[a]=c?d(c)[b]:f):this[a]=0},g.prototype.layoutItems=function(a,b){a=this._getItemsForLayout(a),this._layoutItems(a,b),this._postLayout()},g.prototype._getItemsForLayout=function(a){for(var b=[],c=0,d=a.length;d>c;c++){var e=a[c];e.isIgnored||b.push(e)}return b},g.prototype._layoutItems=function(a,b){if(this._emitCompleteOnItems("layout",a),a&&a.length){for(var c=[],d=0,e=a.length;e>d;d++){var f=a[d],g=this._getItemLayoutPosition(f);g.item=f,g.isInstant=b||f.isLayoutInstant,c.push(g)}this._processLayoutQueue(c)}},g.prototype._getItemLayoutPosition=function(){return{x:0,y:0}},g.prototype._processLayoutQueue=function(a){for(var b=0,c=a.length;c>b;b++){var d=a[b];this._positionItem(d.item,d.x,d.y,d.isInstant)}},g.prototype._positionItem=function(a,b,c,d){d?a.goTo(b,c):a.moveTo(b,c)},g.prototype._postLayout=function(){this.resizeContainer()},g.prototype.resizeContainer=function(){if(this.options.isResizingContainer){var a=this._getContainerSize();a&&(this._setContainerMeasure(a.width,!0),this._setContainerMeasure(a.height,!1))}},g.prototype._getContainerSize=j,g.prototype._setContainerMeasure=function(a,b){if(void 0!==a){var c=this.size;c.isBorderBox&&(a+=b?c.paddingLeft+c.paddingRight+c.borderLeftWidth+c.borderRightWidth:c.paddingBottom+c.paddingTop+c.borderTopWidth+c.borderBottomWidth),a=Math.max(a,0),this.element.style[b?"width":"height"]=a+"px"}},g.prototype._emitCompleteOnItems=function(a,b){function c(){e.dispatchEvent(a+"Complete",null,[b])}function d(){g++,g===f&&c()}var e=this,f=b.length;if(!b||!f)return void c();for(var g=0,h=0,i=b.length;i>h;h++){var j=b[h];j.once(a,d)}},g.prototype.dispatchEvent=function(a,b,c){var d=b?[b].concat(c):c;if(this.emitEvent(a,d),i)if(this.$element=this.$element||i(this.element),b){var e=i.Event(b);e.type=a,this.$element.trigger(e,c)}else this.$element.trigger(a,c)},g.prototype.ignore=function(a){var b=this.getItem(a);b&&(b.isIgnored=!0)},g.prototype.unignore=function(a){var b=this.getItem(a);b&&delete b.isIgnored},g.prototype.stamp=function(a){if(a=this._find(a)){this.stamps=this.stamps.concat(a);for(var b=0,c=a.length;c>b;b++){var d=a[b];this.ignore(d)}}},g.prototype.unstamp=function(a){if(a=this._find(a))for(var b=0,c=a.length;c>b;b++){var d=a[b];e.removeFrom(this.stamps,d),this.unignore(d)}},g.prototype._find=function(a){return a?("string"==typeof a&&(a=this.element.querySelectorAll(a)),a=e.makeArray(a)):void 0},g.prototype._manageStamps=function(){if(this.stamps&&this.stamps.length){this._getBoundingRect();for(var a=0,b=this.stamps.length;b>a;a++){var c=this.stamps[a];this._manageStamp(c)}}},g.prototype._getBoundingRect=function(){var a=this.element.getBoundingClientRect(),b=this.size;this._boundingRect={left:a.left+b.paddingLeft+b.borderLeftWidth,top:a.top+b.paddingTop+b.borderTopWidth,right:a.right-(b.paddingRight+b.borderRightWidth),bottom:a.bottom-(b.paddingBottom+b.borderBottomWidth)}},g.prototype._manageStamp=j,g.prototype._getElementOffset=function(a){var b=a.getBoundingClientRect(),c=this._boundingRect,e=d(a),f={left:b.left-c.left-e.marginLeft,top:b.top-c.top-e.marginTop,right:c.right-b.right-e.marginRight,bottom:c.bottom-b.bottom-e.marginBottom};return f},g.prototype.handleEvent=function(a){var b="on"+a.type;this[b]&&this[b](a)},g.prototype.bindResize=function(){this.isResizeBound||(b.bind(a,"resize",this),this.isResizeBound=!0)},g.prototype.unbindResize=function(){this.isResizeBound&&b.unbind(a,"resize",this),this.isResizeBound=!1},g.prototype.onresize=function(){function a(){b.resize(),delete b.resizeTimeout}this.resizeTimeout&&clearTimeout(this.resizeTimeout);var b=this;this.resizeTimeout=setTimeout(a,100)},g.prototype.resize=function(){this.isResizeBound&&this.needsResizeLayout()&&this.layout()},g.prototype.needsResizeLayout=function(){var a=d(this.element),b=this.size&&a;return b&&a.innerWidth!==this.size.innerWidth},g.prototype.addItems=function(a){var b=this._itemize(a);return b.length&&(this.items=this.items.concat(b)),b},g.prototype.appended=function(a){var b=this.addItems(a);b.length&&(this.layoutItems(b,!0),this.reveal(b))},g.prototype.prepended=function(a){var b=this._itemize(a);if(b.length){var c=this.items.slice(0);this.items=b.concat(c),this._resetLayout(),this._manageStamps(),this.layoutItems(b,!0),this.reveal(b),this.layoutItems(c)}},g.prototype.reveal=function(a){this._emitCompleteOnItems("reveal",a);for(var b=a&&a.length,c=0;b&&b>c;c++){var d=a[c];d.reveal()}},g.prototype.hide=function(a){this._emitCompleteOnItems("hide",a);for(var b=a&&a.length,c=0;b&&b>c;c++){var d=a[c];d.hide()}},g.prototype.revealItemElements=function(a){var b=this.getItems(a);this.reveal(b)},g.prototype.hideItemElements=function(a){var b=this.getItems(a);this.hide(b)},g.prototype.getItem=function(a){for(var b=0,c=this.items.length;c>b;b++){var d=this.items[b];if(d.element===a)return d}},g.prototype.getItems=function(a){a=e.makeArray(a);for(var b=[],c=0,d=a.length;d>c;c++){var f=a[c],g=this.getItem(f);g&&b.push(g)}return b},g.prototype.remove=function(a){var b=this.getItems(a);if(this._emitCompleteOnItems("remove",b),b&&b.length)for(var c=0,d=b.length;d>c;c++){var f=b[c];f.remove(),e.removeFrom(this.items,f)}},g.prototype.destroy=function(){var a=this.element.style;a.height="",a.position="",a.width="";for(var b=0,c=this.items.length;c>b;b++){var d=this.items[b];d.destroy()}this.unbindResize();var e=this.element.outlayerGUID;delete l[e],delete this.element.outlayerGUID,i&&i.removeData(this.element,this.constructor.namespace)},g.data=function(a){a=e.getQueryElement(a);var b=a&&a.outlayerGUID;return b&&l[b]},g.create=function(a,b){function c(){g.apply(this,arguments)}return Object.create?c.prototype=Object.create(g.prototype):e.extend(c.prototype,g.prototype),c.prototype.constructor=c,c.defaults=e.extend({},g.defaults),e.extend(c.defaults,b),c.prototype.settings={},c.namespace=a,c.data=g.data,c.Item=function(){f.apply(this,arguments)},c.Item.prototype=new f,e.htmlInit(c,a),i&&i.bridget&&i.bridget(a,c),c},g.Item=f,g}),function(a,b){"use strict";"function"==typeof define&&define.amd?define("isotope/js/item",["outlayer/outlayer"],b):"object"==typeof exports?module.exports=b(require("outlayer")):(a.Isotope=a.Isotope||{},a.Isotope.Item=b(a.Outlayer))}(window,function(a){"use strict";function b(){a.Item.apply(this,arguments)}b.prototype=new a.Item,b.prototype._create=function(){this.id=this.layout.itemGUID++,a.Item.prototype._create.call(this),this.sortData={}},b.prototype.updateSortData=function(){if(!this.isIgnored){this.sortData.id=this.id,this.sortData["original-order"]=this.id,this.sortData.random=Math.random();var a=this.layout.options.getSortData,b=this.layout._sorters;for(var c in a){var d=b[c];this.sortData[c]=d(this.element,this)}}};var c=b.prototype.destroy;return b.prototype.destroy=function(){c.apply(this,arguments),this.css({display:""})},b}),function(a,b){"use strict";"function"==typeof define&&define.amd?define("isotope/js/layout-mode",["get-size/get-size","outlayer/outlayer"],b):"object"==typeof exports?module.exports=b(require("get-size"),require("outlayer")):(a.Isotope=a.Isotope||{},a.Isotope.LayoutMode=b(a.getSize,a.Outlayer))}(window,function(a,b){"use strict";function c(a){this.isotope=a,a&&(this.options=a.options[this.namespace],this.element=a.element,this.items=a.filteredItems,this.size=a.size)}return function(){function a(a){return function(){return b.prototype[a].apply(this.isotope,arguments)}}for(var d=["_resetLayout","_getItemLayoutPosition","_manageStamp","_getContainerSize","_getElementOffset","needsResizeLayout"],e=0,f=d.length;f>e;e++){var g=d[e];c.prototype[g]=a(g)}}(),c.prototype.needsVerticalResizeLayout=function(){var b=a(this.isotope.element),c=this.isotope.size&&b;return c&&b.innerHeight!=this.isotope.size.innerHeight},c.prototype._getMeasurement=function(){this.isotope._getMeasurement.apply(this,arguments)},c.prototype.getColumnWidth=function(){this.getSegmentSize("column","Width")},c.prototype.getRowHeight=function(){this.getSegmentSize("row","Height")},c.prototype.getSegmentSize=function(a,b){var c=a+b,d="outer"+b;if(this._getMeasurement(c,d),!this[c]){var e=this.getFirstItemSize();this[c]=e&&e[d]||this.isotope.size["inner"+b]}},c.prototype.getFirstItemSize=function(){var b=this.isotope.filteredItems[0];return b&&b.element&&a(b.element)},c.prototype.layout=function(){this.isotope.layout.apply(this.isotope,arguments)},c.prototype.getSize=function(){this.isotope.getSize(),this.size=this.isotope.size},c.modes={},c.create=function(a,b){function d(){c.apply(this,arguments)}return d.prototype=new c,b&&(d.options=b),d.prototype.namespace=a,c.modes[a]=d,d},c}),function(a,b){"use strict";"function"==typeof define&&define.amd?define("masonry/masonry",["outlayer/outlayer","get-size/get-size","fizzy-ui-utils/utils"],b):"object"==typeof exports?module.exports=b(require("outlayer"),require("get-size"),require("fizzy-ui-utils")):a.Masonry=b(a.Outlayer,a.getSize,a.fizzyUIUtils)}(window,function(a,b,c){var d=a.create("masonry");return d.prototype._resetLayout=function(){this.getSize(),this._getMeasurement("columnWidth","outerWidth"),this._getMeasurement("gutter","outerWidth"),this.measureColumns();var a=this.cols;for(this.colYs=[];a--;)this.colYs.push(0);this.maxY=0},d.prototype.measureColumns=function(){if(this.getContainerWidth(),!this.columnWidth){var a=this.items[0],c=a&&a.element;this.columnWidth=c&&b(c).outerWidth||this.containerWidth}var d=this.columnWidth+=this.gutter,e=this.containerWidth+this.gutter,f=e/d,g=d-e%d,h=g&&1>g?"round":"floor";f=Math[h](f),this.cols=Math.max(f,1)},d.prototype.getContainerWidth=function(){var a=this.options.isFitWidth?this.element.parentNode:this.element,c=b(a);this.containerWidth=c&&c.innerWidth},d.prototype._getItemLayoutPosition=function(a){a.getSize();var b=a.size.outerWidth%this.columnWidth,d=b&&1>b?"round":"ceil",e=Math[d](a.size.outerWidth/this.columnWidth);e=Math.min(e,this.cols);for(var f=this._getColGroup(e),g=Math.min.apply(Math,f),h=c.indexOf(f,g),i={x:this.columnWidth*h,y:g},j=g+a.size.outerHeight,k=this.cols+1-f.length,l=0;k>l;l++)this.colYs[h+l]=j;return i},d.prototype._getColGroup=function(a){if(2>a)return this.colYs;for(var b=[],c=this.cols+1-a,d=0;c>d;d++){var e=this.colYs.slice(d,d+a);b[d]=Math.max.apply(Math,e)}return b},d.prototype._manageStamp=function(a){var c=b(a),d=this._getElementOffset(a),e=this.options.isOriginLeft?d.left:d.right,f=e+c.outerWidth,g=Math.floor(e/this.columnWidth);g=Math.max(0,g);var h=Math.floor(f/this.columnWidth);h-=f%this.columnWidth?0:1,h=Math.min(this.cols-1,h);for(var i=(this.options.isOriginTop?d.top:d.bottom)+c.outerHeight,j=g;h>=j;j++)this.colYs[j]=Math.max(i,this.colYs[j])},d.prototype._getContainerSize=function(){this.maxY=Math.max.apply(Math,this.colYs);var a={height:this.maxY};return this.options.isFitWidth&&(a.width=this._getContainerFitWidth()),a},d.prototype._getContainerFitWidth=function(){for(var a=0,b=this.cols;--b&&0===this.colYs[b];)a++;return(this.cols-a)*this.columnWidth-this.gutter},d.prototype.needsResizeLayout=function(){var a=this.containerWidth;return this.getContainerWidth(),a!==this.containerWidth},d}),function(a,b){"use strict";"function"==typeof define&&define.amd?define("isotope/js/layout-modes/masonry",["../layout-mode","masonry/masonry"],b):"object"==typeof exports?module.exports=b(require("../layout-mode"),require("masonry-layout")):b(a.Isotope.LayoutMode,a.Masonry)}(window,function(a,b){"use strict";function c(a,b){for(var c in b)a[c]=b[c];return a}var d=a.create("masonry"),e=d.prototype._getElementOffset,f=d.prototype.layout,g=d.prototype._getMeasurement;
c(d.prototype,b.prototype),d.prototype._getElementOffset=e,d.prototype.layout=f,d.prototype._getMeasurement=g;var h=d.prototype.measureColumns;d.prototype.measureColumns=function(){this.items=this.isotope.filteredItems,h.call(this)};var i=d.prototype._manageStamp;return d.prototype._manageStamp=function(){this.options.isOriginLeft=this.isotope.options.isOriginLeft,this.options.isOriginTop=this.isotope.options.isOriginTop,i.apply(this,arguments)},d}),function(a,b){"use strict";"function"==typeof define&&define.amd?define("isotope/js/layout-modes/fit-rows",["../layout-mode"],b):"object"==typeof exports?module.exports=b(require("../layout-mode")):b(a.Isotope.LayoutMode)}(window,function(a){"use strict";var b=a.create("fitRows");return b.prototype._resetLayout=function(){this.x=0,this.y=0,this.maxY=0,this._getMeasurement("gutter","outerWidth")},b.prototype._getItemLayoutPosition=function(a){a.getSize();var b=a.size.outerWidth+this.gutter,c=this.isotope.size.innerWidth+this.gutter;0!==this.x&&b+this.x>c&&(this.x=0,this.y=this.maxY);var d={x:this.x,y:this.y};return this.maxY=Math.max(this.maxY,this.y+a.size.outerHeight),this.x+=b,d},b.prototype._getContainerSize=function(){return{height:this.maxY}},b}),function(a,b){"use strict";"function"==typeof define&&define.amd?define("isotope/js/layout-modes/vertical",["../layout-mode"],b):"object"==typeof exports?module.exports=b(require("../layout-mode")):b(a.Isotope.LayoutMode)}(window,function(a){"use strict";var b=a.create("vertical",{horizontalAlignment:0});return b.prototype._resetLayout=function(){this.y=0},b.prototype._getItemLayoutPosition=function(a){a.getSize();var b=(this.isotope.size.innerWidth-a.size.outerWidth)*this.options.horizontalAlignment,c=this.y;return this.y+=a.size.outerHeight,{x:b,y:c}},b.prototype._getContainerSize=function(){return{height:this.y}},b}),function(a,b){"use strict";"function"==typeof define&&define.amd?define(["outlayer/outlayer","get-size/get-size","matches-selector/matches-selector","fizzy-ui-utils/utils","isotope/js/item","isotope/js/layout-mode","isotope/js/layout-modes/masonry","isotope/js/layout-modes/fit-rows","isotope/js/layout-modes/vertical"],function(c,d,e,f,g,h){return b(a,c,d,e,f,g,h)}):"object"==typeof exports?module.exports=b(a,require("outlayer"),require("get-size"),require("desandro-matches-selector"),require("fizzy-ui-utils"),require("./item"),require("./layout-mode"),require("./layout-modes/masonry"),require("./layout-modes/fit-rows"),require("./layout-modes/vertical")):a.Isotope=b(a,a.Outlayer,a.getSize,a.matchesSelector,a.fizzyUIUtils,a.Isotope.Item,a.Isotope.LayoutMode)}(window,function(a,b,c,d,e,f,g){function h(a,b){return function(c,d){for(var e=0,f=a.length;f>e;e++){var g=a[e],h=c.sortData[g],i=d.sortData[g];if(h>i||i>h){var j=void 0!==b[g]?b[g]:b,k=j?1:-1;return(h>i?1:-1)*k}}return 0}}var i=a.jQuery,j=String.prototype.trim?function(a){return a.trim()}:function(a){return a.replace(/^\s+|\s+$/g,"")},k=document.documentElement,l=k.textContent?function(a){return a.textContent}:function(a){return a.innerText},m=b.create("isotope",{layoutMode:"masonry",isJQueryFiltering:!0,sortAscending:!0});m.Item=f,m.LayoutMode=g,m.prototype._create=function(){this.itemGUID=0,this._sorters={},this._getSorters(),b.prototype._create.call(this),this.modes={},this.filteredItems=this.items,this.sortHistory=["original-order"];for(var a in g.modes)this._initLayoutMode(a)},m.prototype.reloadItems=function(){this.itemGUID=0,b.prototype.reloadItems.call(this)},m.prototype._itemize=function(){for(var a=b.prototype._itemize.apply(this,arguments),c=0,d=a.length;d>c;c++){var e=a[c];e.id=this.itemGUID++}return this._updateItemsSortData(a),a},m.prototype._initLayoutMode=function(a){var b=g.modes[a],c=this.options[a]||{};this.options[a]=b.options?e.extend(b.options,c):c,this.modes[a]=new b(this)},m.prototype.layout=function(){return!this._isLayoutInited&&this.options.isInitLayout?void this.arrange():void this._layout()},m.prototype._layout=function(){var a=this._getIsInstant();this._resetLayout(),this._manageStamps(),this.layoutItems(this.filteredItems,a),this._isLayoutInited=!0},m.prototype.arrange=function(a){function b(){d.reveal(c.needReveal),d.hide(c.needHide)}this.option(a),this._getIsInstant();var c=this._filter(this.items);this.filteredItems=c.matches;var d=this;this._bindArrangeComplete(),this._isInstant?this._noTransition(b):b(),this._sort(),this._layout()},m.prototype._init=m.prototype.arrange,m.prototype._getIsInstant=function(){var a=void 0!==this.options.isLayoutInstant?this.options.isLayoutInstant:!this._isLayoutInited;return this._isInstant=a,a},m.prototype._bindArrangeComplete=function(){function a(){b&&c&&d&&e.dispatchEvent("arrangeComplete",null,[e.filteredItems])}var b,c,d,e=this;this.once("layoutComplete",function(){b=!0,a()}),this.once("hideComplete",function(){c=!0,a()}),this.once("revealComplete",function(){d=!0,a()})},m.prototype._filter=function(a){var b=this.options.filter;b=b||"*";for(var c=[],d=[],e=[],f=this._getFilterTest(b),g=0,h=a.length;h>g;g++){var i=a[g];if(!i.isIgnored){var j=f(i);j&&c.push(i),j&&i.isHidden?d.push(i):j||i.isHidden||e.push(i)}}return{matches:c,needReveal:d,needHide:e}},m.prototype._getFilterTest=function(a){return i&&this.options.isJQueryFiltering?function(b){return i(b.element).is(a)}:"function"==typeof a?function(b){return a(b.element)}:function(b){return d(b.element,a)}},m.prototype.updateSortData=function(a){var b;a?(a=e.makeArray(a),b=this.getItems(a)):b=this.items,this._getSorters(),this._updateItemsSortData(b)},m.prototype._getSorters=function(){var a=this.options.getSortData;for(var b in a){var c=a[b];this._sorters[b]=n(c)}},m.prototype._updateItemsSortData=function(a){for(var b=a&&a.length,c=0;b&&b>c;c++){var d=a[c];d.updateSortData()}};var n=function(){function a(a){if("string"!=typeof a)return a;var c=j(a).split(" "),d=c[0],e=d.match(/^\[(.+)\]$/),f=e&&e[1],g=b(f,d),h=m.sortDataParsers[c[1]];return a=h?function(a){return a&&h(g(a))}:function(a){return a&&g(a)}}function b(a,b){var c;return c=a?function(b){return b.getAttribute(a)}:function(a){var c=a.querySelector(b);return c&&l(c)}}return a}();m.sortDataParsers={parseInt:function(a){return parseInt(a,10)},parseFloat:function(a){return parseFloat(a)}},m.prototype._sort=function(){var a=this.options.sortBy;if(a){var b=[].concat.apply(a,this.sortHistory),c=h(b,this.options.sortAscending);this.filteredItems.sort(c),a!=this.sortHistory[0]&&this.sortHistory.unshift(a)}},m.prototype._mode=function(){var a=this.options.layoutMode,b=this.modes[a];if(!b)throw new Error("No layout mode:"+a);return b.options=this.options[a],b},m.prototype._resetLayout=function(){b.prototype._resetLayout.call(this),this._mode()._resetLayout()},m.prototype._getItemLayoutPosition=function(a){return this._mode()._getItemLayoutPosition(a)},m.prototype._manageStamp=function(a){this._mode()._manageStamp(a)},m.prototype._getContainerSize=function(){return this._mode()._getContainerSize()},m.prototype.needsResizeLayout=function(){return this._mode().needsResizeLayout()},m.prototype.appended=function(a){var b=this.addItems(a);if(b.length){var c=this._filterRevealAdded(b);this.filteredItems=this.filteredItems.concat(c)}},m.prototype.prepended=function(a){var b=this._itemize(a);if(b.length){this._resetLayout(),this._manageStamps();var c=this._filterRevealAdded(b);this.layoutItems(this.filteredItems),this.filteredItems=c.concat(this.filteredItems),this.items=b.concat(this.items)}},m.prototype._filterRevealAdded=function(a){var b=this._filter(a);return this.hide(b.needHide),this.reveal(b.matches),this.layoutItems(b.matches,!0),b.matches},m.prototype.insert=function(a){var b=this.addItems(a);if(b.length){var c,d,e=b.length;for(c=0;e>c;c++)d=b[c],this.element.appendChild(d.element);var f=this._filter(b).matches;for(c=0;e>c;c++)b[c].isLayoutInstant=!0;for(this.arrange(),c=0;e>c;c++)delete b[c].isLayoutInstant;this.reveal(f)}};var o=m.prototype.remove;return m.prototype.remove=function(a){a=e.makeArray(a);var b=this.getItems(a);o.call(this,a);var c=b&&b.length;if(c)for(var d=0;c>d;d++){var f=b[d];e.removeFrom(this.filteredItems,f)}},m.prototype.shuffle=function(){for(var a=0,b=this.items.length;b>a;a++){var c=this.items[a];c.sortData.random=Math.random()}this.options.sortBy="random",this._sort(),this._layout()},m.prototype._noTransition=function(a){var b=this.options.transitionDuration;this.options.transitionDuration=0;var c=a.call(this);return this.options.transitionDuration=b,c},m.prototype.getFilteredItemElements=function(){for(var a=[],b=0,c=this.filteredItems.length;c>b;b++)a.push(this.filteredItems[b].element);return a},m});
/*filterable.min.js*/

$.components.register("filterable",{mode:"init",defaults:{animationOptions:{duration:750,easing:"linear",queue:!1}},init:function(context){if("undefined"!=typeof $.fn.isotope){var defaults=$.components.getDefaults("filterable"),callback=function(){$("[data-filterable]",context).each(function(){var $this=$(this),options=$.extend(!0,{},defaults,$this.data(),{filter:"*"});$this.isotope(options)}),$("[data-filter]",context).click(function(e){var $this=$(this),target=$this.data("target"),$li=$this.parent("li");target||(target=$this.attr("href"),target=target&&target.replace(/.*(?=#[^\s]*$)/,"")),$li.siblings(".active").each(function(){$(this).find("a").attr("aria-expanded",!1),$(this).removeClass("active")}),$li.addClass("active"),$this.attr("aria-expanded",!0);var $list=$(target,context),filter=$this.attr("data-filter");"*"!==filter&&(filter='[data-type="'+filter+'"]'),$list.isotope({filter:filter}),e.preventDefault()})};context!==document?callback():$(window).on("load",function(){callback()})}}});

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
        var isMobile = $('html').hasClass('isMobile') ? true: false;

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