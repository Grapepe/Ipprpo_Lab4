package org.example;

public class App {

    private App() {
    }

    public static void main(String[] args) {
        System.out.println("=== APP STARTED ON BRANCH MAIN ===");
        System.out.println("Fibonacci(10) = " + Fibonacci.fib(10));
    }
}
