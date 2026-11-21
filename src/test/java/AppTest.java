import org.example.App;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    void testMainPrintsResult() {
        PrintStream original = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            App.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        assertTrue(out.toString().contains("Fibonacci(10) = 55"));
    }
}
