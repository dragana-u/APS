package Auditoriski.KodoviCourses;

public class SLLNode<E>{
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E element, SLLNode<E> succ) {
        this.element = element;
        this.succ = succ;
    }
}

class SLL<E>{
    private SLLNode<E> first;
    public SLL(){
        this.first=null;
    }
    public void insertFirst(E o){
        SLLNode<E> ins = new SLLNode<E>(o,null);
        ins.succ=first;
        first=ins;
    }

    public void insertAfter(E o, SLLNode<E> node){
        if(node!=null){
            SLLNode<E> ins = new SLLNode<E>(o,node.succ);
            node.succ=ins;
        }else{

            System.out.println("jazolot e null");
        }

    }

    public E deleteFirst(){
        if(first!=null){
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        }else{
            System.out.println("Prazna lista");
            return null;
        }
    }
    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if(first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public int size(){
        int listSize=0;
        SLLNode<E> tmp = first;
        while(tmp!=null){
            listSize++;
            tmp=tmp.succ;
        }
        return listSize;
    }

    public void insertBefore(E o, SLLNode<E> before){
        if(first!=null){
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            while(tmp.succ!=before && tmp.succ!=null){
                tmp=tmp.succ;
            }
            if(tmp.succ==before){
                tmp.succ = new SLLNode<E>(o,before);
            }else{
                System.out.println("nr postoi");
            }
        }else{
            System.out.println("prazna");
        }
    }
    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<E>(o, null);
        } else {
            insertFirst(o);
        }
    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public void merge(SLL<E> in){
        if(first!=null){
            SLLNode<E> tmp = first;
            while(tmp.succ!=null){
                tmp=tmp.succ;
            }
            tmp.succ=in.getFirst();
        }else{
            first=in.getFirst();
        }
    }
    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void mirror() {
        if(first != null){
            SLLNode<E> tmp = first;
            SLLNode<E> nextSucc = null;
            SLLNode<E> next;
            while(tmp!=null){
                next = tmp.succ;
                tmp.succ=nextSucc;
                nextSucc=tmp;
                tmp=next;
            }
            first=nextSucc;
        }
    }

}

class JoinSortedList<E extends Comparable<E>>{
    public SLL<E> join(SLL<E> list1, SLL<E> list2){
        SLL<E> rezultat = new SLL<E>();
        SLLNode<E> jazol1 = list1.getFirst(), jazol2 = list2.getFirst();
        while (jazol1!=null && jazol2!=null){
            if(jazol1.element.compareTo(jazol2.element)<0){
                rezultat.insertLast(jazol1.element);
                jazol1=jazol1.succ;
            }else{
                rezultat.insertLast(jazol2.element);
                jazol2=jazol2.succ;
            }
        }
        if(jazol1!=null){
            while(jazol1!=null){
                rezultat.insertLast(jazol1.element);
                jazol1=jazol1.succ;
            }
        }
        if(jazol2!=null){
            while(jazol2!=null){
                rezultat.insertLast(jazol2.element);
                jazol2=jazol2.succ;
            }
        }
        return rezultat;
    }
    public static void main(String[] args){
        SLL<String> lista1 = new SLL<String>();
        lista1.insertLast("Ana");lista1.insertLast("Bojana");lista1.insertLast("Dejan");
        SLL<String> lista2 = new SLL<String>();
        lista2.insertLast("Andrijana");lista2.insertLast("Biljana");lista2.insertLast("Darko");

        JoinSortedList<String> js = new JoinSortedList<String>();
        System.out.println(js.join(lista1, lista2));

    }
}
