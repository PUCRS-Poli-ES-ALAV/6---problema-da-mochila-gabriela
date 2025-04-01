public class Fibo {

        public static int FIBO(int n) {
            int[] f = new int[n + 1];
            f[0] = 0;
            f[1] = 1;

            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }

            return f[n];
        }

        public static void main(String[] args) {
            int[] testValues = {4, 8, 16, 32, 128, 1000, 10000};

            System.out.println("FIBO:");
            for (int n : testValues) {
                System.out.println("Fibonacci de " + n + ": " + FIBO(n));
            }
        }
    }

