package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {

	private int board_no;			// 게시판 번호
	private int id;					// 작성자
	private String board_name;		// 게시판 이름
	private String board_use;		// 게시판 사용여부
	private Date board_date;		// 게시판 생성(작성)일시
	
	public BoardVo() {
		
	}
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_use() {
		return board_use;
	}
	public void setBoard_use(String board_use) {
		this.board_use = board_use;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
		
	@Override
	public String toString() {
		return "BoardVo [board_no=" + board_no + ", id=" + id + ", board_name="
				+ board_name + ", board_use=" + board_use + ", board_date="
				+ board_date + "]";
	}
	
	
}
