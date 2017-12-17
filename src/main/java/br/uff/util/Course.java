package br.uff.util;

public enum Course {

    INFORMATION_SYSTEMS("Sistemas de Informação", "SI"),
    COMPUTER_SCIENCE("Ciência da computação",  "CC");

    private String name;
    private String abreviation;

    Course(String name, String abreviation) {
        this.name = name;
        this.abreviation = abreviation;
    }

    public String getName() {
        return name;
    }

    public String getAbreviation() {
        return abreviation;
    }
}
