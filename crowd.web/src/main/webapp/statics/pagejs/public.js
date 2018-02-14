define(function(require, exports, module) {

	var $ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/bootstrap.min');
	if(page_type == 'login')require.async('pagejs/yhgl/login');
	if(page_type == 'register')require.async('pagejs/yhgl/register');
	if(page_type=='dszyPublishing')require.async('pagejs/gggl/dszy/publishing');
	if(page_type=='gbzyPublishing')require.async('pagejs/gggl/gbzy/publishing');
	if(page_type=='bzzyPublishing')require.async('pagejs/gggl/bzzy/publishing');
	if(page_type=='zzzyPublishing')require.async('pagejs/gggl/zzzy/publishing');
	if(page_type=='xmtzyPublishing')require.async('pagejs/gggl/xmtzy/publishing');
	if(page_type=='supplyIndex')require.async('pagejs/gggl/index');
	
	if(page_type=='companyInfoView')require.async('pagejs/yhgl/yhxx/companyInfo');
	if(page_type=='companyZzInfo')require.async('pagejs/yhgl/yhxx/companyZzInfo');
	if(page_type=='companyMapInfo')require.async('pagejs/yhgl/yhxx/companyMapInfo');
	if(page_type=='dlglIndex') require.async('pagejs/sjgl/dlgl/index');
	if(page_type=='dlglEdit') require.async('pagejs/sjgl/dlgl/edit');
	if(page_type=='hzglIndex') require.async('pagejs/sjgl/hzgl/index');
	if(page_type=='hzglEdit') require.async('pagejs/sjgl/hzgl/edit');
	
	if(page_type=='zbglIndex') require.async('pagejs/sjgl/zbgl/index');
	if(page_type=='zbglEdit') require.async('pagejs/sjgl/zbgl/edit');
	
	if(page_type=='qyzxNewsIndex') require.async('pagejs/qyzx/news/index');
	if(page_type=='qyzxNewsEdit') require.async('pagejs/qyzx/news/edit');
	
	if(page_type=='qyzxGgIndex') require.async('pagejs/qyzx/gg/index');
	if(page_type=='qyzxGgEdit') require.async('pagejs/qyzx/gg/edit');
});
