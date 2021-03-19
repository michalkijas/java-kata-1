package org.echocat.kata.java.part1.library.domain

import spock.lang.Specification

import javax.swing.text.html.parser.Entity

class LibraryFacadeSpec extends Specification {

    def "should return empty library collection when no initialization was provide"() {
        given:
            LibraryFacade sut = new LibraryFacade()
        when:
            List<Entry> result = sut.findAll()
        then:
            result.isEmpty()
    }

    def "should load authors data"() {
        given:
            LibraryFacade sut = new LibraryFacade()
            String authorsCsvPath = getClass().getClassLoader().getResource(TestResources.AUTHORS_CSV).getPath()
            sut.loadAuthorsDatabase(authorsCsvPath)
        when:
            List<Author> result = sut.findAllAuthors()
        then:
            result != null
            result.size() == 6
    }

    def "should load books and magazines data"() {
        given:
            LibraryFacade sut = new LibraryFacade()
            String authorsCsvPath = getClass().getClassLoader().getResource(TestResources.AUTHORS_CSV).getPath()
            String booksCsvPath = getClass().getClassLoader().getResource(TestResources.BOOKS_CSV).getPath()
            String magazinesCsvPath = getClass().getClassLoader().getResource(TestResources.MAGAZINES_CSV).getPath()
            sut.initializeLibraryDatabase(authorsCsvPath, booksCsvPath, magazinesCsvPath)
        when:
            List<Entity> result = sut.findAll()
        then:
            result != null
            result.size() == 14
    }

}
