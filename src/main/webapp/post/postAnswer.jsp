<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
					<h2 class="sub-header marbtm-30">
						${boardVo.board_name }
					</h2>
					
					<form id="post-insert-form" action="/postAnswer" method="post" role="form" enctype="multipart/form-data">
						<div class="table-responsive">
						
							<!-- set parameter -->
							<input type="hidden" name="board_no" value="${boardVo.board_no }">
							<input type="hidden" name="id" value="${studentVo.id }">
							<input type="hidden" name="post_no" value="${postVo.post_no }">
							<input type="hidden" name="gno" value="${postVo.gno }">
						
							<!-- title -->
							<div class="form-group marbtm-30">
								<label for="inputTit">TITLE</label>
								<input type="text" name="post_tit" id="inputTit" class="post-input" placeholder="글 제목을 입력하세요">
							</div>
							
							<!-- contents -->
							<div class="form-group marbtm-30">
								<label for="smarteditor">CONTENTS</label>
								<textarea name="post_con" id="smarteditor" rows="10" cols="100" style="width:100%; height:412px;"></textarea> 
							</div>
							
							<!-- text editor scirpt -->
							<script src="/SE2/js/HuskyEZCreator.js"></script>
							<script type="text/javascript">
							var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.
							
							$(document).ready(function() {
								// Editor Setting
								nhn.husky.EZCreator.createInIFrame({
									oAppRef : oEditors, // 전역변수 명과 동일해야 함.
									elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
									sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
									fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
									htParams : {
										// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
										bUseToolbar : true,
										// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
										bUseVerticalResizer : true,
										// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
										bUseModeChanger : true, 
									}
								});

								// 등록 버튼 클릭이벤트
								$("button[type=submit]").click(function(){
									// id가 smarteditor인 textarea에 에디터에서 대입
									oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
								});
							});
							</script>
							
							<!-- file -->
							<div class="form-group post-file-box">
								<label for="inputFile" class="maright-10">파일 업로드</label>
								<input type="button" id="addFile" class="file-btn border-box" value="+">
								<input type="button" id="removeFile" class="file-btn border-box" value="-">
								
								<div class="hidden alert alert-danger" role="alert">
									<span class="alert-txt"></span>
									<button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								</div>
								
								<!-- file upload list -->
								<ul class="list-group file-list">
									<li><input type="file" name="file-1" class="btn btn-default" style="display:inline-block"></li>
								</ul>
								<input type="hidden" name="list-size" id="listSize">
							</div>
							
							<!-- 첨부파일 추가/삭제 버튼 클릭이벤트 -->
							<script type="text/javascript">
								$(function(){
									var listSize = $(".file-list").length;
									var fileName = 2;
									
									// size value 초기값
									$("#listSize").val(listSize);
									
									// add btn clicked
									$("#addFile").click(function(){
										if(listSize < 5) {
											$("ul.file-list").append("<li><input type=\"file\" name=\"file-" + fileName + "\" class=\"btn btn-default\" style=\"display:inline-block\"></li>");
											listSize++;
											fileName++;
											
											// size value
											$("#listSize").val(listSize);
										} else {
											$(".alert-txt").html("첨부파일은 5개까지만 추가 가능합니다.");
											$(".alert").removeClass("hidden");
											$(".alert").addClass("show");
										}
									});
									
									// remove btn clicked
									$("#removeFile").click(function(){
										if(listSize > 1) {
											$("ul.file-list li:last").remove();
											listSize--;
											fileName--;
											
											// size value
											$("#listSize").val(listSize);
										}
									});
									
									// alert close btn
									$(".close").click(function(){
										$(this).parent().removeClass("show");
										$(this).parent().addClass("hidden");
									});
								});
							</script>
							
						</div>
						
						<div class="center-block">
							<button type="submit" class="btn btn-primary">등록</button>
							<a href="javascript:history.go(-1)" id="cancelBtn" class="btn btn-danger">취소</a>
						</div>
						
					</form>
					
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









