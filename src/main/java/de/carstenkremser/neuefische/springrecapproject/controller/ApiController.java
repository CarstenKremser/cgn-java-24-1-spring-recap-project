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
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping("/todo")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createNewTodo(todo);
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable Integer id) {
        return todoService.getTodoWithId(id).get();
    }

    @PutMapping("/todo/{id}")
    public Todo updateTodoPutById(@PathVariable Integer id, @RequestBody Todo todo) {
        Todo newTodo = new Todo(
                id,
                todo.description(),
                todo.status()
        );
        return todoService.updateTodo(newTodo);
    }

    @DeleteMapping("/todo/{id}")
    public Todo deleteTodoById(@PathVariable Integer id) {
        return todoService.deleteTodoWithId(id).get();
    }
}
