package com.abhi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class CurrencyConverter extends JFrame {

    private static final String API_KEY = "7610d4e0d918e7ae080490ec";
    private static final String API_URL_BASE = "https://v6.exchangerate-api.com/v6/";

    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JTextField amountField;
    private JLabel resultLabel;
    private JButton convertButton;

    private final String[] currencies = {
            "USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "CNY", "SEK", "NZD", "INR"
    };

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));

        fromCurrency = new JComboBox<>(currencies);
        toCurrency = new JComboBox<>(currencies);
        amountField = new JTextField("1.0");
        resultLabel = new JLabel("Result will be shown here.");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        convertButton = new JButton("Convert");

        mainPanel.add(new JLabel("Amount:"));
        mainPanel.add(amountField);
        mainPanel.add(new JLabel("From:"));
        mainPanel.add(fromCurrency);
        mainPanel.add(new JLabel("To:"));
        mainPanel.add(toCurrency);
        mainPanel.add(new JLabel());
        mainPanel.add(convertButton);

        add(mainPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        if ("YOUR_API_KEY".equals(API_KEY)) {
            resultLabel.setText("<html><font color='red'>Error: Please replace 'YOUR_API_KEY' in the code.</font></html>");
            return;
        }

        try {
            String fromCode = (String) fromCurrency.getSelectedItem();
            String toCode = (String) toCurrency.getSelectedItem();
            double amount = Double.parseDouble(amountField.getText());

            resultLabel.setText("Fetching exchange rates...");

            String urlString = API_URL_BASE + API_KEY + "/latest/" + fromCode;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(this::processApiResponse)
                    .exceptionally(ex -> {
                        SwingUtilities.invokeLater(() ->
                                resultLabel.setText("<html><font color='red'>Error fetching data. Check connection.</font></html>")
                        );
                        return null;
                    });

        } catch (NumberFormatException ex) {
            resultLabel.setText("<html><font color='red'>Error: Please enter a valid number.</font></html>");
        }
    }

    private void processApiResponse(String responseBody) {
        try {
            JSONObject jsonResponse = new JSONObject(responseBody);
            String resultStatus = jsonResponse.getString("result");

            if ("success".equals(resultStatus)) {
                JSONObject conversionRates = jsonResponse.getJSONObject("conversion_rates");
                String toCode = (String) toCurrency.getSelectedItem();
                double rate = conversionRates.getDouble(toCode);
                double amount = Double.parseDouble(amountField.getText());

                double convertedAmount = amount * rate;

                String resultText = String.format("%.2f %s = %.2f %s",
                        amount,
                        (String) fromCurrency.getSelectedItem(),
                        convertedAmount,
                        toCode);

                SwingUtilities.invokeLater(() -> resultLabel.setText(resultText));

            } else {
                String errorType = jsonResponse.optString("error-type", "Unknown error");
                SwingUtilities.invokeLater(() ->
                        resultLabel.setText("<html><font color='red'>API Error: " + errorType + "</font></html>")
                );
            }
        } catch (Exception ex) {
            SwingUtilities.invokeLater(() ->
                    resultLabel.setText("<html><font color='red'>Error parsing API response.</font></html>")
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverter().setVisible(true);
            }
        });
    }
}
