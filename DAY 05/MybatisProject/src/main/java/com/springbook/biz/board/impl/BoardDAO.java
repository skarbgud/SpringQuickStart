package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.util.SqlSessionFactoryBean;

public class BoardDAO{
	
	private SqlSession mybatis;
	
	public BoardDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstace();
	}
	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);
		mybatis.commit();
	}
	
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
		mybatis.commit();
	}
	
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard", vo);
		mybatis.commit();
	}

	public BoardVO getBoard(BoardVO vo) {
		// selectOne() 메소드는 오직 하나의 데이터를 검색하는 SQL 구문
		// selectOne("XML네임스페이스.id", 파라미터 정보)
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		// selectList() 여러 개의 데이터 검색
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
}
