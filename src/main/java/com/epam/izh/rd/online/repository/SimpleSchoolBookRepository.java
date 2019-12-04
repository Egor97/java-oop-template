package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

import java.util.Arrays;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {

    @Override
    public boolean save(SchoolBook book) {
        if (schoolBooks.length == 0) {
            schoolBooks = new SchoolBook[1];
            schoolBooks[0] = book;
        } else {
            schoolBooks = Arrays.copyOf(schoolBooks, schoolBooks.length + 1);
            schoolBooks[schoolBooks.length - 1] = book;
        }

        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        int neededBooksInArray = 0;
        SchoolBook neededBook = null;

        for (SchoolBook element : schoolBooks) {
            if (name.equals(element.getName())) {
                neededBooksInArray += 1;
                neededBook = element;
            }
        }

        SchoolBook[] arrayForSend = new SchoolBook[neededBooksInArray];

        if (neededBooksInArray != 0) {
            Arrays.fill(arrayForSend, neededBook);
        }

        return arrayForSend;
    }

    @Override
    public boolean removeByName(String name) {
        int booksForRemove = 0;
        SchoolBook bookForSearchInArray = null;

        for (SchoolBook element : schoolBooks) {
            if (name.equals(element.getName())) {
                booksForRemove += 1;
                bookForSearchInArray = element;
            }
        }

        if (booksForRemove != 0) {
            if (booksForRemove == schoolBooks.length) {
                schoolBooks = new SchoolBook[]{};
            } else {
                for (int i = 0; i < schoolBooks.length; i++) {
                    if (bookForSearchInArray.equals(schoolBooks[i])) {
                        schoolBooks[i] = null;
                    }
                }

                for (int j = 0; j < schoolBooks.length; j++) {
                    if (schoolBooks[j] == null) {
                        for (int l = j + 1; l < schoolBooks.length; l++) {
                            schoolBooks[l - 1] = schoolBooks[l];
                            schoolBooks[l] = null;
                        }
                    }
                }

                schoolBooks = Arrays.copyOf(schoolBooks, schoolBooks.length - booksForRemove);
            }

            return true;
        }

        return false;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }

    private SchoolBook[] schoolBooks = new SchoolBook[]{};
}
