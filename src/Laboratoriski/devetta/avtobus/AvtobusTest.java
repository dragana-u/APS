package Laboratoriski.devetta.avtobus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Heap<E extends Comparable<E>> {

    private E elements[];

//    private Comparator<? super E> comparator;
//
//    private int compare (E k1, E k2) {
//        return (comparator==null ? k1.compareTo(k2) : comparator.compare(k1, k2));
//    }

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

    public void heapSort() {
        int i;
        buildHeap();
        for (i=elements.length;i>1;i--) {
            swap(0, i-1);
            adjust(0, i-1);
        }
    }

    @SuppressWarnings("unchecked")
    public Heap(int size) {
        elements = (E[])new Comparable[size];
    }


}

class Patnik implements Comparable<Patnik>{
    int kacuvanje;
    boolean inBus;

    public Patnik(int kacuvanje, boolean inBus) {
        this.kacuvanje = kacuvanje;
        this.inBus = inBus;
    }

    @Override
    public int compareTo(Patnik o) {
        return this.kacuvanje - o.kacuvanje;
    }
}
public class AvtobusTest {

    public static int convertToMinutes(String time){
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int kapacitet = Integer.parseInt(br.readLine());
        int brojPatnici = Integer.parseInt(br.readLine())*2;
        Heap<Patnik> patnici = new Heap<>(brojPatnici);
        for(int i=0;i<brojPatnici;i=i+2){
            //08:30 9:30
            String[] parts = br.readLine().split("\\s+");
            int kacuvanje = convertToMinutes(parts[0]);
            int simnuvanje = convertToMinutes(parts[1]);
            patnici.setElement(i,new Patnik(kacuvanje,true));
            patnici.setElement(i+1,new Patnik(simnuvanje,false));
        }
        patnici.heapSort();
        int momentalenBrojPatnici = 0;
        for(int i=0;i<brojPatnici-1;i++){
            if(patnici.getAt(i).inBus){
                momentalenBrojPatnici++;
            }else{
                momentalenBrojPatnici--;
            }
            if(momentalenBrojPatnici>kapacitet){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
