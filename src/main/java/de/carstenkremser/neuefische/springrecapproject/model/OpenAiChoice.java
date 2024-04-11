package de.carstenkremser.neuefische.springrecapproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OpenAiChoice(
        OpenAiMessage message,
        @JsonProperty("finish_reason")
        String finishReason
) {
}
