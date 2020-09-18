package com.springbook.biz.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity	// @Entity가 설정된 클래스를 엔티티 클래스라고 하며, @Entity가 붙은 클래스는 테이블과 매핑된다.
@Table(name = "BOARD")	// 엔티티와 관련된 테이블을 매핑한다. name 속성을 사용하며 BOARD 테이블과 매핑했는데 클래스 이름이 테이블 이름과 매핑된다.
public class Board{
	@Id	// 엔티티 클래스의 필수 어노테이션으로서, 테이블의 기본 키와 매핑한다. 예제에서는 seq 변수를 테이블의 SEQ 칼럼과 매핑했다. @Id가 없는 엔티티 클래스는 JPA가 처리하지 못한다.
	@GeneratedValue
	private int seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)	// 날짜 타입의 변수에 선언하여 날짜 타입을 매핑할 때 사용. TemporalType의 DATE, TIME, TIMESTAMP 중 하나 선택할 수 있다.
	private Date regDate = new Date();
	private int cnt;
	
	// Getter/Setter 메소드
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}
}
