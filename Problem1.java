import java.util.ArrayList;
import java.util.*;
 
public class Totientphi {
    public static List<Integer> sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        for (int num = 2; num * num <= limit; num++) {
            if (isPrime[num]) {
                for (int multiple = num * num; multiple <= limit; multiple += num) {
                    isPrime[multiple] = false;
                }
            }
        }
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }
 
    
    public static int computeTotient(int n, List<Integer> primes) {
        int result = n;
        int tempN = n;
 
        for (int p : primes) {
            if (p * p > tempN) break; 
            if (tempN % p == 0) {
                result *= (1.0 - (1.0 / p)); 
                while (tempN % p == 0) {
                    tempN /= p;
                }
            }
        }
        if (tempN > 1) {
            result *= (1.0 - (1.0 / tempN));
        }
        return result;
    }
    public static boolean isPermutation(int a,int b)
    {
        char[] input=String.valueOf(a).toCharArray();
        char[] output=String.valueOf(b).toCharArray();
        Arrays.sort(input);
        Arrays.sort(output);
        return Arrays.equals(input,output);
    }
    public static void main(String ar[])
    {
        int inputN=(int)Math.pow(10,7);
         List<Integer> primes = sieve((int) Math.sqrt(inputN) + 1);
 
        
        double minratio=Double.MAX_VALUE;
        int reqN=0;
        for(int n=2;n<inputN;n++)
        {
         int totientValue = computeTotient(n, primes);
        if(isPermutation(n,totientValue))
        {  
            double ratio=(double)n/totientValue;
            if(ratio<minratio)
            {
                minratio=ratio;
                reqN=n;
            }
        }
    }
        System.out.println("phi(" + inputN + ") = " + reqN);
        //System.out.println(primes.toString());
    }
}
