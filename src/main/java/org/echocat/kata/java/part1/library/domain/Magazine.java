package org.echocat.kata.java.part1.library.domain;

import lombok.Getter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
class Magazine extends Entry {

    private final String title;
    private final LocalDate publishedAt;
    private final List<Author> authors = new ArrayList<>();


    Magazine(String isbn, String title, LocalDate publishedAt, List<Author> authors) {
        super(EntryType.MAGAZINE, isbn);
        this.title = title;
        this.publishedAt = publishedAt;
        this.authors.addAll(authors);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "isbn='" + getIsbn() + '\'' +
                ", title='" + title + '\'' +
                ", publishedAt=" + publishedAt +
                ", authors=" + authors +
                '}';
    }
}
