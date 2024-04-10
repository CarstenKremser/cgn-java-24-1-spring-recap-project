package de.carstenkremser.neuefische.springrecapproject.service;

import de.carstenkremser.neuefische.springrecapproject.model.Todo;
import de.carstenkremser.neuefische.springrecapproject.repo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
}
