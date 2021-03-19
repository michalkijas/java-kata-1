package org.echocat.kata.java.part1.library.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
class Author {

    private final String firstName;
    private final String lastName;
    // TODO: create Email type
    private final String email;


    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
