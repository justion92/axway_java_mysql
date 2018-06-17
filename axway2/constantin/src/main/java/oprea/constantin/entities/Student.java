package oprea.constantin.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    private List<Curs> courses;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "varsta")
    private int varsta;

    public List<Curs> getCourses() {
        return courses;
    }

    public void setCourses(List<Curs> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
