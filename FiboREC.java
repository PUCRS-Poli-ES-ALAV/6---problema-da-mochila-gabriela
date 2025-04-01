public class FiboREC {
        public static int FIBO_REC(int n) {
            if (n <= 1) {
                return n;
            } else {
                return FIBO_REC(n - 1) + FIBO_REC(n - 2);
            }
        }

        public static void main(String[] args) {
            int[] testValues = {4, 8, 16, 32, 128, 1000, 10000};

            System.out.println("FIBO-REC:");
            for (int n : testValues) {
                System.out.println("Fibonacci de " + n + ": " + FIBO_REC(n));
            }
        }
    }


