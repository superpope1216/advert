/**
 * 
 */

function createShModal(option){
	/**
	 * 如果需要穿hidden，格式为
	 * hidden:[{
				name:"wid",
				value:""
				
			}],
	 */
	var defaultOption={
			url:"",
			id:'defaultId',
			callBack:null
	};
	$.extend(defaultOption,option);
	var html='<div class="modal fade" id="'+defaultOption.id+'">';
		html+='		<div class="modal-dialog">';
		html+='			<div class="modal-content">';
		html+='				<div class="modal-header">';
		html+='					<button type="button" class="close" data-dismiss="modal" aria-label="Close">';
		html+='						<span aria-hidden="true">×</span>';
		html+='					</button>';
		html+='					<h4 class="modal-title">审核信息</h4>';
		html+='				</div>';
		html+='				<div class="modal-body">';
		html+='					<form id="shForm" role="form">';
		if(defaultOption.hidden){
			for(var i=0;i<defaultOption.hidden.length;i++){
				html+='	 <input type="hidden" name="'+defaultOption.hidden[i].name+'" value="'+defaultOption.hidden[i].value+'">';
			}
		}
		
		html+='							<div class="form-group ">';
		html+='								<select name="shzt" class="form-control">';
		html+='									<option value="2">通过</option>';
		html+='									<option value="3">不通过</option>';
		html+='								</select>';
		html+=' 						</div>';
		html+='					</form>';
		html+='				</div>';
		html+='				<div class="modal-footer">';
		html+='					<button type="button" class="btn btn-default pull-left"	data-dismiss="modal">Close</button>';
		html+='					<button type="button" class="btn btn-primary" name="btnSh">审核</button>';
		html+='				</div>';
		html+='			</div>'
		html+='		</div>';
		html+='</div>';
		if($("#"+defaultOption.id).length<=0){
			$("body").append(html);
		}else{
			$("#"+defaultOption.id).remove();
			$("body").append(html);
		}
		
		
		$("#"+defaultOption.id).modal("show");
		$("#"+defaultOption.id).on("click","button[name='btnSh']",function(){
			if(!defaultOption.url){
				if(defaultOption.callback){
					defaultOption.callback();
				}
			}else{
				doPost(defaultOption.url,$("#"+defaultOption.id+" form").serializeArray(),function(data){
					$("#"+defaultOption.id).modal("hide");
					if(defaultOption.callback){
						defaultOption.callback();
					}
				});
			}
		});
}