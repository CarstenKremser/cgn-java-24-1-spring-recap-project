package de.carstenkremser.neuefische.springrecapproject.controller;

import de.carstenkremser.neuefische.springrecapproject.dto.TodoDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/todo")
    public List<TodoDto> getTodos() {
        return List.of(
                new TodoDto(1,"Todo1","OPEN"),
                new TodoDto(2,"Todo2","OPEN"),
                new TodoDto(3,"Todo3","OPEN")
        );
    }

    @GetMapping("/todo/1")
    public TodoDto getTodo1() {
        return new TodoDto(1,"Todo1","OPEN");
    }

    @PostMapping("/todo")
    public String todoPost(@RequestBody TodoDto todo) {
        System.out.println(todo);
        return "{}";
    }
}
