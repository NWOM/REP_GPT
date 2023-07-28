package dev.sagnik;
//A record allows to write more concise class it is an immutable class
//so we are going to create the instance of this using the constructor
//This record will generally contains what a request looks like so it contains model ,prompt,temperture,MAX TOKEN
public record ChatGptRequest(String model,String prompt,int temperature,int max_token) {
}
