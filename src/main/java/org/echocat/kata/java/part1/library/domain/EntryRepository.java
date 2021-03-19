package org.echocat.kata.java.part1.library.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class EntryRepository {

    private final List<Entry> inMemoryRepository = new ArrayList<>();


    List<Entry> findAll() {
        return inMemoryRepository;
    }

    void save(Entry book) {
        inMemoryRepository.add(book);
    }

    int count() {
        return inMemoryRepository.size();
    }

    Optional<Entry> findByIsbn(String isbn) {
        return inMemoryRepository.stream()
                .filter(entry -> entry.getIsbn().equals(isbn))
                .findFirst();
    }

}
