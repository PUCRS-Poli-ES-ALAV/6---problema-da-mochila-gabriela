public class FiboMemo {
    public static int MEMOIZED_FIBO(int n, int[] f) {
        if (n <= 1) {
            return n;
        }

        if (f[n] != -1) {
            return f[n];
        }

        f[n] = MEMOIZED_FIBO(n - 1, f) + MEMOIZED_FIBO(n - 2, f);
        return f[n];
    }

    public static void main(String[] args) {
        int[] testValues = {4, 8, 16, 32, 128, 1000, 10000};

        System.out.println("MEMOIZED-FIBO:");
        for (int n : testValues) {
            int[] f = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                f[i] = -1;
            }
            System.out.println("Fibonacci de " + n + ": " + MEMOIZED_FIBO(n, f));
        }
    }
}
