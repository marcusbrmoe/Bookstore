package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.Book;

@Controller
public class BookController {
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String book(Model model) {
		model.addAttribute("book", new Book());
		return "book";
	}
	
}
