public class _338CountingBits {
    public int[] countBits(int num){
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++){ // !!! starts from 1
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
    /*
    i&i-1 clears the last bit set in i.
    The number of bits set in i would therefore be,
    the number of bits set in i&i-1 plus the bit that the AND operation cleared.
    For eg, take i = 3 (11). i-1 = 2 (10). 3&2 = 2 (10).
    The answer would be, the number of bits set in 2(=1), plus 1(from the cleared bit) = 2.
     */
}
