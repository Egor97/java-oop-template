package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

import java.util.Arrays;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {

    @Override
    public boolean save(SchoolBook book) {
        SchoolBook[] schoolBooksSaving = schoolBooks.clone();

        schoolBooks = new SchoolBook[schoolBooks.length + 1];
        schoolBooks[schoolBooks.length - 1] = book;

        return !Arrays.equals(schoolBooksSaving, schoolBooks);
    }

    @Override
    public SchoolBook[] findByName(String name) {
        int value = 0;
        SchoolBook[] findBooksByName = new SchoolBook[]{};
        for (int i = 0; i < schoolBooks.length; i++) {
            if (schoolBooks[i].getName().equals(name)) {
                value += 1;
                findBooksByName = new SchoolBook[value];
                findBooksByName[value-1] = schoolBooks[i];
            }
        }
        return findBooksByName;
    }

    @Override
    public boolean removeByName(String name) {
        int key = Arrays.binarySearch(schoolBooks, name);

        if (key == -1) {
            return false;
        } else {
            schoolBooks[key] = null;
            for (int i = key; i < schoolBooks.length; i++) {
                schoolBooks[key -1] = schoolBooks[key];
            }
            return true;
        }
    }

    @Override
    public int count() {
        return 0;
    }

    private SchoolBook[] schoolBooks = new SchoolBook[]{};
}
