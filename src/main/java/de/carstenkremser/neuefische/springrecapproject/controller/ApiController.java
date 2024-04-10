package de.carstenkremser.neuefische.springrecapproject.controller;

import de.carstenkremser.neuefische.springrecapproject.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/todo")
    public List<Todo> getTodos() {
        return List.of(
                new Todo(1,"Todo1","OPEN"),
                new Todo(2,"Todo2","OPEN"),
                new Todo(3,"Todo3","OPEN")
        );
    }

    @GetMapping("/todo/1")
    public Todo getTodo1() {
        return new Todo(1,"Todo1","OPEN");
    }

    @PostMapping("/todo")
    public String todoPost(@RequestBody Todo todo) {
        System.out.println(todo);
        return "{}";
    }
}
