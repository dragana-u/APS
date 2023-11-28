package Auditoriski.KodoviCourses;

import java.util.Arrays;

public class ArrayBasic<E> {
    private E[] data;
    private int size;

    public ArrayBasic(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public void insertLast(E o) {
        if (size + 1 > data.length) {
            this.resize();
        }
        data[size++] = o;
    }

    public void resize() {
        // first resize the storage array
        E[] newData = (E[]) new Object[size * 2];
        // copy the data
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        // replace the storage with the new array
        this.data = newData;
    }

    public void insert(int position, E o) {
        if (position >= 0 && position <= size) {
            if (size + 1 > data.length) {
                this.resize();
            }
            for (int i = size; i > position; i--) {
                data[i] = data[i - 1];
            }
            data[position] = o;
            size++;
        } else {
            System.out.println("Ne moze na taa pozicija");
        }
    }

    public void set(int position, E o) {
        if (position >= 0 && position < size)
            data[position] = o;
        else
            System.out.println("Ne moze da se vmetne element na dadenata pozicija");
    }

    public E get(int position) {
        if (position >= 0 && position < size)
            return data[position];
        else
            System.out.println("Ne e validna dadenata pozicija");
        return null;
    }

    public int find(E o) {
        return Arrays.binarySearch(data, o);
    } // try this

//    public int find(E o) { // from aud
//        for (int i = 0; i < size; i++) {
//            if(o.equals(data[i]))
//                return i;
//        }
//        return -1;
//    }

    @Override
    public String toString() {
        String ret = new String();
        if(size>0) {
            ret = "{";
            ret += data[0];
            for(int i=1;i<size;i++) {
                ret += "," + data[i];
            }
            ret+="}";
            return ret;
        }
        else {
            ret = "Prazna niza!";
        }
        return ret;
    }

    public int getSize() {
        return size;
    }

    public void delete(int position) {
        // before all we check if position is within range
        if (position >= 0 && position < size) {
            // first resize the storage array
            E[] newData = (E[]) new Object[size - 1];
            // copy the data prior to the delition
            for (int i = 0; i < position; i++)
                newData[i] = data[i];
            // move the data after the deletion
            for (int i = position + 1; i < size; i++)
                newData[i - 1] = data[i];
            // replace the storage with the new array
            data = newData;
            size--;
        }

    }

    public static void main(String[] args) {
        ArrayBasic<Integer> niza = new ArrayBasic<Integer>(4);
        niza.insertLast(4);
        System.out.print("Nizata po vmetnuvanje na 4 kako posleden element: ");
        System.out.println(niza);

        niza.insertLast(7);
        niza.insertLast(13);
        System.out.print("Nizata po dodavanje na 7 i 13 kako elementi: ");
        System.out.println(niza.toString());

        niza.insert(1, 3);
        System.out.print("Nizata po dodavanje na 3 kako element na pozicija 1: ");
        System.out.println(niza.toString());

        niza.set(2, 6);
        System.out.print("Nizata po menuvanje na vrednosta na elementot na pozicija 2 vo 6: ");
        System.out.println(niza.toString());

        niza.delete(0);
        System.out.print("Nizata po brishenje na elementot na pozicija 0 (prviot element): ");
        System.out.println(niza.toString());

        System.out.print("Na pozicija 2 vo nizata sega se naogja: ");
        System.out.println(niza.get(2));

        System.out.print("Brojot 3 sega se naogja vo nizata na pozicija: ");
        System.out.println(niza.find(3));

        System.out.print("Sega na krajot goleminata na nizata e: ");
        System.out.println(niza.getSize());
    }
}