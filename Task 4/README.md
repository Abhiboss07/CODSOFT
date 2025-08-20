# Currency Converter

A Java-based desktop application that allows users to convert between different currencies using real-time exchange rates from the ExchangeRate-API.

## Features

- **Real-time Exchange Rates**: Fetches current exchange rates from ExchangeRate-API
- **Multiple Currencies**: Support for 11 major currencies including USD, EUR, JPY, GBP, AUD, CAD, CHF, CNY, SEK, NZD, and INR
- **User-friendly GUI**: Clean and intuitive Swing-based interface
- **Instant Conversion**: Real-time currency conversion with live API data
- **Error Handling**: Comprehensive error handling for network issues and invalid inputs

## Screenshots

The application features a clean interface with:
- Amount input field
- Source currency dropdown
- Target currency dropdown
- Convert button
- Real-time result display

## Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Internet connection (for API calls)

## Installation

1. **Clone or download the project**
   ```bash
   git clone [https://github.com/Abhiboss07/CODSOFT]
   cd CurrencyConverter
   ```

2. **Navigate to the project directory**
   ```bash
   cd "Currency Converter"
   ```

3. **Build the project using Maven**
   ```bash
   mvn clean compile
   ```

## Configuration

### API Key Setup

The application uses the ExchangeRate-API. You need to:

1. Visit [ExchangeRate-API](https://www.exchangerate-api.com/) and sign up for a free account
2. Get your API key from the dashboard
3. Replace the API key in the `CurrencyConverter.java` file:

```java
private static final String API_KEY = "YOUR_ACTUAL_API_KEY_HERE";
```

**Note**: The current code has a placeholder API key. You must replace it with your actual API key for the application to work.

## Usage

### Running the Application

1. **Compile and run using Maven**
   ```bash
   mvn exec:java -Dexec.mainClass="com.abhi.CurrencyConverter"
   ```

2. **Or run the compiled JAR file**
   ```bash
   mvn package
   java -jar target/currency-converter-1.0-SNAPSHOT.jar
   ```

### How to Use

1. **Enter Amount**: Type the amount you want to convert in the "Amount" field
2. **Select Source Currency**: Choose the currency you're converting from using the "From" dropdown
3. **Select Target Currency**: Choose the currency you're converting to using the "To" dropdown
4. **Convert**: Click the "Convert" button to get the real-time conversion result
5. **View Result**: The converted amount will be displayed at the bottom of the window

## Supported Currencies

- USD (US Dollar)
- EUR (Euro)
- JPY (Japanese Yen)
- GBP (British Pound)
- AUD (Australian Dollar)
- CAD (Canadian Dollar)
- CHF (Swiss Franc)
- CNY (Chinese Yuan)
- SEK (Swedish Krona)
- NZD (New Zealand Dollar)
- INR (Indian Rupee)

## Technical Details

### Architecture

- **Language**: Java 21
- **GUI Framework**: Java Swing
- **Build Tool**: Maven
- **HTTP Client**: Java 11+ HttpClient
- **JSON Parsing**: org.json library

### Dependencies

- `org.json:json:20231013` - For JSON parsing

### API Integration

The application integrates with the ExchangeRate-API v6:
- **Base URL**: `https://v6.exchangerate-api.com/v6/`
- **Endpoint**: `/latest/{currency_code}`
- **Response Format**: JSON

### Error Handling

The application handles various error scenarios:
- Network connectivity issues
- Invalid API responses
- Invalid user input (non-numeric amounts)
- API key configuration errors

## Project Structure

```
CurrencyConverter/
├── Currency Converter/
│   ├── pom.xml
│   └── src/
│       └── main/
│           └── java/
│               └── com/
│                   └── abhi/
│                       └── CurrencyConverter.java
└── README.md
```

## Development

### Building from Source

```bash
# Clean and compile
mvn clean compile

# Run tests (if any)
mvn test

# Package the application
mvn package
```

### Adding New Currencies

To add support for additional currencies:

1. Add the currency code to the `currencies` array in `CurrencyConverter.java`
2. The API will automatically provide exchange rates for supported currencies

## Troubleshooting

### Common Issues

1. **"Error: Please replace 'YOUR_API_KEY'"**
   - Solution: Replace the placeholder API key with your actual ExchangeRate-API key

2. **"Error fetching data. Check connection."**
   - Solution: Verify your internet connection and API key validity

3. **"Error: Please enter a valid number."**
   - Solution: Ensure the amount field contains only numeric values

4. **Build errors**
   - Solution: Ensure you have Java 21+ and Maven 3.6+ installed

## License

This project is created as part of the CODSOFT internship program.

## Contributing

This is a learning project. Feel free to fork and modify for educational purposes.

## Acknowledgments

- ExchangeRate-API for providing real-time exchange rate data
- CODSOFT for the internship opportunity
