package com.book.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.book.BookEntity;
import com.book.Respo.IBook;

@Controller
public class BookController {
	private IBook ibook;

	public BookController(IBook ibook) {
		this.ibook = ibook;
		System.out.println("Constructer Call.....!");
	}

	@GetMapping("/viewbooks")
	public ModelAndView ViewBooks() {
		ModelAndView mav = new ModelAndView();
		List<BookEntity> list = ibook.findAllRecord();
		mav.addObject("record", list);
		mav.setViewName("index");
		return mav;
	}

	@GetMapping("/addBook")
	public ModelAndView AddBook() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", new BookEntity());
		mav.setViewName("add_book");
		return mav;
	}

	@PostMapping("/saveBook")
	public ModelAndView getBook(BookEntity entity) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", entity);
		mav.setViewName("add_book");
		System.out.println(entity);

		boolean save = ibook.saveBook(entity);
		if (save) {
			mav.addObject("succMsg", "Book Saved");
		} else {
			mav.addObject("errMsg", " Failed to save");
		}

		return mav;
	}

	@GetMapping("/delete")
	public ModelAndView deleteId(@RequestParam("BOOKID") Integer bookid) {
		ibook.DeleteID(bookid);
		ModelAndView mav = new ModelAndView();
		List<BookEntity> list = ibook.findAllRecord();
		mav.addObject("record", list);
		mav.setViewName("index");
		return mav;
	}
	@GetMapping("/edit")
	public ModelAndView editBook(@RequestParam("BOOKID") Integer bookid) {
		BookEntity bookObj = ibook.getBookByID(bookid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", bookObj);
		mav.setViewName("add_book");
		return mav;
	}
}
