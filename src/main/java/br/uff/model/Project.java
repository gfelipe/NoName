package br.uff.model;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String name;

    private Date start;

    private Date due;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Professor professor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

}
