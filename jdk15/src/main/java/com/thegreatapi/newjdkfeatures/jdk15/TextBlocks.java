package com.thegreatapi.newjdkfeatures.jdk15;

public interface TextBlocks {

    String getSql();

    class jdk14 implements TextBlocks {

        @Override
        public String getSql() {
            return new StringBuilder("SELECT")
                    .append(System.lineSeparator())
                    .append("    id,").append(System.lineSeparator())
                    .append("    name,").append(System.lineSeparator())
                    .append("    date_of_birth,").append(System.lineSeparator())
                    .append("    city").append(System.lineSeparator())
                    .append("FROM person").append(System.lineSeparator())
                    .append("WHERE").append(System.lineSeparator())
                    .append("    country = ? AND").append(System.lineSeparator())
                    .append("    active = ?").append(System.lineSeparator())
                    .toString();
        }
    }

    class jdk15 implements TextBlocks {

        @Override
        public String getSql() {
            return """
                    SELECT
                        id,
                        name,
                        date_of_birth,
                        city
                    FROM person
                    WHERE
                        country = ? AND
                        active = ?
                    """;
        }
    }
}