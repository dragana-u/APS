package ZadaciMinatiGod.DeleteParnoPojavuvanje;

import java.util.Scanner;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }
    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + " ";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + " ";
            }
        } else
            ret = "";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }
    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if(first ==node){
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }
    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            }
        }
        return first;
    }
}

public class ExamTerm2 {
    //resenie so koristenje pomosna niza
//    public static void deleteEven(SLL<Integer> list1) {
//        //todo: enter code here
//        SLLNode<Integer> tmp1 = list1.getFirst();
//        SLLNode<Integer> tmp2 = tmp1.succ;
//        int[] m = new int[100];
//        int counter;
//        int j=0;
//        while(true){
//            counter=1;
//            while(tmp2!=null){
//                if(tmp1.element == tmp2.element){
//                    counter++;
//                }
//                tmp2 = tmp2.succ;
//            }
//            if(counter%2==0){
//                boolean flag = true;
//                for(int i=0;i<j;i++){
//                    if(m[i]== tmp1.element){
//                        flag=false;
//                    }
//                }
//                if (flag) {
//                    SLLNode<Integer> pomosen = list1.getFirst();
//                    while(pomosen!=null){
//                        if(pomosen.element==tmp1.element){
//                            list1.delete(pomosen);
//                        }
//                        pomosen=pomosen.succ;
//                    }
//                }
//            }else{
//                m[j++] = tmp1.element;;
//            }
//            tmp1 = tmp1.succ;
//            if(tmp1==null){
//                break;
//            }
//            tmp2 = tmp1.succ;
//        }
//    }


    // samo so lista
        public static void deleteEven(SLL<Integer> list1) {
        //todo: enter code here
        SLLNode<Integer> tmp1 = list1.getFirst();
        int counter=0;
        while(tmp1!=null) {
            counter = 0;
            SLLNode<Integer> tmp2 = list1.getFirst();
            while (tmp2 != null) {
                if (tmp1.element == tmp2.element) {
                    counter++;
                }
                tmp2 = tmp2.succ;
            }
            if (counter % 2 == 0) {
                    SLLNode<Integer> pomosen = list1.getFirst();
                    while (pomosen != null) {
                        if (pomosen.element == tmp1.element) {
                            list1.delete(pomosen);
                        }
                        pomosen = pomosen.succ;
                    }
            }
            tmp1= tmp1.succ;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        //todo: enter code here
        for(int i=0;i<n;i++){
            list1.insertLast(scanner.nextInt());
        }

        deleteEven(list1);
        //todo: enter code here
        System.out.println(list1);
    }
}