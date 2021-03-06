package br.uff.model;

import br.uff.util.BibliographyType;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Bibliography {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BibliographyType type;

    private String title;

    private String author;

    private String year;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BibliographyType getType() {
        return type;
    }

    public void setType(BibliographyType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

