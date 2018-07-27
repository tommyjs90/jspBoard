<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
					<h2 class="sub-header">
						${boardVo.board_name }
					</h2>
					<div class="table-responsive">
					
						<table id="post-list-table" class="table table-striped table-hover">
							<colgroup>
								<col width="10%">
								<col width="60%">
								<col width="10%">
								<col width="20%">
							</colgroup>
							<thead>
								<tr>
									<td>NO</td>
									<td>제목</td>
									<td>작성자</td>
									<td>작성일시</td>
								</tr>
							</thead>
							<tbody>
								<% request.setAttribute("nbsp", " "); %>
								<c:forEach items="${postList }" var="post" varStatus="status">
									<c:choose>
										<c:when test="${post.post_del_pre == 'N' }">
											<tr data-id="${post.post_no }">
												<td>${status.index+1 }</td>
												<td>${fn:replace(post.post_tit, nbsp, '&nbsp;') }</td>
												<td>${post.std_id }</td>
												<td><fmt:formatDate value="${post.post_date }" pattern="yyyy-MM-dd"/></td>
											</tr>
										</c:when>
										<c:when test="${post.post_del_pre == 'Y' }">
											<tr class="table-disabled">
												<td>${status.index+1 }</td>
												<td>삭제된 게시글 입니다.</td>
												<td>${post.std_id }</td>
												<td><fmt:formatDate value="${post.post_date }" pattern="yyyy-MM-dd"/></td>
											</tr>
										</c:when>
									</c:choose>
								</c:forEach>
							</tbody>
						</table>
						
						<!-- 게시글 상세보기 //-->
						<form id="post-list-form" action="/postDetail" method="get">
							<input type="hidden" id="pno" name="post_no">
						</form>
						<script type="text/javascript">
							$(function(){
								$("#post-list-table tbody tr[data-id]").on("click", function(){
									$("#pno").val($(this).data("id"));
									$("#post-list-form").submit();
								});
							});
						</script>
						<!--// 게시글 상세보기 -->
					</div>
					
					<form id="post-insert-btn" action="/postInsert" method="get">
						<input type="hidden" name="board_no" value="${boardVo.board_no }">
						<input type="hidden" name="id" value="${studentVo.id }">
						<button type="submit" class="btn btn-default pull-right">새글쓰기</button>
					</form>
					
					<div class="text-center">
						<ul class="pagination">
							<%=request.getAttribute("pageNavi") %>
						</ul>
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









