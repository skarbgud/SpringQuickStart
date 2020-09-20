package com.springbook.biz.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BoardServiceClient {
	public static void main(String[] args) {
		/*
			JPA 구조
			1. Persistence 클래스를 이용하여 영속성 유닛 정보가 저장된 JPA 메인 환경 설정 파일(persistence.xml)을 로딩한다.
			2. 이 설정 정보를 바탕으로 EntityManager를 생성하는 공장 기능의 EntityManagerFactory 객체를 생성한다.
			3. 이제 EntityManagerFactory로부터 필요한 EntityManager를 얻어서 사용
		 */
		
		
		
		//	EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		//	Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			// Transaction 시작
			tx.begin();
			
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요");
			
			// 글 등록
			em.persist(board);
			
			
			/*
				메소드 											기능 설명
				persist(Object entity) 							엔티티를 영속화한다.(INSERT)
				merge(Object entity) 							준영속 상태의 엔티티를 영속화한다.(UPDATE)
				remove(Object entity) 							영속 상태의 엔티티를 제거한다.(DELETE)
				find(Class<T> entityClass, Object primaryKey)	하나의 엔티티를 검색한다.(SELECT ONE)
				createQuery(String qlString, Class<T> resultClass) JPQL에 해당하는 엔티티 목록을 검색한다.(SELECT LIST)
			 */
			
			// 글 목록 조회
			String jpql = "select b from Board b order by b.seq desc";	// JPQL(JPA 고유의 쿼리 구문)
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			
			for(Board brd : boardList) {
				System.out.println("---> "+brd.toString());
			}
			// Transaction commit
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Transaction rollback
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
