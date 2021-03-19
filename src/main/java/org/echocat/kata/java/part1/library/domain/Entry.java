package org.echocat.kata.java.part1.library.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
abstract class Entry {

    enum EntryType {
        BOOK, MAGAZINE
    }

    private final EntryType type;
    private final String isbn;

}
