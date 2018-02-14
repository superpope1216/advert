$(document).ready(function() {
	if($("#met-job-cv").length){
		/*招聘模块弹出表单*/
		$(document).on('click',".met-job-cvbtn",function(){
			var cvurl = $(this).data('cvurl'),
				jobid = $(this).data('jobid');
			if($("#met-job-cv .modal-body .form-group").length){
				$("#met-job-cv .met-form").data('formValidation').resetForm();
				$("#met-job-cv .modal-body input[name='jobid']").val(jobid);
			}else{
				$("#met-job-cv .modal-body").html('<div class="height-100 vertical-align text-center cart-loader"><div class="loader vertical-align-middle loader-default"></div></div>');
				$.ajax({
					url: cvurl+'&jobid='+jobid,
					type: 'POST',
					success: function(data) {
						$("#met-job-cv .modal-body").html(data).hide().slideDown(500);
						$.components.init('placeholder');
						$("#met-job-cv .met-form").formValidation({
							framework: "bootstrap"
						})
						if(!$("#met-job-cv .modal-body input[name='jobid']").val()) $("#met-job-cv .modal-body input[name='jobid']").val(jobid);
					}
				});
			}
			$("#met-job-cv").modal('show');
		});
	}
})