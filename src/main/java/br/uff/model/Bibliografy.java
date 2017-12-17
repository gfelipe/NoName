package br.uff.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Bibliografy {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Enumerated
    private Enum BibliografyType;



}
