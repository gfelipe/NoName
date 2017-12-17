package br.uff.model;

import br.uff.util.Course;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Student extends AcademicPerson {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private Course course;
    private String grade;
    private String enrollment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
