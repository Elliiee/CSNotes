public class _231PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }

    public boolean isPowerOfTwoII(int n) {
        if (n == 0)
            return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
}
