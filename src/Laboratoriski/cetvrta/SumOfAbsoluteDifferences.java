package Laboratoriski.cetvrta;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfAbsoluteDifferences {

    static int solve(int numbers[], int N, int K) {
        // vasiot kod ovde
        // mozete da napisete i drugi funkcii dokolku vi se potrebni
        int[][] temp = new int[N][K + 1];
        for (int i = 1; i < N; i++) { //numbers
            for (int j = 1; j < K; j++) { //podnizie od K elementi
                for (int k = 0; k < i; k++) { //elementi pred i
                    temp[i][j] = Math.max(temp[i][j], temp[k][j - 1]
                            + Math.abs(numbers[i] - numbers[k]));
                }
            }
        }
        return Arrays.stream(temp)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(0);
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println(res);

        br.close();

    }

}