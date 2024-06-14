package com.book.Respo;

import java.util.List;

import com.book.BookEntity;

public interface IBook {
	public List<BookEntity> findAllRecord();

	public boolean saveBook(BookEntity entity);

	public boolean DeleteID(Integer entity);
	
	public BookEntity getBookByID(Integer BOOKID); 
	
}
