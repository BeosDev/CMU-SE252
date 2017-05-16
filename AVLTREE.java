package avltree;

import practice.avltree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class AVLTREE {
    class TNode {
        int data;
        TNode left, right;

        TNode(int x) {
            data = x;
            left = right = null;
        }

        TNode(int x, TNode ll, TNode rr) {
            data = x;
            left = ll;
            right = rr;
        }

    }

    TNode root;

    int cao(TNode T) {
        if (T == null)
            return 0;
        return 1 + Math.max(cao(T.left), cao(T.right));
    }

    TNode qL(TNode T) {
        TNode x = T;
        TNode y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    TNode qLR(TNode T) {
        TNode x = T;
        TNode y = x.left;
        TNode z = y.right;
        y.right = z.left;
        x.left = z.right;
        z.left = y;
        z.right = x;
        return z;
    }

    TNode qR(TNode T) {
        TNode x = T;
        TNode y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    TNode qRL(TNode T) {
        TNode x = T;
        TNode y = x.right;
        TNode z = y.left;
        x.right = z.left;
        y.left = z.right;
        z.left = x;
        z.right = y;
        return z;
    }

    private TNode chenx(TNode T, int x) {
        if (T == null)
            T = new TNode(x);
        else if (x == T.data)
            System.out.println(x + " da co trong cay AVL");
        else {
            if (x < T.data)
                T.left = chenx(T.left, x);
            else if (x > T.data)
                T.right = chenx(T.right, x);
            int h1 = cao(T.left);
            int h2 = cao(T.right);
            if (Math.abs(h1 - h2) > 1) {
                if (h1 > h2) {
                    int h11 = cao(T.left.left);
                    int h12 = cao(T.left.right);
                    if (h11 > h12)
                        T = qL(T);
                    else
                        T = qLR(T);
                } else {
                    int h22 = cao(T.right.right);
                    int h21 = cao(T.right.left);
                    if (h22 > h21)
                        T = qR(T);
                    else
                        T = qRL(T);
                }
            }
        }
        return T;
    }
    void print(TNode root){
        if (root != null){
            print(root.left);
            System.out.println(root.data);
            print(root.right);
        }
    }
    void print(){
        print(root);
    }
    void chenx(int x) {
        root = chenx(root, x);
    }

    public static void main(String[] args) throws FileNotFoundException {
        AVLTREE s = new AVLTREE();
        Scanner sc = new Scanner(System.in);
        int k = 0;
        do{
            k = sc.nextInt();
            s.chenx(k);
        }while (k != 0);
        s.print();
    }

}
