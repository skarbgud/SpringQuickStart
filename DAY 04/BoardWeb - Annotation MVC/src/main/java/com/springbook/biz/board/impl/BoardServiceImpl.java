package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
//	private BoardDAOSpring boardDAO;
	private BoardDAO boardDAO;	// 기존의 DAO 클래스를 수정하여도 BoardController를 수정할 필요가 없다.
	
	@Override
	public void insertBoard(BoardVO vo) {
//		if(vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//		}
		boardDAO.insertBoard(vo); // 100번 글 등록 성공
		boardDAO.insertBoard(vo); // Exception 발생
		
		// 첫번째 입력은 성공하지만, BOARD 테이블에 SEQ 컬럼이 기본 키로 지정되어 있으므로 두 번째 입력에서 예외가 발생한다.
		// 하지만 트랜잭션은 메소드 단위로 관리되므로 발생한 예외로 인해 BoardServiceImpl 클래스의 insertBoard() 메소드의 작업 결과는 모두 롤백(Rollback) 처리된다.
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
