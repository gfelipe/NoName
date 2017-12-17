package br.uff.util;

public enum GraduationWorkType {

    TCC1("Trabalho de Conclusão de Curso 1", "TCC1"),
    TCC2("Trabalho de Conclusão de Curso 1", "TCC2");

    private String name;
    private String abbreviation;

    GraduationWorkType(String name, String abbreviation){
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() { return this.abbreviation; }

    public String getName(){ return this.name; }
}
