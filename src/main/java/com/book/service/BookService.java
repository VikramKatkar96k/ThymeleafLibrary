package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.BookEntity;
import com.book.Respo.BookRespo;
import com.book.Respo.IBook;

@Service
public class BookService implements IBook {
	@Autowired
	private BookRespo bookRespo;

	@Override
	public List<BookEntity> findAllRecord() {
		return bookRespo.findBystatus('Y');
	}

	@Override
	public boolean saveBook(BookEntity entity) {
		BookEntity book = bookRespo.save(entity);
		entity.setStatus('Y');
		bookRespo.save(entity);
		if (book.getBOOKID() != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean DeleteID(Integer BOOKID) {
		// hard Delete
		// bookRespo.deleteById(BOOKID);

		// Soft Delete
		Optional<BookEntity> findById = bookRespo.findById(BOOKID);
		if (findById.isPresent()) {
			BookEntity entity = findById.get();
			entity.setStatus('N');
			bookRespo.save(entity);
		}
		return true;
	}
	@Override
	public BookEntity getBookByID(Integer BOOKID) {
		Optional<BookEntity> findById = bookRespo.findById(BOOKID);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
}
