<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<style>
.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
    padding: 0px 0px 0px 0px;
    line-height: 1.42857143;
    vertical-align: top;
    border-top: 1px solid #ddd;
}
section#main-container {
    height: auto;
    margin-top: 19px;
    min-height: 663px;
    font-size: 1.4em;
}


</style>



<body>

		<br>
			<h2>수정화면</h2>
		<br>
		<form name="modify" method="post" action="modify">
		<table class="table table-striped table-hover">
			<tbody>
				<tr class="" style="background-color: #337ab7;" valign="middle">
					<td colspan="2" class="text-center" style="height: 25px;"><p class="bg-primary" style="font-size:large; margin: 5px;">창업동기 및 사업추진 내용</p></td>
				</tr>
			
				<tr class="info">
					<td class="text-center" style="width: 15%;"><p style="font-size:larger; margin: 5px; margin-top: 15px;">창업명</p></td>
					<td class="">
					<textarea id="proposal_title" name="proposal_title" rows="2" cols=140 style="resize: none;margin-top: 4px;width: 99.5%;">${proposal.proposal_title }</textarea>
					</td>
				</tr>
				<tr class="info">
					<td class="text-center" style="width: 15%;"><p style="font-size:larger; margin: 5px; margin-top: 40px;">창업 목적 및 배경</p></td>
					<td class="">
					<textarea id="proposal_motivation" name="proposal_motivation" rows="5" cols=140 style="resize: none;margin-top: 4px;width: 99.5%;">${proposal.proposal_motivation }</textarea>
					</td>
				</tr>
				<tr class="info">
					<td class="text-center" style="width: 15%;"><p style="font-size: larger; margin: 5px; margin-top: 35px;">창업 아이템의 내용 및 특성</p></td>
					<td class="">
					<textarea id="proposal_idea" name="proposal_idea" rows="5" cols="140" style="resize: none;margin-top: 4px;width: 99.5%;">${proposal.proposal_idea }</textarea>
					</td>
				</tr>
				<tr class="info">
					<td class="text-center" style="width: 15%;"><p style="font-size: larger; margin: 5px; margin-top: 25px;">상품개발 및 사업화 목표, 창업 후 추진계획</p></td>
					<td class="">
					<textarea id="proposal_propulsion" name="proposal_propulsion" rows="5" cols="140" style="resize: none;margin-top: 4px;width: 99.5%;">${proposal.proposal_propulsion }</textarea>
					</td>
				</tr>
			</tbody>
		</table>
		
		<table class="table table-striped table-hover">
			<tbody>
			<tr class="" style="background-color: #337ab7; " valign="middle">
					<td colspan="2" class="text-center" style=" height: 25px;"><p class="bg-primary" style="font-size:large; margin: 5px;">사업화 추진 계획</p></td>
				</tr>
				<tr class="info">
					<td class="text-center" style="width: 15%;"><p style="font-size: larger; margin: 5px; margin-top: 25px;">매출 실현 가능성, 판로개척 방안등</p></td>
					<td class="">
					<textarea id="proposal_market" name="proposal_market" rows="5" cols="140" style="resize: none;margin-top: 4px;width: 99.5%;">${proposal.proposal_market }</textarea>
					</td>
				</tr>
				<tr class="info">
					<td class="text-center" style="width: 15%;"><p style="font-size: larger; margin: 5px; margin-top: 25px;">수익 전망 및 손익 분기 예상시기 등</p></td>
					<td class="">
					<textarea id="proposal_funds" name="proposal_funds" rows="5" cols="140" style="resize: none;margin-top: 4px;width: 99.5%;">${proposal.proposal_funds }</textarea>
					</td>
				</tr>
				<tr class="info">
					<td class="text-center" style="width: 15%;"><p style="font-size: larger; margin: 5px; margin-top: 25px;">사업 성공에 따른 인력 채용 효과 등</p></td>
					<td class="">
					<textarea id="proposal_effect" name="proposal_effect" rows="5" cols="140" style="resize: none;margin-top: 4px;width: 99.5%;">${proposal.proposal_effect }</textarea>
					</td>
				</tr>
			
			</tbody>
		</table>
		<input type="hidden" id="proposal_num" name="proposal_num" value="${proposal.proposal_num }">
		</form>
		
		<div align="right">
			<button id="modify" name="modify" class="btn btn-info" style="width: auto; font-size: larger;">완료</button>&nbsp;&nbsp;
			<button id="close" name="close" class="btn btn-danger" style="width: auto; font-size: larger;">뒤로가기</button>
		</div>
		<br>
		
		
		
		<%@ include file="/WEB-INF/views/proposal/proposalModify_js.jsp" %>
</body>
