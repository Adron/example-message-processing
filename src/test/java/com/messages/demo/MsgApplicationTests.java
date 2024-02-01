package com.messages.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MsgApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    // Initialize your mock objects and any necessary setup here
    @BeforeEach
    void setUp() {
    }

    @Test
    void testReceiveTextMessage() throws Exception {
        // Prepare a sample message in JSON format
        String jsonMessage = "{\"message\":\"Hello, World!\"}";

        // Perform a POST request to your endpoint
        mockMvc.perform(post("/api/msg")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonMessage))
                .andExpect(status().isOk()) // Assert that the response status is 200 OK
                .andExpect(content().string("Hi, thanks for your message.")); // Replace "expectedResponse" with the expected response from your service
    }
}
