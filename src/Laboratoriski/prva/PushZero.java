package Laboratoriski.prva;

import java.util.Arrays;
import java.util.Scanner;

public class PushZero
{
    static void pushZerosToBeginning(int arr[], int n)
    {
        int j=0;
        for(int i=0;i<n;i++){
            j=i;
            if(arr[i]==0){
                while(j>0){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
                }
            }
        }
    }

    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();
        int[] array = new int[numberOfElements];
        for(int i=0;i<numberOfElements;i++){
            array[i]=scanner.nextInt();
        }
        pushZerosToBeginning(array,numberOfElements);
        System.out.println("Transformiranata niza e:");
        for(int i=0;i<numberOfElements;i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }
}
