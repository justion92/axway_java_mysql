package oprea.constantin.controller;

import oprea.constantin.entities.Curs;
import oprea.constantin.entities.Student;
import oprea.constantin.model.CursModel;
import oprea.constantin.model.LoginUser;
import oprea.constantin.model.StudentModel;
import oprea.constantin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody LoginUser loginUser){
        userService.login(loginUser);
    }

    @PutMapping("/addStud")
    public void addStudent(@RequestBody StudentModel studentModel){
        userService.addStudent(studentModel);
    }

    @GetMapping("/getAllStud")
    public List<StudentModel> getAllStudents(){
        return userService.getAllStudents();
    }

    @PutMapping("/addCurs")
    public void addCurs(@RequestBody CursModel cursModel){
        userService.addCurs(cursModel);
    }

    @GetMapping("/getAllCourses")
    public List<CursModel> getAllCourses(){
        return userService.getAllCourses();
    }

    @GetMapping("/showCoursesWithStudents")
    public List<CursModel> showCoursesWithStudents(){
        return userService.showCoursesWithStudents();
    }
    @GetMapping("/showStudentsWithCourses")
    public List<StudentModel> showStudentsWithCourses(){
        return userService.showStudentsWithCourses();
    }

    @PostMapping("updateCurs/{cursId}")
    public void updateCurs(@PathVariable ("cursId") int cursId, @RequestBody CursModel cursModel){
        userService.updateCurs(cursId,cursModel);
    }

    @DeleteMapping("deleteCurs/{cursId}")
    public void deleteCurs(@PathVariable int cursId){
        userService.deleteCurs(cursId);
    }


}
