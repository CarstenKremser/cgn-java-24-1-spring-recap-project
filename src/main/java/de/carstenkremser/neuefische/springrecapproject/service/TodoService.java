package de.carstenkremser.neuefische.springrecapproject.service;

import de.carstenkremser.neuefische.springrecapproject.model.Todo;
import de.carstenkremser.neuefische.springrecapproject.repo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoWithId(Integer id) {
        return todoRepository.findById(id);

    }

    public Todo updateTodo(Todo newTodo) {
        todoRepository.save(newTodo);
        return newTodo;
    }

    public Todo createNewTodo(Todo todo) {
        int newId = findMaxId() + 1;
        Todo newTodo = new Todo(
                newId,
                todo.description(),
                todo.status()
        );
        todoRepository.save(newTodo);
        return newTodo;
    }

    private Integer findMaxId() {
        Optional<Todo> maxIdTodo = todoRepository.findTopByOrderByIdDesc();
        Integer maxId = 0;
        if (maxIdTodo.isPresent()) {
            maxId = maxIdTodo.get().id();
        }
        System.out.println("MaxId: " + maxId);
        return maxId;
    }

    public Optional<Todo> deleteTodoWithId(Integer id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        todoRepository.deleteById(id);
        return todoOptional;
    }
}
