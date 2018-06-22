<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar" role="navigation">
					<div class="container" id="mycontainer">
						<!-- Brand and toggle get grouped for better mobile display -->

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse navbar-ex1-collapse">
							<ul class="nav navbar-nav" id="header_navbar">
								<c:forEach varStatus="status" items="${gglx}" var="data">
									<c:choose>
										<c:when test="${data.lbdm == 1}">
											<c:set var="icon" value="fa-files-o"></c:set>
											<c:set var="url" value="supplyHwzyCenter"/>
										</c:when>
										<c:when test="${data.lbdm == 2}">
											<c:set var="icon" value="fa-tv"></c:set>
											<c:set var="url" value="supplyDszyCenter"/>
										</c:when>
										<c:when test="${data.lbdm == 3}">
											<c:set var="icon" value="fa-podcast"></c:set>
											<c:set var="url" value="supplyGbzyCenter"/>
										</c:when>
										<c:when test="${data.lbdm == 4}">
											<c:set var="icon" value="fa-file-text-o"></c:set>
											<c:set var="url" value="supplyBzzyCenter"/>
										</c:when>
										<c:when test="${data.lbdm == 5}">
											<c:set var="icon" value="fa-video-camera"></c:set>
											<c:set var="url" value="supplyXmtzyCenter"/>
										</c:when>
										<c:when test="${data.lbdm == 6}">
											<c:set var="icon" value="fa-files-o"></c:set>
											<c:set var="url" value="supplyZzzyCenter"/>
										</c:when>
										<c:when test="${data.lbdm == 7}">
											<c:set var="icon" value="fa-wifi"></c:set>
											<c:set var="url" value="supplyWlzyCenter"/>
										</c:when>
										<c:otherwise>
											<c:set var="icon" value="fa-files-o"></c:set>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${flag eq data.lbdm}">
											<li class="active">
										</c:when>
										<c:otherwise>
											<li>
										</c:otherwise>
									</c:choose>
									<a
										href="<%=request.getContextPath()%>/${url}/index?flag=${data.lbdm}">
										<div class="text-center">
											<i class="fa ${icon} fa-3x" data-original-title="" title=""></i><br>
											${data.lbmc}
										</div>
									</a>
									</li>
								</c:forEach>
							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</div>
				</nav>