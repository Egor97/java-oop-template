package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.repository.BookRepository;
import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookService implements BookService {

    @Override
    public  boolean save(Book book) {
//        SimpleAuthorService bookAuthor = new SimpleAuthorService();
//        if (bookAuthor.findByFullName(((SchoolBook) book).getAuthorName(), ((SchoolBook) book).getAuthorLastName()).equals(true) == true){
//            return schoolBookBookRepository.save((SchoolBook) book);
//        } else {
//            return false;
//        }
        return false;
    }

    @Override
    public Book[] findByName(String name) {
        return schoolBookBookRepository.findByName(name);
    }

    @Override
    public int getNumberOfBooksByName(String name) {
        return findByName(name).length;
    }

    @Override
    public boolean removeByName(String name) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Author findAuthorByBookName(String name) {
        return null;
    }

    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;

    public SimpleSchoolBookService() {
    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }
}
