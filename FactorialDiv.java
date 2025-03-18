import java.math.BigInteger;
 
public class FactorialDiv
{ 
 
    public static long Findp(long n, long p) {
        long count = 0;
        while (n > 0) {
            count += n / p;
            n /= p;
        }
        return count;
    }
 
    public static long findN(long i, long exponent) {
        long left = 1, right = 2 * i, answer = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            boolean valid = true;
 
            for (long p = 2; p <= i; p++) {
                if (isPrime(p)) {
                    long powerInFactorial = Findp(mid, p);
                    long requiredPower = exponent * Findp(i, p);
 
                    if (powerInFactorial < requiredPower) {
                        valid = false;
                        break;
                    }
                }
            }
 
            if (valid) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
 
    public static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
 
    public static void main(String[] args) {
        long limit = 1000000;
        long exponent = 1234567890;
        BigInteger sum = BigInteger.ZERO;
        BigInteger mod = BigInteger.TEN.pow(18);
 
        for (long i = 10; i <= limit; i++) {
            long Ni = findN(i, exponent);
            sum = sum.add(BigInteger.valueOf(Ni)).mod(mod);
        }
 
        System.out.println("S(1,000,000) mod 10^18 = " + sum);
    }
}
 
