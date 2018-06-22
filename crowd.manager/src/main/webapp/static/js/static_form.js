/**
 * 
 */

function createStaticForm(config,data,col){
	if(col==undefined|| col==null || col==""){
		col=2;
	}
	var labelWidth="col-xs-2";
	var inputWidth="col-xs-4";
	
	
	var html='<table class="table table-bordered">';
	var end=true;
	var endIndex=1;
	for(var i=0;i<config.length;i++){
		var _label=config[i].label;
		var _value="";
		if(config[i]["field"]!=undefined){
			_value=data[config[i].field]
		}else{
			var fields=config[i].fields;
			for(var j=0;j<fields.length;j++){
				_value+=data[fields[j].field]+"";
			}
			
		}
		
		if(_value==undefined||_value==null){
			_value="";
		}
		if(config[i].col==undefined || config[i].col==null|| config[i].col==""){
			config[i].col=2;
		}
		if(config[i].col==1){
			inputWidth="col-xs-10";
			if(i!=0){
				html+="</tr>";
			}
			html+='<tr>';
			
		}else if(config[i].col==2){
			inputWidth="col-xs-4";
			if(endIndex==1){
				html+='<tr>';
			}
		}
		
		html+='	<td class="'+labelWidth+'">'+_label+'</td>';
		var colspan="1";
		if(col==2 &&config[i].col=="1"){
			colspan="3";
		}
		html+='<td colspan='+colspan+' class="'+inputWidth+'">';
		if(config[i].type=="img"){
			html+='<div id="'+config[i].field+'Div" data-type="img" data-key="'+_value+'"></div>';
		}else{
			html+=_value;
		}
		
		html+='</td>';
		if(config[i].col==1){
			html+='</tr>';
		}else if(config[i].col==2){
			if(endIndex==2){
				html+='</tr>';
				
			}
		}
		if(config[i].col==1){
			endndex=1;
		}else{
			if(endIndex==2){
				endIndex=1;
			}else{
				endIndex=2;
			}
		}
		
		
	}
	html+='</table>';
	return html;
}