package com.sjh.cloud_note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjh.cloud_note.dao.BookDao;
import com.sjh.cloud_note.entity.Book;
import com.sjh.cloud_note.entity.User;
import com.sjh.cloud_note.util.NoteResult;
import com.sjh.cloud_note.util.NoteUtil;

@Service("bookService") //ɨ��spring����
@Transactional
public class BookServiceImpl implements BookService {

	@Resource
	private BookDao bookDao;
	
	public NoteResult<List<Book>> loadBooks(String userId) {
		NoteResult<List<Book>> result = new NoteResult<List<Book>>();
		
		List<Book> books = bookDao.findByUserId(userId);
		result.setStatus(0);
		result.setMsg("��ѯ�ʼǱ��ɹ�");
		result.setData(books);
		
		return result;
	}

	public NoteResult<Book> AddBook(String userId,String title) {
		Book book = new Book();
		String bookId = NoteUtil.createId();
		book.setCn_notebook_id(bookId);
		book.setCn_user_id(userId);
		book.setCn_notebook_name(title);
		book.setCn_notebook_type_id("1");
		
		bookDao.save(book);
		NoteResult<Book> result = new NoteResult<Book>();
		
		result.setStatus(0);
		result.setMsg("�ʼǱ���ӳɹ�");
		result.setData(book);	
		
		return result;
	}

}
