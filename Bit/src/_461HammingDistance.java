public class _461HammingDistance {
    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);
    }

    /*
    Approach 2: logical shift
     */
    public int approach2(int x, int y){
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0){
            if (xor % 2 == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }

    /*
    Approach 3: Brian Kernighan's Algorithm
    x & (x -1) get rid of the right most bit 1
     */
    public int approach3(int x, int y){
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0){
            distance += 1;
            xor = xor & (xor - 1);
        }
        return distance;
    }
}
