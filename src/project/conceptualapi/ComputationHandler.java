package project.conceptualapi;

import project.processapi.IntegerData;
import project.processapi.IntegerDataset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComputationHandler implements ComputationAPI {
    //numbers higher than this can become problematic
    public static final int MAX_RANK = 100_000;

    public boolean isPrime(Integer number) {
        if (number <= 1) {
            return false;
        }

        for (int divisor = 2; divisor <= number / divisor; divisor++) {
            Objects.requireNonNull(number, "number must not be null");

            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public int findNthPrime(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        if (n > MAX_RANK) {
            throw new IllegalArgumentException("n can be at most " + MAX_RANK);
        }

        int rank = 0;
        int number = 2;

        while (true) {
            if (isPrime(number)) {
                rank++;

                if (rank == n) {
                    return number;
                }
            }
            number++;
        }
    }

    @Override
    public IntegerData compute(IntegerData input) {
        Objects.requireNonNull(input, "input must not be null");
        List<Integer> integers = Objects.requireNonNull(input.getIntegers(), "input integers must not be null");
        List<Integer> results = new ArrayList<>();

        for (Integer n : integers) {
            Objects.requireNonNull(n, "input must not contain null values");
            results.add(findNthPrime(n));
        }

        return new IntegerDataset(results);
    }
}