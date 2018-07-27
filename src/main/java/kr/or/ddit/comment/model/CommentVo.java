package kr.or.ddit.comment.model;

import java.util.Date;

public class CommentVo {
	
	private int comment_no;			// 댓글 번호
	private int post_no;			// 게시글 번호
	private int id;					// 작성자
	private String re_con;			// 댓글 내용
	private Date re_date;			// 작성일시
	private String re_del_pre;		// 댓글 삭제여부
	private String std_id;			// 작성자의 id명
	
	public CommentVo() {
		
	}

	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRe_con() {
		return re_con;
	}

	public void setRe_con(String re_con) {
		this.re_con = re_con;
	}

	public Date getRe_date() {
		return re_date;
	}

	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}

	public String getRe_del_pre() {
		return re_del_pre;
	}

	public void setRe_del_pre(String re_del_pre) {
		this.re_del_pre = re_del_pre;
	}

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	@Override
	public String toString() {
		return "CommentVo [comment_no=" + comment_no + ", post_no=" + post_no
				+ ", id=" + id + ", re_con=" + re_con + ", re_date=" + re_date
				+ ", re_del_pre=" + re_del_pre + ", std_id=" + std_id + "]";
	}

}
