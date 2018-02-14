/**
 * 
 */
define(function(require, exports, module) {
	var $$ = jQuery$ = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	var pjrwlwglChart = echarts.init(document.getElementById('main'));
	var option = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['支出']
		    },
		    toolbox: {
		        show : true
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : ['周一','周二','周三','周四','周五','周六','周日']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'支出',
		            type:'line',
		            smooth:true,
		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
		            data:[10, 12, 21, 54, 260, 830, 710]
		        }
		    ]
		};
	pjrwlwglChart.setOption(option);
		                    
});