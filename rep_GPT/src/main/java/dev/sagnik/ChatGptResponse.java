package dev.sagnik;

public record ChatGptResponse (  String id,
        String object,
        int created,
        String model,
        ChatGptResponseChoices[] choices,ChatGptResponseUsage usage) {


}
