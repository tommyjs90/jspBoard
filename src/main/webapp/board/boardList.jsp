<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- top.jsp -->
<%@ include file="/common/top.jsp" %>

<!-- container //-->
<div class="container-fluid">
	<div class="row">
			
		<!-- left.jsp -->
		<%@ include file="/common/left.jsp" %>
		
		<!-- main //-->
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			<div class="row">
				<!-- blog-main //-->
				<div class="col-sm-8 blog-main">
					<h2 class="sub-header">게시판 생성</h2>
					
					<div class="table-responsive">
					
						<!-- insert(create) board form //-->
						<form id="create-board-form" class="form-horizontal" role="form" action="/boardInsert" method="post">
							<input type="hidden" name="id" value="${studentVo.id }">
							<table class="table table-striped">
								<tr>
									<td>게시판이름</td>
									<td><input type="text" name="board_name"></td>
									<td>
										<select name="board_use">
											<option value="Y" name="Y">사용</option>
											<option value="N" name="N">미사용</option>
										</select>
									</td>
									<td><a id="btnCreate" class="btn btn-default pull-right">생성</a></td>
									<%--<td><fmt:formatDate value="${vo.reg_dt }" pattern="yyyy-MM-dd"/></td> --%>
								</tr>
							</table>
						</form>
						<script type="text/javascript">
							$(function(){
								$("#btnCreate").on('click', function(){
									$("#create-board-form").submit();
								});
							});
						</script>
						<!--// insert(create) board form -->
						
						<c:forEach items="${boardList }" var="vo">
						<form id="board-list-form" class="form-horizontal" role="form" action="/boardUpdate" method="post">
							<input type="hidden" name="brd_id" value="${studentVo.id }">
							<table class="table table-striped">
								<tr>
									<td>
										게시판이름
										<input type="hidden" name="brd_no" value="${vo.board_no }">
									</td>
									<td><input type="text" name="brd_name" value="${vo.board_name}"></td>
									<td>
										<select name="brd_use">
											<option value="Y" ${vo.board_use == 'Y' ? 'selected' : '' }>사용</option>
											<option value="N" ${vo.board_use == 'N' ? 'selected' : '' }>미사용</option>
										</select>
									</td>
									<td><a id="btnUpdate" class="btn btn-default pull-right">수정</a></td>
								</tr>
							</table>
						</form>
						<script type="text/javascript">
							$(function(){
								$("#btnUpdate").on('click', function(){
									$("#board-list-form").submit();
								});
							});
						</script>
						</c:forEach>
						
					</div>
					
				</div>
				<!--// blog-main -->
			</div>
			
		</div>
		<!--// main -->
		
	</div>
	<!--// row -->
</div>
<!--// container -->

<!-- tail.jsp -->
<%@ include file="/common/tail.jsp" %>