package org.echocat.kata.java.part1.library.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class LibraryService {

    private final CsvParser csvParser = new CsvParser();
    private final EntryRepository entriesRepository = new EntryRepository();
    private final AuthorRepository authorsRepository = new AuthorRepository();


    List<Author> findAllAuthors() {
        return authorsRepository.findAll();
    }

    List<Entry> findAll() {
        return entriesRepository.findAll();
    }

    Optional<Entry> findByIsbn(String isbn) {
        return entriesRepository.findByIsbn(isbn);
    }

    void initializeLibraryDatabase(String authorsCsvPath, String booksCsvPath, String magazinesCsvPath) {
        loadAuthorsDatabase(authorsCsvPath);
        loadBooksDatabase(booksCsvPath);
        loadMagazinesDatabase(magazinesCsvPath);
    }

    int loadAuthorsDatabase(String authorsCsvPath) {
        csvParser.parse(authorsCsvPath).stream()
                // TODO[TASK-ID]: use http://opencsv.sourceforge.net/ to parse and wrap values into object
                .map(value -> new Author(value[1], value[2], value[0]))
                .forEach(authorsRepository::save);
        return authorsRepository.count();
    }

    int loadBooksDatabase(String booksCsvPath) {
        csvParser.parse(booksCsvPath).stream()
                // TODO[TASK-ID]: use http://opencsv.sourceforge.net/ to parse and wrap values into object
                .map(value -> new Book(value[1], value[0], value[3], mapEmailsToAuthors(value[2])))
                .forEach(entriesRepository::save);
        return entriesRepository.count();
    }

    int loadMagazinesDatabase(String magazinesCsvPath) {
        csvParser.parse(magazinesCsvPath).stream()
                // TODO[TASK-ID]: use http://opencsv.sourceforge.net/ to parse and wrap values into object
                .map(value -> new Magazine(value[1], value[0], parseDate(value[3]), mapEmailsToAuthors(value[2])))
                .forEach(entriesRepository::save);
        return entriesRepository.count();
    }

    private LocalDate parseDate(String dateString) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(dateString, dateFormatter);
    }

    private List<Author> mapEmailsToAuthors(String emails) {
        return Arrays.stream(emails.split(","))
                .flatMap(email -> authorsRepository.findByEmail(email).stream())
                .collect(Collectors.toList());
    }

    String prepareOverview() {
        return entriesRepository.findAll().toString();
    }

}
