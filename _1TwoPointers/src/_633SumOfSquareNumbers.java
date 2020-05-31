public class _633SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        if (c < 0)
            return false;

        int i = 0, j = (int) Math.sqrt(c);

        while (i <= j){
            int sum = i * i + j * j;
            if (sum == c)
                return true;
            else if (sum > c)
                j--;
            else
                i++;
        }
        return false;
    }
}
