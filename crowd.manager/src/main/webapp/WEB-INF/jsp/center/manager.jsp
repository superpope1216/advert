<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top.jsp"%>
<body class="skin-blue sidebar-mini"
	style="height: auto; min-height: 100%;">
	<div class="wrapper" style="height: auto; min-height: 100%;">

		<!-- Main Header -->
		<%@include file="/jsp/header.jsp"%>
		<!-- Left side column. contains the logo and sidebar -->
		<%@include file="/jsp/left.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="min-height: 929px;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					云工场数据一览 <small>${year}财年</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 数据中心</a></li>
					<li class="active">数据统计</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content container-fluid">
				<div class="row">
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-aqua">
							<div class="inner">
								<h3 id="fbrws" title="本财年发布所有开发性质并进入招标状态的需求数">0</h3>

								<p>发布任务数</p>
							</div>
							<div class="icon">
								<i class="fa fa-shopping-cart"></i>
							</div>
							<a href="#" class="small-box-footer"> 更多 <i
								class="fa fa-arrow-circle-right"></i>
							</a>
						</div>
					</div>
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-green">
							<div class="inner">
								<h3 id="fbrwje" title="本财年发布所有开发性质并进入招标状态的需求金额">0</h3>

								<p>发布任务金额</p>
							</div>
							<div class="icon">
								<i class="fa fa-shopping-cart"></i>
							</div>
							<a href="#" class="small-box-footer"> 更多 <i
								class="fa fa-arrow-circle-right"></i>
							</a>
						</div>
					</div>
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-yellow">
							<div class="inner">
								<h3 id="wgrws" title="本财年发布所有开发性质并进入售后中状态的需求数">0</h3>

								<p>完工任务数</p>
							</div>
							<div class="icon">
								<i class="ion ion-person-add"></i>
							</div>
							<a href="#" class="small-box-footer"> 更多 <i
								class="fa fa-arrow-circle-right"></i>
							</a>
						</div>
					</div>
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-red">
							<div class="inner">
								<h3 id="wgrwje" title="本财年发布所有开发性质并进入招标状态的需求金额">0</h3>

								<p>完工任务金额</p>
							</div>
							<div class="icon">
								<i class="ion ion-pie-graph"></i>
							</div>
							<a href="#" class="small-box-footer"> 更多<i
								class="fa fa-arrow-circle-right"></i>
							</a>
						</div>
					</div>
				</div>
				<div class="row">
					<section class="col-lg-7 connectedSortable ui-sortable">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">业务线任务剩余周期</h3>
								<div class="box-tools pull-right">
									<small>${year}财年</small>
								</div>
							</div>
							<div class="box-body">

								<canvas id="ywxSyzq" width="100%" height="30vm"></canvas>
							</div>
							<!-- /.box-footer-->
						</div>
					</section>
					<section class="col-lg-5 connectedSortable ui-sortable">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">业务线得分</h3>
								<div class="box-tools pull-right">
									<small>${month}</small>
								</div>
							</div>
							<div class="box-body">

								<canvas id="ywxScore" width="100%" height="42vm"></canvas>
							</div>
							<!-- /.box-footer-->
						</div>
					</section>
				</div>
				<div class="row">
					<section class="col-lg-12 connectedSortable ui-sortable">
						<div class="nav-tabs-custom" style="cursor: move;">
							<!-- Tabs within a box -->
							<ul class="nav nav-tabs pull-right ui-sortable-handle">
								<li class=""><a href="#xqwglYwx" data-toggle="tab"
									aria-expanded="false">业务线</a></li>
								<li class="active"><a href="#xqwglMonth" data-toggle="tab"
									aria-expanded="true">月份</a></li>
								<li class="pull-left header"><i class="fa fa-inbox"></i>
									需求完工量</li>
							</ul>
							<div class="tab-content no-padding">
								<div class="chart tab-pane " id="xqwglYwx"
									style="position: relative;  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
										<canvas id="xmwglYwxChart" width="100%" height="20vm"></canvas>
								</div>
								<div class="chart tab-pane active" id="xqwglMonth"
									style="position: relative; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
										<canvas id="xmwglMonthChart" width="100%" height="20vm"></canvas>
								</div>
							</div>	
							<div classs="tab-footer no-padding">
								<div class="row">
										<div class="col-sm-3 col-xs-6">
											<div class="description-block border-right">
												<span class="description-percentage text-green"><i
													class="fa fa-caret-up"></i> 17%</span>
												<h5 class="description-header">$35,210.43</h5>
												<span class="description-text">开发者总数</span>
											</div>
											<!-- /.description-block -->
										</div>
										<!-- /.col -->
										<div class="col-sm-3 col-xs-6">
											<div class="description-block border-right">
												<span class="description-percentage text-yellow"><i
													class="fa fa-caret-left"></i> 0%</span>
												<h5 class="description-header">$10,390.90</h5>
												<span class="description-text">内部开发者</span>
											</div>
											<!-- /.description-block -->
										</div>
										<!-- /.col -->
										<div class="col-sm-3 col-xs-6">
											<div class="description-block border-right">
												<span class="description-percentage text-green"><i
													class="fa fa-caret-up"></i> 20%</span>
												<h5 class="description-header">$24,813.53</h5>
												<span class="description-text">外部开发者</span>
											</div>
											<!-- /.description-block -->
										</div>
										<!-- /.col -->
										<div class="col-sm-3 col-xs-6">
											<div class="description-block">
												<span class="description-percentage text-red"><i
													class="fa fa-caret-down"></i> 18%</span>
												<h5 class="description-header">1200</h5>
												<span class="description-text">老友记</span>
											</div>
											<!-- /.description-block -->
										</div>
									</div>
							</div>
							
						</div>
					</section>
				</div>

				<div class="row">
					<section class="col-lg-12 connectedSortable ui-sortable">
						<div class="nav-tabs-custom" style="cursor: move;">
							<!-- Tabs within a box -->
							<ul class="nav nav-tabs pull-right ui-sortable-handle">
								<li class=""><a href="#xqyqYwx" data-toggle="tab"
									aria-expanded="false">业务线</a></li>
								<li class="active"><a href="#xqyqMonth" data-toggle="tab"
									aria-expanded="true">月份</a></li>
								<li class="pull-left header"><i class="fa fa-inbox"></i>
									需求延期趋势</li>
							</ul>
							<div class="tab-content no-padding">
								<div class="chart tab-pane " id="xqyqYwx"
									style="position: relative;  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
										<canvas id="xqyqYwxChart" width="100%" height="20vm"></canvas>
								</div>
								<div class="chart tab-pane active" id="xqyqMonth"
									style="position: relative; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
										<canvas id="xqyqMonthChart" width="100%" height="20vm"></canvas>
								</div>
							</div>	
						</div>
					</section>
				</div>
				
				<div class="row">
					<section class="col-lg-12 connectedSortable ui-sortable">
						<div class="nav-tabs-custom" style="cursor: move;">
							<!-- Tabs within a box -->
							<ul class="nav nav-tabs pull-right ui-sortable-handle">
								<li class=""><a href="#xqbugYwx" data-toggle="tab"
									aria-expanded="false">业务线</a></li>
								<li class="active"><a href="#xqbugMonth" data-toggle="tab"
									aria-expanded="true">月份</a></li>
								<li class="pull-left header"><i class="fa fa-inbox"></i>
									需求BUG趋势</li>
							</ul>
							<div class="tab-content no-padding">
								<div class="chart tab-pane " id="xqbugYwx"
									style="position: relative;  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
										<canvas id="xqbugYwxChart" width="100%" height="20vm"></canvas>
								</div>
								<div class="chart tab-pane active" id="xqbugMonth"
									style="position: relative; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
										<canvas id="xqbugMonthChart" width="100%" height="20vm"></canvas>
								</div>
							</div>	
						</div>
					</section>
				</div>
				
				<div class="row">
					<section class="col-lg-12 connectedSortable ui-sortable">
						<div class="nav-tabs-custom" style="cursor: move;">
							<!-- Tabs within a box -->
							<ul class="nav nav-tabs pull-right ui-sortable-handle">
								<li class=""><a href="#revenue-chart" data-toggle="tab"
									aria-expanded="false">月份</a></li>
								<li class="active"><a href="#sales-chart" data-toggle="tab"
									aria-expanded="true">业务线</a></li>
								<li class="pull-left header"><i class="fa fa-inbox"></i>
									业务线日报趋势图</li>
							</ul>
							<div class="tab-content no-padding">
								<!-- Morris chart - Sales -->
								<div class="chart tab-pane" id="revenue-chart"
									style="position: relative; height: 300px; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
									<svg height="300" version="1.1" width="604"
										xmlns="http://www.w3.org/2000/svg"
										xmlns:xlink="http://www.w3.org/1999/xlink"
										style="overflow: hidden; position: relative;">
										<desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.2.0</desc>
										<defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs>
										<text x="52.5" y="260" text-anchor="end"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal">
										<tspan dy="4.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">0</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M65,260H578.5"
											stroke-width="0.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="52.5" y="201.25" text-anchor="end"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal">
										<tspan dy="4"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">7,500</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M65,201.25H578.5"
											stroke-width="0.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="52.5" y="142.5" text-anchor="end"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal">
										<tspan dy="4"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">15,000</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M65,142.5H578.5"
											stroke-width="0.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="52.5" y="83.75" text-anchor="end"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal">
										<tspan dy="4"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">22,500</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M65,83.75H578.5"
											stroke-width="0.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="52.5" y="25.00000000000003" text-anchor="end"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal">
										<tspan dy="4.000000000000028"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">30,000</tspan></text>
										<path fill="none" stroke="#aaaaaa"
											d="M65,25.00000000000003H578.5" stroke-width="0.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="484.28554070473876" y="272.5" text-anchor="middle"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal" transform="matrix(1,0,0,1,0,7.5)">
										<tspan dy="4.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2013</tspan></text>
										<text x="255.9246658566221" y="272.5" text-anchor="middle"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal" transform="matrix(1,0,0,1,0,7.5)">
										<tspan dy="4.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2012</tspan></text>
										<path fill="#74a5c2" stroke="none"
											d="M65,218.23266666666666C79.3505467800729,218.74183333333332,108.05164034021871,221.7860625,122.40218712029161,220.26933333333335C136.75273390036452,218.75260416666669,165.45382746051033,208.35534699453552,179.80437424058323,206.09883333333335C193.99893681652492,203.86684699453554,222.38806196840827,204.11993750000002,236.58262454434995,202.31533333333334C250.77718712029161,200.51072916666666,279.16631227217493,194.192947859745,293.3608748481166,191.662C307.71142162818956,189.10323952641167,336.41251518833536,181.84977083333334,350.7630619684083,181.9565C365.11360874848117,182.06322916666667,393.81470230862703,203.4213315118397,408.1652490886999,192.51583333333332C422.3598116646416,181.72887317850635,450.7489368165249,101.61791988950276,464.9434993924666,95.18666666666667C478.98207776427705,88.82608655616943,507.05923450789794,134.67133653846153,521.0978128797084,141.3485C535.4483596597813,148.17404487179488,564.1494532199271,147.23525,578.5,149.1975L578.5,260L65,260Z"
											fill-opacity="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></path>
										<path fill="none" stroke="#3c8dbc"
											d="M65,218.23266666666666C79.3505467800729,218.74183333333332,108.05164034021871,221.7860625,122.40218712029161,220.26933333333335C136.75273390036452,218.75260416666669,165.45382746051033,208.35534699453552,179.80437424058323,206.09883333333335C193.99893681652492,203.86684699453554,222.38806196840827,204.11993750000002,236.58262454434995,202.31533333333334C250.77718712029161,200.51072916666666,279.16631227217493,194.192947859745,293.3608748481166,191.662C307.71142162818956,189.10323952641167,336.41251518833536,181.84977083333334,350.7630619684083,181.9565C365.11360874848117,182.06322916666667,393.81470230862703,203.4213315118397,408.1652490886999,192.51583333333332C422.3598116646416,181.72887317850635,450.7489368165249,101.61791988950276,464.9434993924666,95.18666666666667C478.98207776427705,88.82608655616943,507.05923450789794,134.67133653846153,521.0978128797084,141.3485C535.4483596597813,148.17404487179488,564.1494532199271,147.23525,578.5,149.1975"
											stroke-width="3"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<circle cx="65" cy="218.23266666666666" r="4" fill="#3c8dbc"
											stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="122.40218712029161" cy="220.26933333333335" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="179.80437424058323" cy="206.09883333333335" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="236.58262454434995" cy="202.31533333333334" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="293.3608748481166" cy="191.662" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="350.7630619684083" cy="181.9565" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="408.1652490886999" cy="192.51583333333332" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="464.9434993924666" cy="95.18666666666667" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="521.0978128797084" cy="141.3485" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="578.5" cy="149.1975" r="4" fill="#3c8dbc"
											stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<path fill="#eaf3f6" stroke="none"
											d="M65,239.11633333333333C79.3505467800729,238.897,108.05164034021871,240.43820833333334,122.40218712029161,238.239C136.75273390036452,236.03979166666667,165.45382746051033,222.49635428051002,179.80437424058323,221.52266666666668C193.99893681652492,220.55956261384335,222.38806196840827,232.3502916666667,236.58262454434995,230.49183333333335C250.77718712029161,228.633375,279.16631227217493,208.50817190346083,293.3608748481166,206.655C307.71142162818956,204.7814635701275,336.41251518833536,213.63645833333334,350.7630619684083,215.585C365.11360874848117,217.53354166666668,393.81470230862703,231.50074954462661,408.1652490886999,222.24333333333334C422.3598116646416,213.08654121129325,450.7489368165249,147.70467656537753,464.9434993924666,141.92816666666667C478.98207776427705,136.21513489871086,507.05923450789794,169.85397847985348,521.0978128797084,176.28516666666667C535.4483596597813,182.85927014652015,564.1494532199271,189.53329166666668,578.5,193.94933333333336L578.5,260L65,260Z"
											fill-opacity="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></path>
										<path fill="none" stroke="#a0d0e0"
											d="M65,239.11633333333333C79.3505467800729,238.897,108.05164034021871,240.43820833333334,122.40218712029161,238.239C136.75273390036452,236.03979166666667,165.45382746051033,222.49635428051002,179.80437424058323,221.52266666666668C193.99893681652492,220.55956261384335,222.38806196840827,232.3502916666667,236.58262454434995,230.49183333333335C250.77718712029161,228.633375,279.16631227217493,208.50817190346083,293.3608748481166,206.655C307.71142162818956,204.7814635701275,336.41251518833536,213.63645833333334,350.7630619684083,215.585C365.11360874848117,217.53354166666668,393.81470230862703,231.50074954462661,408.1652490886999,222.24333333333334C422.3598116646416,213.08654121129325,450.7489368165249,147.70467656537753,464.9434993924666,141.92816666666667C478.98207776427705,136.21513489871086,507.05923450789794,169.85397847985348,521.0978128797084,176.28516666666667C535.4483596597813,182.85927014652015,564.1494532199271,189.53329166666668,578.5,193.94933333333336"
											stroke-width="3"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<circle cx="65" cy="239.11633333333333" r="4" fill="#a0d0e0"
											stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="122.40218712029161" cy="238.239" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="179.80437424058323" cy="221.52266666666668" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="236.58262454434995" cy="230.49183333333335" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="293.3608748481166" cy="206.655" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="350.7630619684083" cy="215.585" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="408.1652490886999" cy="222.24333333333334" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="464.9434993924666" cy="141.92816666666667" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="521.0978128797084" cy="176.28516666666667" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="578.5" cy="193.94933333333336" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle></svg>
									<div class="morris-hover morris-default-style"
										style="left: 474.098px; top: 90px; display: none;">
										<div class="morris-hover-row-label">2013 Q1</div>
										<div class="morris-hover-point" style="color: #a0d0e0">
											Item 1: 10,687</div>
										<div class="morris-hover-point" style="color: #3c8dbc">
											Item 2: 4,460</div>
									</div>
								</div>
								<div class="chart tab-pane active" id="sales-chart"
									style="position: relative; height: 300px;">
									<svg height="342" version="1.1" width="512"
										xmlns="http://www.w3.org/2000/svg"
										xmlns:xlink="http://www.w3.org/1999/xlink"
										style="overflow: hidden; position: relative;">
										<desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.2.0</desc>
										<defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs>
										<path fill="none" stroke="#3c8dbc"
											d="M316.75,243.33333333333331A93.33333333333333,93.33333333333333,0,0,0,404.9777551949771,180.44625304313007"
											stroke-width="2" opacity="0"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path>
										<path fill="#3c8dbc" stroke="#ffffff"
											d="M316.75,246.33333333333331A96.33333333333333,96.33333333333333,0,0,0,407.81364732624417,181.4248826052307L444.3651459070204,194.03833029452744A135,135,0,0,1,316.75,285Z"
											stroke-width="3"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<path fill="none" stroke="#f56954"
											d="M404.9777551949771,180.44625304313007A93.33333333333333,93.33333333333333,0,0,0,233.03484627831412,108.73398312817662"
											stroke-width="2" opacity="0"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path>
										<path fill="#f56954" stroke="#ffffff"
											d="M407.81364732624417,181.4248826052307A96.33333333333333,96.33333333333333,0,0,0,230.34400205154566,107.40757544301087L195.6620097954186,90.31165416754118A135,135,0,0,1,444.3651459070204,194.03833029452744Z"
											stroke-width="3"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<path fill="none" stroke="#00a65a"
											d="M233.03484627831412,108.73398312817662A93.33333333333333,93.33333333333333,0,0,0,316.72067846904883,243.333328727518"
											stroke-width="2" opacity="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 1;"></path>
										<path fill="#00a65a" stroke="#ffffff"
											d="M230.34400205154566,107.40757544301087A96.33333333333333,96.33333333333333,0,0,0,316.71973599126824,246.3333285794739L316.70601770357325,289.999993091277A140,140,0,0,1,191.17726941747117,88.10097469226493Z"
											stroke-width="3"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="316.75" y="140" text-anchor="middle"
											font-family="&quot;Arial&quot;" font-size="15px"
											stroke="none" fill="#000000"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: Arial; font-size: 15px; font-weight: 800;"
											font-weight="800"
											transform="matrix(1.3884,0,0,1.3884,-123.0351,-57.876)"
											stroke-width="0.7202380952380952">
										<tspan dy="5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Mail-Order Sales</tspan></text>
										<text x="316.75" y="160" text-anchor="middle"
											font-family="&quot;Arial&quot;" font-size="14px"
											stroke="none" fill="#000000"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: Arial; font-size: 14px;"
											transform="matrix(1.9444,0,0,1.9444,-299.1528,-143.5556)"
											stroke-width="0.5142857142857143">
										<tspan dy="5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">20</tspan></text></svg>
								</div>
							</div>
						</div>
					</section>
				</div>
				
				<div class="row">
					<section class="col-lg-12 connectedSortable ui-sortable">
						<div class="nav-tabs-custom" style="cursor: move;">
							<!-- Tabs within a box -->
							<ul class="nav nav-tabs pull-right ui-sortable-handle">
								<li class=""><a href="#revenue-chart" data-toggle="tab"
									aria-expanded="false">月份</a></li>
								<li class="active"><a href="#sales-chart" data-toggle="tab"
									aria-expanded="true">业务线</a></li>
								<li class="pull-left header"><i class="fa fa-inbox"></i>
									需求审计</li>
							</ul>
							<div class="tab-content no-padding">
								<!-- Morris chart - Sales -->
								<div class="chart tab-pane" id="revenue-chart"
									style="position: relative; height: 300px; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
									<svg height="300" version="1.1" width="604"
										xmlns="http://www.w3.org/2000/svg"
										xmlns:xlink="http://www.w3.org/1999/xlink"
										style="overflow: hidden; position: relative;">
										<desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.2.0</desc>
										<defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs>
										<text x="52.5" y="260" text-anchor="end"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal">
										<tspan dy="4.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">0</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M65,260H578.5"
											stroke-width="0.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="52.5" y="201.25" text-anchor="end"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal">
										<tspan dy="4"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">7,500</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M65,201.25H578.5"
											stroke-width="0.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="52.5" y="142.5" text-anchor="end"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal">
										<tspan dy="4"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">15,000</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M65,142.5H578.5"
											stroke-width="0.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="52.5" y="83.75" text-anchor="end"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal">
										<tspan dy="4"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">22,500</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M65,83.75H578.5"
											stroke-width="0.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="52.5" y="25.00000000000003" text-anchor="end"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal">
										<tspan dy="4.000000000000028"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">30,000</tspan></text>
										<path fill="none" stroke="#aaaaaa"
											d="M65,25.00000000000003H578.5" stroke-width="0.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="484.28554070473876" y="272.5" text-anchor="middle"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal" transform="matrix(1,0,0,1,0,7.5)">
										<tspan dy="4.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2013</tspan></text>
										<text x="255.9246658566221" y="272.5" text-anchor="middle"
											font-family="sans-serif" font-size="12px" stroke="none"
											fill="#888888"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;"
											font-weight="normal" transform="matrix(1,0,0,1,0,7.5)">
										<tspan dy="4.5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2012</tspan></text>
										<path fill="#74a5c2" stroke="none"
											d="M65,218.23266666666666C79.3505467800729,218.74183333333332,108.05164034021871,221.7860625,122.40218712029161,220.26933333333335C136.75273390036452,218.75260416666669,165.45382746051033,208.35534699453552,179.80437424058323,206.09883333333335C193.99893681652492,203.86684699453554,222.38806196840827,204.11993750000002,236.58262454434995,202.31533333333334C250.77718712029161,200.51072916666666,279.16631227217493,194.192947859745,293.3608748481166,191.662C307.71142162818956,189.10323952641167,336.41251518833536,181.84977083333334,350.7630619684083,181.9565C365.11360874848117,182.06322916666667,393.81470230862703,203.4213315118397,408.1652490886999,192.51583333333332C422.3598116646416,181.72887317850635,450.7489368165249,101.61791988950276,464.9434993924666,95.18666666666667C478.98207776427705,88.82608655616943,507.05923450789794,134.67133653846153,521.0978128797084,141.3485C535.4483596597813,148.17404487179488,564.1494532199271,147.23525,578.5,149.1975L578.5,260L65,260Z"
											fill-opacity="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></path>
										<path fill="none" stroke="#3c8dbc"
											d="M65,218.23266666666666C79.3505467800729,218.74183333333332,108.05164034021871,221.7860625,122.40218712029161,220.26933333333335C136.75273390036452,218.75260416666669,165.45382746051033,208.35534699453552,179.80437424058323,206.09883333333335C193.99893681652492,203.86684699453554,222.38806196840827,204.11993750000002,236.58262454434995,202.31533333333334C250.77718712029161,200.51072916666666,279.16631227217493,194.192947859745,293.3608748481166,191.662C307.71142162818956,189.10323952641167,336.41251518833536,181.84977083333334,350.7630619684083,181.9565C365.11360874848117,182.06322916666667,393.81470230862703,203.4213315118397,408.1652490886999,192.51583333333332C422.3598116646416,181.72887317850635,450.7489368165249,101.61791988950276,464.9434993924666,95.18666666666667C478.98207776427705,88.82608655616943,507.05923450789794,134.67133653846153,521.0978128797084,141.3485C535.4483596597813,148.17404487179488,564.1494532199271,147.23525,578.5,149.1975"
											stroke-width="3"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<circle cx="65" cy="218.23266666666666" r="4" fill="#3c8dbc"
											stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="122.40218712029161" cy="220.26933333333335" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="179.80437424058323" cy="206.09883333333335" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="236.58262454434995" cy="202.31533333333334" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="293.3608748481166" cy="191.662" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="350.7630619684083" cy="181.9565" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="408.1652490886999" cy="192.51583333333332" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="464.9434993924666" cy="95.18666666666667" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="521.0978128797084" cy="141.3485" r="4"
											fill="#3c8dbc" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="578.5" cy="149.1975" r="4" fill="#3c8dbc"
											stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<path fill="#eaf3f6" stroke="none"
											d="M65,239.11633333333333C79.3505467800729,238.897,108.05164034021871,240.43820833333334,122.40218712029161,238.239C136.75273390036452,236.03979166666667,165.45382746051033,222.49635428051002,179.80437424058323,221.52266666666668C193.99893681652492,220.55956261384335,222.38806196840827,232.3502916666667,236.58262454434995,230.49183333333335C250.77718712029161,228.633375,279.16631227217493,208.50817190346083,293.3608748481166,206.655C307.71142162818956,204.7814635701275,336.41251518833536,213.63645833333334,350.7630619684083,215.585C365.11360874848117,217.53354166666668,393.81470230862703,231.50074954462661,408.1652490886999,222.24333333333334C422.3598116646416,213.08654121129325,450.7489368165249,147.70467656537753,464.9434993924666,141.92816666666667C478.98207776427705,136.21513489871086,507.05923450789794,169.85397847985348,521.0978128797084,176.28516666666667C535.4483596597813,182.85927014652015,564.1494532199271,189.53329166666668,578.5,193.94933333333336L578.5,260L65,260Z"
											fill-opacity="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></path>
										<path fill="none" stroke="#a0d0e0"
											d="M65,239.11633333333333C79.3505467800729,238.897,108.05164034021871,240.43820833333334,122.40218712029161,238.239C136.75273390036452,236.03979166666667,165.45382746051033,222.49635428051002,179.80437424058323,221.52266666666668C193.99893681652492,220.55956261384335,222.38806196840827,232.3502916666667,236.58262454434995,230.49183333333335C250.77718712029161,228.633375,279.16631227217493,208.50817190346083,293.3608748481166,206.655C307.71142162818956,204.7814635701275,336.41251518833536,213.63645833333334,350.7630619684083,215.585C365.11360874848117,217.53354166666668,393.81470230862703,231.50074954462661,408.1652490886999,222.24333333333334C422.3598116646416,213.08654121129325,450.7489368165249,147.70467656537753,464.9434993924666,141.92816666666667C478.98207776427705,136.21513489871086,507.05923450789794,169.85397847985348,521.0978128797084,176.28516666666667C535.4483596597813,182.85927014652015,564.1494532199271,189.53329166666668,578.5,193.94933333333336"
											stroke-width="3"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<circle cx="65" cy="239.11633333333333" r="4" fill="#a0d0e0"
											stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="122.40218712029161" cy="238.239" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="179.80437424058323" cy="221.52266666666668" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="236.58262454434995" cy="230.49183333333335" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="293.3608748481166" cy="206.655" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="350.7630619684083" cy="215.585" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="408.1652490886999" cy="222.24333333333334" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="464.9434993924666" cy="141.92816666666667" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="521.0978128797084" cy="176.28516666666667" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="578.5" cy="193.94933333333336" r="4"
											fill="#a0d0e0" stroke="#ffffff" stroke-width="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle></svg>
									<div class="morris-hover morris-default-style"
										style="left: 474.098px; top: 90px; display: none;">
										<div class="morris-hover-row-label">2013 Q1</div>
										<div class="morris-hover-point" style="color: #a0d0e0">
											Item 1: 10,687</div>
										<div class="morris-hover-point" style="color: #3c8dbc">
											Item 2: 4,460</div>
									</div>
								</div>
								<div class="chart tab-pane active" id="sales-chart"
									style="position: relative; height: 300px;">
									<svg height="342" version="1.1" width="512"
										xmlns="http://www.w3.org/2000/svg"
										xmlns:xlink="http://www.w3.org/1999/xlink"
										style="overflow: hidden; position: relative;">
										<desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.2.0</desc>
										<defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs>
										<path fill="none" stroke="#3c8dbc"
											d="M316.75,243.33333333333331A93.33333333333333,93.33333333333333,0,0,0,404.9777551949771,180.44625304313007"
											stroke-width="2" opacity="0"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path>
										<path fill="#3c8dbc" stroke="#ffffff"
											d="M316.75,246.33333333333331A96.33333333333333,96.33333333333333,0,0,0,407.81364732624417,181.4248826052307L444.3651459070204,194.03833029452744A135,135,0,0,1,316.75,285Z"
											stroke-width="3"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<path fill="none" stroke="#f56954"
											d="M404.9777551949771,180.44625304313007A93.33333333333333,93.33333333333333,0,0,0,233.03484627831412,108.73398312817662"
											stroke-width="2" opacity="0"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path>
										<path fill="#f56954" stroke="#ffffff"
											d="M407.81364732624417,181.4248826052307A96.33333333333333,96.33333333333333,0,0,0,230.34400205154566,107.40757544301087L195.6620097954186,90.31165416754118A135,135,0,0,1,444.3651459070204,194.03833029452744Z"
											stroke-width="3"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<path fill="none" stroke="#00a65a"
											d="M233.03484627831412,108.73398312817662A93.33333333333333,93.33333333333333,0,0,0,316.72067846904883,243.333328727518"
											stroke-width="2" opacity="1"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 1;"></path>
										<path fill="#00a65a" stroke="#ffffff"
											d="M230.34400205154566,107.40757544301087A96.33333333333333,96.33333333333333,0,0,0,316.71973599126824,246.3333285794739L316.70601770357325,289.999993091277A140,140,0,0,1,191.17726941747117,88.10097469226493Z"
											stroke-width="3"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="316.75" y="140" text-anchor="middle"
											font-family="&quot;Arial&quot;" font-size="15px"
											stroke="none" fill="#000000"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: Arial; font-size: 15px; font-weight: 800;"
											font-weight="800"
											transform="matrix(1.3884,0,0,1.3884,-123.0351,-57.876)"
											stroke-width="0.7202380952380952">
										<tspan dy="5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Mail-Order Sales</tspan></text>
										<text x="316.75" y="160" text-anchor="middle"
											font-family="&quot;Arial&quot;" font-size="14px"
											stroke="none" fill="#000000"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: Arial; font-size: 14px;"
											transform="matrix(1.9444,0,0,1.9444,-299.1528,-143.5556)"
											stroke-width="0.5142857142857143">
										<tspan dy="5"
											style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">20</tspan></text></svg>
								</div>
							</div>
						</div>
					</section>
				</div>
				<!--------------------------
        | Your Page Content Here |
        -------------------------->

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<%@include file="/jsp/footer.jsp"%>

		<!-- Control Sidebar -->
		<%@include file="/jsp/left_scroll.jsp"%>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->


	<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->

	<%@ include file="/jsp/bottom.jsp"%>
	<script type="text/javascript" src="<%=request.getContextPath() %>/static/pagejs/center/manager.js"></script>
	<script>
		$(document).ready(
				function() {
					

					
					var ctx3 = document.getElementById('myChart3').getContext(
							'2d');
					var chart3 = new Chart(ctx3, {
						// The type of chart we want to create
						type : 'line',
						responsive : false,
						// The data for our dataset
						data : {
							labels : [ "January", "February", "March", "April",
									"May", "June", "July" ],
							datasets : [ {
								label : "My First dataset",
								backgroundColor : 'rgba(60,141,188,0.9)',
								borderColor : 'rgba(60,141,188,0.9)',
								data : [ 0, 10, 5, 2, 20, 30, 45 ],
							} ]
						},

						// Configuration options go here
						options : {
							legend : {
								display : false
							}
						}
					});
				});
	</script>
</body>
</html>