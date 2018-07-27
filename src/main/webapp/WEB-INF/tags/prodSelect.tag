<%@tag import="java.sql.SQLException"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>

<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="lgu" type="java.lang.String" required="true"%>

<!-- oracle DB의 student 테이블을 조회하여 화면에 출력 -->
<%

	String code = (String) jspContext.getAttribute("code");

	// DB작업에 필요한 객체 변수 선언
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;		// 쿼리문이 'select'일 경우 필요
	
	try {
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. DB접속 : Connection객체 생성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	// 현재 컴퓨터에 oracle이 설치되어 있을 때 localhost
		String user = "pc08";
		String pass = "java";
		conn = DriverManager.getConnection(url, user, pass);
		
		// 3. Statement객체 생성(Statement객체는 Connection객체를 이용해서 생성한다)
		stmt = conn.createStatement();
		
		// 4. SQL문을 Statement객체를 이용하여 실행하고 실행 결과를 ResultSet객체에 저장한다.
		String sql = "select prod_id, prod_name from prod where prod_lgu='" + lgu + "'";
		rs = stmt.executeQuery(sql);
		
		// 5. 결과 처리 : ResultSet객체에 저장되어 있는 자료를 반복문을 이용하여 차례로 읽어와 처리한다.
		out.write("<select>");
		while (rs.next()) {
			out.write("<option value=\"" + rs.getString("prod_id") + "\">" + rs.getString("prod_name") + "</option>");
		}
		out.write("</select>");
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (rs!=null) try { rs.close(); } catch (SQLException e2) {}
		if (stmt!=null) try { stmt.close(); } catch (SQLException e2) {}
		if (conn!=null) try { conn.close(); } catch (SQLException e2) {}
	}

%>