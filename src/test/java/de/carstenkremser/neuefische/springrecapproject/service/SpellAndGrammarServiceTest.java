package de.carstenkremser.neuefische.springrecapproject.service;

import de.carstenkremser.neuefische.springrecapproject.model.OpenAiResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.io.IOException;

@SpringBootTest
class SpellAndGrammarServiceTest {

    private static MockWebServer mockWebServer;
    private static String openAiApiUrl;
    private static String openAiApiKey;

    @BeforeAll
    static void setUp() throws IOException {
        // set up mock webserver
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        // tear down mock webserver
        mockWebServer.shutdown();
    }

    @DynamicPropertySource
    static void dynamicProperty(DynamicPropertyRegistry registry) {
        openAiApiUrl = mockWebServer.url("").toString();
        openAiApiKey = "";
        registry.add("OPENAI_API_URL", () -> openAiApiUrl);
        registry.add("OPENAI_API_KEY", () -> openAiApiKey);
    }

    @Test
    void requestOpenAi() {
        SpellAndGrammarService spellAndGrammarService = new SpellAndGrammarService(openAiApiUrl, openAiApiKey);
        mockWebServer.enqueue(new MockResponse()
                .setBody("""
                        {
                            "id": "chatcmpl-abc123",
                            "object": "chat.completion",
                            "created": 1677858242,
                            "model": "gpt-3.5-turbo-0613",
                            "usage": {
                                "prompt_tokens": 13,
                                "completion_tokens": 7,
                                "total_tokens": 20
                            },
                            "choices": [
                                {
                                    "message": {
                                        "role": "assistant",
                                        "content": "This is a test!"
                                    },
                                    "logprobs": null,
                                    "finish_reason": "stop",
                                    "index": 0
                                }
                            ]
                        }
                        """)
                .addHeader("Content-Type", "application/json"));
        OpenAiResponse actual =  spellAndGrammarService.requestOpenAi("Hello world!");

        Assertions.assertNotNull(actual);
        Assertions.assertNotNull(actual.choices());
        Assertions.assertNotNull(actual.choices().getFirst());
        Assertions.assertNotNull(actual.choices().getFirst().message());
        Assertions.assertNotNull(actual.choices().getFirst().message().content());
    }
}