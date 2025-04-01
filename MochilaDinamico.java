public class MochilaDinamico {
        public static int knapsack(int capacidade, int[] pesos, int[] valores, int n) {

            int[][] dp = new int[n + 1][capacidade + 1];

            for (int i = 0; i <= n; i++) {
                for (int w = 0; w <= capacidade; w++) {
                    if (i == 0 || w == 0) {
                        dp[i][w] = 0;
                    } else if (pesos[i - 1] <= w) {

                        dp[i][w] = Math.max(valores[i - 1] + dp[i - 1][w - pesos[i - 1]], dp[i - 1][w]);
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }


            return dp[n][capacidade];
        }

        public static void main(String[] args) {
            int[] pesos = {2, 3, 4, 5};
            int[] valores = {3, 4, 5, 6};
            int capacidade = 5;
            int n = pesos.length;


            int resultado = knapsack(capacidade, pesos, valores, n);
            System.out.println("Valor máximo que pode ser obtido: " + resultado);
        }
    }


