package org.example;

/**
 * Генератор чисел Фибоначчи: F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2).
 */
public class Fibonacci {

    /** Максимальный n, для которого F(n) помещается в long. */
    public static final int MAX_N = 92;

    private Fibonacci() {
    }

    /**
     * Возвращает n-е число Фибоначчи.
     *
     * @param n номер числа (0..92)
     * @return F(n)
     * @throws IllegalArgumentException если n отрицательный или больше 92
     */
    public static long fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n не может быть отрицательным: " + n);
        }
        if (n > MAX_N) {
            throw new IllegalArgumentException("n слишком велико (переполнение long): " + n);
        }
        long a = 0;
        long b = 1;
        for (int i = 0; i < n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return a;
    }
}
