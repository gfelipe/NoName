package br.uff.util;

public enum BibliographyType {
    ARTIGOINTERNET("Artigo da Internet"),
    CDROM("CD-Rom"),
    COMUNICACAOORAL("Comunicação Oral"),
    DICIONARIO("Dicionário"),
    DISSERTACAO("Dissertação"),
    DOCUMENTOELETRONICO("Documento Eletrônico"),
    EMAIL("E-Mail"),
    ENCICLOPEDIA("Enciclopédia"),
    ENTREVISTA("Entrevista"),
    EVENTO("Evento científico"),
    JORNAL("Artigo de Jornal"),
    LEGISLACAO("Legislação"),
    LIVRO("Livro"),
    PERIODICO("Periódico"),
    PROGRAMATVRADIO("Programa de TV/Rádio"),
    REVISTA("Artigo de Revista"),
    SITE("Site de Internet"),
    TESE("Tese"),
    TEXTO("Texto digitado");

    private String tipo;

    BibliographyType(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }
}
