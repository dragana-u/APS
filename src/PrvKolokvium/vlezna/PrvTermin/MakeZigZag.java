package PrvKolokvium.vlezna.PrvTermin;

import java.util.Scanner;

class SLLNode<E> {
    protected E element;
    protected PrvKolokvium.vlezna.VtorTermin.SLLNode<E> succ;

    public SLLNode(E elem, PrvKolokvium.vlezna.VtorTermin.SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLL<E> {
    private PrvKolokvium.vlezna.VtorTermin.SLLNode<E> first;

    public SLL() {
        // Construct an empty PrvKolokvium.vlezna.VtorTermin.SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        PrvKolokvium.vlezna.VtorTermin.SLLNode<E> tmp = first;
        while (tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            PrvKolokvium.vlezna.VtorTermin.SLLNode<E> tmp = first;
            ret += tmp;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += " -> " + tmp;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        PrvKolokvium.vlezna.VtorTermin.SLLNode<E> ins = new PrvKolokvium.vlezna.VtorTermin.SLLNode<E>(o, null);
        ins.succ = first;
        //PrvKolokvium.vlezna.VtorTermin.SLLNode<E> ins = new PrvKolokvium.vlezna.VtorTermin.SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, PrvKolokvium.vlezna.VtorTermin.SLLNode<E> node) {
        if (node != null) {
            PrvKolokvium.vlezna.VtorTermin.SLLNode<E> ins = new PrvKolokvium.vlezna.VtorTermin.SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, PrvKolokvium.vlezna.VtorTermin.SLLNode<E> before) {

        if (first != null) {
            PrvKolokvium.vlezna.VtorTermin.SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new PrvKolokvium.vlezna.VtorTermin.SLLNode<E>(o, before);
                ;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            PrvKolokvium.vlezna.VtorTermin.SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new PrvKolokvium.vlezna.VtorTermin.SLLNode<E>(o, null);
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            PrvKolokvium.vlezna.VtorTermin.SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(PrvKolokvium.vlezna.VtorTermin.SLLNode<E> node) {
        if (first != null) {
            PrvKolokvium.vlezna.VtorTermin.SLLNode<E> tmp = first;
            if (first == node) {
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

    public PrvKolokvium.vlezna.VtorTermin.SLLNode<E> getFirst() {
        return first;
    }

    public PrvKolokvium.vlezna.VtorTermin.SLLNode<E> find(E o) {
        if (first != null) {
            PrvKolokvium.vlezna.VtorTermin.SLLNode<E> tmp = first;
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

    public void merge(PrvKolokvium.vlezna.VtorTermin.SLL<E> in) {
        if (first != null) {
            PrvKolokvium.vlezna.VtorTermin.SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        } else {
            first = in.getFirst();
        }
    }

    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            PrvKolokvium.vlezna.VtorTermin.SLLNode<E> tmp = first;
            PrvKolokvium.vlezna.VtorTermin.SLLNode<E> newsucc = null;
            PrvKolokvium.vlezna.VtorTermin.SLLNode<E> next;

            while (tmp != null) {
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }
    }
}

public class MakeZigZag {

    //TODO: implement function
    public static void makeZigZag(PrvKolokvium.vlezna.VtorTermin.SLL<Integer> list) {
        PrvKolokvium.vlezna.VtorTermin.SLLNode<Integer> tmp = list.getFirst();
        while (tmp != null) {
            if(tmp.element==0){
                list.delete(tmp);
                tmp = tmp.succ;
                continue;
            }else if(tmp.succ!=null){
                if(tmp.element<0 && tmp.succ.element<0){
                    int o = Math.abs(tmp.element);
                    list.insertAfter(o,tmp);
                }else if(tmp.element>0 && tmp.succ.element>0){
                    list.delete(tmp.succ);
                    continue;
                }
            }
            tmp = tmp.succ;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        PrvKolokvium.vlezna.VtorTermin.SLL<Integer> list = new PrvKolokvium.vlezna.VtorTermin.SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(input.nextInt());
        }

        System.out.println(list);

        makeZigZag(list);

        System.out.println(list);
    }
}