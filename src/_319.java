import java.util.BitSet;

public class _319 {
    public static void main(String[] args) {
        int x = new _319().bulbSwitch(32);
        new BitSet();
        System.out.println("res: " + x);
    }

    public int bulbSwitch(int n) {
        if (n == 0) return 0;
        long bulbs = (1 << (n - 1)) | ((1 << (n - 1)) - 1);
        for (int step = 2; step <= n; step++) {
            for (int i = step; i <= n; i += step) {
                bulbs = bulbs ^ (1 << (i - 1));
            }
        }
        return Long.bitCount(bulbs);
    }
}
