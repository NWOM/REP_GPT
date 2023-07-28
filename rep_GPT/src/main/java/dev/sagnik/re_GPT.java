package dev.sagnik;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class re_GPT extends JFrame {

    private JButton generateButton;
    private JTextField inputTextField;
    private JTextArea responseTextArea;

    public re_GPT() {
        setTitle("ReGPT Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputTextField = new JTextField();
        generateButton = new JButton("Generate Response");
        responseTextArea = new JTextArea();

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Enter a string to search for:"), BorderLayout.NORTH);
        inputPanel.add(inputTextField, BorderLayout.CENTER);
        inputPanel.add(generateButton, BorderLayout.SOUTH);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prompt = inputTextField.getText();
                try {
                    String response = makeApiRequest(prompt);
                    if (response != null) {
                        responseTextArea.setText(response.replace("\n", " ").trim());
                    }
                } catch (IOException | InterruptedException ex) {
                    responseTextArea.setText("Error occurred: " + ex.getMessage());
                }
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(responseTextArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private static final String API_URL = "https://api.openai.com/v1/completions";
    private static final String AUTH_TOKEN = "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";

    private String makeApiRequest(String prompt) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        ChatGptRequest gptRequest = new ChatGptRequest("text-davinci-001", prompt, 1, 100);
        String input = objectMapper.writeValueAsString(gptRequest);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + AUTH_TOKEN)
                .POST(HttpRequest.BodyPublishers.ofString(input))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            return "wrong";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new re_GPT();
            }
        });
    }
}
