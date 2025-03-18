import java.util.ArrayList;

import java.util.List;
 
public class IrJumps{
 

    public static List<Integer> gPrimes(int n) {

        boolean[] isPrime = new boolean[n + 1];

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) isPrime[i] = true;
 
        for (int i = 2; i * i <= n; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= n; j += i) {

                    isPrime[j] = false;

                }

            }

        }
 
        for (int i = 2; i <= n; i++) {

            if (isPrime[i]) {

                primes.add(i);

            }

        }

        return primes;

    }
 

    public static double calculateSum(double l, double g, double d) {

        double position = 0.0;

        double totalJumpDistance = 0.0;
 
        while (true) {

            position = (position + l) % 1.0;

            totalJumpDistance += l;

            if (position >= d && position <= d + g) {

                break; 

            }

        }

        return totalJumpDistance;

    }
 

    public static double calculateMax(int n, double g) {

        List<Integer> primes = gPrimes(n);

        double maxS = 0.0;
 

        for (double d = 0.0; d <= (1.0 - g); d += 0.0001) 
        { 

            double currentS= 0.0;

            for (int p : primes) {

                double l = Math.sqrt(1.0 / p);

                currentS += calculateSum(l, g, d);

            }

            maxS = Math.max(maxS, currentS);

        }
 
        return maxS;

    }
 
    public static void main(String[] args) {

        int n = 100;

        double g = 0.00002;

        double result = calculateMax(n, g);


        System.out.printf("M(100, 0.00002) = %.4f%n", result);

    }

}

 
