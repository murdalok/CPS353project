package project.conceptualapi;

import project.processapi.IntegerData;
import project.processapi.IntegerDataset;
import java.util.ArrayList;
import java.util.List;

public class ComputationHandler implements ComputationAPI {

    public boolean isPrime(Integer number) {
        if (number <= 1) {
            return false;
        }

        for (int divisor = 2; divisor <= number / divisor; divisor++) {
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
        List<Integer> results = new ArrayList<>();

        for (int n : input.getIntegers()) {
            results.add(findNthPrime(n));
        }

        return new IntegerDataset(results);
    }
}