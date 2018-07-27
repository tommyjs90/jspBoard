<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- top.jsp -->
<%@ include file="/common/top.jsp" %>

<script>
$(function() {
	$("button[type=submit]").on("click", function(){
		$("#frm").submit();
	});
});
</script>

	<!-- container //-->
	<div class="container-fluid">
		<!-- row //-->
		<div class="row">
			
			<!-- left.jsp -->
			<%@ include file="/common/left.jsp" %>

			<!-- main //-->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
				<!-- post header //-->
				<div class="post-header">
					<div class="post-nav marbtm-20"><a href="/main.jsp" class="post-nav-item">HOME</a><a href="/postList?id=${boardVo.board_no }">${boardVo.board_name}</a></div>
					<h1 class="post-tit marbtm-30">${postVo.post_tit }</h1>
					<ul class="no-pad post-info">
						<li><i class="far fa-user maright-5"></i> ${postVo.std_id }</li>
						<li><i class="far fa-clock maright-5"></i> <fmt:formatDate value="${postVo.post_date }" pattern="yyyy.MM.dd hh:mm"/> </li>
					</ul>
				</div>
				<!--// post header -->

				<!-- post contents //-->
				<div class="post-contents">
				
					<!-- 글 내용 -->
					<div class="post-con-text">${postVo.post_con }</div>
					
					<!-- 첨부파일 //-->
					<div class="con-box file-box border-box">
						<h3 class="sub-tit">첨부파일 목록</h3>
						
						<ul>
							<c:forEach items="${fileList }" var="file">
							<li data-id="${file.file_no }"><a href="/fileDownload?fileName=${file.file_name }"><i class="fas fa-save"></i> ${file.file_name }</a></li>
							</c:forEach>
						</ul>
					</div>
					<!--// 첨부파일 -->
					
				</div>
				<!--// post contents -->
					
				<!-- post footer //-->
				<div class="post-footer">
						
					<!-- 댓글 //-->
					<div class="con-box reply-box border-box">
						<h3 class="sub-tit">댓글 목록</h3>
						
						<!-- 댓글 리스트 -->
						<ul class="no-pad list-disc">
							<c:forEach items="${commentList }" var="comment">
							<li data-id="${comment.comment_no }">
								<c:choose>
									<c:when test="${comment.re_del_pre == 'N'}">
										${comment.re_con} [ ${comment.std_id} / <fmt:formatDate value="${comment.re_date }" pattern="yyyy-MM-dd"/> ]
										<!-- delete btn -->
										<c:if test="${comment.id == studentVo.id }">
											<button type="button" class="reply-del-btn"><i class="fas fa-times"></i></button>
										</c:if>
									</c:when>
									<c:when test="${comment.re_del_pre == 'Y'}">
										<span class="disabled">삭제된 댓글입니다.</span>
									</c:when>
								</c:choose>
							</li>
							</c:forEach>
						</ul>
						
						<!-- 댓글 삭제 //-->
						<form id="reply-del-form" action="/commentDelete" method="post">
							<input type="hidden" id="coNo" name="comment_no">
							<input type="hidden" id="postNo" name="post_no" value="${postVo.post_no }">
						</form>
						<script type="text/javascript">
							$(function(){
								$(".reply-del-btn").on("click", function(){
									$("#coNo").val($(this).parent().data("id"));
									$("#reply-del-form").submit();
								});
							});
						</script>
						
						<!-- 댓글 등록 -->
						<form id="reply-insert-form" action="/commentInsert" method="post">
							<input type="hidden" name="post_no" value="${postVo.post_no }">
							<input type="hidden" name="id" value="${studentVo.id }">
							<div class="reply-insert-box border-box">
								<div class="col-sm-11">
									<textarea name="re_con" maxlength="500"></textarea>
								</div>
								<button type="submit" id="" class="col-sm-1 btn btn-default pull-right">댓글등록</button>
							</div>
						</form>
					</div>
					<!--// 댓글 -->
					
					<ul class="no-pad list-no post-btn">
						<c:if test="${postVo.id == studentVo.id}">
						<li><a href="/postUpdate" class="btn btn-default">수정</a></li>
						<li><a class="btn btn-default btn-delete">삭제</a></li>
						</c:if>
						<li><a href="/postAnswer" class="btn btn-default">답글</a></li>
					</ul>
					
					<form id="post-del-form" action="/postDelete" method="post">
						<input type="hidden" name="post_no" value="${postVo.post_no}">
						<input type="hidden" name="board_no" value="${postVo.board_no }">
					</form>
					<script type="text/javascript">
					$(function(){
						$(".btn-delete").click(function(){
							$("#post-del-form").submit();
						});
					});
					</script>
					
				</div>
				<!--// post footer -->
				
			</div>
			<!--// main -->
			
		</div>
		<!--// row -->
	</div>
	<!--// container -->

<!-- tail.jsp -->
<%@ include file="/common/tail.jsp" %>












