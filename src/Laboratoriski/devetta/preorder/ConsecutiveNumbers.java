package Laboratoriski.devetta.preorder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Stack;


class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}

class BTree<E> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode<E>(elem);
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public void inorder() {
        System.out.print("INORDER: ");
        inorderR(root);
        System.out.println();
    }

    public void inorderR(BNode<E> n) {
        if (n != null) {
            inorderR(n.left);
            System.out.print(n.info.toString()+" ");
            inorderR(n.right);
        }
    }

    public void preorder() {
        System.out.print("PREORDER: ");
        preorderR(root);
        System.out.println();
    }

    public void preorderR(BNode<E> n) {
        if (n != null) {
            System.out.print(n.info.toString()+" ");
            preorderR(n.left);
            preorderR(n.right);
        }
    }

    public void postorder() {
        System.out.print("POSTORDER: ");
        postorderR(root);
        System.out.println();
    }

    public void postorderR(BNode<E> n) {
        if (n != null) {
            postorderR(n.left);
            postorderR(n.right);
            System.out.print(n.info.toString()+" ");
        }
    }

    public void preorderCheck(BNode<E> n, List<Integer> list) {
        if(n != null){
            list.add((Integer) n.info);
            preorderCheck(n.left,list);
            preorderCheck(n.right,list);
        }
    }

    public void inorderNonRecursive() {
        Stack<BNode<E>> s = new Stack<BNode<E>>();
        BNode<E> p = root;
        System.out.print("INORDER (nonrecursive): ");

        while (true) {
            // pridvizuvanje do kraj vo leva nasoka pri sto site koreni
            // na potstebla se dodavaat vo magacin za podocnezna obrabotka
            while (p != null) {
                s.push(p);
                p = p.left;
            }

            // ako magacinot e prazen znaci deka stebloto e celosno izminato
            if (s.isEmpty())
                break;

            p = s.peek();
            // pecatenje (obrabotka) na jazelot na vrvot od magacinot
            System.out.print(p.info.toString()+" ");
            // brisenje na obraboteniot jazel od magacinot
            s.pop();
            // pridvizuvanje vo desno od obraboteniot jazel i povtoruvanje na
            // postapkata za desnoto potsteblo na jazelot
            p = p.right;

        }
        System.out.println();

    }

}

public class ConsecutiveNumbers {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        BNode<Integer> nodes[] = new BNode[N];
        BTree<Integer> tree = new BTree<Integer>();

        for (i=0;i<N;i++)
            nodes[i] = null;

        for (i = 0; i < N; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            int index = Integer.parseInt(st.nextToken());
            nodes[index] = new BNode<Integer>(Integer.parseInt(st.nextToken()));
            String action = st.nextToken();
            if (action.equals("LEFT")) {
                BNode<Integer> child = tree.addChild(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index].info);
                nodes[index] = child;
            } else if (action.equals("RIGHT")) {
                BNode<Integer> child = tree.addChild(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index].info);
                nodes[index] = child;
            } else {
                // this node is the root
                tree.makeRoot(nodes[index].info);
                nodes[index] = tree.root;
            }
        }

        br.close();

        // vasiot kod ovde
        List<Integer> list = new ArrayList<>();
        tree.preorderCheck(tree.root,list);
        for(i=0;i<list.size()-1;i++){
            if(list.get(i+1) - list.get(i) != 2){
                System.out.print("false");
                return;
            }
        }
        System.out.println("true");
    }

}
