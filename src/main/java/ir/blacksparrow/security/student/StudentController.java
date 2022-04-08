package ir.blacksparrow.security.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private static final List<Student> STUDENT_LIST = Arrays.asList(
            new Student(1, "Frank Jones"),
            new Student(2, "Muhammad Ali Kelley"),
            new Student(3, "Will Smith")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENT_LIST.stream()
                .filter(x-> x.id().equals(studentId))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("there is no student with this id!"));
    }
}
