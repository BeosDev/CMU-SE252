package dynamic;

import java.util.Scanner;

/**
 * Created by linh on 17/05/2017.
 *
 Input
 abcqweqrqtwt
 xvnbmnabcsdq

 Output Table:
 4 4 4 4 4 4 4 3 2 1 1 1
 3 3 3 3 3 3 3 3 2 1 1 1
 2 2 2 2 2 2 2 2 2 1 1 1
 1 1 1 1 1 1 1 1 1 1 1 1
 1 1 1 1 1 1 1 1 1 1 1 1
 1 1 1 1 1 1 1 1 1 1 1 1
 1 1 1 1 1 1 1 1 1 1 1 1
 1 1 1 1 1 1 1 1 1 1 1 1
 1 1 1 1 1 1 1 1 1 1 1 1
 0 0 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0 0 0
 */
public class Xauconchungdainhat
{
    String st1,st2;
    int L[][];
    void input(){
        Scanner scanner = new Scanner(System.in);
        st1 = scanner.next();
        st2 = scanner.next();
    }
    int qhd(){
        int s1 = st1.length();
        int s2 = st2.length();
        L = new int[s1+1][s2+2];
        for (int i = 0;i<s1;i++) {
            L[i][0] = 0;
        }
        for (int i = 0;i<s2;i++) {
            L[0][i] = 0;
        }
        L[s1][s2] = 0;
        for (int i = s1-1;i>=0;i--)
            for (int j = s2-1;j>=0;j--)
                if (st1.charAt(i) == st2.charAt(j)){
                    L[i][j] = 1 + L[i+1][j+1];
                }
                else L[i][j] = Math.max(L[i+1][j],L[i][j+1]);
        return L[0][0];
    }

    public static void main(String[] args) {
        Xauconchungdainhat x = new Xauconchungdainhat();
        x.input();
        System.out.println(x.qhd());
    }
}
