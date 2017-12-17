package br.uff.util;

public enum Course {

    INFORMATION_SYSTEMS("Sistemas de Informação", "SI"),
    COMPUTER_SCIENCE("Ciência da computação",  "CC");

    private String name;
    private String abbreviation;

    Course(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
