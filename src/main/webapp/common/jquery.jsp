<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/js/jquery-1.12.4.js"></script>
<script src="/js/js.cookie.js"></script>

<!-- login cookie set script -->
<script type="text/javascript">
function getCookie(name){
	var cookies = document.cookie;
	
	var cookieArr = cookies.split("; ");
	var cookieResult = "";
	
	for(var i in cookieArr){
		var cookie = cookieArr[i];
		var cookieNameValue = cookie.split("=");
		
		var cookieName = cookieNameValue[0];
		var cookieValue = cookieNameValue[1];
		
		if(name == cookieName){
			cookieResult = cookieValue;
			break;
		}
	}
 	return cookieResult;
}
   
// 쿠키 추가
function setCookie(cookieName, cookieValue, expires){
	var dt = new Date();
	dt.setDate(dt.getDate() + parseInt(expires));
	document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + dt.toGMTString();
}

// 쿠키 삭제
function deleteCookie(cookieName){
	setCookie(cookieName, "", -1);
}

// 문서 로딩 완료후 실행
$(function(){
   	if(getCookie("rememberMe") == "y") {
   		// userId input에 userId cookie 값을 설정
   		$("#userId").val(getCookie("userId"));
   		$("#rememberMe").attr("checked", true);
   		$("#rememberMe").val(getCookie("rememberMe"));
   	}
   	
   	// rememberMe 체크박스 클릭이벤트
   	$("#rememberMe").on("click", function(){
   		if($(this).is(":checked")){
   			//rememberMe cookie 설정
   			setCookie("rememberMe", "y", 30);
   			setCookie("userId", $("#userId").val(), 30);
   		} else {
   			//쿠키 제거
   			deleteCookie("rememberMe");
   		}
   	});
});
</script>
