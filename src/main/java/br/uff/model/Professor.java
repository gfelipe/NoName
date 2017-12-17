package br.uff.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Professor extends AcademicPerson {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String siape;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor", cascade = CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }
}
