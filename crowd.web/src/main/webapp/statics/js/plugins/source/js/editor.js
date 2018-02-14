$(document).ready(function() {
	/*编辑器响应式表格*/
	if($(".met-editor table").length){
		$(".met-editor table").addClass('table table-bordered table-hover table-striped table-responsive');
		tablexys();
	}
	/*编辑器图片处理*/
	if($(".met-editor img").length){
		//图片懒加载
    	$(".met-editor.lazyload img").lazyload();
		// 编辑器画廊
    	if (!$(".met-editor.no-gallery").length) {
    		$(".met-editor").wrapInner("<div class='editorlightgallery'></div>");
    		$(".met-editor").each(function() {
				var img_gallery_open=1,
					this_editor=this;
	    		$("img",this).one('click',function() {
	    			if(img_gallery_open){
	    				$('img',this_editor).each(function() {
		    				if($(this).parent("a").length==0){
								var data_thumb=data_src = $(this).data("original") ? $(this).data("original"): $(this).attr("src");
								if($(this).hasClass('imgloading')){
									var data_thumbs=data_src.split('upload/');
									data_thumb='../include/thumb.php?dir=../upload/'+data_thumbs[1]+'&x=60&y=60';
								}
								$(this).wrap("<div class='lg-item-box' data-src='"+data_src+"' data-exthumbimage='"+data_thumb+"'></div>");
							}
		    			});
		    			//画廊加载
		    			$('.editorlightgallery',this_editor).galleryLoad();
						$(this).parent('.lg-item-box').trigger('click');
						img_gallery_open=0;
	    			}
	    		});
    		});
    	}
	}
})
/*表格格式化*/
function tablexys(){
	Breakpoints.get('xs').on({
		enter: function(){
			$(".met-editor table").each(function(){
				var table = $(this);
				if(table.is(':visible')&&!table.hasClass('tablesaw')){
					if(table.find("thead").length){
						table.addClass('tablesaw').attr("data-tablesaw-mode","swipe");
					}else{
						var td = table.find("tbody tr:eq(0) td"),th;
						if(td.length==0)td = table.find("tbody tr:eq(0) th");
						td.each(function(){
							th+='<th>'+$(this).html()+'</th>';
						});
						table.prepend("<thead><tr>"+th+"</tr></thead>");
						table.find("tbody tr:eq(0)").remove();
						table.find("tbody td").attr('width','auto');
						table.addClass('tablesaw').attr("data-tablesaw-mode","swipe");
					}
				}
			});
			$('.met-editor .table-responsive').parent().addClass('table-saw');
			$( document ).trigger( "enhance.tablesaw");
		}
	});
}