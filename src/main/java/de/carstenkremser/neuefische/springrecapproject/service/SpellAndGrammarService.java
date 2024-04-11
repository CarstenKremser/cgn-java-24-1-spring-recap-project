package de.carstenkremser.neuefische.springrecapproject.service;

import de.carstenkremser.neuefische.springrecapproject.model.OpenAiMessage;
import de.carstenkremser.neuefische.springrecapproject.model.OpenAiRequest;
import de.carstenkremser.neuefische.springrecapproject.model.OpenAiResponse;
import de.carstenkremser.neuefische.springrecapproject.model.OpenAiUsage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class SpellAndGrammarService {

    private final RestClient restClient;

    public SpellAndGrammarService(
            @Value("${OPENAI_API_URL}") String openAiApiUrl,
            @Value("${OPENAI_API_KEY}") String openAiApiKey
    ) {
        System.out.println("URL: " + openAiApiUrl);
        System.out.println("Key: " + openAiApiKey);
        restClient = RestClient.builder()
                .baseUrl(openAiApiUrl)
                .defaultHeader("Authorization", "Bearer " + openAiApiKey)
                .build();
    }

    public String improveText(String text) {
        return askOpenAi(text);
    }

    String askOpenAi(String text) {
        OpenAiResponse response = requestOpenAi(text);
        persistBillingInformation(response.usage());
        return response.choices().getFirst().message().content();
    }

    void persistBillingInformation(OpenAiUsage usage) {
        // dummy, only prints usage information on console
        System.out.println(usage);
    }

    OpenAiResponse requestOpenAi(String text) {
        return restClient
                .post()
                .body(buildRequest(text))
                .retrieve()
                .body(OpenAiResponse.class);
    }

    OpenAiRequest buildRequest(String text) {
        String question = "Check spelling and grammar for this text: " + text;
        return new OpenAiRequest(
                "gpt-3.5-turbo",
                List.of(new OpenAiMessage(
                        "user",
                        question
                ))
        );
    }
}
