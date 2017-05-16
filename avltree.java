package practice;

import java.util.Scanner;

/**
 * Created by linh on 16/05/2017.
 *
 *
 AVL tree khi chèn vào cây làm cây mất cân bằng thì sẽ chia thành
 4 Trường hợp:

 - Trường hợp 1 phía trái trái không cân bằng thì sẽ quay phải

         T1, T2, T3 và T4 là một nhánh con.
          z                                       y
         / \                                    /  \
        y   T4      Right Rotate              x     z
       / \          - - - - - - - - ->      /  \   / \
      x   T3                               T1  T2 T3 T4
     / \
   T1   T2

 - Trường hợp 2 phía trái phải không cần bằng thì sẽ quay trái phải

          z                                   x
         / \                                /   \
        y   T4  Left Right Rotate          y      z
       / \      - - - - - - - - ->       / \    / \
     T1   x                             T1  T2 T3  T4
         / \
       T2   T3
 - Trường hợp 3 phía phải  không cần bằng thì sẽ quay trái

           z                              y
         /  \                            /   \
        T1   y     Left Rotate         z      x
            / \   - - - - - - - ->    / \    / \
           T2  x                     T1  T2 T3 T4
              / \
            T3  T4

 - Trường hợp 4 phía phải trái không cân bằng thì sẽ quay phải trái

          z                               x
         / \     Right Left Rotate      /   \
       T1   y     - - - - - - - ->     z     y
           / \                       / \    / \
          x   T4                   T1  T2 T3  T4
         / \
       T2   T3


 *
 *
 */
class Node {
    public Node() {
        super();
    }

    public Node(int data) {
        this.data = data;
    }

    int data;
    Node left;
    Node right;
}

public class avltree {
    Node root;
    int height(Node node) {
        return (node != null) ? Math.max(height(node.left), height(node.right)) + 1 : 0;
    }

    Node rightRotate(Node node){
        Node nodeLeft = node.left;
        node.left = nodeLeft.right;
        nodeLeft.right = node;
        return nodeLeft;
    }

    Node leftRightRotate(Node node){
        Node nodeLeftRight = node.left.right;
        Node nodeLeft = node.left;
        nodeLeft.right = nodeLeftRight.left;
        node.left = nodeLeftRight.right;
        nodeLeftRight.left = nodeLeft;
        nodeLeftRight.right = node;
        return nodeLeftRight;
    }

    Node leftRotate(Node node){
        Node nodeRight = node.right;
        node.right = nodeRight.left;
        nodeRight.left = node;
        return nodeRight;
    }

    Node rightLeftRotate(Node node){
        Node nodeRightLeft = node.right.left;
        Node nodeRight = node.right;
        nodeRight.left = nodeRightLeft.right;
        node.right = nodeRightLeft.left;
        nodeRightLeft.right = nodeRight;
        nodeRightLeft.left = node;
        return nodeRightLeft;
    }

    Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        }
        if (data == root.data) return root;
        if (data > root.data)
            root.right = insert(root.right, data);
        else {
            root.left = insert(root.left, data);
        }
        int heightOfNodeLeft = height(root.left);
        int heightOfNodeRight = height(root.right);
        if (Math.abs(heightOfNodeLeft - heightOfNodeRight) > 1) {
            if (heightOfNodeLeft > heightOfNodeRight) {
                int heighOfNodeLeftLeft = height(root.left.left);
                int heighOfNodeLeftRight = height(root.left.right);
                if (heighOfNodeLeftLeft > heighOfNodeLeftRight) root = rightRotate(root);
                if (heighOfNodeLeftLeft < heighOfNodeLeftRight) root = leftRightRotate(root);
            } else {
                int heighOfNodeRightRight = height(root.right.right);
                int heighOfNodeRightLeft = height(root.right.left);
                if (heighOfNodeRightRight > heighOfNodeRightLeft) root = leftRotate(root);
                if (heighOfNodeRightLeft > heighOfNodeRightRight) root = rightLeftRotate(root);
            }
        }
        return root;
    }
    void insert(int data){
        root = insert(root,data);
    }
    void print(Node root){
        if (root != null){
            print(root.left);
            System.out.println(root.data);
            print(root.right);
        }
    }
    void print(){
        print(root);
    }
    public static void main(String[] args) {
        avltree s = new avltree();
        Scanner sc = new Scanner(System.in);
        int k = 0;
        do{
            k = sc.nextInt();
            s.insert(k);
        }while (k != 0);
        s.print();
    }
}
