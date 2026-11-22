package orgFibonacci {

    public static final int MAX_N = 92;

    private Fibonacci() {
    }

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
