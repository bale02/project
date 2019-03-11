package net.library.persistence;

import java.util.List;

import net.commons.paging.Criteria;
import net.library.domain.libraryVO;

public interface libraryDAO {

	//책 넣어주기
	void bookInsert(libraryVO libraryVO) throws Exception;
	
	//리스트 불러오기 
	List<libraryVO> listCriteria(Criteria criteria) throws Exception;
	
	// 책 삭제
	void bookDelete(Integer book_No) throws Exception;
	
	//책 대출
	void bookRental(Integer book_No,String user_Id) throws Exception;
	
	//책 반납
	void bookReturn(Integer book_No) throws Exception;
	
	//전체 카운트
	int count() throws Exception;
	
	// 검색카운트
	int count(String skey,String sval) throws Exception;
	
	//id당 카운트
	int Countbooks(String user_Id) throws Exception;
	
	//검색리스트 불러오기
	List<libraryVO> listSearch(Criteria criteria) throws Exception;
	
	//댓글 +1 
	void updateReplyCnt(Integer book_No,int amount) throws Exception;
	
	libraryVO read(Integer book_No) throws Exception;
	
	List<libraryVO> rentalBooks(String user_Id) throws Exception;
}
