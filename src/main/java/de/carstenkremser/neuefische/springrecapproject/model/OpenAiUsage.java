package de.carstenkremser.neuefische.springrecapproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OpenAiUsage(
        @JsonProperty("prompt_tokens")
        int promptTokens,
        @JsonProperty("completion_tokens")
        int completionTokens,
        @JsonProperty("total_tokens")
        int totalTokens
) {
}