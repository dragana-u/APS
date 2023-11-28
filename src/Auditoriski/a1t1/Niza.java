package Auditoriski.a1t1;

import java.util.ArrayList;

public class Niza<E> {

    public void changeArrays (ArrayList<E> a1, ArrayList<E> a2){
        if(a1.size() != a2.size()){
            System.out.println("Nizite se so razlicna golemina");
        }
        int size=a1.size();
        for(int i=0;i<size;i++){
            if(a1.get(i).equals(a2.get(i))){
                a1.remove(i);
                a2.remove(i);
                size--;
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> niza3 = new ArrayList<Integer>( 3);

        niza3.add(10);

        niza3.add(13);

        niza3.add(7);

        ArrayList<Integer> niza4 = new ArrayList<Integer>( 3);

        niza4.add(5);

        niza4.add(13);

        niza4.add(3);
        System.out.println("Nizite pred primenuvanjeto na funkcijata: ");
        System.out.println(niza3.toString());
        System.out.println(niza4.toString());

        Niza<Integer> pom2 = new Niza<Integer>();
        pom2.changeArrays(niza3,niza4);

        System.out.println("Nizite po primenuvanjeto na funkcijata: ");

        System.out.println(niza3.toString());

        System.out.println(niza4.toString());
    }
}
