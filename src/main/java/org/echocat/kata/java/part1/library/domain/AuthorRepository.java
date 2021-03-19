package org.echocat.kata.java.part1.library.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class AuthorRepository {

    private final List<Author> inMemoryRepository = new ArrayList<>();


    List<Author> findAll() {
        return inMemoryRepository;
    }

    int count() {
        return inMemoryRepository.size();
    }

    void save(Author author) {
        inMemoryRepository.add(author);
    }

    Optional<Author> findByEmail(String email) {
        return inMemoryRepository.stream()
                .filter(author -> author.getEmail().equals(email))
                .findFirst();
    }

}
