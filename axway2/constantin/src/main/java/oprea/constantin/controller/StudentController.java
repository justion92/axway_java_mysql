package oprea.constantin.controller;

import oprea.constantin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addStudentsToCourses")
public class StudentController {

    @Autowired
    private UserService userService;

    @PutMapping("/{cursId}")
    public void addStudentsToCourses(@RequestBody List<Integer> studentModels, @PathVariable("cursId") int id){
       userService.addStudentsToCourses(studentModels,id);
    }
}
