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
/*
	@Table : 엔티티 클래스를 정의할 때 엔티티 클래스와 매핑되는 테이블의 이름을 별도로 지정하지 않으면 엔티티 클래스 이름과 같은 테이블이 자동으로 매핑
	속성 					설명
	name 				매핑될 테이블 이름을 지정한다.
	catalog				데이터베이스 카탈로그를 지정한다.
	schema				데이터베이스 스키마를(schema)를 지정한다.
	uniqueConstraints	결합 unique 제약조건을 지정하며, 여러 개의 칼럼이 결합되어 유일성을 보장해야 하는 경우 사용한다.
	
	ex) @Table(name="E_BOARD", uniqueConstraints={@UniqueConstraints(columnName={"SEQ", "WRITER"})}) -> SEQ, WRITER 두개의 칼럼을 결합했을 때 유일한 값만 유지
	
	
	@Column : 엔티티 클래스의 변수와 테이블의 칼럼을 매핑할 때 사용. 일반적으로 엔티티 클래스의 변수 이름과 칼럼 이름이 다를 때 사용, 생략시 변수이름과 칼럼 이름을 동일하게 매핑
	속성 					설명
	name				칼럼 이름을 지정한다.(생략 시 프로퍼티명과 동일하게 매핑)
	unique				unique 제약조건을 추가한다(기본값:false)
	nullable			null 상태 허용 여부를 설정한다.(기본값:false)
	insertable			입력 SQL 명령어를 자동으로 생성할 때 이 칼럼을 포함할 것인지를 지정한다.(기본값:true)
	updatable			수정 SQL 명령어를 자동으로 생성할 때 이 칼럼을 포함할 것인지를 지정한다.(기본값:true)
	columnDefinition	이 칼럼에 대한 DDL 문을 직접 설정한다.
	length				문자열 타입의 칼럼 길이를 지정한다.(기본값:255) 길이제한
	precision			숫자 타입의 전체 자리수를 지정한다(기본값:0)
	scale				숫자 타입의 소수점 자리수를 지정한다.(기본값:0)
	
	@GeneratedValue : @Id로 지정된 식별자 필드에 Primary Key 값을 생성하여 저장할 때 사용한다.
	속성						설명
	strategy				자동 생성 유형을 지정한다.(GenerationType 지정)
	generator 				이미 생성된 Generator 이름을 지정한다.
	
	@Transient : 엔티티 클래스 내의 특정 변수를 영속 필드에서 제외할 때 사용 -> 제외할 변수들
	
	@Temporal : java.util.Date 타입의 날짜 데이터를 매핑할 때 사용한다. 이 때 TemporalType을 이용하면 출력되는 날짜의 형식을 지정할 수 있다.
	Temporal.TIME은 시간 정보만 출력한다. Temporal.TIMESTAMP는 날짜와 시간 정보를 모두 출력한다.
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
