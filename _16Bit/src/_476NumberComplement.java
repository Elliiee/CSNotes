public class _476NumberComplement {
    public int findComplement(int num) {
        int todo = num, bit = 1;
        while (todo != 0){
            num ^= bit;
            bit = bit << 1;
            todo = todo >> 1;
        }
        return num;
    }

    public int findComplementII(int num) {
        int n = (int)(Math.log(num)/Math.log(2)) + 1;
        int bitmask = (1 << n) - 1;
        return num ^ bitmask;
    }

    public int findComplementIII(int num) {
        if (num == 0) return 1;
        int mask = Integer.highestOneBit(num);
        mask = (mask << 1) - 1;
        return num ^ mask;
    }
}
