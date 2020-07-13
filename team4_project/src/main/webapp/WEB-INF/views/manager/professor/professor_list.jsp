<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
		table{
		border-collapse:separate ;
		
		}
	
		#writeBtn{
			width : 90px; 
			background: #C7C4FF;
			font-weight: bold;
			font-size: 15px;
			
			
		}
		
		.form-group{
			margin-top : 20px;	
			padding: 3px;
		
		}
		.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
		    padding: 15px 0px 10px 0px;
		    line-height: 1.42857143;
		    vertical-align: top;
		    border-top: 1px solid #ddd;
		    font-size: 18px;
		}
		
</style>		

	
	
<body class="blur-theme data-container-body">
	
		<div class="container-dashboard-inner">
		
			<form id="infoForm" class="form-inline" action="list">				
				<div class="pull-left">
					<h3>&nbsp;관리자 - 교수 목록</h3>
				</div>
				<div class="clearfix">	
					<div class="pull-right" id="keyword">
					</div>
				</div>				
			</form>				
			
				<div class="table-responsive">
					<table class="table table-striped">
						<!-- <tbody class="tableA"> -->
						<thead id="trtr">
							<tr>
								<td class="text-center" >아이디</td>  
								<td class="text-center" >이름</td>   
								<td class="text-center" >휴대폰</td>  
								<td class="text-center" >전공</td>   
								<td class="text-center" >재직상태</td>					
								<!-- <td class="text-center" >비고</td> -->		
							</tr>
						 </thead>
						 <tbody>                                           
						 <c:forEach items="${professorList}" var="professor">						 	
							<tr>
								<td class="text-center" ><a href="#write" onclick="OpenWindow('professor_detail?professor_id=${professor.member_id }','','710','500');" style="cursor: pointer;">${professor.member_id }</a>
								</td>
								<td class="text-center" >${professor.member_name}</td>
								<td class="text-center" ><a href="tel:${professor.member_phone }">${professor.member_phone }</a></td>
								<c:if test="${professor.professor_hope_subject == null}">	
									<td class="text-center">없음</td>
								</c:if>
								<c:if test="${professor.professor_hope_subject != null}">
									<td class="text-center">${professor.professor_hope_subject }</td>
								</c:if>																						
								<c:set value="${professor.member_status }" var="status" />
								<c:choose>
									<c:when test="${professor.member_status eq 1}">	
										<td class="text-center">재직</td>
									</c:when>
									<c:when test="${professor.member_status eq 0}">	
										<td class="text-center" >정지</td>
									</c:when>
									<c:otherwise> 
									    <td class="text-center" >가입 대기중</td>
									</c:otherwise>									
								</c:choose>
								<%-- <td class="text-center" >${professor.professor_remark}</td> --%>
							</tr>		 	
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- <input type="button" value="맨위로" onClick="javascript:window.scrollTo(0,0)" /> -->

				<input type="image" src="/resources/images/top.png" style="     position: relative;
																			    left: 1078px;
																			    bottom: 10px;
																			    width: 65px;
																			    border: 0;
																			    outline: 0;
																			    opacity: 0.3;
																		" onClick="javascript:window.scrollTo(0,0)" alt="Top" value="Top" />
				
			</div>
			<form id="jobForm">
			<input type='hidden' name="page" value="${pageMaker.cri.page}" />
			<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
			<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
			<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
			</form>
</body>

