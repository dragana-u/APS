package Laboratoriski.devetta.natprevar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

 class Heap<E extends Comparable<E>> {

    private E elements[];

    private Comparator<? super E> comparator;

    private int compare (E k1, E k2) {
        return (comparator==null ? k1.compareTo(k2) : comparator.compare(k1, k2));
    }

    int getParent(int i) {
        return (i+1)/2-1;
    }

    public E getAt(int i) {
        return elements[i];
    }

    int getLeft(int i) {
        return (i+1)*2-1;
    }

    int getRight(int i) {
        return (i+1)*2;
    }

    void setElement(int index, E elem) {
        elements[index] = elem;
    }

    void swap(int i, int j) {
        E tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }

    void adjust(int i, int n){

        while (i < n) {

            int left = getLeft(i);
            int right = getRight(i);
            int largest = i;

            if ((left < n)&&(elements[left].compareTo(elements[largest]) > 0))
                largest = left;
            if ((right < n)&&(elements[right].compareTo(elements[largest]) > 0))
                largest = right;

            if (largest == i)
                break;

            swap(i, largest);
            i = largest;

        }

    }

    void buildHeap() {
        int i;
        for (i=elements.length/2-1;i>=0;i--)
            adjust(i, elements.length);
    }


    @SuppressWarnings("unchecked")
    public Heap(int size) {
        elements = (E[])new Comparable[size];
    }


}

public class NatprevarTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Heap<Integer> poeniOdNatprevaruvaci = new Heap<>(n);
        for(int i=0;i<n;i++){
            poeniOdNatprevaruvaci.setElement(i,Integer.parseInt(br.readLine()));
        }
        int baraniPoeni = Integer.parseInt(br.readLine());
        int rang = n;
        int duplikat = 0;
        for(int i=0;i<n;i++){
            if(poeniOdNatprevaruvaci.getAt(i) < baraniPoeni){
                rang--;
            }else if(poeniOdNatprevaruvaci.getAt(i) == baraniPoeni){
                duplikat++;
            }
        }
        System.out.println(rang-(duplikat-1));
    }
}
