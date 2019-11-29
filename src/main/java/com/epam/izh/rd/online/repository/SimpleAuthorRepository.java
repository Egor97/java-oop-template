package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

import java.util.Arrays;

public class SimpleAuthorRepository implements AuthorRepository {

    private Author[] authors = new Author[]{};

    @Override
    public boolean save(Author author) {
        Author[] checkLength = Arrays.copyOf(authors, authors.length);
        int value = authors.length+1;
        if (authors.length == 0) {
            authors = new Author[1];
            authors[0] = author;
        } else {
            for (int i = 0; i < authors.length; i++){
                if (authors[i].getName().equals(author.getName()) && authors[i].getLastName().equals(author.getLastName())) {
                    break;
                } else {
                    authors = new Author[value];
                    for (int j = 0; j < authors.length; j++){
                        if(authors[j] == null){
                            authors[j] = author;
                        }
                    }
                }
            }
        }
        return !Arrays.equals(checkLength, authors);
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getName().equals(name) && authors[i].getLastName().equals(lastname)) {
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getName().equals(author.getName()) && authors[i].getLastName().equals(author.getLastName())) {
                authors[i] = null;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return authors.length;
    }
}
