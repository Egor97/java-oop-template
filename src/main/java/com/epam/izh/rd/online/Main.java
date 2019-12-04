package com.epam.izh.rd.online;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.SimpleAuthorRepository;
import com.epam.izh.rd.online.repository.SimpleSchoolBookRepository;
import com.epam.izh.rd.online.service.SimpleSchoolBookService;

import java.time.LocalDate;
import java.util.Arrays;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Author authorFirst = new Author("John", "Lima", LocalDate.of(1974, 12, 19), "USA");
        Author authorSecond = new Author("Max", "Levin", LocalDate.of(1993, 9, 30), "Russia");
        Author authorThird = new Author("John", "Lima", LocalDate.of(1974, 12, 19), "USA");
        SchoolBook schoolBook1 = new SchoolBook(501, "Nani", "John", "Lima", LocalDate.of(1997, 7, 10));
        SchoolBook schoolBook2 = new SchoolBook(501, "Nani", "John", "Lima", LocalDate.of(1997, 7, 10));
        SchoolBook schoolBook3 = new SchoolBook(754, "Kubil", "Max", "Levin", LocalDate.of(2007, 11, 15));
        SchoolBook schoolBook4 = new SchoolBook(754, "Kubil", "Max", "Levin", LocalDate.of(2007, 11, 15));

        SimpleAuthorRepository author1 = new SimpleAuthorRepository();
        SimpleSchoolBookRepository simpleSchoolBookRepository = new SimpleSchoolBookRepository();
//
//        out.println(author1.save(authorFirst));
//        out.println(author1.save(authorSecond));
//        out.println(author1.count());

        out.println(simpleSchoolBookRepository.save(schoolBook1));
//        out.println(simpleSchoolBookRepository.count());
        out.println(simpleSchoolBookRepository.save(schoolBook4));
        out.println(simpleSchoolBookRepository.save(schoolBook2));
//
//        out.println(Arrays.toString(simpleSchoolBookRepository.findByName(schoolBook2.getName())));
//        simpleSchoolBookRepository.valuesOfArray();
//
        out.println(simpleSchoolBookRepository.save(schoolBook3));
        out.println(simpleSchoolBookRepository.removeByName(schoolBook3.getName()));
        out.println(simpleSchoolBookRepository.removeByName(schoolBook1.getName()));

        simpleSchoolBookRepository.valuesOfArray();
//        out.println(simpleSchoolBookRepository.count());
    }

}
