package oprea.constantin.service;

import oprea.constantin.entities.Curs;
import oprea.constantin.entities.Student;
import oprea.constantin.entities.User;
import oprea.constantin.exception.BadContentException;
import oprea.constantin.model.CursModel;
import oprea.constantin.model.LoginUser;
import oprea.constantin.model.StudentModel;
import oprea.constantin.repository.CursJpaRepository;
import oprea.constantin.repository.StudentJpaRepository;
import oprea.constantin.repository.UserJpaRepository;
import oprea.constantin.service.sesion.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private StudentJpaRepository studentJpaRepository;
    @Autowired
    private CursJpaRepository cursJpaRepository;
    @Autowired
    private SesionService sesionService;
    @Autowired
    private UserJpaRepository userJpaRepository;

    public void login(LoginUser loginUser){
        User user = userJpaRepository.findUserByEmail(loginUser.getEmail());
        if(user != null && user.getPassword().equals(loginUser.getPassword())){
            sesionService.setUser(user);
            System.out.println("User login");
        }else {
            throw new BadContentException("User sau parola gresita");
        }
    }

    public void addStudent(StudentModel studentModel){
        Student student = new Student();
        student.setNume(studentModel.getNume());
        student.setPrenume(studentModel.getPrenume());
        student.setVarsta(studentModel.getVarsta());
        studentJpaRepository.save(student);

    }

    public List<StudentModel> getAllStudents(){
        List<Student> students = studentJpaRepository.findAll();
        List<StudentModel> studentModels = new ArrayList<>();

        for(Student s:students){
            StudentModel studentModel = new StudentModel();
            studentModel.setNume(s.getNume());
            studentModel.setPrenume(s.getPrenume());
            studentModel.setVarsta(s.getVarsta());
            studentModels.add(studentModel);
        }
        return studentModels;
    }

    public void addCurs(CursModel cursModel){
        Curs curs = new Curs();
        curs.setDenumnire(cursModel.getDenumire());
        curs.setDataIncepere(cursModel.getDataIncepere());
        cursJpaRepository.save(curs);
    }

    public List<CursModel> getAllCourses(){
        List<Curs> courses = cursJpaRepository.findAll();
        List<CursModel> cursModels = new ArrayList<>();

        for(Curs c:courses){
            CursModel cursModel = new CursModel();
            cursModel.setDenumire(c.getDenumnire());
            cursModel.setDataIncepere(c.getDataIncepere());
            cursModels.add(cursModel);
        }

        return cursModels;
    }

    public void addStudentsToCourses(List<Integer> studentsInput,int cursId){
        Curs courses = cursJpaRepository.findCursById(cursId);
        List<Student> students = new ArrayList<>();

        List<Curs> curs = new ArrayList<>();
        curs.add(courses);

        for(Integer idStud:studentsInput){
            Student student = studentJpaRepository.findStudentById(idStud);
            student.setCourses(curs);
            students.add(student);
        }
        courses.setStudents(students);
        cursJpaRepository.save(courses);
    }

    public void updateCurs(int cursId, CursModel cursModel){
        Curs curs = cursJpaRepository.findCursById(cursId);
        if(curs == null) throw new BadContentException("datele introduse nu sunt corecte sau cursul nu exista");

        curs.setDenumnire(cursModel.getDenumire());
        curs.setDataIncepere(cursModel.getDataIncepere());
        cursJpaRepository.save(curs);
        System.out.println("Cursul " + curs + " a fost modificat" );
    }

    public List<CursModel> showCoursesWithStudents(){
        List<CursModel> cursModels = new ArrayList<>();
        List<Curs> courses = cursJpaRepository.findAll();
        for(Curs c:courses){
            CursModel cursModel = new CursModel();
            cursModel.setDenumire(c.getDenumnire());
            cursModel.setDataIncepere(c.getDataIncepere());
            List<Student> students = c.getStudents();

            List<StudentModel> studentModels = new ArrayList<>();

            for(Student s:students){
                StudentModel studentModel = new StudentModel();
                studentModel.setPrenume(s.getPrenume());
                studentModel.setNume(s.getNume());
                studentModel.setVarsta(s.getVarsta());
                studentModels.add(studentModel);

            }
            cursModel.setStudents(studentModels);
            cursModels.add(cursModel);
        }
        return cursModels;
    }

    public List<StudentModel> showStudentsWithCourses(){
        List<StudentModel> studentModels = new ArrayList<>();
        List<Student> students = studentJpaRepository.findAll();
        for(Student studentJpa:students){
            StudentModel studentModel = new StudentModel();
            studentModel.setPrenume(studentJpa.getPrenume());
            studentModel.setNume(studentJpa.getNume());
            studentModel.setVarsta(studentJpa.getVarsta());

            List<Curs> cursModels = studentJpa.getCourses();
            List<CursModel> cursModels1 = new ArrayList<>();
            for(Curs c:cursModels){
                CursModel cursModel = new CursModel();
                cursModel.setDenumire(c.getDenumnire());
                cursModel.setDataIncepere(c.getDataIncepere());
                cursModels1.add(cursModel);
            }
            studentModel.setCourses(cursModels1);
            studentModels.add(studentModel);
        }
        return studentModels;
    }

    public void deleteCurs(int cursId){
        Curs curs = cursJpaRepository.findCursById(cursId);
        cursJpaRepository.delete(curs);

    }
}
