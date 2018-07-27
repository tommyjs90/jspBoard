<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!-- Sidebar  -->
<nav id="sidebar" class="side-navbar">
	
	<!-- nav header -->
	<div class="sidebar-header"><h3>JSP BOARD</h3></div>

    <!-- nav list -->
    <ul class="list-unstyled components">
		<li><a href="/main.jsp">Home</a></li>
		<li><a href="/createBoard">Create Board</a></li>
        <li class="active">
            <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Board</a>
            <ul class="collapse list-unstyled" id="homeSubmenu">
			<c:forEach items="${boardList }" var="vo">
				<c:choose>
					<c:when test="${vo.board_use == 'Y' }">
						<li><a href="/postList?board_no=${vo.board_no }">${vo.board_name }</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
            </ul>
        </li>
    </ul>
    
</nav>
        

<script type="text/javascript">
$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});
</script>