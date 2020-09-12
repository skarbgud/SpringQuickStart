package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")	// 세션에 모델 객체 저장
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	/*
		@ModelAttriute를 Controller 메소드의 매개변수로 선언된 Command 객체의 이름으로 변경할 때 사용
		Command 객체의 이름을 변경할 목적으로 @ModelAttribute를 사용할 수 있지만, View(jsp)에서 사용할 데이터를 설정하는 용도로도 사용
		할 수도 있다.
		@ModelAttriute가 설정된 메소드는 @RequestMapping 어노테이션이 적용된 메소드보다 먼저 호출된다.
		그리고 @ModelAttriute 메소드 실행 결과로 리턴된 객체는 자동으로 Model에 저장된다.
		따라서 @ModelAttriute 메소드의 실행 결과로 리턴된 객체는 View 페이지에서 사용할 수 있다.
	 */
	
	
	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/SpringFileUpload/" + fileName));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	/*	MultipartFile 인터페이스 제공 메소드
		String getOriginalFilename() - 업로드한 파일명을 문자열로 리턴
		void transferTo(File destFile) - 업로드한 파일을 destFile에 저장
		boolean isEmpty() - 업로드한 파일 존재 여부 리턴(없으면 true 리턴)	
	 */
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {	//@ModelAttribute("board")를 해석하여 세션에 board로 저장된 객체를 찾는다.
		System.out.println("번호 : "+ vo.getSeq());
		System.out.println("제목 : "+ vo.getTitle());
		System.out.println("작성자 : "+ vo.getWriter());
		System.out.println("내용 : "+ vo.getContent());
		System.out.println("등록일 : "+ vo.getRegDate());
		System.out.println("조회수 : "+ vo.getCnt());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제 
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("getBoard.do") 	
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board",boardService.getBoard(vo));	//Model 정보 저장 => 여기서 board라는 이름으로 vo객체가  @SessionAttribute 때문에 세션에 저장된다.
		return "getBoard.jsp";//View 정보 저장
	}
	
	// 글 목록 검색
	@RequestMapping("getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {	// required 파리미터 생략 여부
		// Null Check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		// Model 정보 저장
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp"; //View 정보 저장
	}
}
