package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

import java.util.Arrays;

public class SimpleAuthorRepository implements AuthorRepository {

    @Override
    public boolean save(Author author) {
        int countPropInArray = authors.length;
        System.out.println(Arrays.toString(authors));
        System.out.println(author.getName() + " " + author.getLastName());
        if (authors.length == 0 ) {
            authors = new Author[1];
            authors[0] = author;
        } else {
            for (int i = 0; i < authors.length; i++) {
                if (authors[i].getName().equals(author.getName()) && authors[i].getLastName().equals(author.getLastName())) {
                    break;
                } else {
                    authors = new Author[countPropInArray + 1];
                }
            }
        }

//        authors
        Author[] arraysForCopy = Arrays.copyOf(authors, authors.length);

//        System.out.println(Arrays.toString(arraysForCopy));
//        authors =  Arrays.copyOf(arraysForCopy, arraysForCopy.length)
//        System.out.println(Arrays.toString(authors));
        if (authors.length != countPropInArray) {
            authors[authors.length-1] = author;
            return true;
        }

        return false;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getName().equals(name) && authors[i].getLastName().equals(lastname)) {
                return authors[i];
            }
        }
//        for (Author element : authors) {
//            if (element.getName().equals(name) && element.getLastName().equals(lastname)) {
//                return element;
//            }
//        }

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

//    public void countInArray(){
//        System.out.println(Arrays.toString(authors));
//    }

    @Override
    public int count() {
        return authors.length;
    }

    private Author[] authors = new Author[]{};
}
