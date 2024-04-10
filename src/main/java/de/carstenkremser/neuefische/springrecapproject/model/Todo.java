package de.carstenkremser.neuefische.springrecapproject.model;

import org.springframework.data.annotation.Id;

public record Todo(
        @Id
        Integer id,
        String description,
        String status
) {
}
