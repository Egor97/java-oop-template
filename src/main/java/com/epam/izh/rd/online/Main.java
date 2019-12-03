package com.epam.izh.rd.online;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.repository.SimpleAuthorRepository;

import java.time.LocalDate;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Author authorFirst = new Author("John", "Lima", LocalDate.of(1974, 12, 19), "USA");
        Author authorSecond = new Author("Max", "Levin", LocalDate.of(1993, 9, 30), "Russia");
        Author authorThird = new Author("John", "Lima", LocalDate.of(1974, 12, 19), "USA");

        SimpleAuthorRepository author1 = new SimpleAuthorRepository();

        out.println(author1.save(authorFirst));
        out.println("-------------");
        out.println(author1.findByFullName(authorFirst.getName(), authorFirst.getLastName()));
        out.println(author1.findByFullName(authorSecond.getName(), authorSecond.getLastName()));
        out.println(author1.count());
        out.println(author1.save(authorThird));
        out.println("-------------");
        out.println(author1.findByFullName(authorThird.getName(), authorThird.getLastName()));
        out.println(author1.count());
        out.println(author1.save(authorSecond));
        out.println("-------------");
        out.println(author1.findByFullName(authorSecond.getName(), authorSecond.getLastName()));
        out.println(author1.count());
        author1.valueOfArray();


    }

}
