public class _461HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
        /*
        XOR ( ^ ): Bitwise XOR also takes two equal-length bit patterns.
        If both bits in the compared position of the bit patterns are 0 or 1,
        the bit in the resulting bit pattern is 0, otherwise 1.
         */
    }
}
/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
 */
