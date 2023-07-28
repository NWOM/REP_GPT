# ReGPT Application

The ReGPT Application is a Java Swing-based Graphical User Interface (GUI) that allows users to interact with the OpenAI GPT-3 API to generate responses for a given prompt.

## How to Use

1. Clone or download the source code from the repository.
2. Ensure you have Java Development Kit (JDK) installed on your system.
3. Open the project in your preferred Java IDE.
4. Run the `re_GPT` class, and the GUI window will open.
5. Enter a string in the text field and click the "Generate Response" button.
6. The application will make an API request to OpenAI GPT-3 using the entered string as the prompt.
7. The generated response will be displayed in the text area below the text field.
   
## Dependencies

The application uses the following dependencies:

- Java Development Kit (JDK) - Ensure you have JDK 11 or above installed on your system.

## Configuration 

Before running the application, make sure to update the `AUTH_TOKEN` variable in the `re_GPT` class with your OpenAI GPT-3 API token.

```java
private static final String AUTH_TOKEN = "YOUR_OPENAI_GPT3_API_TOKEN";
