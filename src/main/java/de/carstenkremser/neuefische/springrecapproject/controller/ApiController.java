package de.carstenkremser.neuefische.springrecapproject.controller;

import de.carstenkremser.neuefische.springrecapproject.model.Todo;
import de.carstenkremser.neuefische.springrecapproject.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final TodoService todoService;

    @GetMapping("/todo")
    public List<Todo> getTodos() {
        return todoService.findAll();
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
