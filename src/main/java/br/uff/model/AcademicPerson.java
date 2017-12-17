package br.uff.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AcademicPerson {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String name;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
