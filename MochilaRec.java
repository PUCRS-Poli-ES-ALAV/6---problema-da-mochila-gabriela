public class MochilaRec {
    public static int knapsackRecursivo(int capacidade, int[] pesos, int[] valores, int n) {
        if (n == 0 || capacidade == 0) {
            return 0;
        }

        if (pesos[n - 1] > capacidade) {
            return knapsackRecursivo(capacidade, pesos, valores, n - 1);
        } else {
            int incluirItem = valores[n - 1] + knapsackRecursivo(capacidade - pesos[n - 1], pesos, valores, n - 1);
            int naoIncluirItem = knapsackRecursivo(capacidade, pesos, valores, n - 1);
            return Math.max(incluirItem, naoIncluirItem);
        }
    }

    public static void main(String[] args) {
        int[] pesos = {2, 3, 4, 5};
        int[] valores = {3, 4, 5, 6};
        int capacidade = 5;
        int n = pesos.length;

        int resultado = knapsackRecursivo(capacidade, pesos, valores, n);
        System.out.println("Valor máximo que pode ser obtido: " + resultado);
    }
}
