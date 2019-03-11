package net.library.service;

import java.util.List;

import net.commons.paging.Criteria;
import net.library.domain.libraryVO;

public interface libraryService {
	void bookInsert(libraryVO libraryVO) throws Exception;
	
	//리스트 불러오기 
	List<libraryVO> listCriteria(Criteria criteria) throws Exception;
	
	// 책 삭제
	void bookDelete(int book_No) throws Exception;
	
	//책 대출
	void bookRental(int book_No,String user_Id) throws Exception;
	
	//책 반납
	void bookReturn(int book_No) throws Exception;
	 
	int count() throws Exception;
	
	int count(String skey,String sval) throws Exception;
	
	int Countbooks(String user_Id) throws Exception;
	
	List<libraryVO> listSearch(Criteria criteria) throws Exception;
	
	void updateReplyCnt(int book_No,int amount) throws Exception;
	
	libraryVO read(Integer book_No) throws Exception;
	
	List<libraryVO> rentalBooks(String user_Id) throws Exception;
}
