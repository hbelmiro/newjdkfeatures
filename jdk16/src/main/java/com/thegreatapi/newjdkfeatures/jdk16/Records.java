package com.thegreatapi.newjdkfeatures.jdk16;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@SuppressWarnings("unused")
public interface Records {

    class Jdk15 {
        static class Person {
            private final String name;
            private final LocalDate dateOfBirth;
            private final String country;

            Person(String name, LocalDate dateOfBirth, String country) {
                this.name = name;
                this.dateOfBirth = dateOfBirth;
                this.country = country;
            }

            public String getName() {
                return name;
            }

            public LocalDate getDateOfBirth() {
                return dateOfBirth;
            }

            public String getCountry() {
                return country;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Person person = (Person) o;
                return name.equals(person.name)
                        && dateOfBirth.equals(person.dateOfBirth)
                        && country.equals(person.country);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, dateOfBirth, country);
            }

            @Override
            public String toString() {
                return "Person[" +
                        "name=" + name +
                        ", dateOfBirth=" + dateOfBirth +
                        ", country=" + country +
                        ']';
            }
        }
    }

    class ProjectLombok {
        @AllArgsConstructor
        @ToString
        @EqualsAndHashCode
        static class Person {
            @Getter private final String name;
            @Getter private final LocalDate dateOfBirth;
            @Getter private final String country;
        }
    }

    class Jdk16 {
        static record Person(String name, LocalDate dateOfBirth, String country) {
        }
    }
}