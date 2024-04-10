package de.carstenkremser.neuefische.springrecapproject.dto;

public record TodoDto(
        int id,
        String description,
        String status // sollte Enum sein: es gibt: OPEN
) {
}
