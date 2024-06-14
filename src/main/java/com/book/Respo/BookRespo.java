package com.book.Respo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.BookEntity;

public interface BookRespo extends JpaRepository<BookEntity, Integer> {
	public List<BookEntity> findBystatus(Character s);

}
