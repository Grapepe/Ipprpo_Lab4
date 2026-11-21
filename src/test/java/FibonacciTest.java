import org.example.Fibonacci;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciTest {

    @Test
    void testZero() {
        assertEquals(0L, Fibonacci.fib(0));
    }

    @Test
    void testOne() {
        assertEquals(1L, Fibonacci.fib(1));
    }

    @Test
    void testSmallValues() {
        assertEquals(1L, Fibonacci.fib(2));
        assertEquals(2L, Fibonacci.fib(3));
        assertEquals(55L, Fibonacci.fib(10));
    }

    @Test
    void testLargerValue() {
        assertEquals(6765L, Fibonacci.fib(20));
    }

    @Test
    void testUpperBoundary() {
        assertEquals(7540113804746346429L, Fibonacci.fib(92));
    }

    @Test
    void testNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fib(-1));
    }

    @Test
    void testOverflowThrows() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fib(93));
    }
}
