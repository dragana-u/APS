package Laboratoriski.cetvrta;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        // Vasiot kod tuka
        int max = Integer.MIN_VALUE;
        int brojac;
        for (int i=0;i<a.length;i++){
            brojac=1;
            for(int j=i;j<a.length-1;j++){
                if(a[j] > 0 && a[j+1] < 0
                || a[j]<0 && a[j+1] > 0){
                    brojac++;
                }else{
                    break;
                }
            }
            max = Integer.max(max,brojac);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}

