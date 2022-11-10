package HW12;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FizzBuzz {
    static int length;
    static int number = 1;

    public FizzBuzz(int length) {
        this.length = length;
    }

    protected synchronized void iterate() {
        number++;
    }
    protected void fizz() {
        while (number <= length) {
            if (number % 3 == 0 && number % 5 != 0) {

                System.out.println("fizz");
                iterate();
            }
        }
    }

    protected void fizzbuzz() {
        while (number <= length) {
            if (number % 3 == 0 && number % 5 == 0) {

                System.out.println("fizzbuzz");
                iterate();
            }
        }
    }

    protected void buzz() {
        while (number <= length) {
        if (number % 3 != 0 && number % 5 == 0) {

            System.out.println("buzz");
            iterate();
        }
        }
}

    protected void number() {
        while (number <= length) {
            if (number % 3 != 0 && number % 5 != 0) {
                System.out.println(number);
                iterate();
            }
        }
    }
    }


class TestFizzBuzz {
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(45);
        while (fizzBuzz.number <= fizzBuzz.length) {
            new Thread(fizzBuzz::fizz).start();
            new Thread(fizzBuzz::buzz).start();
            new Thread(fizzBuzz::fizzbuzz).start();
            new Thread(fizzBuzz::number).start();
        }
    }
}


