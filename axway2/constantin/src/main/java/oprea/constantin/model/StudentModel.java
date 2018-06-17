package oprea.constantin.model;

import java.util.List;

public class StudentModel {
    private String nume;

    private String prenume;

    private int varsta;

    private List<CursModel> courses;

    public List<CursModel> getCourses() {
        return courses;
    }

    public void setCourses(List<CursModel> courses) {
        this.courses = courses;
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
