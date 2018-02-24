package algorithms.F1to50;

public class Pow {
    public double myPow(double x, int n) {
        if (n > 0) {
            n = -n;
        } else {
            x = 1 / x;
        }
        return binaryPow(x, n);
    }

    public double binaryPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == -1) {
            return x;
        }
        double left = binaryPow(x, n / 2);
        if (n % 2 == 0) {
            return left * left;
        }
        return left * left * x;
    }
}
