package PrvKolokvium.p3;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Bus {

    public static long maxPrice(int N, int M) {
        if (M != 0) {
            return 100L * N + (M - 1) * 100L;
        } else {
            return 100L * N;
        }
    }

    public static long minPrice(int N, int M) {
        if (M > N) {
            return 100L * N + (M - N) * 100L;
        } else {
            return N * 100L;
        }
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        System.out.println(minPrice(N, M));
        System.out.println(maxPrice(N, M));
    }

}

