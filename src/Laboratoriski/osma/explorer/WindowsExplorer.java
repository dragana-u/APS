package Laboratoriski.osma.explorer;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

interface Tree<E> {
    ////////////Accessors ////////////

    public Node<E> root();

    public Node<E> parent(Node<E> node);

    public int childCount(Node<E> node);

    ////////////Transformers ////////////
    public void makeRoot(E elem);

    public Node<E> addChild(Node<E> node, E elem);

    public void remove(Node<E> node);

    ////////////Iterator ////////////
    public Iterator<E> children(Node<E> node);

}

interface Node<E> {

    public E getElement();

    public void setElement(E elem);
}


class SLLTree<E> implements Tree<E> {

    public SLLNode<E> root;

    public SLLTree() {
        root = null;
    }

    public Node<E> root() {
        return root;
    }

    public Node<E> parent(Node<E> node) {
        return ((SLLNode<E>) node).parent;
    }

    public int childCount(Node<E> node) {
        SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
        int num = 0;
        while (tmp != null) {
            tmp = tmp.sibling;
            num++;
        }
        return num;
    }

    public void makeRoot(E elem) {
        root = new SLLNode<E>(elem);
    }

    public Node<E> addChild(Node<E> node, E elem) {
        SLLNode<E> tmp = new SLLNode<E>(elem);
        SLLNode<E> current = (SLLNode<E>) node;

        if (current.firstChild == null || elem.toString().compareTo(current.firstChild.element.toString()) < 0) {
            tmp.sibling = current.firstChild;
            current.firstChild = tmp;
        } else {
            SLLNode<E> prev = current.firstChild;
            while (prev.sibling != null && elem.toString().compareTo(prev.sibling.element.toString()) > 0) {
                prev = prev.sibling;
            }
            tmp.sibling = prev.sibling;
            prev.sibling = tmp;
        }

        tmp.parent = current;
        return tmp;
    }

    public void remove(Node<E> node) {
        SLLNode<E> curr = (SLLNode<E>) node;
        if (curr.parent != null) {
            if (curr.parent.firstChild == curr) {
                // The node is the first child of its parent
                // Reconnect the parent to the next sibling
                curr.parent.firstChild = curr.sibling;
            } else {
                // The node is not the first child of its parent
                // Start from the first and search the node in the sibling list and remove it
                SLLNode<E> tmp = curr.parent.firstChild;
                while (tmp.sibling != curr) {
                    tmp = tmp.sibling;
                }
                tmp.sibling = curr.sibling;
            }
        } else {
            root = null;
        }
    }

    class SLLTreeIterator<T> implements Iterator<T> {

        SLLNode<T> start, current;

        public SLLTreeIterator(SLLNode<T> node) {
            start = node;
            current = node;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public T next() throws NoSuchElementException {
            if (current != null) {
                SLLNode<T> tmp = current;
                current = current.sibling;
                return tmp.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (current != null) {
                current = current.sibling;
            }
        }
    }

    public Iterator<E> children(Node<E> node) {
        return new SLLTreeIterator<E>(((SLLNode<E>) node).firstChild);
    }

    void printTreeRecursive(Node<E> node, int level) {
        if (node == null)
            return;
        int i;
        SLLNode<E> tmp;

        for (i=0;i<level;i++)
            System.out.print(" ");
        System.out.println(node.getElement().toString());
        tmp = ((SLLNode<E>)node).firstChild;
        while (tmp != null) {
            printTreeRecursive(tmp, level+1);
            tmp = tmp.sibling;
        }
    }
    public void printTree() {
        printTreeRecursive(root, 0);
    }

}

class SLLNode<P> implements Node<P> {

    // Holds the links to the needed nodes
    public SLLNode<P> parent, sibling, firstChild;
    // Hold the data
    public P element;

    public SLLNode(P o) {
        element = o;
        parent = sibling = firstChild = null;
    }

    public P getElement() {
        return element;
    }

    public void setElement(P o) {
        element = o;
    }
}

public class WindowsExplorer {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String commands[] = new String[N];

        for (i=0;i<N;i++)
            commands[i] = br.readLine();

        br.close();

        SLLTree<String> tree = new SLLTree<String>();
        tree.makeRoot("c:");

        // vasiot kod stoi ovde

        SLLNode<String> tmp1;
        SLLNode<String> current = tree.root;
        for(int m=0;m<commands.length;m++){
            String[] parts = commands[m].split("\\s+");
            if(parts[0].equals("CREATE")){
                tree.addChild(current,parts[1]);
            }else if(parts[0].equals("OPEN")){
                tmp1 = current.firstChild;
                while(!(tmp1.element.equals(parts[1]))){
                    tmp1 = tmp1.sibling;
                }
                current = tmp1;
            }else if(parts[0].equals("DELETE")){
                SLLNode<String> tmp;
                tmp = current.firstChild;
                while(!(tmp.element.equals(parts[1]))){
                    tmp = tmp.sibling;
                }
                tree.remove(tmp);
            }else if(parts[0].equals("BACK")){
                current = current.parent;
            }else if(parts[0].equals("PATH")){
                SLLNode<String> temp = current;
                StringBuilder sb = new StringBuilder();
                String[] st = new String[50];
                int l = 0;
                while(temp!=null){
                    st[l++] = temp.getElement();
                    temp = temp.parent;
                }
                for(int t=l-1;t>=0;t--){
                    sb.append(st[t])
                            .append("\\");
                }
                System.out.println(sb);
            }else if(parts[0].equals("PRINT")){
                tree.printTreeRecursive(tree.root,0);
            }
        }
    }
}

