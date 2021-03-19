package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.library.domain.LibraryFacade;

public class MainApp {

    private static final String AUTHORS_CSV = "org/echocat/kata/java/part1/data/authors.csv";
    private static final String BOOKS_CSV = "org/echocat/kata/java/part1/data/books.csv";
    private static final String MAGAZINES_CSV = "org/echocat/kata/java/part1/data/magazines.csv";


    public static void main(String[] args) {
        LibraryFacade libraryFacade = new LibraryFacade();
        String authorsCsvPath = MainApp.class.getClassLoader().getResource(AUTHORS_CSV).getPath();
        String booksCsvPath = MainApp.class.getClassLoader().getResource(BOOKS_CSV).getPath();
        String magazinesCsvPath = MainApp.class.getClassLoader().getResource(MAGAZINES_CSV).getPath();
        libraryFacade.initializeLibraryDatabase(authorsCsvPath, booksCsvPath, magazinesCsvPath);

        findAllAndPrint(libraryFacade);
        findByIsbnAndPrint(libraryFacade);
    }

    protected static void findAllAndPrint(LibraryFacade libraryFacade) {
        System.out.println("\n\nAll entries:\n" + libraryFacade.prepareOverview());
    }

    private static void findByIsbnAndPrint(LibraryFacade libraryFacade) {
        System.out.println("\n\nBook by ISBM:\n" + libraryFacade.findByIsbn("1313-4545-8875"));
    }

}
