package org.echocat.kata.java.part1.library.domain;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
class Book extends Entry {

    private final String title;
    private final String description;
    private final List<Author> authors = new ArrayList<>();


    Book(String isbn, String title, String description, List<Author> authors) {
        super(EntryType.BOOK, isbn);
        this.title = title;
        this.description = description;
        this.authors.addAll(authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + getIsbn() + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", authors=" + authors +
                '}';
    }
}
