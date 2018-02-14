/**
 * 
 */

window.MODULE_FAVORITE=(function(metmod){
/*StackBlur.js*/
/*
StackBlur - a fast almost Gaussian Blur For Canvas
Version: 	0.5
Author:		Mario Klingemann
Contact: 	mario@quasimondo.com
Website:	http://www.quasimondo.com/StackBlurForCanvas
Twitter:	@quasimondo
In case you find this class useful - especially in commercial projects -
I am not totally unhappy for a small donation to my PayPal account
mario@quasimondo.de
Or support me on flattr:
https://flattr.com/thing/72791/StackBlur-a-fast-almost-Gaussian-Blur-Effect-for-CanvasJavascript
Copyright (c) 2010 Mario Klingemann
Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:
The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
*/
(function($,window,document,undefined){var mul_table=[512,512,456,512,328,456,335,512,405,328,271,456,388,335,292,512,454,405,364,328,298,271,496,456,420,388,360,335,312,292,273,512,482,454,428,405,383,364,345,328,312,298,284,271,259,496,475,456,437,420,404,388,374,360,347,335,323,312,302,292,282,273,265,512,497,482,468,454,441,428,417,405,394,383,373,364,354,345,337,328,320,312,305,298,291,284,278,271,265,259,507,496,485,475,465,456,446,437,428,420,412,404,396,388,381,374,367,360,354,347,341,335,329,323,318,312,307,302,297,292,287,282,278,273,269,265,261,512,505,497,489,482,475,468,461,454,447,441,435,428,422,417,411,405,399,394,389,383,378,373,368,364,359,354,350,345,341,337,332,328,324,320,316,312,309,305,301,298,294,291,287,284,281,278,274,271,268,265,262,259,257,507,501,496,491,485,480,475,470,465,460,456,451,446,442,437,433,428,424,420,416,412,408,404,400,396,392,388,385,381,377,374,370,367,363,360,357,354,350,347,344,341,338,335,332,329,326,323,320,318,315,312,310,307,304,302,299,297,294,292,289,287,285,282,280,278,275,273,271,269,267,265,263,261,259];var shg_table=[9,11,12,13,13,14,14,15,15,15,15,16,16,16,16,17,17,17,17,17,17,17,18,18,18,18,18,18,18,18,18,19,19,19,19,19,19,19,19,19,19,19,19,19,19,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24];$.stackBlurImage=function(imageID,canvasID,radius,blurAlphaChannel){var img=new Image();img.src=imageID.attr('src');var canvas=document.getElementById(canvasID);img.onload=function(){var w=imageID.width(),h=imageID.height();canvas.style.width=w+"px";canvas.style.height=h+"px";canvas.width=w;canvas.height=h;var context=canvas.getContext("2d");context.clearRect(0,0,w,h);context.drawImage(img,0,0,w,h);if(isNaN(radius)||radius<1)return;if(blurAlphaChannel)
stackBlurCanvasRGBA(canvasID,0,0,w,h,radius);else
stackBlurCanvasRGB(canvasID,0,0,w,h,radius);}}
function stackBlurCanvasRGBA(id,top_x,top_y,width,height,radius){if(isNaN(radius)||radius<1)return;radius|=0;var canvas=document.getElementById(id);var context=canvas.getContext("2d");var imageData;try{try{imageData=context.getImageData(top_x,top_y,width,height);}catch(e){
try{netscape.security.PrivilegeManager.enablePrivilege("UniversalBrowserRead");imageData=context.getImageData(top_x,top_y,width,height);}catch(e){return;}}}catch(e){}
var pixels=imageData.data;var x,y,i,p,yp,yi,yw,r_sum,g_sum,b_sum,a_sum,r_out_sum,g_out_sum,b_out_sum,a_out_sum,r_in_sum,g_in_sum,b_in_sum,a_in_sum,pr,pg,pb,pa,rbs;var div=radius+radius+1;var w4=width<<2;var widthMinus1=width-1;var heightMinus1=height-1;var radiusPlus1=radius+1;var sumFactor=radiusPlus1*(radiusPlus1+1)/2;var stackStart=new BlurStack();var stack=stackStart;for(i=1;i<div;i++){stack=stack.next=new BlurStack();if(i==radiusPlus1)var stackEnd=stack;}
	stack.next=stackStart;var stackIn=null;var stackOut=null;yw=yi=0;var mul_sum=mul_table[radius];var shg_sum=shg_table[radius];for(y=0;y<height;y++){r_in_sum=g_in_sum=b_in_sum=a_in_sum=r_sum=g_sum=b_sum=a_sum=0;r_out_sum=radiusPlus1*(pr=pixels[yi]);g_out_sum=radiusPlus1*(pg=pixels[yi+1]);b_out_sum=radiusPlus1*(pb=pixels[yi+2]);a_out_sum=radiusPlus1*(pa=pixels[yi+3]);r_sum+=sumFactor*pr;g_sum+=sumFactor*pg;b_sum+=sumFactor*pb;a_sum+=sumFactor*pa;stack=stackStart;for(i=0;i<radiusPlus1;i++){stack.r=pr;stack.g=pg;stack.b=pb;stack.a=pa;stack=stack.next;}
	for(i=1;i<radiusPlus1;i++){p=yi+((widthMinus1<i?widthMinus1:i)<<2);r_sum+=(stack.r=(pr=pixels[p]))*(rbs=radiusPlus1-i);g_sum+=(stack.g=(pg=pixels[p+1]))*rbs;b_sum+=(stack.b=(pb=pixels[p+2]))*rbs;a_sum+=(stack.a=(pa=pixels[p+3]))*rbs;r_in_sum+=pr;g_in_sum+=pg;b_in_sum+=pb;a_in_sum+=pa;stack=stack.next;}
	stackIn=stackStart;stackOut=stackEnd;for(x=0;x<width;x++){pixels[yi+3]=pa=(a_sum*mul_sum)>>shg_sum;if(pa!=0){pa=255/pa;pixels[yi]=((r_sum*mul_sum)>>shg_sum)*pa;pixels[yi+1]=((g_sum*mul_sum)>>shg_sum)*pa;pixels[yi+2]=((b_sum*mul_sum)>>shg_sum)*pa;}else{pixels[yi]=pixels[yi+1]=pixels[yi+2]=0;}
	r_sum-=r_out_sum;g_sum-=g_out_sum;b_sum-=b_out_sum;a_sum-=a_out_sum;r_out_sum-=stackIn.r;g_out_sum-=stackIn.g;b_out_sum-=stackIn.b;a_out_sum-=stackIn.a;p=(yw+((p=x+radius+1)<widthMinus1?p:widthMinus1))<<2;r_in_sum+=(stackIn.r=pixels[p]);g_in_sum+=(stackIn.g=pixels[p+1]);b_in_sum+=(stackIn.b=pixels[p+2]);a_in_sum+=(stackIn.a=pixels[p+3]);r_sum+=r_in_sum;g_sum+=g_in_sum;b_sum+=b_in_sum;a_sum+=a_in_sum;stackIn=stackIn.next;r_out_sum+=(pr=stackOut.r);g_out_sum+=(pg=stackOut.g);b_out_sum+=(pb=stackOut.b);a_out_sum+=(pa=stackOut.a);r_in_sum-=pr;g_in_sum-=pg;b_in_sum-=pb;a_in_sum-=pa;stackOut=stackOut.next;yi+=4;}
	yw+=width;}
	for(x=0;x<width;x++){g_in_sum=b_in_sum=a_in_sum=r_in_sum=g_sum=b_sum=a_sum=r_sum=0;yi=x<<2;r_out_sum=radiusPlus1*(pr=pixels[yi]);g_out_sum=radiusPlus1*(pg=pixels[yi+1]);b_out_sum=radiusPlus1*(pb=pixels[yi+2]);a_out_sum=radiusPlus1*(pa=pixels[yi+3]);r_sum+=sumFactor*pr;g_sum+=sumFactor*pg;b_sum+=sumFactor*pb;a_sum+=sumFactor*pa;stack=stackStart;for(i=0;i<radiusPlus1;i++){stack.r=pr;stack.g=pg;stack.b=pb;stack.a=pa;stack=stack.next;}
	yp=width;for(i=1;i<=radius;i++){yi=(yp+x)<<2;r_sum+=(stack.r=(pr=pixels[yi]))*(rbs=radiusPlus1-i);g_sum+=(stack.g=(pg=pixels[yi+1]))*rbs;b_sum+=(stack.b=(pb=pixels[yi+2]))*rbs;a_sum+=(stack.a=(pa=pixels[yi+3]))*rbs;r_in_sum+=pr;g_in_sum+=pg;b_in_sum+=pb;a_in_sum+=pa;stack=stack.next;if(i<heightMinus1){yp+=width;}}
	yi=x;stackIn=stackStart;stackOut=stackEnd;for(y=0;y<height;y++){p=yi<<2;pixels[p+3]=pa=(a_sum*mul_sum)>>shg_sum;if(pa>0){pa=255/pa;pixels[p]=((r_sum*mul_sum)>>shg_sum)*pa;pixels[p+1]=((g_sum*mul_sum)>>shg_sum)*pa;pixels[p+2]=((b_sum*mul_sum)>>shg_sum)*pa;}else{pixels[p]=pixels[p+1]=pixels[p+2]=0;}
	r_sum-=r_out_sum;g_sum-=g_out_sum;b_sum-=b_out_sum;a_sum-=a_out_sum;r_out_sum-=stackIn.r;g_out_sum-=stackIn.g;b_out_sum-=stackIn.b;a_out_sum-=stackIn.a;p=(x+(((p=y+radiusPlus1)<heightMinus1?p:heightMinus1)*width))<<2;r_sum+=(r_in_sum+=(stackIn.r=pixels[p]));g_sum+=(g_in_sum+=(stackIn.g=pixels[p+1]));b_sum+=(b_in_sum+=(stackIn.b=pixels[p+2]));a_sum+=(a_in_sum+=(stackIn.a=pixels[p+3]));stackIn=stackIn.next;r_out_sum+=(pr=stackOut.r);g_out_sum+=(pg=stackOut.g);b_out_sum+=(pb=stackOut.b);a_out_sum+=(pa=stackOut.a);r_in_sum-=pr;g_in_sum-=pg;b_in_sum-=pb;a_in_sum-=pa;stackOut=stackOut.next;yi+=width;}}
	context.putImageData(imageData,top_x,top_y);}
	function stackBlurCanvasRGB(id,top_x,top_y,width,height,radius){if(isNaN(radius)||radius<1)return;radius|=0;var canvas=document.getElementById(id);var context=canvas.getContext("2d");var imageData;try{try{imageData=context.getImageData(top_x,top_y,width,height);}catch(e){
	try{netscape.security.PrivilegeManager.enablePrivilege("UniversalBrowserRead");imageData=context.getImageData(top_x,top_y,width,height);}catch(e){return;}}}catch(e){}
	var pixels=imageData.data;var x,y,i,p,yp,yi,yw,r_sum,g_sum,b_sum,r_out_sum,g_out_sum,b_out_sum,r_in_sum,g_in_sum,b_in_sum,pr,pg,pb,rbs;var div=radius+radius+1;var w4=width<<2;var widthMinus1=width-1;var heightMinus1=height-1;var radiusPlus1=radius+1;var sumFactor=radiusPlus1*(radiusPlus1+1)/2;var stackStart=new BlurStack();var stack=stackStart;for(i=1;i<div;i++){stack=stack.next=new BlurStack();if(i==radiusPlus1)var stackEnd=stack;}
		stack.next=stackStart;var stackIn=null;var stackOut=null;yw=yi=0;var mul_sum=mul_table[radius];var shg_sum=shg_table[radius];for(y=0;y<height;y++){r_in_sum=g_in_sum=b_in_sum=r_sum=g_sum=b_sum=0;r_out_sum=radiusPlus1*(pr=pixels[yi]);g_out_sum=radiusPlus1*(pg=pixels[yi+1]);b_out_sum=radiusPlus1*(pb=pixels[yi+2]);r_sum+=sumFactor*pr;g_sum+=sumFactor*pg;b_sum+=sumFactor*pb;stack=stackStart;for(i=0;i<radiusPlus1;i++){stack.r=pr;stack.g=pg;stack.b=pb;stack=stack.next;}
		for(i=1;i<radiusPlus1;i++){p=yi+((widthMinus1<i?widthMinus1:i)<<2);r_sum+=(stack.r=(pr=pixels[p]))*(rbs=radiusPlus1-i);g_sum+=(stack.g=(pg=pixels[p+1]))*rbs;b_sum+=(stack.b=(pb=pixels[p+2]))*rbs;r_in_sum+=pr;g_in_sum+=pg;b_in_sum+=pb;stack=stack.next;}
		stackIn=stackStart;stackOut=stackEnd;for(x=0;x<width;x++){pixels[yi]=(r_sum*mul_sum)>>shg_sum;pixels[yi+1]=(g_sum*mul_sum)>>shg_sum;pixels[yi+2]=(b_sum*mul_sum)>>shg_sum;r_sum-=r_out_sum;g_sum-=g_out_sum;b_sum-=b_out_sum;r_out_sum-=stackIn.r;g_out_sum-=stackIn.g;b_out_sum-=stackIn.b;p=(yw+((p=x+radius+1)<widthMinus1?p:widthMinus1))<<2;r_in_sum+=(stackIn.r=pixels[p]);g_in_sum+=(stackIn.g=pixels[p+1]);b_in_sum+=(stackIn.b=pixels[p+2]);r_sum+=r_in_sum;g_sum+=g_in_sum;b_sum+=b_in_sum;stackIn=stackIn.next;r_out_sum+=(pr=stackOut.r);g_out_sum+=(pg=stackOut.g);b_out_sum+=(pb=stackOut.b);r_in_sum-=pr;g_in_sum-=pg;b_in_sum-=pb;stackOut=stackOut.next;yi+=4;}
		yw+=width;}
		for(x=0;x<width;x++){g_in_sum=b_in_sum=r_in_sum=g_sum=b_sum=r_sum=0;yi=x<<2;r_out_sum=radiusPlus1*(pr=pixels[yi]);g_out_sum=radiusPlus1*(pg=pixels[yi+1]);b_out_sum=radiusPlus1*(pb=pixels[yi+2]);r_sum+=sumFactor*pr;g_sum+=sumFactor*pg;b_sum+=sumFactor*pb;stack=stackStart;for(i=0;i<radiusPlus1;i++){stack.r=pr;stack.g=pg;stack.b=pb;stack=stack.next;}
		yp=width;for(i=1;i<=radius;i++){yi=(yp+x)<<2;r_sum+=(stack.r=(pr=pixels[yi]))*(rbs=radiusPlus1-i);g_sum+=(stack.g=(pg=pixels[yi+1]))*rbs;b_sum+=(stack.b=(pb=pixels[yi+2]))*rbs;r_in_sum+=pr;g_in_sum+=pg;b_in_sum+=pb;stack=stack.next;if(i<heightMinus1){yp+=width;}}
		yi=x;stackIn=stackStart;stackOut=stackEnd;for(y=0;y<height;y++){p=yi<<2;pixels[p]=(r_sum*mul_sum)>>shg_sum;pixels[p+1]=(g_sum*mul_sum)>>shg_sum;pixels[p+2]=(b_sum*mul_sum)>>shg_sum;r_sum-=r_out_sum;g_sum-=g_out_sum;b_sum-=b_out_sum;r_out_sum-=stackIn.r;g_out_sum-=stackIn.g;b_out_sum-=stackIn.b;p=(x+(((p=y+radiusPlus1)<heightMinus1?p:heightMinus1)*width))<<2;r_sum+=(r_in_sum+=(stackIn.r=pixels[p]));g_sum+=(g_in_sum+=(stackIn.g=pixels[p+1]));b_sum+=(b_in_sum+=(stackIn.b=pixels[p+2]));stackIn=stackIn.next;r_out_sum+=(pr=stackOut.r);g_out_sum+=(pg=stackOut.g);b_out_sum+=(pb=stackOut.b);r_in_sum-=pr;g_in_sum-=pg;b_in_sum-=pb;stackOut=stackOut.next;yi+=width;}}
		context.putImageData(imageData,top_x,top_y);}
		function BlurStack(){this.r=0;this.g=0;this.b=0;this.a=0;this.next=null;}})(jQuery,window,document);
/*jquery.lazyload.min.js*/
/*!
 * Lazy Load - jQuery plugin for lazy loading images
 *
 * Copyright (c) 2007-2015 Mika Tuupola
 *
 * Licensed under the MIT license:
 *   http://www.opensource.org/licenses/mit-license.php
 *
 * Project home:
 *   http://www.appelsiini.net/projects/lazyload
 *
 * Version:  1.9.7
 *
 */
(function($, window, document, undefined) {
    var $window = $(window),
        canvasPosition=function(from_dom,to_dom){ // canvas设置
            var top=from_dom.position().top,
                left=from_dom.position().left,
                width=from_dom.width(),
                height=from_dom.height();
            to_dom.css({top:top,left:left}).width(width).height(height);
        },
        canvasControl=function(dom,canvas_id){
            $.stackBlurImage(dom, canvas_id, 10, false);
            if(dom.is(':visible')) canvasPosition(dom,$('#'+canvas_id));
            $(window).resize(function() {
                if(dom.is(":visible")) canvasPosition(dom,$('#'+canvas_id));
            });
            $('#'+canvas_id).attr({'data-load':true});
        },
        thumbdir=M['navurl']+'include/thumb.php?dir=';
    $.fn.lazyload = function(options) {
        var elements = this;
        var $container;
        var settings = {
            threshold       : 30,
            failure_limit   : 20,
            event           : "scroll",
            effect          : "fadeIn",
            effect_speed    : null,
            container       : window,
            data_attribute  : "original",
            data_srcset     : 'srcset',
            skip_invisible  : true,
            appear          : null,
            load            : null,
            placeholder     : 'blur',// 'base64',met_lazyloadbg,'blur'
        };

        function update() {
            var counter = 0;

            elements.each(function() {
                var $this = $(this),
                    $this_canvas=$this.next('canvas');
                if (settings.skip_invisible && !$this.is(":visible")) {
                    return;
                }
                if($this_canvas.length && !$this_canvas.attr('data-load') && $.stackBlurImage) canvasControl($this,$this_canvas.attr('id'));
                if ($.abovethetop(this, settings) ||
                    $.leftofbegin(this, settings)) {
                        /* Nothing. */
                } else if (!$.belowthefold(this, settings) &&
                    !$.rightoffold(this, settings)) {
                        $this.trigger("appear");
                        /* if we found an image we'll load, reset the counter */
                        counter = 0;
                } else {
                    if (++counter > settings.failure_limit) {
                        return false;
                    }
                }
            });

        }

        if(options) {
            /* Maintain BC for a couple of versions. */
            if (undefined !== options.failurelimit) {
                options.failure_limit = options.failurelimit;
                delete options.failurelimit;
            }
            if (undefined !== options.effectspeed) {
                options.effect_speed = options.effectspeed;
                delete options.effectspeed;
            }

            $.extend(settings, options);
        }

        /* Cache container as jQuery as object. */
        $container = (settings.container === undefined ||
                      settings.container === window) ? $window : $(settings.container);

        /* Fire one scroll event per scroll. Not one scroll event per image. */
        if (0 === settings.event.indexOf("scroll")) {
            $container.on(settings.event, function() {
                return update();
            });
        }
        if(settings.placeholder=='base64') settings.placeholder=met_lazyloadbg_base64;

        this.each(function(index) {
            var self = this,
                $self = $(self),
                original = $self.attr("data-" + settings.data_attribute),
                placeholder=settings.placeholder,
                placeholder_ok=placeholder!=met_lazyloadbg_base64?true:false;
            self.loaded = false;

            /* If no src attribute given use data:uri. */
            if ($self.is("img") && original && (!$self.attr("src") || $self.attr("src")!=original)) {
                if(placeholder=='blur' && $.stackBlurImage){
                    // 图片高斯模糊加载小图
                    if(!$self.attr('data-minimg')){
                        // 设置小图路径
                        var thumb=original.replace(M['weburl'],M['navurl']),
                            original_array=thumb.split('&');
                        if(thumb.indexOf('http')<0 || (thumb.indexOf('http')>=0 && thumb.indexOf(M['weburl'])>=0)){
                            if(original.indexOf('include/thumb.php?dir=')>-1){
                                var data_minimg=original_array[0]+'&x=50';
                            }else{
                                var data_minimg=thumbdir+thumb+'&x=50';
                            }
                            if(original_array && original_array.length==3){
                                scale_x=original_array[1].substring(2);
                                scale_y=original_array[2].substring(2);
                                scale=scale_y/scale_x;
                                minimg_h=Math.round(50*scale);
                                data_minimg+='&y='+minimg_h;
                            }
                            $(this).attr({src:data_minimg,'data-minimg':true});
                            // 高斯模糊小图
                            var img=new Image();
                            img.src=$self.attr("src");
                            img.onload=function(){
                                var $self_canvas=$self.next('canvas');
                                if($self.attr('src')!=original && !$self_canvas.length){
                                    var canvas_id="imgcanvas"+index;
                                    $self.wrapAll('<section style="position: relative;"></section>').after('<canvas id="'+canvas_id+'" data-load width="'+$self.width()+'" height="'+$self.height()+'" style="position:absolute;z-index:10;"></canvas>');
                                    if(!settings.skip_invisible || $self.is(":visible")) canvasControl($self,canvas_id);
                                }else if($self_canvas.length){
                                    canvasPosition($self,$self_canvas);
                                }
                            }
                        }
                    }
                }else{
                    if(placeholder=='blur') placeholder=met_lazyloadbg;
                    $self.attr("src", placeholder);
                    if(placeholder_ok && !$self.hasClass('imgloading')) $self.addClass('imgloading');
                }
            }

            /* When appear is triggered load original image. */
            $self.one("appear", function() {
                if (!this.loaded) {
                    if (settings.appear) {
                        var elements_left = elements.length;
                        settings.appear.call(self, elements_left, settings);
                    }
                    var srcset = $self.attr("data-" + settings.data_srcset);
                    $("<img />")
                        .one("load", function() {
                        $self.hide();
                        if ($self.is("img")/* || $self.is("source") || $self.is("video") || $self.is("audio") || $self.is("iframe") || $self.is("script") || $self.is("link")*/) {
                            if(srcset) $self.attr("srcset", srcset);
                            $self.attr("src", original);
                        } else {
                            $self.css("background-image", "url('" + original + "')");
                            if(srcset) $self.css("background-image", "-webkit-image-set(" + srcset + ")");
                        }
                        $self[settings.effect](settings.effect_speed);
                        $self.one('load', function() {
                            $self.removeClass('imgloading');
                            $self.next('canvas').fadeOut("normal",function(){
                                $self.next('canvas').remove();
                            });
                        });

                        self.loaded = true;

                        /* Remove image from array so it is not looped next time. */
                        var temp = $.grep(elements, function(element) {
                            return !element.loaded;
                        });
                        elements = $(temp);

                        if (settings.load) {
                            var elements_left = elements.length;
                            settings.load.call(self, elements_left, settings);
                        }
                    }).attr({srcset:srcset,src:original}).removeClass('imgloading').next('canvas').fadeOut("normal",function(){
                        $("<img />").next('canvas').remove();
                    });
                }
            });

            /* When wanted event is triggered load original image */
            /* by triggering appear.                              */
            if (0 !== settings.event.indexOf("scroll")) {
                $self.on(settings.event, function() {
                    if (!self.loaded) {
                        $self.trigger("appear");
                    }
                });
            }
        });

        /* Check if something appears when window is resized. */
        $window.on("resize", function() {
            update();
        });

        /* With IOS5 force loading images when navigating with back button. */
        /* Non optimal workaround. */
        if ((/(?:iphone|ipod|ipad).*os 5/gi).test(navigator.appVersion)) {
            $window.on("pageshow", function(event) {
                if (event.originalEvent && event.originalEvent.persisted) {
                    elements.each(function() {
                        $(this).trigger("appear");
                    });
                }
            });
        }

        /* Force initial check if images should appear. */
        $(document).ready(function() {
            update();
        });

        return this;
    };

    /* Convenience methods in jQuery namespace.           */
    /* Use as  $.belowthefold(element, {threshold : 100, container : window}) */

    $.belowthefold = function(element, settings) {
        var fold;

        if (settings.container === undefined || settings.container === window) {
            fold = (window.innerHeight ? window.innerHeight : $window.height()) + $window.scrollTop();
        } else {
            fold = $(settings.container).offset().top + $(settings.container).height();
        }

        return fold <= $(element).offset().top - settings.threshold;
    };

    $.rightoffold = function(element, settings) {
        var fold;

        if (settings.container === undefined || settings.container === window) {
            fold = $window.width() + $window.scrollLeft();
        } else {
            fold = $(settings.container).offset().left + $(settings.container).width();
        }

        return fold <= $(element).offset().left - settings.threshold;
    };

    $.abovethetop = function(element, settings) {
        var fold;

        if (settings.container === undefined || settings.container === window) {
            fold = $window.scrollTop();
        } else {
            fold = $(settings.container).offset().top;
        }

        return fold >= $(element).offset().top + settings.threshold  + $(element).height();
    };

    $.leftofbegin = function(element, settings) {
        var fold;

        if (settings.container === undefined || settings.container === window) {
            fold = $window.scrollLeft();
        } else {
            fold = $(settings.container).offset().left;
        }

        return fold >= $(element).offset().left + settings.threshold + $(element).width();
    };

    $.inviewport = function(element, settings) {
         return !$.rightoffold(element, settings) && !$.leftofbegin(element, settings) &&
                !$.belowthefold(element, settings) && !$.abovethetop(element, settings);
     };

    /* Custom selectors for your convenience.   */
    /* Use as $("img:below-the-fold").something() or */
    /* $("img").filter(":below-the-fold").something() which is faster */

    $.extend($.expr[":"], {
        "below-the-fold" : function(a) { return $.belowthefold(a, {threshold : 0}); },
        "above-the-top"  : function(a) { return !$.belowthefold(a, {threshold : 0}); },
        "right-of-screen": function(a) { return $.rightoffold(a, {threshold : 0}); },
        "left-of-screen" : function(a) { return !$.rightoffold(a, {threshold : 0}); },
        "in-viewport"    : function(a) { return $.inviewport(a, {threshold : 0}); },
        /* Maintain BC for couple of versions. */
        "above-the-fold" : function(a) { return !$.belowthefold(a, {threshold : 0}); },
        "right-of-fold"  : function(a) { return $.rightoffold(a, {threshold : 0}); },
        "left-of-fold"   : function(a) { return !$.rightoffold(a, {threshold : 0}); }
    });

})(jQuery, window, document);

/*form.js*/
$(function(){
    // 验证码输入自动转为大写
    $(document).on('change keyup','.input-codeimg',function(){
        $(this).val($(this).val().toUpperCase());
    });
    // 上传文件
    $(document).on("change keyup",".input-group-file input[type=file]",function(){
        var $self=$(this),
            $text=$(this).parents('.input-group-file').find('.form-control'),
            value="";
        if(is_lteie9) value=$(this).val();
        if(!value){
            $.each($self[0].files,function(i,file){
                if(i>0 ) value +=',';
                value +=file.name;
            });
        }
        $text.val(value);
    });
    // 验证码点击刷新
    $(document).on('click',".met-form-codeimg",function(){
        $(this).attr({src:$(this).data("src")+'&random='+Math.floor(Math.random()*9999+1)});
    });
});
// 表单验证通用
$.fn.validation=function(){
    var $self=$(this),
        self_validation=$(this).formValidation({
        locale:validation_locale,
        framework:'bootstrap4'
    });
    // 表单所处弹窗隐藏时重置验证
    $(this).parents('.modal').on('hide.bs.modal',function() {
        $self.data('formValidation').resetForm();
    });
    function success(func,afterajax_ok){
        self_validation.on('success.form.fv', function(e) {
            e.preventDefault();
            var ajax_ok=typeof afterajax_ok != "undefined" ?afterajax_ok:true;
            if(ajax_ok){
                formDataAjax(e,func);
            }else{
                $self.data('formValidation').resetForm();
                if (typeof func==="function") return func(e,$self);
            }
        })
    }
    function formDataAjax(e,func){
        var $form    = $(e.target);
        if(is_lteie9){
            $.ajax({
                url: $form.attr('action'),
                data: $form.serializeArray(),
                cache: false,
                type: 'POST',
                dataType:'json',
                success: function(result) {
                    $form.data('formValidation').resetForm();
                    if (typeof func==="function") return func(result,$form);
                }
            });
        }else{
            var formData = new FormData(),
                params   = $form.serializeArray();
            $.each(params, function(i, val) {
                formData.append(val.name, val.value);
            });
            $.ajax({
                url: $form.attr('action'),
                data: formData,
                cache: false,
                contentType: false,
                processData: false,
                type: 'POST',
                dataType:'json',
                success: function(result) {
                    $form.data('formValidation').resetForm();
                    if (typeof func==="function") return func(result,$form);
                }
            });
        }
    }
    return {self_validation:self_validation,success:success,formDataAjax:formDataAjax};
}
// formValidation多语言选择
window.validation_locale='';
if("undefined" != typeof M && M['lang_pack'] && M['plugin_lang']){
    validation_locale=M['lang_pack']+'_';
    switch(M['lang_pack']){
        case 'sq':validation_locale+='AL';break;
        case 'ar':validation_locale+='MA';break;
        // case 'az':validation_locale+='az';break;
        // case 'ga':validation_locale+='ie';break;
        // case 'et':validation_locale+='ee';break;
        case 'be':validation_locale+='BE';break;
        case 'bg':validation_locale+='BG';break;
        case 'pl':validation_locale+='PL';break;
        case 'fa':validation_locale+='IR';break;
        // case 'af':validation_locale+='za';break;
        case 'da':validation_locale+='DK';break;
        case 'de':validation_locale+='DE';break;
        case 'ru':validation_locale+='RU';break;
        case 'fr':validation_locale+='FR';break;
        // case 'tl':validation_locale+='ph';break;
        case 'fi':validation_locale+='FI';break;
        // case 'ht':validation_locale+='ht';break;
        // case 'ko':validation_locale+='kr';break;
        case 'nl':validation_locale+='NL';break;
        // case 'gl':validation_locale+='es';break;
        case 'ca':validation_locale+='ES';break;
        case 'cs':validation_locale+='CZ';break;
        // case 'hr':validation_locale+='hr';break;
        // case 'la':validation_locale+='IT';break;
        // case 'lv':validation_locale+='lv';break;
        // case 'lt':validation_locale+='lt';break;
        case 'ro':validation_locale+='RO';break;
        // case 'mt':validation_locale+='mt';break;
        // case 'ms':validation_locale+='ID';break;
        // case 'mk':validation_locale+='mk';break;
        case 'no':validation_locale+='NO';break;
        case 'pt':validation_locale+='PT';break;
        case 'ja':validation_locale+='JP';break;
        case 'sv':validation_locale+='SE';break;
        case 'sr':validation_locale+='RS';break;
        case 'sk':validation_locale+='SK';break;
        // case 'sl':validation_locale+='si';break;
        // case 'sw':validation_locale+='tz';break;
        case 'th':validation_locale+='TH';break;
        // case 'cy':validation_locale+='wls';break;
        // case 'uk':validation_locale+='ua';break;
        // case 'iw':validation_locale+='';break;
        case 'el':validation_locale+='GR';break;
        case 'eu':validation_locale+='ES';break;
        case 'es':validation_locale+='ES';break;
        case 'hu':validation_locale+='HU';break;
        case 'it':validation_locale+='IT';break;
        // case 'yi':validation_locale+='de';break;
        // case 'ur':validation_locale+='pk';break;
        case 'id':validation_locale+='ID';break;
        case 'en':validation_locale+='US';break;
        case 'vi':validation_locale+='VN';break;
        case 'tc':validation_locale='zh_TW';break;
        case 'cn':validation_locale='zh_CN';break;
    }
}else{
    validation_locale='zh_CN';
}
// 表单验证初始化
if($(".met-form-validation").length) {
    window.validate=new Array();
    $(".met-form-validation").each(function(index, el) {
        validate[index]=$(el).validation();
    });
}
/*datatable.js*/
$(function(){
    var $datatable=$('[data-table-ajaxurl]');
    if($datatable.length){
        var datatable_langurl= M['navurl']+'app/system/include/static2/vendor/datatables/language/';
        // datatable多语言选择
        if("undefined" != typeof M && M['lang_pack'] && M['plugin_lang']){
            switch(M['lang_pack']){
                case 'sq':datatable_langurl+='AL';break;
                case 'ar':datatable_langurl+='MA';break;
                // case 'az':datatable_langurl+='az';break;
                // case 'ga':datatable_langurl+='ie';break;
                // case 'et':datatable_langurl+='ee';break;
                case 'be':datatable_langurl+='BE';break;
                case 'bg':datatable_langurl+='BG';break;
                case 'pl':datatable_langurl+='PL';break;
                case 'fa':datatable_langurl+='IR';break;
                // case 'af':datatable_langurl+='za';break;
                case 'da':datatable_langurl+='DK';break;
                case 'de':datatable_langurl+='DE';break;
                case 'ru':datatable_langurl+='RU';break;
                case 'fr':datatable_langurl+='FR';break;
                // case 'tl':datatable_langurl+='ph';break;
                case 'fi':datatable_langurl+='FI';break;
                // case 'ht':datatable_langurl+='ht';break;
                // case 'ko':datatable_langurl+='kr';break;
                case 'nl':datatable_langurl+='NL';break;
                // case 'gl':datatable_langurl+='es';break;
                case 'ca':datatable_langurl+='ES';break;
                case 'cs':datatable_langurl+='CZ';break;
                // case 'hr':datatable_langurl+='hr';break;
                // case 'la':datatable_langurl+='IT';break;
                // case 'lv':datatable_langurl+='lv';break;
                // case 'lt':datatable_langurl+='lt';break;
                case 'ro':datatable_langurl+='RO';break;
                // case 'mt':datatable_langurl+='mt';break;
                // case 'ms':datatable_langurl+='ID';break;
                // case 'mk':datatable_langurl+='mk';break;
                case 'no':datatable_langurl+='NO';break;
                case 'pt':datatable_langurl+='PT';break;
                case 'ja':datatable_langurl+='JP';break;
                case 'sv':datatable_langurl+='SE';break;
                case 'sr':datatable_langurl+='RS';break;
                case 'sk':datatable_langurl+='SK';break;
                // case 'sl':datatable_langurl+='si';break;
                // case 'sw':datatable_langurl+='tz';break;
                case 'th':datatable_langurl+='TH';break;
                // case 'cy':datatable_langurl+='wls';break;
                // case 'uk':datatable_langurl+='ua';break;
                // case 'iw':datatable_langurl+='';break;
                case 'el':datatable_langurl+='GR';break;
                case 'eu':datatable_langurl+='ES';break;
                case 'es':datatable_langurl+='ES';break;
                case 'hu':datatable_langurl+='HU';break;
                case 'it':datatable_langurl+='IT';break;
                // case 'yi':datatable_langurl+='de';break;
                // case 'ur':datatable_langurl+='pk';break;
                case 'id':datatable_langurl+='ID';break;
                case 'en':datatable_langurl+='English';break;
                case 'vi':datatable_langurl+='VN';break;
                case 'tc':datatable_langurl+='Chinese-traditional';break;
                default:datatable_langurl+='Chinese';break;
            }
        }else{
            datatable_langurl+='Chinese';
        }
        datatable_langurl+='.json';
        window.datatable_pagelength=$datatable.data('pagelength')||30,
        window.datatable_option={
            drawCallback: function(settings){
                if($(window).scrollTop()>$(this).offset().top) $(window).scrollTop($(this).offset().top);// 表单重绘后页面滚动回表单顶部
                if($('[data-original]',this).length) $('[data-original]',this).lazyload();
            },
            responsive: true,
            ordering: false, //是否支持排序
            searching: false, //搜索
            searchable: false, //让搜索支持ajax异步查询
            lengthChange: false,//让用户可以下拉无刷新设置显示条数
            pageLength:datatable_pagelength,//默认每一页的显示数量
            serverSide: true, //ajax服务开启
            stateSave:true,//状态保存 - 再次加载页面时还原表格状态
            language: {
                url:datatable_langurl
            },
            ajax: {
                url: $datatable.data('table-ajaxurl'),
                data: function ( v ) {
                     var l = $("input[data-table-search],select[data-table-search]"),vlist='{ ',i=0;
                     if(l.length>0){
                         l.each(function(){
                             i++;
                             var n  = '"'+$(this).attr("name")+'"',val = '"'+$(this).val()+'"';
                             if(val!='')vlist+=i==l.length?n+':'+val:n+':'+val+',';
                         });
                     }
                     vlist+=' }';
                     vlist=$.parseJSON(vlist);
                     return $.extend( {}, v, vlist );
                }
            }
        };
        if($datatable.hasClass('dataTable')) window.datatable=$datatable.DataTable(datatable_option);
    }
})
/*favorite.js*/
$(function(){
    // 通过锚点获取所需收藏状态
    var hash=location.hash?location.hash:'';
    $('.shop-favorite-state a[href="'+hash+'"]').addClass('active');
    // 渲染收藏数据
    favoriteList();
    // 加载更多收藏、搜索收藏
    // $("#shop-favorite-more,.shop-favorite-keyword .input-search-btn").click(function(){
    //     var search=$(this).hasClass('input-search-btn')?true:false;
    //     favoriteList(search);
    // })
    // 切换收藏类型
    $(".shop-favorite-state a").click(function(){
        // $('input[name="keyword"]').val('');
        setTimeout(function(){
             favoriteList(true);
        },0)
        location.hash=$(this).attr('href');
    })
    // 删除收藏
    $(document).on('click','.favorite-remove',function(e){
        e.preventDefault();
        var $self = $(this);
        alertify.theme('bootstrap').okBtn(SHOPLANG.app_shop_ok).cancelBtn(SHOPLANG.app_shop_cancel).confirm(SHOPLANG.app_shop_deleteok, function (ev) {
            $.ajax({
                url: $self.attr('href'),
                type: 'POST',
                dataType:'json',
                data:{pid:$self.data('pid')},
                success: function(result) {
                    if(result.status){
                        location.reload();
                    }else{
                        alertify.error(result.error);
                    }
                }
            });
        });
    });
});
function favoriteList(search){
    // var $morebtn = $('#shop-favorite-more');
    var $favorite_list=$('.shop-favorite-list'),
        favorite_do_url=$favorite_list.data('do-url');
    // if(search) window.page = null;
    // $favorite_list.html('<div class="h-200 vertical-align text-xs-center favorite-loader"><div class="loader vertical-align-middle loader-default"></div></div>');
    // $morebtn.attr('disabled','disabled');
    favoriteJson(function(json){
        if(json.status==1 && json.data.length){
            var html = window.page>1?'<hr>':'',
                state=$(".shop-favorite-state a.active").data('state'),
                img_size=$favorite_list.data('size'),
                img_thumbdir=M['navurl']+'include/thumb.php?dir=';
            $.each(json.data,function(i,item){
                var original=i>3?'data-original':'src';
                item.img=item.img.replace(M['weburl'],'');
                item.img=img_thumbdir+item.img+img_size;
                item.price=state?SHOPLANG.app_shop_avorite_expired:item.price;
                item.price_class=state?'grey-400':'red-600';
                html += '<li>'
                    +'<div class="card card-shadow text-xs-center">'
                        +'<figure class="card-img-top overlay overlay-hover">'
                            +'<img class="overlay-figure overlay-scale" '+original+'="'+item.img+'" alt="'+item.title+'">'
                            +'<div class="overlay-panel vertical-align hidden-xl-up">'
                                +'<a href="'+item.url+'" title="'+item.title+'" target="_blank" class="btn btn-xs btn-danger btn-squared vertical-align-middle">'+SHOPLANG.app_shop_buy+'</a>'
                                +'<a href="'+favorite_do_url+'" data-pid="'+item.pid+'" class="btn btn-xs btn-default btn-squared pos-t-f favorite-remove">X</a>'
                            +'</div>'
                            +'<figcaption class="overlay-panel overlay-background overlay-fade vertical-align hidden-lg-down">'
                                +'<a href="'+item.url+'" title="'+item.title+'" target="_blank" class="btn btn-xs btn-danger btn-squared vertical-align-middle m-r-5">'+SHOPLANG.app_shop_buy+'</a>'
                                +'<a href="'+favorite_do_url+'" data-pid="'+item.pid+'" class="btn btn-xs btn-default btn-squared vertical-align-middle favorite-remove">'+SHOPLANG.app_shop_del+'</a>'
                            +'</figcaption>'
                        +'</figure>'
                        +'<div class="card-block p-10 bg-blue-grey-100">'
                            +'<h4 class="card-title m-b-0 font-size-14"><a href="'+item.url+'" title="'+item.title+'" target="_blank">'+item.title+'</a></h4>'
                            +'<p class="m-b-0 '+item.price_class+'">'+item.price+'</p>'
                        +'</div>'
                    +'</div>'
                +'</li>';
            });
            $('.shop-favorite-list .favorite-loader').remove();
            if(search){
                $favorite_list.html(html);
            }else{
                $favorite_list.append(html);
            }
            $favorite_list.imageSize();
            if($('[data-original]').length) $('[data-original]').lazyload();
            // $morebtn.removeAttr('disabled');
            // window.page = parseInt(json.page) + 1;
            // if(json.endnum<=json.page){
            //     $morebtn.attr({hidden:''});
            // }else{
            //     $morebtn.removeAttr('hidden');
            // }
        }else{
            // $('.shop-favorite-list .favorite-loader').remove();
            $favorite_list.html('<div class="h-200 vertical-align text-xs-center favorite-null animation-fade"><div class="vertical-align-middle font-size-18 blue-grey-500">'+SHOPLANG.app_shop_nofavorites+'</div></div>');
            // $morebtn.attr({hidden:''});
        }
    });
}
function favoriteJson(func){
    var search = '&state='+$('.shop-favorite-state li a.active').data('state');
    // if($('input[name="keyword"]').val()!='') search+='&keyword='+$('input[name="keyword"]').val();
    // if(window.page>1)search+='&page='+window.page;
    $.ajax({
        url: $('.shop-favorite-list').data('ajax-url'),
        data: search,
        type: 'POST',
        dataType:'json',
        success: function(json) {
            func(json);
        }
    });
}
return metmod;
})(window.MODULE_FAVORITE||{});