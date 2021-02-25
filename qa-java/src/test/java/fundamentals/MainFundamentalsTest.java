package fundamentals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainFundamentalsTest {

    private MainFundamentals mainFundamentals;
    private final InputStream standardIn = System.in;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        mainFundamentals = new MainFundamentals();
    }


    @AfterEach
    void tearDown() {
        System.setIn(standardIn);
        System.setOut(standardOut);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(
                data.getBytes())
        );
    }

    @Test
    void greetUserEnteringNameViaCli() {
        provideInput("Jor");
        mainFundamentals.greetUserEnteringNameViaCli();
        assertEquals("Welcome, Jor!", outputStreamCaptor.toString()
                .substring(outputStreamCaptor.toString()
                        .indexOf(System.lineSeparator())).trim());
    }

    @Test
    void printCliArgumentsInReverseOrder() {
        mainFundamentals.printCliArgumentsInReverseOrder(
                new String[]{"1", "2", "3", "4", "5"});
        assertEquals("5 4 3 2 1", outputStreamCaptor.toString());
    }

    @Test
    void printRandomNumbersWithAndWithoutNewLine() {
        provideInput("5");
        mainFundamentals.printRandomNumbersWithAndWithoutNewLine();
        String expected = "Please, enter the number of random numbers: " +
                "Random numbers with the transition to a new line: \r\n" +
                "9\r\n" +
                "2\r\n" +
                "9\r\n" +
                "6\r\n" +
                "4\r\n" +
                "Random numbers without a line break: \r\n" +
                "9 2 9 6 4 ";
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    void printSumAndCompositionOfCliArgs() {
        mainFundamentals.printSumAndCompositionOfCliArgs(
                new String[]{"1", "2", "3", "4", "5"});
        String expected = "sum: 15\r\n" +
                "composition: 120";
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 20})
    void printNameOfMonthCorrespondingToSpecifiedDate(int number) {
        String[] months = new String[]{
                null,
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December",
                "Wrong number. Please enter the date corresponding to the month of the year."
        };

        if (number > months.length || number < 1) {
            number = 13;
        }

        provideInput(String.valueOf(number));
        mainFundamentals.printNameOfMonthCorrespondingToSpecifiedDate();
        assertEquals(months[number], outputStreamCaptor.toString().substring(outputStreamCaptor.toString()
                .indexOf(System.lineSeparator())).trim());
    }
}