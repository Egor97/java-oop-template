package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

import java.util.Arrays;

public class SimpleAuthorRepository implements AuthorRepository {

    @Override
    public boolean save(Author author) {
        SimpleAuthorRepository checkAuthor = new SimpleAuthorRepository();

        if (checkAuthor.findByFullName(author.getName(), author.getLastName()) == author) {
            return false;
        } else {
            Author[] arrayForCopy = Arrays.copyOf(authors, authors.length+1);
            authors = new Author[authors.length+1];
            authors = Arrays.copyOf(arrayForCopy, arrayForCopy.length);
            authors[authors.length-1] = author;
            return true;
        }
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (Author element : authors) {
            if (element.getName().equals(name) && element.getLastName().equals(lastname)) {
                return element;
            }
        }

        return null;
    }

    @Override
    public boolean remove(Author author) {
        Author[] checkLength = Arrays.copyOf(authors, authors.length);
        int valueOfIndexArray = 0;

        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getName().equals(author.getName()) && authors[i].getLastName().equals(author.getLastName())) {
                valueOfIndexArray = i;
                authors[i] = null;
                checkLength = new Author[authors.length-1];
            }
        }

        if (!Arrays.equals(checkLength, authors)) {
            for (int i = valueOfIndexArray; i < authors.length-1; i++){
                authors[i-1] = authors[i];
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int count() {
        return authors.length;
    }

    private Author[] authors = new Author[]{};
}
