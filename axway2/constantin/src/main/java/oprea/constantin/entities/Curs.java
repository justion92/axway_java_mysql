package oprea.constantin.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
public class Curs {

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @Column(name = "denumire")
    private String denumnire;

    @Column(name = "data_incepere")
    @Temporal(TemporalType.DATE)
    private Date dataIncepere;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumnire() {
        return denumnire;
    }

    public void setDenumnire(String denumnire) {
        this.denumnire = denumnire;
    }

    public Date getDataIncepere() {
        return dataIncepere;
    }

    public void setDataIncepere(Date dataIncepere) {
        this.dataIncepere = dataIncepere;
    }

    @Override
    public String toString() {
        return denumnire ;
    }
}
