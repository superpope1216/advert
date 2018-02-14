/**
 * 
 */

define(function(require, exports, module) {

	var $$ = jQuery$ = require('jquery');
	$("#selArea").val(area);
	$("#selCity").val(city);
	$("#selXian").val(xian);
	
	
	function setCenterMap(_map){
		var _selAreaDisplay=$("#selArea").find("option:selected").text();
		var _selCityDisplay=$("#selCity").find("option:selected").text();
		var _selXianDisplay=$("#selXian").find("option:selected").text();
		var _selDispay="";
		if($("#selArea").val()){
			_selDispay=_selAreaDisplay;
		}
		if($("#selCity").val()){
			_selDispay+=_selCityDisplay;
		}
		if($("#selXian").val()){
			_selDispay+=_selXianDisplay
		}
		_map.centerAndZoom(_selDispay,14);      // 初始化地图,用城市名设置地图中心点
	}
	var map = new BMap.Map("allmap");  // 创建Map实例
	
	if(sfybz=="1"){
		var _point = new BMap.Point(lng, lat);
		var marker = new BMap.Marker(_point);        // 创建标注    
		map.addOverlay(marker);
		
		map.centerAndZoom(_point,14);
	}else{
		setCenterMap(map);
	}
	var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
	var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
	var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}); //右上角
	map.addControl(top_left_control);        
	map.addControl(top_left_navigation);     
	map.addControl(top_right_navigation);  
	var menu = new BMap.ContextMenu();
	var txtMenuItem=[{text:'标注',callback:function(e){
		map.clearOverlays();
		var point = new BMap.Point(e.lng, e.lat);
		
		var marker = new BMap.Marker(point);        // 创建标注    
		map.addOverlay(marker);
		doPost(basePath+"/companyMapInfo/save","lng="+e.lng+"&lat="+e.lat,function(data){
			$("#spanYbz").show();
			$("#spanWbz").hide();
		});
	}}];
	for(var i=0; i < txtMenuItem.length; i++){
		menu.addItem(new BMap.MenuItem(txtMenuItem[i].text,txtMenuItem[i].callback,100));
	}
	map.addContextMenu(menu);
	
	$("#selArea").change(function(){
		var _value=$(this).val();
		$("#selXian").empty();
		$("#selXian").append("<option value=''>--请选择--</option>");
		if(_value==""){
			$("#selCity").empty();
			$("#selCity").append("<option value=''>--请选择--</option>");
			setCenterMap(map);
		}else{
			doGet(basePath+"/dictionary/selectCity","parentBm="+$(this).val(),function(data){
				if(data && data.datas){	
					var html="";
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
					}
					$("#selCity").html(html);
					setCenterMap(map);
				}
			});
		}
	});
	
	$("#selCity").change(function(){
		var _value=$(this).val();
		if(_value==""){
			$("#selXian").empty();
			$("#selXian").append("<option value=''>--请选择--</option>");
			setCenterMap(map);
		}else{
			doGet(basePath+"/dictionary/selectCity","parentBm="+$(this).val(),function(data){
				if(data && data.datas){
					
					var html="";
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
					}
					$("#selXian").html(html);
					setCenterMap(map);
				}
			});
		}
	});
	$("#selXian").change(function(){
		setCenterMap(map);
	});
});