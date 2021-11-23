package org;

public class Main {

    /*
        Application prints numbers like:
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        1 5 10 10 5 1
     */
    public static void main(String[] args) {
        prn(func(8));
    }

    public static int[][] func(int n) {
        if (n == 1) return new int[][] {{ 1 }};
        if (n == 2) return new int[][] {{ 1 }, { 1, 1 }};

        int[][] result = new int[n][];
        result[0] = new int[] { 1 };
        result[1] = new int[] { 1 , 1 };

        for (int i = 2; i < n; i++) {
            result[i] = new int[i+1];
            int j;
            for (j = 1; j < i; j++) {
                result[i][j] = result[i-1][j-1] + result[i-1][j];
            }

            // corner case
            result[i][0] = 1;
            result[i][j] = 1;
        }

        return result;
    }

    public static void prn(int[][] in) {
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                System.out.print(in[i][j] + " ");
            }
            System.out.println('\n');
        }
    }
}
