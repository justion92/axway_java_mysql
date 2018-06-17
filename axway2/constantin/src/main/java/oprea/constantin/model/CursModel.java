package oprea.constantin.model;

import java.util.Date;
import java.util.List;

public class CursModel {

    private String denumire;

    private Date dataIncepere;

    private List<StudentModel> students;

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Date getDataIncepere() {
        return dataIncepere;
    }

    public void setDataIncepere(Date dataIncepere) {
        this.dataIncepere = dataIncepere;
    }
}
