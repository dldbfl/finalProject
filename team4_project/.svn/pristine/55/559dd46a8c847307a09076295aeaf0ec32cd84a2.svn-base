<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

 <nav aria-label="member list Navigation" class="paginationNav text-center">
	<ul class="pagination justify-content-center m-0">
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(1);">
			<i class="glyphicon glyphicon-step-backward"></i>
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
			${pageMaker.prev ? pageMaker.startPage-1 : 1}				
			);"><i class="glyphicon glyphicon-chevron-left"></i></a>
		</li>
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">						
		<li class="page-item 
			<c:out value="${pageMaker.cri.page == pageNum?'active':''}"/>">
			<a class="page-link" href="javascript:searchList_go(${pageNum});" >${pageNum }
			</a>
		</li>
		</c:forEach>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(${pageMaker.next ? pageMaker.endPage+1 : pageMaker.cri.page});"><i class="glyphicon glyphicon-chevron-right" ></i></a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(${pageMaker.realEndPage});">
				<i class="glyphicon glyphicon-step-forward"></i></a>
		</li>	
	</ul>
</nav>   	