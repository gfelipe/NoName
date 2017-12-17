package br.uff.model;

import br.uff.util.GraduationWorkType;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

    @Enumerated(EnumType.STRING)
    private GraduationWorkType type;

    private Student student1;

    private Student student2;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Schedule> scheduleSet;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "bibliografy", cascade = CascadeType.ALL)
    private Set<Bibliografy> bibliografySet;

    @Temporal(TemporalType.DATE)
    private Date presentation;

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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public GraduationWorkType getType() {
        return type;
    }

    public void setType(GraduationWorkType type) {
        this.type = type;
    }

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }

    public Student getStudent2() {
        return student2;
    }

    public void setStudent2(Student student2) {
        this.student2 = student2;
    }

    public Set<Schedule> getScheduleSet() {
        return scheduleSet;
    }

    public void setScheduleSet(Set<Schedule> scheduleSet) {
        this.scheduleSet = scheduleSet;
    }

    public Set<Bibliografy> getBibliografySet() {
        return bibliografySet;
    }

    public void setBibliografySet(Set<Bibliografy> bibliografySet) {
        this.bibliografySet = bibliografySet;
    }

    public Date getPresentation() {
        return presentation;
    }

    public void setPresentation(Date presentation) {
        this.presentation = presentation;
    }
}
