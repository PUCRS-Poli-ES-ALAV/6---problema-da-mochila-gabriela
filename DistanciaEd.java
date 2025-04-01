public class DistanciaEd {
    public static int calcularDistanciaEdicao(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int custoRemocao = 1;
        int custoInsercao = 1;
        int custoSubstituicao = 1;
        int custoCorrespondencia = 0;


        int[][] dp = new int[m + 1][n + 1];


        for (int i = 0; i <= m; i++) {
            dp[i][0] = i * custoRemocao;          }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j * custoInsercao;
        }


        int iteracoes = 0;


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                iteracoes++;

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int custoInserir = dp[i][j - 1] + custoInsercao;
                    int custoRemover = dp[i - 1][j] + custoRemocao;
                    int custoSubstituir = dp[i - 1][j - 1] + custoSubstituicao;

                    dp[i][j] = Math.min(Math.min(custoInserir, custoRemover), custoSubstituir);
                }
            }
        }

        System.out.println("Número de iterações: " + iteracoes);

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1_1 = "Casablanca";
        String s2_1 = "Portentoso";

        System.out.println("Distância de Edição entre \"" + s1_1 + "\" e \"" + s2_1 + "\":");
        int distancia1 = calcularDistanciaEdicao(s1_1, s2_1);
        System.out.println("Resultado: " + distancia1);

        String s1_2 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
                "simplify the build processes in the Jakarta Turbine project. There were several" +
                " projects, each with their own Ant build files, that were all slightly different." +
                "JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+
                "definition of what the project consisted of, an easy way to publish project information" +
                "and a way to share JARs across several projects. The result is a tool that can now be" +
                "used for building and managing any Java-based project. We hope that we have created " +
                "something that will make the day-to-day work of Java developers easier and generally help " +
                "with the comprehension of any Java-based project.";

        String s2_2 = "This post is not about deep learning. But it could be might as well. This is the power of " +
                "kernels. They are universally applicable in any machine learning algorithm. Why you might" +
                "ask? I am going to try to answer this question in this article." +
                "Go to the profile of Marin Vlastelica Pogančić" +
                "Marin Vlastelica Pogančić Jun";

        System.out.println("\nDistância de Edição entre grandes textos:");
        int distancia2 = calcularDistanciaEdicao(s1_2, s2_2);
        System.out.println("Resultado: " + distancia2);
    }
}
