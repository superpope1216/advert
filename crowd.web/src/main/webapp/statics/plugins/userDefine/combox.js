(function($) {    
  // 插件的定义    
  $.fn.combox = function(options) {    
    var opts = $.extend({}, $.fn.combox.defaults, options);    
    return this.each(function() {    
      $this = $(this);    
      // build element specific options    
      var o = $.meta ? $.extend({}, opts, $this.data()) : opts;    
      // update element styles    
      $this.css({    
        backgroundColor: o.background,    
        color: o.foreground    
      });    
      var markup = $this.html();    
      // call our format function    
      markup = $.fn.hilight.format(markup);    
      $this.html(markup);    
    });    
  };    
  // 插件的defaults    
  $.fn.combox.defaults = {    
    url: basePath+"/sjzd/list",    
    params:null    
  };    
// 闭包结束    
})(jQuery);    