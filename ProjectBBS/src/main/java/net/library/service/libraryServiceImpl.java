package net.library.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.commons.paging.Criteria;
import net.library.domain.libraryVO;
import net.library.persistence.libraryDAO;

@Transactional
@Service
public class libraryServiceImpl implements libraryService {

	@Autowired
	private final libraryDAO libraryDAO;
	
	@Inject
	public libraryServiceImpl(libraryDAO libraryDAO) {
		// TODO Auto-generated constructor stub
		this.libraryDAO = libraryDAO;
	}
	
	@Override
	public void bookInsert(libraryVO libraryVO) throws Exception {
		// TODO Auto-generated method stub
		libraryDAO.bookInsert(libraryVO);
	}

	@Override
	public List<libraryVO> listCriteria(Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return libraryDAO.listCriteria(criteria);
	}

	@Override
	public void bookDelete(int book_No) throws Exception {
		// TODO Auto-generated method stub
		libraryDAO.bookDelete(book_No);
	}

	@Override
	public void bookRental(int book_No,String user_Id) throws Exception {
		// TODO Auto-generated method stub
		libraryDAO.bookRental(book_No,user_Id);
	}

	@Override
	public void bookReturn(int book_No) throws Exception {
		// TODO Auto-generated method stub
		libraryDAO.bookReturn(book_No);
	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		return libraryDAO.count();
	}

	@Override
	public int count(String skey, String sval) throws Exception {
		// TODO Auto-generated method stub
		return libraryDAO.count(skey, sval);
	}

	@Override
	public int Countbooks(String user_Id) throws Exception {
		// TODO Auto-generated method stub
		return libraryDAO.Countbooks(user_Id);
	}

	@Override
	public List<libraryVO> listSearch(Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return libraryDAO.listSearch(criteria);
	}

	@Override
	public void updateReplyCnt(int book_No, int amount) throws Exception {
		// TODO Auto-generated method stub
		libraryDAO.updateReplyCnt(book_No, amount);
	}

	@Override
	public libraryVO read(Integer book_No) throws Exception {
		// TODO Auto-generated method stub
		return libraryDAO.read(book_No);
	}

	@Override
	public List<libraryVO> rentalBooks(String user_Id) throws Exception {
		// TODO Auto-generated method stub
		return libraryDAO.rentalBooks(user_Id);
	}


}
