package PrvKolokvium.p4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {
        int max=Integer.MIN_VALUE;
        int length = a.length;
        int[] dolzini = new int[length*2];
        for(int i=0;i<length;i++){
            dolzini[i]=1;
            for(int j=0; j<i;j++){
                if (a[i] < a[j] && dolzini[i] < dolzini[j] + 1) {
                    dolzini[i] = dolzini[j] + 1;
                }
            }
        }
        return Arrays.stream(dolzini).max().getAsInt();
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}

