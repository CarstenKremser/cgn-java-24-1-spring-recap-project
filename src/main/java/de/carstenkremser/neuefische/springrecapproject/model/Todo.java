package de.carstenkremser.neuefische.springrecapproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Todo")
public record Todo(
        @Id
        Integer id,
        String description,
        TodoStatus status
) {
}
