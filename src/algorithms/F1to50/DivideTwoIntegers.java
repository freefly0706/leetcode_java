package algorithms.F1to50;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int res = 0;
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        while (dividendAbs >= divisorAbs) {
            long temp = divisorAbs, mul = 1;
            while (dividendAbs >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }
            dividendAbs -= temp;
            res += mul;
        }
        return sign < 0 ? -res : res;
    }
}
