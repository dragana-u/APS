package Laboratoriski.petta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ShakerSort {

    static void printArray(int[] a, int n){
        for(int i=0;i<n;i++){
            System.out.print(a[i]);
            if(i!=n-1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    static void shakerSort(int a[], int n) {
        // Vasiot kod tuka
        for(int i=0;i<n;i++){
            int brojac = 0;
            boolean switched = false;
            for(int j=n-1;j>brojac;j--){
                if(a[j] < a[j - 1]){
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    switched=true;
                }
            }
            printArray(a,n);
            for(int j=brojac;j<n-1;j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    switched=true;
                }
            }
            printArray(a,n);
            brojac++;
            if(!switched){
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        shakerSort(a,n);
    }
}
