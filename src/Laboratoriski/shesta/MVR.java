package Laboratoriski.shesta;

import java.util.NoSuchElementException;
import java.util.Scanner;

 interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}

class ArrayQueue<E> {
    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}



public class MVR {

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);
        ArrayQueue<Gragjanin> zaLicnaKarta = new ArrayQueue<>(1000);
        ArrayQueue<Gragjanin> zaPasos = new ArrayQueue<>(1000);
        ArrayQueue<Gragjanin> zaVozacka = new ArrayQueue<>(1000);

        int N = Integer.parseInt(br.nextLine());
        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);
            if(lKarta==1){
                zaLicnaKarta.enqueue(covek);
            }
            else if(pasos==1){
                zaPasos.enqueue(covek);
            }
            else if(vozacka==1){
                zaVozacka.enqueue(covek);
            }
        }
//        ArrayQueue<Gragjanin> red = new ArrayQueue<>(1000);
        while (!zaLicnaKarta.isEmpty()){
            Gragjanin gragjanin = zaLicnaKarta.peek();
            if(gragjanin.getPasos()==1){
                Gragjanin g = zaLicnaKarta.dequeue();
                zaPasos.enqueue(g);
            }else if(gragjanin.getVozacka() == 1){
                Gragjanin g = zaLicnaKarta.dequeue();
                zaVozacka.enqueue(g);
            }else{
                System.out.println(zaLicnaKarta.dequeue());
            }
        }
        while(!zaPasos.isEmpty()){
            Gragjanin gragjanin = zaPasos.peek();
            if(gragjanin.getVozacka()==1){
                Gragjanin g = zaPasos.dequeue();
                zaVozacka.enqueue(g);
            }else{
                System.out.println(zaPasos.dequeue());
            }
        }
        while(!zaVozacka.isEmpty()){
            System.out.println(zaVozacka.dequeue());
        }

//        while (!red.isEmpty()){
//            System.out.println(red.dequeue());
//        }
    }
}
class Gragjanin{

    String imePrezime;
    int lkarta;
    int vozacka;
    int pasos;

    public Gragjanin(String imePrezime, int lKarta, int pasos, int vozacka) {
        this.imePrezime=imePrezime;
        this.lkarta = lKarta;
        this.pasos = pasos;
        this.vozacka = vozacka;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public int getLkarta() {
        return lkarta;
    }

    public int getVozacka() {
        return vozacka;
    }

    public int getPasos() {
        return pasos;
    }

    @Override
    public String toString() {
        return imePrezime;
    }
}
