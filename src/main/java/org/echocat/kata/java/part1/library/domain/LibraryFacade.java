package org.echocat.kata.java.part1.library.domain;

import java.util.List;
import java.util.Optional;

public class LibraryFacade {

    private final LibraryService libraryService = new LibraryService();


    public List<Author> findAllAuthors() {
        return libraryService.findAllAuthors();
    }

    public void loadAuthorsDatabase(String authorsCsvPath) {
        libraryService.loadAuthorsDatabase(authorsCsvPath);
    }

    public List<Entry> findAll() {
        return libraryService.findAll();
    }

    public Optional<Entry> findByIsbn(String isbn) {
        return libraryService.findByIsbn(isbn);
    }

    public void initializeLibraryDatabase(String authorsCsvPath, String booksCsvPath, String magazinesCsvPath) {
        libraryService.initializeLibraryDatabase(authorsCsvPath, booksCsvPath, magazinesCsvPath);
    }

    public String prepareOverview() {
        return libraryService.prepareOverview();
    }

}
