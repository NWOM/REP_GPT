package dev.sagnik;

public record ChatGptResponseChoices(String text,int index,Object logprobs,String finish_reason) {
}
