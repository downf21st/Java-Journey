package CodePtit;

import java.util.Scanner;

public class NK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (n >= 0 && k >= 0 && k <= n) {
            generateCombinations(n, k);
        }

        scanner.close();
    }

    private static void generateCombinations(int n, int k) {
        int[] combination = new int[k];
        for (int i = 0; i < k; i++) {
            combination[i] = i + 1;
        }

        while (true) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < k; i++) {
                if (i > 0) {
                    line.append(' ');
                }
                line.append(combination[i]);
            }
            System.out.println(line);

            int index = k - 1;
            while (index >= 0 && combination[index] == n - k + index + 1) {
                index--;
            }
            if (index < 0) {
                break;
            }

            combination[index]++;
            for (int i = index + 1; i < k; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }
    }
}
