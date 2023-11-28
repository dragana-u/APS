package Auditoriski.KodoviCourses;

class DLL<E>{
    private DLLNode<E> first,last;
    public DLL(){
        this.first=null;
        this.last=null;
    }
    public void insertFirst(E o){
        DLLNode<E> ins = new DLLNode<E>(o,null,first);
        if(first==null){
            last=ins;
        }else{
            first.pred=ins;
        }
        first=ins;
    }
    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after){
        if(after == last){
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o,after,after.succ);
        after.succ.pred=ins;
        after.succ=ins;
    }

    public E deleteFirst(){
        if(first!=null){
            DLLNode<E> tmp = first;
            first = first.succ;
            if(first!=null) {
                first.pred=null;
            }
            if(first == null){
                last=null;
            }
            return tmp.element;
        }else return null;
    }

    public E deleteLast(){
        if(first!=null){
            if(first.succ==null){
                return deleteFirst();
            }else{
               DLLNode<E> tmp = last;
               last=last.pred;
               last.succ=null;
               return tmp.element;
            }
        }else{
            return null;
        }
    }
    public E delete(DLLNode<E> node){
        if(node==first){
            return deleteFirst();
        }
        if(node==last){
            return deleteLast();
        }
        node.pred.succ=node.succ;
        node.succ.pred=node.pred;
        return node.element;
    }
    public void deleteList(){
        first=null;
        last=null;
    }
    public int getSize(){
        int listSize=0;
        DLLNode<E> tmp = first;
        while(tmp!=null){
            listSize++;
            tmp=tmp.succ;
        }
        return listSize;
    }
    public DLLNode<E> find(E o){
        if(first!=null){
            DLLNode<E> tmp = first;
            while(!tmp.element.equals(o) && tmp.succ!=null){
                tmp=tmp.succ;
            }
            if(tmp.element.equals(o)){
                return tmp;
            }else{
                System.out.println("Ne postoi");
            }
        }else{
            System.out.println("prazna");
        }
        return null;
    }
    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }
    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret += tmp.toString();
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp.toString();
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {
        return last;
    }
}

class PalindromeDLL{
    public static int isPalindrome(DLL<Integer> list){
        DLLNode<Integer> poceten = list.getFirst();
        DLLNode<Integer> posleden = list.getLast();
        while((poceten!=posleden)&&(poceten.pred!=posleden)){
            if(!poceten.element.equals(posleden.element)){
                return -1;
            }
            poceten=poceten.succ;
            posleden=posleden.pred;
        }
        return 1;
    }
}
public class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E element, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = element;
        this.pred = pred;
        this.succ = succ;
    }
    public static void main(String[] args) {
        DLL<Integer> lista = new DLL<Integer>();
        lista.insertLast(5);
        System.out.print("Listata po vmetnuvanje na 5 kako posleden element: ");
        System.out.println(lista.toString()+" i obratno "+lista.toStringR());

        lista.insertFirst(3);
        System.out.print("Listata po vmetnuvanje na 3 kako prv element: ");
        System.out.println(lista.toString()+" i obratno "+lista.toStringR());

        lista.insertLast(1);
        System.out.print("Listata po vmetnuvanje na 1 kako posleden element: ");
        System.out.println(lista.toString()+" i obratno "+lista.toStringR());

        lista.deleteFirst();
        System.out.print("Listata po brishenje na prviot element: ");
        System.out.println(lista.toString()+" i obratno "+lista.toStringR());

        DLLNode<Integer> pom = lista.find(5);
        lista.insertBefore(2, pom);
        System.out.print("Listata po vmetnuvanje na elementot 2 pred elementot 5: ");
        System.out.println(lista.toString()+" i obratno "+lista.toStringR());

        pom = lista.find(1);
        lista.insertAfter(3, pom);
        System.out.print("Listata po vmetnuvanje na elementot 3 posle elementot 1: ");
        System.out.println(lista.toString()+" i obratno "+lista.toStringR());

        pom = lista.find(1);
        lista.insertAfter(6, pom);
        System.out.print("Listata po vmetnuvanje na elementot 6 posle elementot 1: ");
        System.out.println(lista.toString()+" i obratno "+lista.toStringR());

        pom = lista.find(3);
        lista.delete(pom);
        System.out.print("Listata po brishenje na elementot 3: ");
        System.out.println(lista.toString()+" i obratno "+lista.toStringR());

        System.out.println("Momentalna dolzina na listata: "+lista.getSize());

        lista.deleteList();
        System.out.print("Pecatenje na listata po nejzino brishenje: ");
        System.out.println(lista.toString()+" i obratno "+lista.toStringR());
        System.out.println("Momentalna dolzina na listata: "+lista.getSize());


    }
}
