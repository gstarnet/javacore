package com.example.corejava;

import com.example.corejava.runner.DemoRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.SAME_THREAD)
class DemoRunnerTest {
    @Test
    void selectedTopicRunsOnlyThatTopic() {
        String output = captureRunnerOutput("strings");

        assertTrue(output.contains("Topic: strings"));
        assertTrue(output.contains("String immutability"));
        assertFalse(output.contains("Topic: oop"));
    }

    @Test
    void helpPrintsAvailableTopics() {
        String output = captureRunnerOutput("help");

        assertTrue(output.contains("Usage:"));
        assertTrue(output.contains("collections"));
        assertTrue(output.contains("concurrency"));
    }

    @Test
    void unknownTopicPrintsHelpfulMessage() {
        String output = captureRunnerOutput("missing-topic");

        assertTrue(output.contains("Unknown topic: missing-topic"));
        assertTrue(output.contains("Usage:"));
    }

    private static String captureRunnerOutput(String argument) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (PrintStream capture = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            System.setOut(capture);
            DemoRunner.main(new String[]{argument});
        } finally {
            System.setOut(originalOut);
        }

        return output.toString(StandardCharsets.UTF_8);
    }
}
